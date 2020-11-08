/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf1_act6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

/**
 *
 * @author ianlo
 */
public class Desencriptacio {
    
    public static void main(String[] args) throws NoSuchAlgorithmException, 
            InvalidKeySpecException, IOException{
        
        byte[] dataPrivada;
        dataPrivada = Files.readAllBytes(Paths.get("clauPRIVADA"));

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        // Clean private key information
        String privateKeyContent = new String(dataPrivada);
        privateKeyContent = privateKeyContent
                .replace("—-BEGIN RSA PRIVATE KEY—-", "")
                .replace("—-END RSA PRIVATE KEY—-", "")
                .replace("\n", "");

        // Get all bytes decoded from the private key content
        byte[] privateKeyDecoded = Base64.getDecoder()
                .decode(privateKeyContent);

        // Generate private key object from bytes
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyDecoded);
        PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);
        
        
        
        
        
        
    }
    
    
    
    
}
