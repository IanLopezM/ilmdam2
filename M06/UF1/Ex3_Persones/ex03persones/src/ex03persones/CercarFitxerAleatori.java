/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf1_act4;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.BadPaddingException;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
/**
 *
 * @author ianlo
 */
public class M9_uf1_act4 {
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
	//declarem les variables
        Scanner sc = new Scanner(System.in);
	String clau, arxiu;
        int kSize = 256; //podría ser 128 o 192 pero he escollit 256
        
        //demanem la clau i la paraula/es a encriptar
	System.out.print("Introdueix la paraula clau: ");
	clau = sc.nextLine();
	System.out.print("Introdueix l arxiu que vols encriptar i desencriptar: ");
	arxiu = sc.nextLine();

	//Generem la clau amb la size especificara
	SecretKey sKey = passwordKeyGeneration(clau, kSize);

	//Agafem la paraula a encriptar, la transformem en bytes 
        //i cridem a la funció per a encriptar encryptData(sKey, data
	byte[] data;
        File fitxer = new File(arxiu);
        data = Files.readAllBytes(fitxer.toPath());
	byte[] encryptData;
        encryptData = encryptData(sKey, data);

        //Ara la desencriptem utilitzant la clau generada 
        //i el texte encriptat anteriorment
	byte[] decryptData;
        decryptData = decryptData(sKey, encryptData);

	//Mostrem per pantalla el texte encriptat i el desencriptat
	String encripta;
        encripta = new String(encryptData);
	System.out.println("L arxiu encriptat: " + encripta);
	String desencripta;
        desencripta = new String(decryptData);
	System.out.println("La paraula desencriptada: " + desencripta);
        
        //Dividim la ruta per a poder afegir el nom correcte a l arxiu
        String[] partes = arxiu.split("\\.");
        String parte0 = partes[0];
        String parte1 = partes[1];
        
        //afegim el texte encriptat a l arxiu _X
        try{
            File file = new File(parte0 + "_X." + parte1);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(encripta);
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception ex) {
            System.out.println("Hi ha hagut un error");
        }
        
        //afegim el texte desencriptat a l arxiu _Y
        try{
            File file1 = new File(parte0 + "_Y." + parte1);
            FileWriter fileWriter1 = new FileWriter(file1);
            fileWriter1.write(desencripta);
            fileWriter1.flush();
            fileWriter1.close();
        } catch (Exception ex) {
            System.out.println("Hi ha hagut un error");
        }
    }

    // Funcio que donas a la teoria
    public static SecretKey passwordKeyGeneration(String text, int keySize) {
	SecretKey sKey = null;
        
	if ((keySize == 128) || ( keySize == 192) || (keySize == 256)) {
            try {
                byte[] data = text.getBytes("UTF-8");
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(data);
                byte[] key = Arrays.copyOf(hash, keySize/8);
                sKey = new SecretKeySpec(key, "AES");
            } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
                System.out.println("Error generant la clau: " + ex);
            }
	}
        
	return sKey;
    }

    // Metode per a poder encriptar
    public static byte[] encryptData(SecretKey sKey, byte[] data) {
	byte[] encryptedData = null;
        
	try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, sKey);
            encryptedData = cipher.doFinal(data);
	}catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            System.err.println("Error xifrant les dades: " + ex);
	}
        
	return encryptedData;
    }


    // Metode per a poder desencriptar
    public static byte[] decryptData(SecretKey sKey1, byte[] data) {
        byte[] decryptedData = null;
        
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, sKey1);
            decryptedData = cipher.doFinal(data);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            System.err.println("Error desxifrant les dades: " + ex);
        }
        
        return decryptedData;
    }
}
