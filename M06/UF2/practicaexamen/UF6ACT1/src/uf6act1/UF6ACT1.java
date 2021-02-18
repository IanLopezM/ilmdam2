/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf6act1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author ianlo
 */
public class UF6ACT1 extends JFrame implements ActionListener {

    JButton bChange, bChange1, bChange2, bChange3;
    
    public UF6ACT1(){
        bChange = new JButton("Vermell");
        bChange1 = new JButton("Verd");
        bChange2 = new JButton("Blau");
        bChange3 = new JButton("Gray");
        setLayout(new FlowLayout());
        
        bChange.addActionListener(this);
        bChange1.addActionListener(this);
        bChange2.addActionListener(this);
        bChange3.addActionListener(this);
        
        add(bChange);
        add(bChange1);
        add(bChange2);
        add(bChange3);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UF6ACT1 button = new UF6ACT1();
        button.setSize(400, 300);
        button.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Vermell")) {
            getContentPane().setBackground(Color.red);
            repaint();
        } else if (e.getActionCommand().equals("Verd")) {
            getContentPane().setBackground(Color.green);
            repaint();
        } else if (e.getActionCommand().equals("Blau")) {
            getContentPane().setBackground(Color.blue);
            repaint();
        } else {
            getContentPane().setBackground(Color.GRAY);
            repaint();
        }
    }
    
}
