/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf_act1_coches;

/**
 *
 * @author Alumne
 */
import java.io.*;
import java.util.Scanner;

public class Escriu_fitxer_coches {
	public static void main(String[] args) throws IOException {
                Scanner sc = new Scanner(System.in);
                int accion = 4;
		//Camp variable tipus Comarca
		Uf_act1_coches coche;
		//Declaració del fitxer
		File fitxer = new File("C://Users//Alumne//Downloads/coche.txt");
		//Crea el flux de sortida
		FileOutputStream fileout = new FileOutputStream(fitxer);
		//Connectar el flux de bytes al flux de dades
		ObjectOutputStream dataOuCoche = new ObjectOutputStream(fileout);
		//Les dades per generar els objectes Comarca
		String marca[] = {"Audi", "Seat", "Mercedes", "Fiat", "Renault", "Citroen", "Ferrari", "BMW", "Porsche"};
                String model[] = {"R8", "Leon", "Clase A", "500", "Peugeot", "C4", "f40", "i8", "Panamera"};
		int any[] = {2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009};
                String matricula[] = {"1234QWE", "2345BES", "3456FGR", "4567CTG", "5678PFI", "6789KVJ", "7890PLM", "8901FLG", "9012FJG"};
		//Recorre els arrays
		for (int i=0; i<marca.length; i++){//Crea la comarca
			coche = new Uf_act1_coches(marca[i], model[i], any[i], matricula[i]);
			dataOuCoche.writeObject(coche);//L'escriu al fixer
                        
		}
                
                while(accion != 0){
                if(accion == 1){
                    String marcaAñ;
                    String modelAñ;
                    int añoAñ;
                    String matriculaAñ;
                    
                    
                    System.out.println("Marca");
                    marcaAñ = sc.next();
                    System.out.println("Model");
                    modelAñ = sc.next();
                    System.out.println("Any");
                    añoAñ = sc.nextInt();
                    System.out.println("Matricula");
                    matriculaAñ = sc.next();
                
                    coche =  new Uf_act1_coches(marcaAñ, modelAñ, añoAñ, matriculaAñ);
                    dataOuCoche.writeObject(coche);
                }
                
                System.out.println("Afegir un cotxe 1");
                System.out.println("Sortir 0");
                
                accion = sc.nextInt();
                
                
                }
                
                
                
                
                
                
                
		dataOuCoche.close();//Tanca el stream de sortida
	}
        

}


