/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf1_act6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 *
 * @author ianlo
 */
public class Generacio {
    
    public static void main(String[] args) throws IOException {
        int kSize = 512;
        KeyPair parellDeClaus;
        PrivateKey clauPrivada;
        PublicKey clauPublica;
        
        parellDeClaus = randomGenerate(kSize);
        clauPrivada = parellDeClaus.getPrivate();
        clauPublica = parellDeClaus.getPublic();
        
        ArxiuClauPublica(clauPublica);
        ArxiuClauPrivada(clauPrivada);
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
    
    public static void ArxiuClauPublica(PublicKey pub) throws IOException{  
        byte[] data = pub.getEncoded();
        String strData = new String(data);
        File file = new File("clauPublica");
        FileWriter fw = new FileWriter(file);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(strData);
        }
        System.out.println("Arxiu amb clau publica creat");
    }
    
    public static void ArxiuClauPrivada(PrivateKey priv) throws IOException{  
        byte[] data = priv.getEncoded();
        String strData = new String(data);
        File file = new File("clauPRIVADA");
        FileWriter fw = new FileWriter(file);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(strData);
        }
        System.out.println("Arxiu amb clau privada creat");
    }
    
}


