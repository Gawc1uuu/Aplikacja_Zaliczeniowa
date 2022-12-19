import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PanelKlienci extends JPanel implements ActionListener {

    String createTableString = "CREATE TABLE IF NOT EXISTS klienci(id_klient int not null primary key auto_increment," +
            "Imie varchar(50) not null," +
            "Nazwisko varchar(50) not null," +
            "Email varchar(50) not null," +
            "Ulica varchar(50) not null," +
            "NrLokalu varchar(10)," +
            "NrTel varchar(15) not null)";

    String lokal = null;
    JButton wyczysc;
    JButton dodaj;
    JButton wroc;

    JTextField imie;
    JTextField nazwisko;
    JTextField email;
    JTextField ulica;
    JTextField nrLokalu;
    JTextField nrTel;

    DBManager db = new DBManager();

    public PanelKlienci(){

        this.setLayout(null);
        this.setBounds(0,0,800,600);
    this.setBackground(Color.BLACK);

        JLabel imieLabel= new JLabel("Imie: ");
        imieLabel.setBounds(150,100,50,30);
        imie = new JTextField();
        imie.setBounds(200,100,150,30);

        JLabel nazwiskoLabel= new JLabel("Nazwisko: ");
        nazwiskoLabel.setBounds(430,100,80,30);
        nazwisko = new JTextField();
        nazwisko.setBounds(500,100,150,30);

        JLabel emailLabel = new JLabel("E-mail: ");
        emailLabel.setBounds(150,150,50,30);
       email = new JTextField();
        email.setBounds(200,150,150,30);

        JLabel ulicaLabel = new JLabel("Ulica: ");
        ulicaLabel.setBounds(450,150,50,30);
        ulica = new JTextField();
        ulica.setBounds(500,150,150,30);

        JLabel nrLokaluLabel = new JLabel("Nr lokalu: ");
        nrLokaluLabel.setBounds(150,200,50,30);
        nrLokalu = new JTextField();
        nrLokalu.setText(null);
        nrLokalu.setBounds(200,200,150,30);

        JLabel nrTelLabel = new JLabel("Nr telefonu: ");
        nrTelLabel.setBounds(450,200,50,30);
        nrTel = new JTextField();
        nrTel.setBounds(500,200,150,30);

        wyczysc = new JButton("Wyczysc");
        wyczysc.setBounds(410,400,200,40);
        wyczysc.addActionListener(this);

        dodaj = new JButton("Dodaj");
        dodaj.setBounds(190,400,200,40);
        dodaj.addActionListener(this);

        wroc = new JButton("Wroc");
        wroc.setBounds(300,450,200,40);


        this.add(imieLabel);
        this.add(imie);
        this.add(nazwiskoLabel);
        this.add(nazwisko);
        this.add(emailLabel);
        this.add(email);
        this.add(ulicaLabel);
        this.add(ulica);
        this.add(nrLokaluLabel);
        this.add(nrLokalu);
        this.add(nrTelLabel);
        this.add(nrTel);

        this.add(wroc);
        this.add(wyczysc);
        this.add(dodaj);
        this.setVisible(false);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == wyczysc) {
            imie.setText("");
            nazwisko.setText("");
            ulica.setText("");
            email.setText("");
            nrTel.setText("");
            nrLokalu.setText("");
        }else if(e.getSource()==dodaj){
            System.out.println(imie.getText());
            System.out.println(nazwisko.getText());
            System.out.println(email.getText());
            System.out.println(ulica.getText());
            System.out.println(nrLokalu.getText());
            System.out.println(nrTel.getText());
            db.useDatabase();
            db.createTable(createTableString);
            String insertString = "INSERT INTO klienci(Imie,Nazwisko,Email,Ulica,NrLokalu,NrTel) values('"+imie.getText()+"','"+nazwisko.getText()+"','"+email.getText()+"','"+ulica.getText()+"','"+nrLokalu.getText()+"','"+nrTel.getText()+"')";
            db.insert(insertString);
            imie.setText("");
            nazwisko.setText("");
            ulica.setText("");
            email.setText("");
            nrTel.setText("");
            nrLokalu.setText("");

        }

    }

}
