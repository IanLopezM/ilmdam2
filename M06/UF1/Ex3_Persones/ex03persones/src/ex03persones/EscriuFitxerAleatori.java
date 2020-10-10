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
import java.util.Scanner;

public class EscriuFitxerAleatori {
	public static void main(String[] args) throws IOException {
                Scanner sc = new Scanner(System.in);
		File fitxer = new File("C:\\Users\\Alumne\\Downloads\\persones.txt");
		//Crea un flux (stream) d'arxiu d'accés aleatori per llegir
		RandomAccessFile aleatoriFile = new RandomAccessFile(fitxer, "rw");
		//Les dades per inserir
		String nom[] = new String[3];
		String dni[] = new String[3];
		String cognom[] = new String[3];
		int telf[] = new int[3];
                String correu[] = new String[3];
		//Construeix un buffer (memòria intermèdia) de strings
		StringBuffer buffer = null;
		
		for (int i=0; i<1; i++) {
			aleatoriFile.writeInt(i+1);//1 enter ocupa 4 bytes
			//50 caràcters a 2bytes/caràcter 100 bytes
                        nom[i] = sc.next();
			buffer = new StringBuffer (nom[i]);
			buffer.setLength(20);
			aleatoriFile.writeChars(buffer.toString());
			//1 enter ocupa 4 bytes
                        
                        dni[i] = sc.next();
			buffer = new StringBuffer (dni[i]);
			buffer.setLength(9);
			aleatoriFile.writeChars(buffer.toString());
			//25 caràcters a 2bytes/caràcter 50 bytes
                        
                        cognom[i] = sc.next();
			buffer = new StringBuffer (cognom[i]);
			buffer.setLength(20);
			aleatoriFile.writeChars(buffer.toString());
			//30 caràcters a 2bytes/caràcter 60 bytes
                        
                        correu[i] = sc.next();
			buffer = new StringBuffer (correu[i]);
			buffer.setLength(30);
			aleatoriFile.writeChars(buffer.toString());
			//1 float ocupa 4 bytes
                        
			telf[i] = sc.nextInt();
			aleatoriFile.writeInt(telf[i]);
			//Total 166 bytes
		}
		aleatoriFile.close();
	}
}

