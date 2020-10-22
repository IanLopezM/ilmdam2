/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf4_act4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Alumne
 */
public class M9_uf4_act4 {

   public static void main(String[] args) {
	Scanner teclado = new Scanner (System.in);
	String clau;
	String contrasenya;
	System.out.println("Quina es la clau?");
	clau=teclado.next();
	System.out.println("Quina es la contrasenya?");
	contrasenya=teclado.next();
	//AES
	//byte [] e1 = passwordKeyGeneration(clau,128).getEncoded();
	int keySize=256;
	String texto = clau;
	SecretKeySpec sKey = null;
	if ((keySize == 128)|| (keySize==192)||(keySize==256)) {
		try {
			
			byte[] data = texto.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte [] hash = md.digest(data);
		    byte [] key = Arrays.copyOf(hash, keySize/8);
			sKey = new SecretKeySpec(key, "AES");
			
		
			
		}catch(UnsupportedEncodingException | NoSuchAlgorithmException ex) {
			System.err.println("Error al generar la clau."+ ex);
		}
	}
	//LLEGIR FITXER 
	File fitxer = new File ("arxiu.txt");
	//ECB
	byte [] e2 = contrasenya.getBytes();
	byte [] e3 = encryptData( sKey, e2);
	//MOSTRAR VALOR ENCRIPTAT
	byte [] e1 = encryptData(sKey, e2);
	String s1 = new String(e1);
	System.out.println("missatge encriptat:"+s1);
	//PASSAR VALORS ENCRIPTATS ECB
	byte [] e4 = decryptData( sKey,  e1);
	byte [] e5 = decryptData(sKey, e1);
	String s = new String(e5);
	System.out.println("missatge desincriptat:"+s);
	}
	//ENCRIPTAR
	public static byte[] encryptData(SecretKey sKey, byte[] data) {
		byte[] encryptedData = null;
		
		try {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, sKey);
		encryptedData = cipher.doFinal(data);
		}
		catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
		System.err.println("Error xifrant les dades: " + ex);
		}
		return encryptedData;
		}
	//DESENCRIPTAR
	public static byte[] decryptData(SecretKey sKey, byte[] data) {
		byte[] encryptedData = null;
		
		try {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, sKey);
		encryptedData = cipher.doFinal(data);
		}
		catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
		System.err.println("Error xifrant les dades: " + ex);
		}
		return encryptedData;
		}
}
