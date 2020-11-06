/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf1_act6;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 *
 * @author ianlo
 */
public class Generacio {
    
    public static void main(String[] args) {
        int kSize = 512;
        KeyPair parellDeClaus;
        PrivateKey clauPrivada;
        PublicKey clauPublica;
        
        parellDeClaus = randomGenerate(kSize);
        clauPrivada = parellDeClaus.getPrivate();
        clauPublica = parellDeClaus.getPublic();
        
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

