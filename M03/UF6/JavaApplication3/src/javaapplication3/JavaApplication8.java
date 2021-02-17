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
import javax.swing.JTextField;

/**
 *
 * @author Alumne
 */
public class JavaApplication8 extends JFrame implements ActionListener{
    JTextField text, text2;
    JButton bChange;
    
    public JavaApplication8(String title) {
        super(title);
        text = new JTextField(15);
        
        add(text);
        
        text2 = new JTextField(15);
        add(text2);
        
        bChange = new JButton("Click me!");
        bChange.addActionListener(this);
        add(bChange);
        setLayout(new FlowLayout());
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args){
        JavaApplication8 teg = new JavaApplication8("TextField");
        teg.setSize(200, 150);
        teg.setVisible(true);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        String name = text.getText();
        text2.setText(name);
        repaint();
    
    }
    
}
