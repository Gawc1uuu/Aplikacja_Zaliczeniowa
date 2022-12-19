import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class StartPanel extends JPanel {

    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;


    DBManager db = new DBManager();

//    URL url = getClass().getResource("Czytusmall.png");
//
//    File file = new File(url.getPath());
    ImageIcon myPicture = new ImageIcon(this.getClass().getResource("Czytusmall.png"));
    JLabel picLabel = new JLabel(myPicture);


    public StartPanel() {

        this.setLayout(null);
        this.setBounds(0,0,800,600);
        picLabel.setLayout(null);
        picLabel.setBounds(275,0,250,250);
        button1 = new JButton();
        button2 = new JButton();
         button3 = new JButton();
        button4 = new JButton();
        button1.setBounds(300,250,200,40);
        button2.setBounds(300,300,200,40);
        button3.setBounds(300,350,200,40);
        button4.setBounds(300,400,200,40);
        button1.setText("Aktualnie wypożyczone");
        button2.setText("Nowe wypożyczenie");
        button3.setText("Dodaj książkę");
        button4.setText("Dodaj klienta");

        this.setBackground(Color.BLACK);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(picLabel);
        this.setVisible(true);

    }

}
