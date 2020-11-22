/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf1_act8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Scanner;


/**
 *
 * @author ianlo
 */
public class M9_uf1_act8 {

    /**
     * @param args the command line arguments
     * @throws java.security.KeyStoreException
     * @throws java.io.FileNotFoundException
     * @throws java.security.NoSuchAlgorithmException
     * @throws java.security.cert.CertificateException
     */
    public static void main(String[] args) throws KeyStoreException, 
            FileNotFoundException, IOException, NoSuchAlgorithmException,
            CertificateException{
        // TODO code application logic here
        
        //declaració de variables
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        Scanner sc = new Scanner(System.in);
        FileInputStream fis = new FileInputStream("E:/dam/m09/uf1/act8/llavesianlopez");
        String contrasenya = "123456";
        char[] arrayContrasenya = contrasenya.toCharArray();
    
        ks.load(fis, arrayContrasenya);
    }
    
}
