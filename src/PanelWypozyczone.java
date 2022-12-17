import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class PanelWypozyczone extends JPanel{

    DBManager db = new DBManager();

    JButton wroc = new JButton("Wroc");

     String selectString = "SELECT wypozyczenia.id_w, ksiazki.Tytul, klienci.imie, klienci.nazwisko, wypozyczenia.DataWyp from wypozyczenia " +
             "INNER JOIN ksiazki ON wypozyczenia.id_k=ksiazki.id_k " +
             "INNER JOIN klienci ON wypozyczenia.id_klient=klienci.id_klient";

     JPanel data;

     JTextArea textArea=new JTextArea();

     JTable table;

     String[][] wypozyczenia = new String[100][100];

    JScrollPane scrollPane;

    public PanelWypozyczone(){
        this.setLayout(null);
        this.setBounds(0,0,800,600);

        db.selectAll(selectString,"wypozyczenia.id_w","ksiazki.tytul","klienci.imie","klienci.nazwisko","wypozyczenia.DataWyp");

        String[] myArray = db.results.toArray(new String[0]);
        int licznik=0;

        for(String x : myArray){
            wypozyczenia[licznik][0] = x.split(" ")[0];
            wypozyczenia[licznik][1] = x.split(" ")[1];
            wypozyczenia[licznik][2] = x.split(" ")[2];
            wypozyczenia[licznik][3] = x.split(" ")[3];
            wypozyczenia[licznik][4] = x.split(" ")[4];
            licznik++;
        }

//        System.out.println(wypozyczenia[0][0]);


        String[] columnNames = {"id","Tytuł książki", "Imie","Nazwisko","Data Zwrotu"};

        table = new JTable(wypozyczenia,columnNames);
//        table.setLayout(null);
//        table.setBounds(50,50,700,400);

        scrollPane = new JScrollPane();
        scrollPane.add(table);
        scrollPane.setLayout(null);
        scrollPane.setBounds(50,50,700,400);

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
        wroc = new JButton("Wroc");
        wroc.setBounds(300,500,200,40);
//
//       textArea.setBounds(0,0,800,600);
//
//
////        this.add(data);
//        this.add(textArea);
        this.add(table);
        this.add(scrollPane);
        this.add(wroc);
        this.setVisible(false);

    }

}
