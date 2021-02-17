/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Alumne
 */
public class JavaApplication7 {
    public static void main(String[] args) {
        ButtonFrame3 b = new ButtonFrame3();
        b.setSize(300, 150);
        b.setVisible(true);
    }
}

class ButtonFrame3 extends JFrame implements ActionListener {

    JButton bChange, bChange2;
    String[] hola = new String[]{"Color.Blue", "Color.Red", "Color.Green"};
    Random rand;
    int ian;
    
    public ButtonFrame3() {
        bChange = new JButton("Click me!");
        bChange2 = new JButton("syso!");
        setLayout(new FlowLayout());
        
        bChange.addActionListener(this);
        add(bChange);
        
        bChange2.addActionListener(this);
        add(bChange2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Click me!")) {
            if(getContentPane().getBackground().equals(Color.red)) {
                getContentPane().setBackground(Color.blue);
            } else {
                getContentPane().setBackground(Color.red);
            }
        } else {
            System.out.println("Hola");
        }
    }


}