/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf1_act6;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author ianlo
 */
public class Encriptacio {
    
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner sc = new Scanner(System.in);
        String arxiuPublica, textePerPantalla;
        Path pathArxiuPublica;
        byte[] clauSimetrica;
        
        System.out.println("Digues el nom de l arxiu de la clau publica");
        arxiuPublica = sc.nextLine();
        
        pathArxiuPublica = Paths.get(arxiuPublica);
        
        clauSimetrica = keyGenerator().getEncoded();
       
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
    
}
