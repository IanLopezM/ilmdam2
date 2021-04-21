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

public class ServidorTCP2 extends Thread {

    // ATRIBUTOS
    private final Socket cliente;
    private final int numCliente;
    private boolean conActiva;

    // CONSTRUCTOR
    public ServidorTCP2(Socket clienteConectado, int i) {
        this.cliente = clienteConectado;
        this.numCliente = i;
        this.conActiva = true;
    }

    // GETTER PARA COMPROBAR SI LA CONEXION CON ESE CLIENTE HA FINALIZADO
    public boolean isConActiva() {
        return conActiva;
    }

    // RUN
    public void run() {

        // VARIABLES
        String cadena;

        // FLUJO DE SALIDA Y ENTRADA AL CLIENTE
        PrintWriter fSalida = null;
        BufferedReader fEntrada = null;
        try {
            fSalida = new PrintWriter(cliente.getOutputStream(), true);
            fEntrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        } catch (IOException e) {
            System.err.println("Error creando flujo de salida o entrada al cliente " + numCliente);
        }

        // CONTROLA ERRORES RECIBIENDO MENSAJES DEL CLIENTE
        try {
            // VA MOSTRANDO LOS MENSAJES DEL CLIENTE HASTA QUE SE DESCONECTE
            if (fEntrada != null) {
                while ((cadena = fEntrada.readLine()) != null) {

                    fSalida.println(cadena);
                    System.out.println("Cliente " + numCliente + " - Recibiendo: " + cadena);
                    if (cadena.equals("*")) {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error en la conexion del cliente " + numCliente);
        }

        // CONTROLA DESCONEXION CLIENTE
        try {
            // CERRAR STREAMS Y SOCKETS
            if (fEntrada != null) {
                fEntrada.close();
            }
            if (fSalida != null) {
                fSalida.close();
            }
            cliente.close();
            conActiva = false;
            System.out.println("Cerrando conexión cliente..." + numCliente);
        } catch (IOException e) {
            System.out.println("Error cerrando conexion con el cliente " + numCliente);
        }
    }

    // METODO QUE COMPRUEBA SI HAN ACABADO TODAS LAS CONEXIONES CON LOS CLIENTES
    private static boolean finalServer(ServidorTCP2[] c, int totalClientes) {

        boolean fin = false;
        boolean clienteConectado = false;

        int i = 0;
        while (i < totalClientes && !clienteConectado) {

            if (c[i] != null) {
                clienteConectado = c[i].isConActiva();
            }
            fin = !clienteConectado;
            i++;
        }

        return fin;
    }

    // MAIN
    public static void main(String[] args) {

        // VARIABLES
        final int totalClientes;
        Scanner sc = new Scanner(System.in);
        final int numPort = 60000;
        ServerSocket servidor = null;

        System.out.println("cuantos clientes soporta el servidor?");
        totalClientes = sc.nextInt();

        ServidorTCP2 clientes[] = new ServidorTCP2[totalClientes];

        // CONTROLA LA CONEXION DEL SERVIDOR
        try {
            // INICIALIZO SERVIDOR
            servidor = new ServerSocket(numPort);

            // INDICO CREACION SERVIDOR
            System.out.println("Servidor empezado");

        } catch (IOException e) {
            System.err.println("Error inicializando servidor");
        }

        // CONTROLA LA CONEXION CON EL CLIENTE
        try {
            // BUCLE N CLIENTES
            for (int i = 0; i < totalClientes; i++) {

                // ESPERA CONEXION DE UN CLIENTE
                System.out.println("Esperando conexión... ");
                Socket clienteConectado = null;
                if (servidor != null) {
                    clienteConectado = servidor.accept();
                    System.out.println("Cliente conectado... " + i);

                    // LANZA UN HILO CON UN NUEVO CLIENTE
                    clientes[i] = new ServidorTCP2(clienteConectado, i);
                    clientes[i].start();
                }
            }
        } catch (IOException e) {
            System.err.println("Error conectando con cliente");
        }

        // INDICO QUE SE HA LLEGADO AL LIMITE DE CLIENTES
        System.out.println("Limite de clientes alcanzado (" + totalClientes + ")");

        // CONTROLA LA DESCONEXION DEL SERVIDOR
        try {
            // CUANDO EL SERVIDOR HA LLEGADO AL MAXIMO DE CLIENTES, COMPRUEBA CONSTANTEMENTE
            // SI SE HAN DESCONECTADO TODOS LOS CLIENTES
            while (!finalServer(clientes, totalClientes)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (servidor != null) {
                servidor.close();
            }
            System.out.println("Cerrando conexión servidor");
        } catch (IOException e) {
            System.out.println("Error cerrando conexion del servidor");
        }
    }
}
