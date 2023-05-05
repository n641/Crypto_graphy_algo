package finalProj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Second_Gui implements ActionListener {
    JFrame frame = new JFrame();

    JLabel label = new JLabel("Choose your favourite Cipher");
    JButton b1 = new JButton("Cesar Cipher");
    JButton b2 = new JButton("Hill Cipher");
    JButton b8 = new JButton("Play Fair");
    JButton b3 = new JButton("Vernam Cipher");
    JButton b4 = new JButton("Vigenère Cipher");
    JButton b5 = new JButton("AutokeyCipher");
    JButton b12 = new JButton("OneTimePadCipher");
    JButton b7 = new JButton("Rail Fence");
    JButton b6 = new JButton("Row Transportation");
    JButton b9 = new JButton("AES");

    JButton b10 = new JButton("DES");

    JButton b11 = new JButton("RSA");




    Second_Gui(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        b1.setBounds(0,0,15,15);

        frame.setLayout(new GridLayout(4, 4, 5, 6));

        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);
        frame.add(b7);
        frame.add(b8);
        frame.add(b9);
        frame.add(b10);
        frame.add(b11);
        frame.add(b12);


        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);


        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            CS402Lab1 obj = new CS402Lab1("Cesar Cipher");
        }
        if (e.getSource() == b2){
            CS402Lab1 obj = new CS402Lab1("Hill Cipher");
        }
        if (e.getSource() == b3){
            CS402Lab1 obj = new CS402Lab1("Vernam Cipher");
        }
        if (e.getSource() == b4){
            CS402Lab1 obj = new CS402Lab1("VigenèreCipher");
        }
        if (e.getSource() == b5){
            CS402Lab1 obj = new CS402Lab1("AutokeyCipher");
        }
        if (e.getSource() == b6){
            CS402Lab1 obj = new CS402Lab1("RowTranspositionCiphers");
        }
        if (e.getSource() == b7){
            CS402Lab1 obj = new CS402Lab1("railFenceCipher");
        }
        if (e.getSource() == b8){
            CS402Lab1 obj = new CS402Lab1("Play Fair");
        }
        if (e.getSource() == b9){
            CS402Lab1 obj = new CS402Lab1("RowTranspositionCiphers");
        }
        if (e.getSource() == b10){
            CS402Lab1 obj = new CS402Lab1("DES");
        }
        if (e.getSource() == b11){
            CS402Lab1 obj = new CS402Lab1("RSA");
        }
        if (e.getSource() == b12){
            CS402Lab1 obj = new CS402Lab1("OneTimePadCipher");
        }
    }
}
