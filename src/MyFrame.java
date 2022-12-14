import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MyFrame extends JFrame implements ActionListener {

//    Image backgroundImage;

    DBManager db = new DBManager();
    StartPanel startPanel;

    PanelDodawanie panelDodawanie;

    PanelKlienci panelKlienci;

    PanelWypozyczone panelWypozyczone;
    PanelWypozyczenia panelWypozyczenia;
    MyFrame(){
//        startPanel.db.createDatabase();
//        startPanel.db.useDatabase();
//        panelKlienci.db.createTable(panelKlienci.createTableString);
//        panelDodawanie.db.createTable(panelDodawanie.createTableString);
//        panelWypozyczenia.db.createTable(panelWypozyczenia.createTableString);
//        panelWypozyczenia.db.createTable(panelWypozyczenia.alterTableString1);
//        panelWypozyczenia.db.createTable(panelWypozyczenia.alterTableString2);
//        ImageIcon image = new ImageIcon("Untitled.png");
//        background = new JLabel("",image,JLabel.CENTER);
//        background.setBounds(0,0,800,600);
//
//        JButton button1 = new JButton();
//        JButton button2 = new JButton();
//        JButton button3 = new JButton();
//        button1.setBounds(300,200,200,50);
//        button2.setBounds(300,300,200,50);
//        button3.setBounds(300,400,200,50);
//        button1.setText("dodaj");
//        button2.setText("pokaz wszytskie");
//        button3.setText("wypozycz");
//
//
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setLayout(null);
//        this.setSize(800,600);
//
//        this.add(button1);
//        this.add(button2);
//        this.add(button3);
//        this.add(background);
//        this.setVisible(true);








         startPanel = new StartPanel();
         startPanel.button3.addActionListener(this);
         startPanel.button4.addActionListener(this);
         startPanel.button2.addActionListener(this);
         startPanel.button1.addActionListener(this);

         panelDodawanie = new PanelDodawanie();
         panelDodawanie.wyczysc.addActionListener(this);

        panelDodawanie.dodaj.addActionListener(this);
        panelDodawanie.wroc.addActionListener(this);

        panelKlienci= new PanelKlienci();
        panelKlienci.wroc.addActionListener(this);

        panelWypozyczenia = new PanelWypozyczenia();
        panelWypozyczenia.wroc.addActionListener(this);

        panelWypozyczone = new PanelWypozyczone();
        panelWypozyczone.wroc.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Czytu??");
        this.setSize(800,600);



        ImageIcon image1 = new ImageIcon(this.getClass().getResource("book.png"));
        this.setIconImage(image1.getImage());
        this.add(startPanel);
        this.add(panelDodawanie);
        this.add(panelKlienci);
        this.add(panelWypozyczenia);
//        this.add(panelWypozyczone);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==startPanel.button3){
            startPanel.setVisible(false);
            panelDodawanie.setVisible(true);
        }else if(e.getSource()==panelDodawanie.wroc){
            panelDodawanie.autor.setText("");
            panelDodawanie.tytul.setText("");
            startPanel.setVisible(true);
            panelDodawanie.setVisible(false);
        } else if(e.getSource()==panelKlienci.wroc){
            startPanel.setVisible(true);
            panelKlienci.setVisible(false);
        }else if(e.getSource()==startPanel.button4){
            startPanel.setVisible(false);
            panelKlienci.setVisible(true);
        }
        else if(e.getSource()==panelWypozyczenia.wroc){
            startPanel.setVisible(true);
            panelWypozyczenia.setVisible(false);
            panelWypozyczenia.db.comboBoxModel1.removeAllElements();
            panelWypozyczenia.db.comboBoxModel2.removeAllElements();
        }else if(e.getSource()==startPanel.button2){
            startPanel.setVisible(false);
            panelWypozyczenia.setVisible(true);
            panelWypozyczenia.db.select(panelWypozyczenia.sqlSelectString2,"id_k","Tytul");
            panelWypozyczenia.db.select(panelWypozyczenia.sqlSelectString1,"id_klient","Imie","Nazwisko");
        }else if(e.getSource()==startPanel.button1){
            panelWypozyczone.db.selectAll(panelWypozyczone.selectString,"wypozyczenia.id_w","ksiazki.tytul","klienci.imie","klienci.nazwisko","wypozyczenia.DataWyp");
            panelWypozyczone.setVisible(true);
        }else if(e.getSource()==panelWypozyczone.wroc) {
            startPanel.setVisible(true);
            panelWypozyczone.setVisible(false);
        }
    }

}
