/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf1_act2;

import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import static sun.security.krb5.internal.ktab.KeyTabConstants.keySize;

/**
 *
 * @author Alumne
 */
public class M9_uf1_act2 {

    /**
     * @param args the command line arguments
     */
    public static SecretKey KeygenKeyGeneration(int Keysize){
    
        SecretKey sKey = null;
        if((keySize == 128) || (keySize == 192) || (keySize == 256)){
            try{
                KeyGenerator kgen = KeyGenerator.getInstance("AES");
                kgen.init(keySize);
                sKey = kgen.generateKey();
            } catch(NoSuchAlgorithmException ex){
                System.err.println("Generador no disponible");
            }
        }
        
        
        
        return sKey;
    }
    
    public static void main(String[] args){
        
        int keySz = 128;
        SecretKey sK = KeygenKeyGeneration(keySz);
        
        System.out.println(sK);
        
    }
}
