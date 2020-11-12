/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf1_act7;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;
import java.util.Scanner;

/**
 *
 * @author ianlo
 */
public class Signatura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        KeyPair clausPuPr;
        PublicKey clauPublica;
        PrivateKey clauPrivada;
        String frase;
        byte[] dataFrase, dataFraseFirmada;
        int kSize = 512;
        Scanner sc = new Scanner(System.in);
        
        clausPuPr = randomGenerate(kSize);
        clauPublica = clausPuPr.getPublic();
        clauPrivada = clausPuPr.getPrivate();
        
        System.out.println("Frase a encriptar:");
        frase = sc.nextLine();
        dataFrase = frase.getBytes();
        
        dataFraseFirmada = signData(dataFrase, clauPrivada);
        
        ArxiuClauPublica(clauPublica);
        ArxiuClauPrivada(clauPrivada);
        ArxiuBytes(dataFrase, "missatge");
        ArxiuBytes(dataFraseFirmada, "firma");
    }
    
    public static KeyPair randomGenerate(int longuitudClau) {
        KeyPair keys = null;
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(longuitudClau);
            keys = keyGen.genKeyPair();
        }
        catch (Exception ex) {
            System.err.println("Generador no disponible.");
        }
        return keys;
    }
    
    public static byte[] signData(byte[] data, PrivateKey priv) {
        byte[] signature = null;
        try {
            Signature signer = Signature.getInstance("SHA1withRSA");
            signer.initSign(priv);
            signer.update(data);
            signature = signer.sign();
        }
        catch (Exception ex) {
            System.err.println("Error signant les dades: " + ex);
        }
        return signature;
    }
    
    public static void ArxiuClauPublica(PublicKey pub) throws IOException{  
       Base64.Encoder encoder = Base64.getEncoder();
        try (FileWriter out = new FileWriter("clauPublica")) {
            out.write("—-BEGIN RSA PUBLIC KEY—-");
            out.write("\n");

            out.write(encoder.encodeToString(pub.getEncoded()));
            out.write("\n");

            out.write("—-END RSA PUBLIC KEY—-");
            out.write("\n");
            out.close();
        } catch (IOException ex) {
            System.out.println("Arxiu amb clau publica no creat");
        }
    }
    
    public static void ArxiuClauPrivada(PrivateKey priv) throws IOException{  
        Base64.Encoder encoder = Base64.getEncoder();
        try (FileWriter out = new FileWriter("clauPRIVADA")) {
            out.write("—-BEGIN RSA PRIVATE KEY—-");
            out.write("\n");

            out.write(encoder.encodeToString(priv.getEncoded()));
            out.write("\n");

            out.write("—-END RSA PRIVATE KEY—-");
            out.write("\n");
            out.close();
        } catch (IOException ex) {
            System.out.println("Arxiu amb clau privada no creat");
        }
    }
    
    public static void ArxiuBytes(byte[] data, String nameData){
        try(FileOutputStream fos = new FileOutputStream(nameData)){
            fos.write(data);
            fos.close();
        } catch (IOException ex) {
            System.out.println("Arxiu no creat");
        }
        
        
        
    }
}
