import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PanelKlienci extends JPanel implements ActionListener {

    JButton wyczysc;
    JButton dodaj;
    JButton wroc;

    JTextField imie;
    JTextField nazwisko;
    JTextField email;
    JTextField ulica;
    JTextField nrLokalu;
    JTextField nrTel;

    public PanelKlienci(){
        this.setLayout(null);
        this.setBounds(0,0,800,600);

        JLabel imieLabel= new JLabel("Imie: ");
        imieLabel.setBounds(300,100,50,30);
        imie = new JTextField();
        imie.setBounds(350,100,150,30);

        JLabel nazwiskoLabel= new JLabel("Nazwisko: ");
        nazwiskoLabel.setBounds(300,150,50,30);
        nazwisko = new JTextField();
        nazwisko.setBounds(350,150,150,30);

        JLabel emailLabel = new JLabel("E-mail: ");
        emailLabel.setBounds(300,200,50,30);
       email = new JTextField();
        email.setBounds(350,200,150,30);

        JLabel ulicaLabel = new JLabel("Ulica: ");
        ulicaLabel.setBounds(300,250,50,30);
        ulica = new JTextField();
        ulica.setBounds(350,250,150,30);

        JLabel nrLokaluLabel = new JLabel("Nr lokalu: ");
        nrLokaluLabel.setBounds(300,300,50,30);
        nrLokalu = new JTextField();
        nrLokalu.setBounds(350,300,150,30);

        JLabel nrTelLabel = new JLabel("Nr telefonu: ");
        nrTelLabel.setBounds(300,350,50,30);
        nrTel = new JTextField();
        nrTel.setBounds(350,350,150,30);

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
        }

    }

}
