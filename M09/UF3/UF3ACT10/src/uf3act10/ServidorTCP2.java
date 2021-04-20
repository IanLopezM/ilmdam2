/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf3act10;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ianlo
 */
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ServidorTCP2 implements Runnable {

    ServerSocket srv;
    Socket cln;
    int nCln;
    String cadena = "";

    public ServidorTCP2(ServerSocket srv, Socket clnConn) {
        this.cln = clnConn;
        this.nCln = this.nCln + 1;
        this.srv = srv;
        
        
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int numPort = 60000;
        ServerSocket servidor = new ServerSocket(numPort);
        String cadena = "";

        System.out.println("Quants clients soporta aquest server?");
        int numClnts = sc.nextInt();

//        Runnable[] arrayRunnable = new Runnable[numClnts];
        Thread[] arrayThread = new Thread[numClnts];

        // Determinem les vegades que es conectaran els clients
        for (int i = 0; i < numClnts; i++) {
            Socket clientConnectat = servidor.accept();

            // Runnable
            ServidorTCP2 a = new ServidorTCP2(servidor, clientConnectat);

            // Thread
            arrayThread[i] = new Thread(a);
            arrayThread[i].start();

        }
    }

    @Override
    public void run() {
        try {
            //FLUX DE SORTIDA AL CLIENT
            PrintWriter fsortida = new PrintWriter(this.cln.getOutputStream(), true);

            //FLUX D'ENTRADA DEL CLIENT
            BufferedReader fentrada;

            System.out.println("Client " + this.nCln + " connectat... ");

            fentrada = new BufferedReader(new InputStreamReader(this.cln.getInputStream()));

            while ((cadena = fentrada.readLine()) != null) {

                fsortida.println(cadena);
                System.out.println("Rebent: " + cadena);
                if (cadena.equals("*")) {
                    break;
                }
            }

            //TANCAR STREAMS I SOCKETS
            System.out.println("Tancant connexió... ");
            fentrada.close();
            fsortida.close();
            this.cln.close();
            this.srv.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

