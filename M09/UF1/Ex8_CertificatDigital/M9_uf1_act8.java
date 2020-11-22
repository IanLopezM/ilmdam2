/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf1_act8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.X509EncodedKeySpec;
import static java.time.Clock.system;
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
        FileInputStream fis;
        fis = new FileInputStream("E:/dam/m09/uf1/act8/llavesianlopez");
        FileOutputStream fos;
        String contrasenya = "123456", aliasllavevuelta, llaveaexportar;
        char[] arrayContrasenya = contrasenya.toCharArray();
        byte[] arrayEncoded;
        int llaveALlevarse = 0;
        X509EncodedKeySpec x509EncodedKeySpec;
        Key llaveexportar;
    
        //carreguem la keystore
        ks.load(fis, arrayContrasenya);
        
        //Creem una enumeració de string que conté els noms dels alias
        Enumeration<String> aliasllaves = ks.aliases();
        
        
        while(aliasllaves.hasMoreElements()) {
            
            aliasllavevuelta = aliasllaves.nextElement();
            System.out.print("Entry name: " + aliasllavevuelta + 
                    "\t\t" + "Algorithm: " + ks.getKey(aliasllavevuelta, 
                            arrayContrasenya).getAlgorithm() + "\t\t");
            
            arrayEncoded = ks.getKey(aliasllavevuelta,arrayContrasenya)
                    .getEncoded();
            System.out.print("Key Size: " + arrayEncoded.length + 
                    " bytes \t\t");
            
            if (ks.getCertificateChain(aliasllavevuelta) == null){
                System.out.print("Certificat Expiry: No te certificat");
            } else {
                System.out.print("Certificat Expiry: " + ( (X509Certificate) 
                        ks.getCertificate(aliasllavevuelta)).getNotAfter());
            }
            
            System.out.print("\t\tLast Modified: " + 
                    ks.getCreationDate(aliasllavevuelta));
            
            System.out.println("");
        }
        
        System.out.println("Quina clau vols exportar?");
        Enumeration<String> aliasllaves2 = ks.aliases();
            llaveaexportar = sc.nextLine();
            while(aliasllaves2.hasMoreElements() && llaveALlevarse == 0){
                aliasllavevuelta = aliasllaves2.nextElement();
                if(aliasllavevuelta.equals(llaveaexportar.trim())){
                    llaveexportar = ks.getKey(aliasllavevuelta, 
                            arrayContrasenya);
                    x509EncodedKeySpec = new X509EncodedKeySpec(llaveexportar
                            .getEncoded());
                    fos = new FileOutputStream("E:/dam/m09/uf1/act8/" 
                            + aliasllavevuelta + "_clau.cer");
                    System.out.println("Creat");
                }
            }
    }
    
}
