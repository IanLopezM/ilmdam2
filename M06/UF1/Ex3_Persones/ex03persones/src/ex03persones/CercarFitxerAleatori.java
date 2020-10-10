/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex03persones;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author Alumne
 */
public class CercarFitxerAleatori {
    public static void main(String[] args) throws IOException {
        
        File fitxer = new File("C:\\Users\\Alumne\\Downloads\\persones.txt");
	RandomAccessFile aleatoriFile = new RandomAccessFile(fitxer, "r");
        
        Scanner sc = new Scanner(System.in);
        
        int apuntador = 0, telf, id, seleccio, menu;
        char nom[] = new char[20], dni[] = new char[9], cognom[] = new char[20], correu[] = new char[30], aux;
        String menul = "";
        int menun = 0;
        
        System.out.println("Cercar per el nom 1");
        System.out.println("Cercar per el dni 2");
        System.out.println("Cercar per el cognom 3");
        System.out.println("Cercar per el correu 4");
        System.out.println("Cercar per el telf 5");
        
        menu = sc.nextInt();
        sc.nextLine();
        
        if(menu == 1){
            menul = sc.nextLine();
        } else if(menu == 2){
            menul = sc.next();
        } else if(menu == 3){
            menul = sc.next();
        } else if(menu == 4){
            menul = sc.next();
        } else if(menu == 5){
            menun = sc.nextInt();
        }
        
        for (;;) {
            aleatoriFile.seek(apuntador);//Apuntar a l'inici de cada llibre al fitxer
	//Llegeix ID
		id = aleatoriFile.readInt();
			//Llegeix Títol
		for(int i = 0; i<nom.length; i++) {
			aux = aleatoriFile.readChar();
                        nom[i] = aux;
		}
		String noms = new String(nom);
		//Llegeix ISBN
		//Llegeix Autor
		for(int i = 0; i<dni.length; i++) {
                    aux = aleatoriFile.readChar();
                    dni[i] = aux;
		}
		String dnis = new String(dni);
		//Llegeix Editorial
		for(int i = 0; i<cognom.length; i++) {
			aux = aleatoriFile.readChar();
                        cognom[i] = aux;
		}
		String cognoms = new String(cognom);
                       
                for(int i = 0; i<correu.length; i++) {
			aux = aleatoriFile.readChar();
			correu[i] = aux;
		}
		String correus = new String(correu);
		//Llegeix Preu
		telf = aleatoriFile.readInt();
		//Sortida de les dades de cada llibre
                if((noms.trim().toLowerCase().equals(menul.trim().toLowerCase())) || (dnis.trim().toLowerCase().equals(menul.trim().toLowerCase())) || (cognoms.trim().toLowerCase().equals(menul.trim().toLowerCase())) || (correus.trim().toLowerCase().equals(menul.trim().toLowerCase())) || (telf == menun)){
                    System.out.println("ID: "+id+"\nNom: "+noms+"\nDNI: "+dnis+"\nCognom: "+cognoms+"\nCorreu: "+correus+"\nTelf: "+telf+"\n\n");
                } 
		
                //S'ha de posicionar l'apuntador al següent llibre
		apuntador += 166;
		//Si coincideix on s'està apuntat amb el final del fitxer, sortim
		if(aleatoriFile.getFilePointer()==aleatoriFile.length()) break;
	}

        
        
        
        aleatoriFile.close();
        
        
        
        
        
    }
    
    
}
