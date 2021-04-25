/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06uf4act3;

import ElsMeusBeans.BaseDades;
import ElsMeusBeans.Comanda;
import ElsMeusBeans.Producte;
import ElsMeusBeans.Venda;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author ianlo
 */
public class M06uf4act3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //*     MYSQL*/
        String urldb = "jdbc:mysql://localhost:3306/basedades";
        String usuari = "root";
        String contrasenya = "";
        String driver = "com.mysql.jdbc.Driver";
        
        //Es crea un objecte BaseDades
        BaseDades bd = new BaseDades(urldb, usuari, contrasenya, driver);
        bd.setCrearConnexio(); //Es crea la connexió a la base de dades
        
        //Variables per demanar les dades per teclat
        int idproducte = 0;
        int quantitat = 0;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Introdueix el id del producte: ");            
        idproducte = scan.nextInt();

        System.out.println("Introdueix la quantitat del producte: ");            
        quantitat = scan.nextInt();
        
        if (bd.getCrearConnexio()) {
            System.out.println("Connectat");
            
            System.out.println("======================================");
            System.out.println("LLISTA INICIAL DE PRODUCTES");
            VeureProductes(bd);
            
            //Crea una venda
            System.out.println("======================================");
            System.out.println("ES CREA VENDA DE ID " + idproducte + " AMB QUANTITAT " + quantitat);
            CrearVenda(bd, idproducte, quantitat);//Si no hi ha estoc no es crea venda
            
            System.out.println("======================================");
            System.out.println("LLISTA DE PRODUCTES DESPRÉS DE CREAR VENDA");
            VeureProductes(bd);
            
            System.out.println("======================================");
            System.out.println("LLISTA DE VENDES");
            VeureVendes(bd);
            
            System.out.println("======================================");
            System.out.println("LLISTA DE COMANDES");
            VeureComandes(bd);
            
        } else System.out.println("NO connectat");
        //Tancar connexio
        bd.tancarConnexio();
        
    }//Fi main
    
}
