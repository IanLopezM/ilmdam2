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
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Enumeration;
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
            CertificateException, UnrecoverableKeyException{
        // TODO code application logic here
        
        //declaració de variables
        KeyStore ks = KeyStore.getInstance("JCEKS");
        Scanner sc = new Scanner(System.in);
        FileInputStream fis = new FileInputStream("E:/dam/m09/uf1/act8/llavesianlopez");
        String contrasenya = "123456", aliasllavevuelta;
        char[] arrayContrasenya = contrasenya.toCharArray();
        byte[] arrayEncoded;
    
        //carreguem la keystore
        ks.load(fis, arrayContrasenya);
        
        //Creem una enumeració de string que conté els noms dels alias
        Enumeration<String> aliasllaves = ks.aliases();
        
        while(aliasllaves.hasMoreElements()) {
            
            aliasllavevuelta = aliasllaves.nextElement();
            System.out.println("Entry name: " + aliasllavevuelta + 
                    "\t" + "Algorithm: " + ks.getKey(aliasllavevuelta, 
                            arrayContrasenya).getAlgorithm() + "\t");
            arrayEncoded = ks.getKey(aliasllavevuelta,arrayContrasenya)
                    .getEncoded();
            System.out.println("Key Size: " + arrayEncoded.length + " bytes");
            
            
        }
        
        
        
    }
    
}
