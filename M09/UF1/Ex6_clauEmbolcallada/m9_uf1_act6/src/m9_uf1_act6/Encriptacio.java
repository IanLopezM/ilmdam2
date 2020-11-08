/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf1_act6;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author ianlo
 */
public class Encriptacio {
    
    public static void main(String[] args) throws NoSuchAlgorithmException, 
            InvalidKeyException, NoSuchPaddingException, 
            IllegalBlockSizeException, BadPaddingException, IOException, 
            InvalidKeySpecException, Exception {
        
        Scanner sc = new Scanner(System.in);
        String arxiuPublica, textePerPantalla;
        File filePublica;
        PublicKey clauArxiuPublica;
        SecretKey clauSimetrica;
        byte[] dataTextePerPantalla, encriptedDataTextePerPantalla, 
                clauSimetricaBytes, clauSimetricaEncriptada, dataPublica,
                publicKeyDecoded;
        X509EncodedKeySpec publicKeySpec;
        
        System.out.println("Digues el nom de l arxiu de la clau publica");
        arxiuPublica = sc.nextLine();
        dataPublica = Files.readAllBytes(Paths.get(arxiuPublica));
        
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        String publicKeyContent = new String(dataPublica);
        publicKeyContent = publicKeyContent
        .replace("—-BEGIN RSA PUBLIC KEY—-", "")
        .replace("—-END RSA PUBLIC KEY—-", "")
        .replace("\n", "");
        publicKeyDecoded = Base64.getDecoder()
        .decode(publicKeyContent);
        publicKeySpec = new X509EncodedKeySpec(publicKeyDecoded);
        clauArxiuPublica = keyFactory.generatePublic(publicKeySpec);
        
        clauSimetrica = keyGenerator();
        clauSimetricaBytes = clauSimetrica.getEncoded();
        
        System.out.println("Quin es el texte que vols encriptar?");
        textePerPantalla = sc.nextLine();
        dataTextePerPantalla = textePerPantalla.getBytes();
        
        encriptedDataTextePerPantalla = encryptData(clauSimetrica, 
                dataTextePerPantalla);

        System.out.println(new String (clauSimetricaBytes));
        
        clauSimetricaEncriptada = encryptData(clauSimetricaBytes, 
                clauArxiuPublica);
        
        //System.out.println(new String (clauSimetricaEncriptada));
        
        arxiuClauEncriptada(clauSimetricaEncriptada);
        arxiuMissatgeEncriptat(encriptedDataTextePerPantalla);
    }
    
    public static SecretKey keyGenerator() throws NoSuchAlgorithmException{
        SecretKey sKey = null;
        int kSize = 256;
        try{
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(kSize);
            sKey = kgen.generateKey();
        } catch (Exception ex){
            System.err.println("Generador no disponible.");
        }
        return sKey;
    }
    
    public static byte[] encryptData(SecretKey sKey, byte[] data) 
            throws InvalidKeyException, NoSuchPaddingException, 
            IllegalBlockSizeException, BadPaddingException {
	byte[] encryptedData = null;
        
	try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, sKey);
            encryptedData = cipher.doFinal(data);
	}catch (NoSuchAlgorithmException | NoSuchPaddingException | 
                InvalidKeyException | IllegalBlockSizeException |
                BadPaddingException ex) {
            System.err.println("Error xifrant les dades: " + ex);
	}
        
	return encryptedData;
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

    public static void arxiuClauEncriptada(byte[] data){
        try{
            BufferedOutputStream bos = new BufferedOutputStream
            (new FileOutputStream("ZZZ_clau_encriptada"));
            bos.write(data);
            bos.flush();
        } catch (Exception ex) {
            System.err.println("Hi ha hagut un error");
        }
    }
    
    public static void arxiuMissatgeEncriptat(byte[] data){
        try{
            BufferedOutputStream bos = new BufferedOutputStream
            (new FileOutputStream("ZZZ_missatge_encriptat"));
            bos.write(data);
            bos.flush();
        } catch (Exception ex) {
            System.err.println("Hi ha hagut un error");
        }
    }
}
