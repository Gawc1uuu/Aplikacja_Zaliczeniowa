import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PanelDodawanie extends JPanel implements ActionListener {

    String createTableString = "CREATE TABLE IF NOT EXISTS ksiazki(id_k int not null primary key auto_increment," +
            "Tytul varchar(50) not null," +
            "Autor varchar(50) not null," +
            "Kategoria varchar(50) not null," +
            "Zdjecie varchar(250))";


    String filePath;
    JButton wyczysc;
    JButton dodaj;

    JButton wroc;
    JTextField autor;
    JTextField tytul;

    JButton plik;

    String[] listaKategorii = {"Lektura", "Kryminal","Sci-Fi"};

    JComboBox  kategorie;



    DBManager db = new DBManager();

    public PanelDodawanie(){


        this.setLayout(null);
        this.setBounds(0,0,800,600);

        JLabel tytulLabel = new JLabel("Tytuł: ");
        tytulLabel.setBounds(300,100,50,30);
         tytul = new JTextField();
        tytul.setBounds(350,100,150,30);


        JLabel autorLabel = new JLabel("Autor: ");
        autorLabel.setBounds(300,150,50,30);
        autor = new JTextField();
        autor.setBounds(350,150,150,30);


        JLabel kategoriaLabel = new JLabel("Kategoria: ");
        kategorie = new JComboBox(listaKategorii);
        kategoriaLabel.setBounds(270,200,70,30);
        kategorie.setBounds(350,200,150,30);

//        JLabel zdjecieLabel = new JLabel("wybierz zdjecie: ");
//        zdjecie = new JFileChooser();
//        zdjecieLabel.setBounds(270,250,70,30);
//       zdjecie.setBounds(350,250,150,30);
        JLabel plikLabel = new JLabel("Wybierz zdjecie: ");
            plik=new JButton("Select a file");
        plikLabel.setBounds(240,240,100,30);
        plik.setBounds(350,240,150,40);
        plik.addActionListener(this);


         wyczysc = new JButton("Wyczysc");
        wyczysc.setBounds(410,400,200,40);
        wyczysc.addActionListener(this);

        dodaj = new JButton("Dodaj");
        dodaj.setBounds(190,400,200,40);
        dodaj.addActionListener(this);

        wroc = new JButton("Wroc");
        wroc.setBounds(300,450,200,40);


        this.add(tytulLabel);
        this.add(autorLabel);
        this.add(kategoriaLabel);
        this.add(plik);
        this.add(plikLabel);
//        this.add(zdjecieLabel);
//        this.add(zdjecie);
        this.add(tytul);
        this.add(autor);
        this.add(kategorie);
        this.add(dodaj);
        this.add(wyczysc);
        this.add(wroc);
        setVisible(false);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==plik){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null); //select file to open
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                filePath = file.toString();
            }
        }else if(e.getSource()==wyczysc){
            autor.setText("");
           tytul.setText("");
           filePath="";
        }else if(e.getSource()==dodaj){
            System.out.println(autor.getText());
            System.out.println(tytul.getText());
            System.out.println(kategorie.getSelectedItem());
            System.out.println(filePath);
            db.useDatabase();
            db.createTable(createTableString);
            String insertString = "INSERT INTO ksiazki(Tytul,Autor,Kategoria,Zdjecie) values('"+tytul.getText()+"','"+autor.getText()+"','"+kategorie.getSelectedItem()+"','"+filePath+"')";
            db.insert(insertString);
            autor.setText("");
            tytul.setText("");
        }
    }

}
