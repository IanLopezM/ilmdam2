/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf6act1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author ianlo
 */
public class UF6ACT1P2 extends JFrame implements ActionListener{
    JButton bFC, bCF, bClean;
    JLabel l;
    JTextField f, c;
    
    public static void main(String[] args){
        UF6ACT1P2 frame = new UF6ACT1P2();
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
    
    public UF6ACT1P2() {
        l = new JLabel("Conversor");
        f = new JTextField(100);
        c = new JTextField(100);
        bFC = new JButton("bFC");
        bCF = new JButton("bCF");
        bClean = new JButton("bClean");
        
        setLayout(new FlowLayout());
        
        bFC.addActionListener(this);
        bCF.addActionListener(this);
        bClean.addActionListener(this);
        
        add(l);
        add(f);
        add(c);
        add(bFC);
        add(bCF);
        add(bClean);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("bClean")) {
            f.setText(null);
            c.setText(null);
        } else if(e.getActionCommand().equals("bFC")){
            int far = Integer.parseInt(f.getText());
            int cel = (far - 32) * 5 / 9;
            
            c.setText(String.valueOf(cel));
            
        } else {
            int cel = Integer.parseInt(c.getText());
            int far = (cel *9 / 5) +32;
            
            f.setText(String.valueOf(far));
            
        }
    }
}
