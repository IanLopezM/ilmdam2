/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Alumne
 */
public class JavaApplication6 {
    public static void main(String[] args) {
        ButtonFrame2 b = new ButtonFrame2();
        b.setSize(300, 150);
        b.setVisible(true);    
    }
}

class ButtonFrame2 extends JFrame implements ActionListener {

    JButton bChange;
    
    public ButtonFrame2() {
        bChange = new JButton("Click me!");
        setLayout(new FlowLayout());
        
        bChange.addActionListener(this);
        add(bChange);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Clicat");
    }


}
