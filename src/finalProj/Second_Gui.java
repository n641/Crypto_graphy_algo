package finalProj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Second_Gui implements ActionListener {
    JFrame frame = new JFrame();

    JButton b1 = new JButton("Cesar Cipher");
    JButton b2 = new JButton("Hill Cipher");
    JButton b3 = new JButton("Vernam Cipher");
    JButton b4 = new JButton("Vigenere Cipher");
    JButton b5 = new JButton("One Time Pad");
    JButton b6 = new JButton("Row Transportation");
    JButton b7 = new JButton("Rail Fence");
    JButton b8 = new JButton("Play Fair");
    JButton b9 = new JButton("Rubin Miller");
    JButton b10 = new JButton("Auto Key");

    Second_Gui(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setLayout(new GridLayout(3, 3, 5, 5));

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

        b1.addActionListener(this);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            CS402Lab1 obj = new CS402Lab1("Heelo");
        }
        if (e.getSource() == b2){
            CS402Lab1 obj = new CS402Lab1("Heelo");
        }
        if (e.getSource() == b3){
            CS402Lab1 obj = new CS402Lab1("Heelo");
        }
        if (e.getSource() == b4){
            CS402Lab1 obj = new CS402Lab1("Heelo");
        }
        if (e.getSource() == b5){
            CS402Lab1 obj = new CS402Lab1("Heelo");
        }
        if (e.getSource() == b6){
            CS402Lab1 obj = new CS402Lab1("Heelo");
        }
        if (e.getSource() == b7){
            CS402Lab1 obj = new CS402Lab1("Heelo");
        }
        if (e.getSource() == b8){
            CS402Lab1 obj = new CS402Lab1("Heelo");
        }
        if (e.getSource() == b9){
            CS402Lab1 obj = new CS402Lab1("Heelo");
        }
        if (e.getSource() == b10){
            CS402Lab1 obj = new CS402Lab1("Heelo");
        }
    }
}
