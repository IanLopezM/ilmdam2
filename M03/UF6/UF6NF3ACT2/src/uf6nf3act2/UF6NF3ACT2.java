/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf6nf3act2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Alumne
 */
public class UF6NF3ACT2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here

        String cadena;
        int num = 1234567890, cont = 0;
        FileReader f = new FileReader("dades.txt");
        BufferedReader b = new BufferedReader(f);

        while ((cadena = b.readLine()) != null) {
            try {
                num = Integer.valueOf(cadena);
                cont = cont + num;
            } catch (Exception e) {
                
                if (num != 1234567890) {
                    System.out.println(cont);
                    cont = 0;
                }
                System.out.println(cadena);
            }
        }
        //System.out.println(cadena);
        System.out.println(cont);
        b.close();
    }

}
