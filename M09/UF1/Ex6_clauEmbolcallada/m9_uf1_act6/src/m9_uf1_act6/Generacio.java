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
import java.util.Base64;

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
       Base64.Encoder encoder = Base64.getEncoder();
        try (FileWriter out = new FileWriter("clauPublica")) {
            out.write("—-BEGIN RSA PUBLIC KEY—-");
            out.write("\n");

            out.write(encoder.encodeToString(pub.getEncoded()));
            out.write("\n");

            out.write("—-END RSA PUBLIC KEY—-");
            out.write("\n");
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
        } catch (IOException ex) {
            System.out.println("Arxiu amb clau privada no creat");
        }
    }
    
}


