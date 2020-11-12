/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf1_act7;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

/**
 *
 * @author ianlo
 */
public class Signatura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        KeyPair clausPuPr;
        PublicKey clauPublica;
        PrivateKey clauPrivada;
        String frase;
        int kSize = 512;
        Scanner sc = new Scanner(System.in);
        
        clausPuPr = randomGenerate(kSize);
        clauPublica = clausPuPr.getPublic();
        clauPrivada = clausPuPr.getPrivate();
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
}
