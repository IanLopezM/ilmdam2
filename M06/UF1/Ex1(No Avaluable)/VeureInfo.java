/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici1_veureinfo;

import java.io.File;

/**
 *
 * @author ianlo
 */
public class VeureInfo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        File f = new File(args[0]);
        String[] arxius = f.list();
        
        if(f.exists()){
            System.out.println("\nExisteix");
            if(f.isDirectory()){
                for (String arxiu : arxius) {
                    System.out.println(arxiu);
                }
            } 
            if(f.isFile()){
                System.out.println("\nNom del fitxer : "+f.getName());
                System.out.println("Ruta           : "+f.getPath());
	        System.out.println("Ruta absoluta  : "+f.getAbsolutePath());
		System.out.println("Es pot escriure: "+f.canRead());
		System.out.println("Es pot llegir  : "+f.canWrite());
		System.out.println("Grandaria      : "+f.length());
		System.out.println("Es un directori: "+f.isDirectory());
		System.out.println("Es un fitxer   : "+f.isFile());
            }      
        } else{
            System.out.println("\nNo existeix");
        }
        if(f.isHidden()){
            System.out.println("\nEs troba ocult");
        } else{
            System.out.println("\nNo es troba ocult");
        }
        System.out.println("\nL'ultima data de modificació es de " + ( 18528 - ((((f.lastModified()/ 1000) / 60 ) / 60) / 24 ))  + " dies enrere");
    //    System.out.println(f.lastModified());
    //    System.out.println( 18528 - ((((f.lastModified()/ 1000) / 60 ) / 60) / 24 ));
        
        if( 18528 - ((((f.lastModified()/ 1000) / 60 ) / 60) / 24 ) < 3){
            System.out.println("\nS ha modificat en els darrers 3 dies");
        }
    }
    
}
