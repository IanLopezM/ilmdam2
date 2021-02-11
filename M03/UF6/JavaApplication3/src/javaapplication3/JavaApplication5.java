/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Alumne
 */
public class JavaApplication5 {
    
    public static void main(String[] args) {
        
        MyFrame frame = new MyFrame("Hello");
        frame.setVisible(true);
    }
    
    public void setBounds(int x, int y, int widht, int height){
        
    }

    private static class MyFrame extends JFrame{
        
        JButton label;
        JButton label1;
        JButton label2;
        JButton label3;
        Button label4;
        
        public MyFrame(String string) {
            
            super(string);
            setSize(500, 500);
            setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
            
            setLayout(new BorderLayout(2,2));
            label = new JButton("Hello swing");
            add(label, BorderLayout.NORTH);
            
            label1 = new JButton("Hello swing");
            add(label1, BorderLayout.SOUTH);
            //
            
            label2 = new JButton("Hello swing");
            add(label2, BorderLayout.WEST);
            
            label3 = new JButton("Hello swing");
            add(label3, BorderLayout.EAST);
            
            label4 = new Button("Hello AWT");
            add(label4, BorderLayout.CENTER);
            
        }
    }
    
}
