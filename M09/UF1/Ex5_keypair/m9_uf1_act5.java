/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf1_act5;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;
import javax.crypto.Cipher;

/**
 *
 * @author Alumne
 */
public class M9_uf1_act5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int kSize = 512;
        String frasePerEncriptar, fraseEncriptada, fraseDesencriptada;
        KeyPair clausPuPr;
        PrivateKey clauPr;
        PublicKey clauPu;
        
        System.out.println("Quina es la frase a encriptar?");
        frasePerEncriptar = sc.nextLine();
        long startTime = System.currentTimeMillis();
        clausPuPr = randomGenerate(kSize);
        clauPr = clausPuPr.getPrivate();
        clauPu = clausPuPr.getPublic();
        
        System.out.println("Aquesta es la frase sense encriptar: " + 
                frasePerEncriptar);
        
        byte[] data;
        data = frasePerEncriptar.getBytes();
        
        byte[] enData;
        enData = encryptData(data, clauPu);
        
        byte[] deData;
        deData = decryptData(enData, clauPr);
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println(endTime);
        fraseEncriptada = new String(enData);
        fraseDesencriptada = new String(deData);
        
        System.out.println("Aquesta es la frase encriptada: " +
                fraseEncriptada);
        
        System.out.println("Aquesta es la frase desencriptada: " + 
                fraseDesencriptada);
        
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

    public static byte[] encryptData(byte[] data, PublicKey pub) {
        byte[] encryptedData = null;
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","SunJCE");
            cipher.init(Cipher.ENCRYPT_MODE, pub);
            encryptedData = cipher.doFinal(data);
        }
        catch (Exception ex) {
            System.err.println("Error xifrant: " + ex);
        }
        return encryptedData;
    }
    
    public static byte[] decryptData(byte[] data, PrivateKey pub) {
        byte[] decryptData = null;
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","SunJCE");
            cipher.init(Cipher.DECRYPT_MODE, pub);
            decryptData = cipher.doFinal(data);
        }
        catch (Exception ex) {
            System.err.println("Error xifrant: " + ex);
        }
        return decryptData;
    }
    
} 
