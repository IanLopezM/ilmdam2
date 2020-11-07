/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf1_act6;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author ianlo
 */
public class Encriptacio {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arxiuPublica;
        Path pathArxiuPublica;
    
        System.out.println("Digues el nom de l arxiu de la clau publica");
        arxiuPublica = sc.nextLine();
        
        pathArxiuPublica = Paths.get(arxiuPublica);
       
    }
}
