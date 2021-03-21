/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf3act4ianyjesus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 *
 * @author ianlo
 */
public class UF3ACT4IanyJesus {

    /**
     * @param args the command line arguments
     * @throws java.net.SocketException
     * @throws java.net.UnknownHostException
     * 
     * L'ARXIU
     * Exemple2URL.java
     * FA DE
     * SERVIDOR
     * PER A 
     * AQUESTA
     * ACTIVITAT
     * 
     */
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        // TODO code application logic here
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //Socket client
        DatagramSocket clientSocket = new DatagramSocket();
        byte[] enviats = new byte[1024];
        byte[] rebuts = new byte[1024];
        String cadena;
        boolean mescincsec = true;

        //DADES DEL SERVIDOR al qual s'envia el missatge
        InetAddress IPServidor = InetAddress.getLocalHost();
        int port = 9800;

        while (mescincsec) {
            //INTRODUIR DADES PEL TECLAT
            System.out.print("Introdueix missatge: ");
            cadena = in.readLine();
            enviats = cadena.getBytes();

            //ENVIANT DATAGRAMA AL SERVIDOR
            System.out.println("Enviant " + enviats.length
                    + "bytes al servidor.");
            DatagramPacket enviament
                    = new DatagramPacket(enviats, enviats.length, IPServidor,
                            port);
            clientSocket.send(enviament);

            System.out.println("Esperant datagrama... ");
            DatagramPacket paqRebuts = new DatagramPacket(rebuts, rebuts.length);

            clientSocket.setSoTimeout(5000);

            try {
                clientSocket.receive(paqRebuts);
            } catch (SocketTimeoutException e) {
                System.out.println("Massa temps d'espera");
                mescincsec = false;
            }

            if (mescincsec == true) {

                String majuscula = new String(paqRebuts.getData());
                InetAddress IPOrigen = paqRebuts.getAddress();
                int portOrigen = paqRebuts.getPort();
                System.out.println("\tProcedent de: " + IPOrigen + ":" + portOrigen);
                System.out.println("\tDades: " + majuscula.trim());
            }

            if (mescincsec == false) {
                clientSocket.close();
            }

        }

    }

}
