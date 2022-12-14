import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends JPanel {

    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;


    public StartPanel(){
        this.setLayout(null);
        this.setBounds(0,0,800,600);
        button1 = new JButton();
        button2 = new JButton();
         button3 = new JButton();
        button4 = new JButton();
        button1.setBounds(300,250,200,40);
        button2.setBounds(300,300,200,40);
        button3.setBounds(300,350,200,40);
        button4.setBounds(300,400,200,40);
        button1.setText("Oferta");
        button2.setText("Wypozycz");
        button3.setText("Dodaj");
        button4.setText("Klienci");
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.setVisible(true);

    }

}
