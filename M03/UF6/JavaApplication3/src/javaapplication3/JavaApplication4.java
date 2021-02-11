package javaapplication3;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alumne
 */
public class JavaApplication4 {
    
    public static void main(String[] args) {
        
        int height = 300, width = 600;
        JFrame master = new JFrame("Clic 1");
        JFrame temp = new JFrame("Clic 2");
        
        master.setVisible(true);
        master.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        master.setSize(width, height);
        
        temp.setVisible(true);
        temp.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
        temp.setBounds(width, 0, width, height);
    }
    
    public void setBounds(int x, int y, int widht, int height){
        
    }
    
}
