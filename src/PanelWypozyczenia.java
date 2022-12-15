import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.EventListener;

public class PanelWypozyczenia extends JPanel implements ActionListener {

    JComboBox wyborKsiazki = new JComboBox();

    JComboBox wyborKlienta = new JComboBox();

    Date dataWypozyczenia = new Date();

    Date dataOddania = new Date();

    JButton wroc = new JButton("Wroc");

    JButton dodaj = new JButton("Dodaj");

    JButton wyczysc = new JButton("Wyczysc");

    public PanelWypozyczenia(){

        this.setLayout(null);
        this.setBounds(0,0,800,600);

        wyczysc.setBounds(410,400,200,40);
        wyczysc.addActionListener(this);

        dodaj.setBounds(190,400,200,40);
        dodaj.addActionListener(this);

        wroc = new JButton("Wroc");
        wroc.setBounds(300,450,200,40);


    }

    public void actionPerformed(ActionEvent e){

    }

}
