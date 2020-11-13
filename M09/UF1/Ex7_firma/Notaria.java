/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf1_act7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Scanner;

/**
 *
 * @author ianlo
 */
public class Notaria {
     
    public static void main(String[] args) throws IOException, 
            NoSuchAlgorithmException, InvalidKeySpecException{
        PublicKey clauArxiuPublica;
        byte[] frase, firma;
        boolean isValid;
        String resultado;
        
        clauArxiuPublica = recuperarClauPublica();
        frase = recuperarArxiu("missatge");
        firma = recuperarArxiu("firma");
        isValid = validateSignature(frase, firma, clauArxiuPublica);
        resultado = isValid(isValid); 
        System.out.println(resultado);
    }
    
    public static boolean validateSignature(byte[] data, byte[] signature, 
            PublicKey pub) {
        boolean isValid = false;
        try {
            Signature signer = Signature.getInstance("SHA1withRSA");
            signer.initVerify(pub);
            signer.update(data);
            isValid = signer.verify(signature);
        }
        catch (Exception ex) {
            System.err.println("Error validant les dades: " + ex);
        }
        return isValid;
    }
    
    public static PublicKey recuperarClauPublica() throws IOException, 
            NoSuchAlgorithmException, InvalidKeySpecException{   
        Scanner sc = new Scanner(System.in);
        PublicKey clauArxiuPublica;
        X509EncodedKeySpec publicKeySpec;
        byte[] publicKeyDecoded, dataPublica;
        String arxiuPublica;
        
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
        
        return clauArxiuPublica;
    }
    
    public static byte[] recuperarArxiu(String nameData) throws IOException{
        byte[] data;
        
        data = Files.readAllBytes(Paths.get(nameData));
        
        return data;
    }
    
    public static String isValid(boolean isValid){
        String resultado = null;
    
        if(isValid){
            resultado = "Comprovant signatura de l arxiu missatge... OK";
        } else{
            resultado = "Comprovant signatura de l arxiu missatge... ERROR";
        }
        
        return resultado;
    }
    
}
