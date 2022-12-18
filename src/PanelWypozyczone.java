import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class PanelWypozyczone extends JFrame implements ActionListener {

    DBManager db = new DBManager();

    JButton wroc = new JButton("Wroc");

     String selectString = "SELECT wypozyczenia.id_w, ksiazki.Tytul, klienci.imie, klienci.nazwisko, wypozyczenia.DataWyp from wypozyczenia " +
             "INNER JOIN ksiazki ON wypozyczenia.id_k=ksiazki.id_k " +
             "INNER JOIN klienci ON wypozyczenia.id_klient=klienci.id_klient";

     JPanel data;

     JTextArea textArea=new JTextArea();

     JTable table;

     String[][] wypozyczenia;

    JScrollPane scrollPane;

    DefaultTableModel model;

    public PanelWypozyczone(){

        this.setSize(500,300);
        setVisible(false);



        db.selectAll(selectString,"wypozyczenia.id_w","ksiazki.tytul","klienci.imie","klienci.nazwisko","wypozyczenia.DataWyp");

        String[] myArray = db.results.toArray(new String[0]);
        int licznik=0;

        wypozyczenia = new String[myArray.length][6];

        for(String x : myArray){
            wypozyczenia[licznik][0] = x.split(" ")[0];
            wypozyczenia[licznik][1] = x.split(" ")[1];
            wypozyczenia[licznik][2] = x.split(" ")[2];
            wypozyczenia[licznik][3] = x.split(" ")[3];
            wypozyczenia[licznik][4] = x.split(" ")[4];
            wypozyczenia[licznik][5] = "X";
            licznik++;
        }



////        System.out.println(wypozyczenia[0][0]);
//

        String[] columnNames = {"id","Tytuł książki", "Imie","Nazwisko","Data Zwrotu","Usun"};


        model = new DefaultTableModel(wypozyczenia,columnNames);

        table = new JTable(model);

        this.add(new JScrollPane(table));
//        table = new JTable(wypozyczenia,columnNames);
//        table.getTableHeader().setVisible(true);
//
//        scrollPane = new JScrollPane();
//        scrollPane.add(table.getTableHeader());
//        scrollPane.add(table);
//        scrollPane.setViewportView(table);


// pokazywanie danych w textfield
//       textArea.setEditable(false);
//
//
//        for(String x : myArray){
//            textArea.append(x+"\n");
//        }
//
//
//        this.setLayout(null);
//        this.setBounds(0,0,800,600);
//
////        data = new JPanel();
////        data.setLayout(null);
////        data.setBounds(0,0,800,150);
////        data.setBorder(BorderFactory.createLineBorder(Color.black));
//
//
//        wroc = new JButton("Wroc");
//        wroc.setBounds(300,500,200,40);
//
//       textArea.setBounds(0,0,800,600);
//
//
////        this.add(data);
//        this.add(textArea);
//        this.add(scrollPane);
//        this.setVisible(true);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getClickCount()==1){
                    table.repaint();

                    int row = table.getSelectedRow();
                    int column = table.getSelectedColumn();

                    System.out.println(table.getValueAt(row,0));
                    db.delete("DELETE FROM WYPOZYCZENIA WHERE id_w="+table.getValueAt(row,0));
                    db.selectAll(selectString,"wypozyczenia.id_w","ksiazki.tytul","klienci.imie","klienci.nazwisko","wypozyczenia.DataWyp");


                }
            }

        });


    }

    public void actionPerformed(ActionEvent e){

    }

}
