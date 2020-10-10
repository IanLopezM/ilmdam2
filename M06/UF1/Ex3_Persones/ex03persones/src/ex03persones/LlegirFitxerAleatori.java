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

public class LlegirFitxerAleatori {
	public static void main(String[] args) throws IOException {
		File fitxer = new File("C:\\Users\\Alumne\\Downloads\\persones.txt");
		//Crea un flux (stream) d'arxiu d'accés aleatori només lectura
		RandomAccessFile aleatoriFile = new RandomAccessFile(fitxer, "r");
		
		//Apuntador s'inicialitza apuntant a l'inici del fitxer
		int apuntador = 0, telf, id;
		char nom[] = new char[20], dni[] = new char[9], cognom[] = new char[20], correu[] = new char[30], aux;
		
		//Recorrer el fitxer llibres
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
			System.out.println("ID: "+id+"\nNom: "+noms+"\nDNI: "+dnis+"\nCognom: "+cognoms+"\nCorreu: "+correus+"\nTelf: "+telf+"\n\n");
			//S'ha de posicionar l'apuntador al següent llibre
			apuntador += 166;
			//Si coincideix on s'està apuntat amb el final del fitxer, sortim
			if(aleatoriFile.getFilePointer()==aleatoriFile.length()) break;
		}
		aleatoriFile.close();//Tancar el fitxer
	}
}

