/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf1_act8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Scanner;


/**
 *
 * @author ianlo
 */
public class M9_uf1_act8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws KeyStoreException, 
            FileNotFoundException{
        // TODO code application logic here
        
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        Scanner sc = new Scanner(System.in);
        FileInputStream fis = new FileInputStream("E:/dam/m09/uf1/act8/llavesianlopez");
        String contrasenya = "123456";
        char[] arrayContrasenya = contrasenya.toCharArray();
    }
    
}
