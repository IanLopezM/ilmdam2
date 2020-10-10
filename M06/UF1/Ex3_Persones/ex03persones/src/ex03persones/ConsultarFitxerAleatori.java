/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex03persones;

/**
 *
 * @author Alumne
 */
import java.io.*;
import java.util.*;

public class ConsultarFitxerAleatori {
	public static void main(String[] args) throws IOException {
		File fitxer = new File("C:\\Users\\Alumne\\Downloads\\persones.txt");
		//Crea un flux (stream) d'arxiu d'accés aleatori només lectura
		RandomAccessFile aleatoriFile = new RandomAccessFile(fitxer, "r");
		
		int apuntador = 0, telf, id, seleccio;
		char nom[] = new char[20], dni[] = new char[9], cognom[] = new char[20], correu[] = new char[30], aux;
		//Demana a l'usuari que seleccioni el llibre pel seu identificador
		System.out.print("Introdueixi el ID del llibre a consultar: ");
		Scanner stdin = new Scanner (System.in);
				
		seleccio = stdin.nextInt();
		apuntador = (seleccio-1)*166;
		
		if (apuntador >= aleatoriFile.length()) {
			System.out.println("ERROR: ID incorrecte, no existeix aquest llibre");
		} else {//Apuntar a l'inici del llibre seleccionat al fitxer
			aleatoriFile.seek(apuntador);
			id = aleatoriFile.readInt();//Llegeix ID
			for(int i = 0; i<nom.length; i++) {//Llegeix Títol
				aux = aleatoriFile.readChar();
				nom[i] = aux;
			}
			String noms = new String(nom);
			//Llegeix ISBN
			//isbn = aleatoriFile.readInt();
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
			//Llegeix Preu
                        for(int i = 0; i<correu.length; i++) {
				aux = aleatoriFile.readChar();
				correu[i] = aux;
			}
			String correus = new String(correu);
                        
			telf = aleatoriFile.readInt();
			//Sortida de les dades de cada llibre
			System.out.println("ID: "+id+"\nNom: "+noms+"\nDNI: "+dnis+"\nCognom: "+cognoms+"\nCorreu: "+correus+"\nTelf: "+telf+"\n\n");
		}
		aleatoriFile.close();//Tancar el fitxer
	}
}

