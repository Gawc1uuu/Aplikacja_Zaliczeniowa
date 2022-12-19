import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventListener;

public class PanelWypozyczenia extends JPanel implements ActionListener {
    String createTableString = "CREATE TABLE IF NOT EXISTS wypozyczenia(id_w int not null primary key auto_increment," +
            "id_k int ," +
            "id_klient int ," +
            "DataWyp date not null)";

    String alterTableString1 = "ALTER TABLE wypozyczenia ADD FOREIGN KEY (id_k) REFERENCES ksiazki(id_k)";
    String alterTableString2 = "ALTER TABLE wypozyczenia ADD FOREIGN KEY (id_klient) REFERENCES klienci(id_klient)";


    Date dataWypozyczenia = new Date();

    Date dataOddania = new Date();

    JButton wroc = new JButton("Wroc");

    JButton dodaj = new JButton("Dodaj");

    JButton wyczysc = new JButton("Wyczysc");

    DBManager db = new DBManager();


    String sqlSelectString1 = "SELECT * FROM klienci";

    String sqlSelectString2 = "SELECT * FROM ksiazki";

    JComboBox wyborKsiazki;

    JComboBox wyborKlienta;

    UtilDateModel model;

    JDatePanelImpl datePanel;

    JDatePickerImpl datePicker;

    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");


    public PanelWypozyczenia(){
        db.createTable(createTableString);
        db.createTable(alterTableString1);
        db.createTable(alterTableString2);
//        db.select(sqlSelectString2,"id_k","Tytul");
//        db.select(sqlSelectString1,"id_klient","Imie","Nazwisko");

        this.setLayout(null);
        this.setBounds(0,0,800,600);

        this.setBackground(Color.BLACK);
        wyborKlienta = new JComboBox(db.comboBoxModel1);
        JLabel wyborKlientaLabel = new JLabel("kto wypozycza: ");
        wyborKlientaLabel.setBounds(250,100,120,30);
        wyborKlienta.setBounds(350,100,150,30);

        wyborKsiazki = new JComboBox(db.comboBoxModel2);
        JLabel wyborKsiazkiLabel = new JLabel("wybierz ksiazke: ");
        wyborKsiazkiLabel.setBounds(250,150,120,30);
        wyborKsiazki.setBounds(350,150,150,30);

        JLabel dataZwrotu = new JLabel("Wybierz date zwrotu: ");
        dataZwrotu.setBounds(220,200,150,30);
        model = new UtilDateModel();
        datePanel = new JDatePanelImpl(model);
        datePicker = new JDatePickerImpl(datePanel,null);
        datePicker.setBounds(350,200,150,30);


        dodaj.setBounds(190,400,200,40);
        dodaj.addActionListener(this);

        wroc = new JButton("Wroc");
        wroc.setBounds(410,400,200,40);


        this.add(datePicker);
        this.add(dataZwrotu);
        this.add(wyborKlientaLabel);
        this.add(wyborKsiazkiLabel);
        this.add(wyborKsiazki);
        this.add(wyborKlienta);
        this.add(wroc);
        this.add(dodaj);
        this.setVisible(false);


    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==dodaj){
            System.out.println(wyborKlienta.getSelectedItem().toString().charAt(0));
            System.out.println(wyborKsiazki.getSelectedItem().toString().charAt(0));
            System.out.println(df.format(datePicker.getModel().getValue()));
            db.useDatabase();
            db.createTable(createTableString);
            db.createTable(alterTableString1);
            db.createTable(alterTableString2);
            db.insert("INSERT INTO wypozyczenia(id_klient,id_k,dataWyp) values("+wyborKlienta.getSelectedItem().toString().charAt(0)+","+wyborKsiazki.getSelectedItem().toString().charAt(0)+",'"+df.format(datePicker.getModel().getValue())+"')");
        }

    }

}
