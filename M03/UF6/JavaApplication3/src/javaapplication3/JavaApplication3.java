/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import com.sun.javafx.font.Metrics;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Alumne
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        int x = 400, y = 300;
        
        JFrame frame = new JFrame();
        //frame.setSize(100, 200);
        frame.setBounds((int) Math.round(width)/2 - x/2, (int) Math.round(height)/2 - y/2, x, y);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
    }
    
    public void setBounds(int x, int y, int widht, int height){
        
    }
    
}
