/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf1_act6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author ianlo
 */
public class Desencriptacio {
    
    public static void main(String[] args) throws NoSuchAlgorithmException, 
            InvalidKeySpecException, IOException{
        KeyFactory keyFactory;
        PKCS8EncodedKeySpec privateKeySpec;
        String privateKeyContent;
        PrivateKey privateKey;
        SecretKey secretKey;
        byte[] dataPrivada, dataArxiuEncriptat, dataSimetricaEncriptada,
                privateKeyDecoded, dataDecryptKey;
        dataPrivada = Files.readAllBytes(Paths.get("clauPRIVADA"));

        keyFactory= KeyFactory.getInstance("RSA");
        privateKeyContent = new String(dataPrivada);
        privateKeyContent = privateKeyContent
                .replace("—-BEGIN RSA PRIVATE KEY—-", "")
                .replace("—-END RSA PRIVATE KEY—-", "")
                .replace("\n", "");
        privateKeyDecoded = Base64.getDecoder()
                .decode(privateKeyContent);
        privateKeySpec = new PKCS8EncodedKeySpec(privateKeyDecoded);
        privateKey = keyFactory.generatePrivate(privateKeySpec);
        
        dataArxiuEncriptat = Files
                .readAllBytes(Paths.get("ZZZ_missatge_encriptat"));
        
        dataSimetricaEncriptada = Files
                .readAllBytes(Paths.get("ZZZ_clau_encriptada"));
        
        dataDecryptKey = decryptData(dataSimetricaEncriptada, privateKey);
        secretKey = new SecretKeySpec(dataDecryptKey, 0, 
                 dataDecryptKey.length, "AES");
        
        
    }
    
    public static byte[] decryptData(byte[] data, PrivateKey priv) {
        byte[] encryptedData = null;
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","SunJCE");
            cipher.init(Cipher.DECRYPT_MODE, priv);
            encryptedData = cipher.doFinal(data);
        }
        catch (Exception ex) {
            System.err.println("Error xifrant: " + ex);
        }
        return encryptedData;
    }
    
    
}
