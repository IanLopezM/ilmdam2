/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf3act10;

import java.net.*;
import java.io.*;

public class ClientTCP2 implements Runnable {

    public static String cadena = "", eco = "";
    static PrintWriter fsortida;
    static BufferedReader fentrada;
    static BufferedReader in;

    public static void main(String[] args) throws Exception {

        String host = "localhost";
        int port = 60000;//Port remot
        Socket client = new Socket(host, port);

        //FLUX DE SORTIDA AL SERVIDOR
        fsortida = new PrintWriter(client.getOutputStream(), true);

        //FLUX D'ENTRADA AL SERVIDOR
        fentrada = new BufferedReader(new InputStreamReader(client.getInputStream()));

        //FLUX PER A ENTRADA ESTÀNDARD
        in = new BufferedReader(new InputStreamReader(System.in));

        //System.out.println("Primer de tot possa el teu nom si us plau: ");
        //Lectura teclat
        cadena = in.readLine();

        while ((cadena = fentrada.readLine()) != null) {
            //Lectura del teclat
            
            fsortida.println(cadena);
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
        try {
            while (true) {
                //Rebuda cadena del servidor
                eco = fentrada.readLine();

                System.out.println("  =>ECO: " + eco);

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
