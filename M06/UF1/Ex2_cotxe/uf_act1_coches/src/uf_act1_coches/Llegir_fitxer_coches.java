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
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Llegir_fitxer_coches {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
                Scanner sc = new Scanner(System.in);
                int accion = 4;
                int especificar = 5;
                String espString;
                int espInt = 2;
		//Camp variable tipus Comarca
		Uf_act1_coches coche;
		//Declaració del fitxer
		File fitxer = new File("C://Users//Alumne//Downloads/coche.txt");
		//Crea el flux d'entrada
		FileInputStream filein = new FileInputStream(fitxer);
		//Connectar el flux de bytes al flux de dades
		ObjectInputStream dataInCoche = new ObjectInputStream(filein);
                
                System.out.println("Llegir tots els cotxes 1");
                System.out.println("Llegir segons el camp 2");
                System.out.println("Sortir 0");
                accion = sc.nextInt();
                
                if(accion == 1){
                    try {
			while (true){//Llegeix el fitxer
				//Llegeix la comarca
				coche = (Uf_act1_coches) dataInCoche.readObject();
				System.out.println("Marca: " +coche.getMarca()+ "   Model: "+ coche.getModel()+"  Any: " + coche.getAny() + "  Matricula: " + coche.getMatricula());
			}
                    } catch (EOFException eo) {}
                } else if(accion == 2){
                    System.out.println("Especificar marca 1");
                    System.out.println("Especificar model 2");
                    System.out.println("Especificar any 3");
                    System.out.println("Especificar matricula 4");
                    especificar = sc.nextInt();
                    
                    if(especificar == 1){
                        System.out.println("Quina marca vols cercar?");
                        espString = sc.next();
                        try {
			while (true){//Llegeix el fitxer
				//Llegeix la comarca
				coche = (Uf_act1_coches) dataInCoche.readObject();
                                if(espString.equalsIgnoreCase(coche.getMarca())){
                                    System.out.println("Marca: " +coche.getMarca()+ "   Model: "+ coche.getModel()+"  Any: " + coche.getAny() + "  Matricula: " + coche.getMatricula());
                                }
			}
                    } catch (EOFException eo) {}
                    } else if(especificar == 2){
                        System.out.println("Quin model vols cercar?");
                        espString = sc.next();
                        try {
			while (true){//Llegeix el fitxer
				//Llegeix la comarca
				coche = (Uf_act1_coches) dataInCoche.readObject();
				if(espString.equalsIgnoreCase(coche.getModel())){
                                    System.out.println("Marca: " +coche.getMarca()+ "   Model: "+ coche.getModel()+"  Any: " + coche.getAny() + "  Matricula: " + coche.getMatricula());
                                }
			}
                    } catch (EOFException eo) {}
                    } else if(especificar == 3){
                        System.out.println("Quin any vols cercar?");
                        espInt = sc.nextInt();
                        try {
			while (true){//Llegeix el fitxer
				//Llegeix la comarca
				coche = (Uf_act1_coches) dataInCoche.readObject();
				if(espInt == coche.getAny()){
                                    System.out.println("Marca: " +coche.getMarca()+ "   Model: "+ coche.getModel()+"  Any: " + coche.getAny() + "  Matricula: " + coche.getMatricula());
                                }
			}
                    } catch (EOFException eo) {}
                    } else if(especificar == 4){
                        System.out.println("Quina matricula vols cercar?");
                        espString = sc.next();
                        try {
			while (true){//Llegeix el fitxer
				//Llegeix la comarca
				coche = (Uf_act1_coches) dataInCoche.readObject();
				if(espString.equalsIgnoreCase(coche.getMatricula())){
                                    System.out.println("Marca: " +coche.getMarca()+ "   Model: "+ coche.getModel()+"  Any: " + coche.getAny() + "  Matricula: " + coche.getMatricula());
                                }
			}
                    } catch (EOFException eo) {}
                    }
                    
                
                }
		
		dataInCoche.close();//Tanca el stream d'entrada
                sc.close();
    }
}

