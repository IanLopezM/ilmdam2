package uf3act10;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientTCP2 implements Runnable {

    static String cadena, eco = "";
    static BufferedReader fentrada;

    public static void main(String[] args) throws Exception {

        String host = "localhost";
        int port = 60000;//Port remot
        Socket client = new Socket(host, port);
        ClientTCP2 clientR = new ClientTCP2();
        Thread t1 = new Thread(clientR);

        //FLUX DE SORTIDA AL SERVIDOR
        PrintWriter fsortida = new PrintWriter(client.getOutputStream(), true);

        //FLUX D'ENTRADA AL SERVIDOR
        fentrada = new BufferedReader(new InputStreamReader(client.getInputStream()));

        //FLUX PER A ENTRADA ESTÀNDARD
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Introdueix la cadena: ");
        //Lectura teclat
        cadena = in.readLine();
        t1.start();
        while (!cadena.equals("")) {
            //Enviament cadena al servidor
            fsortida.println(cadena);

            //Lectura del tecla
            cadena = in.readLine();
        }

        fsortida.close();
        fentrada.close();
        System.out.println("Finalització de l'enviament...");
        in.close();
        client.close();

    }

    @Override
    public void run() {
        while (!cadena.equals("")) {
            try {
                //Rebuda cadena del servidor
                eco = fentrada.readLine();
                System.out.println("  =>ECO: " + eco);
            } catch (IOException ex) {
                //Logger.getLogger(ClientTCP2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
