/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf3act3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import org.xmldb.api.*;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;

/**
 *
 * @author Alumne
 */
public class UF3ACT3 {

    static String driver = "org.exist.xmldb.DatabaseImpl";
    static Collection col = null;
    static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db";
    static String usu = "admin";
    static String usuPwd = "alumne";
    static XPathQueryService servicio;
    static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     * @throws org.xmldb.api.base.XMLDBException
     */
    public static void main(String[] args) throws XMLDBException {

        int posicion = 5;

        try {
            Class cl = Class.forName(driver); //Cargar del driver
            Database database = (Database) cl.newInstance(); //Instancia de la BD
            DatabaseManager.registerDatabase(database); //Registro del driver
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | XMLDBException e) {
            System.out.println("Error al inicializar la BD eXist");
        }

        col = DatabaseManager.getCollection(URI, usu, usuPwd);
        servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");

        if (col == null) {
            System.out.println(" *** LA COLECCION NO EXISTE. ***");
        }

        while (posicion != 4) {
            System.out.println("1. Insereix");
            System.out.println("2. Elimina");
            System.out.println("3. Modifica");
            System.out.println("4. Sortir");
            posicion = sc.nextInt();
            if (posicion == 1) {
                insereixDep();
            } else if (posicion == 2) {
                esborraDep();
            } else if (posicion == 3) {
                modificaDep();
            } else {

            }
        }
        col.close();

    }

    public static void insereixDep() throws XMLDBException {
        ResourceSet result;
        String nom = null, loc = null;
        int num = 0;

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escriu un departament: ");
            num = sc.nextInt();

            System.out.println("Escriu un nom: ");
            nom = in.readLine();

            System.out.println("Escriu una localitat: ");
            loc = in.readLine();
        } catch (IOException e) {
            System.out.println("Error en llegir");
        }
        ResourceSet result2 = servicio.query("for $de in /departamentos/DEP_ROW[DEPT_NO=" + (Integer) num + "] return $de");

        ResourceIterator i;
        i = result2.getIterator();
        if (!i.hasMoreResources()) {
            result = servicio.query("update insert <DEP_ROW><DEPT_NO>"
                    + (Integer) num + "</DEPT_NO><DNOMBRE>" + nom + "</DNOMBRE><LOC>" + loc
                    + "</LOC></DEP_ROW> into /departamentos");
        } else {
            System.out.println("Ja te mes d'un camp amb aquest departament");
        }
    }

    public static void esborraDep() throws XMLDBException {
        ResourceSet result;
        int num = 0;

        System.out.println("Escriu un departament: ");
        num = sc.nextInt();

        result = servicio.query("update delete /departamentos/DEP_ROW[DEPT_NO=" + (Integer) num + "]");
        ResourceIterator i;
        i = result.getIterator();

        if (!i.hasMoreResources()) {
            System.out.println("No puedes borrar lo que no existe");
        }

    }

    public static void modificaDep() throws XMLDBException {
        ResourceSet result, result2, resultComp;
        String nom = null, loc = null;
        int num = 0;

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escriu un departament que vols editar: ");
            num = sc.nextInt();

            System.out.println("Escriu un nou nom: ");
            nom = in.readLine();

            System.out.println("Escriu una nova localitat: ");
            loc = in.readLine();
        } catch (IOException e) {
            System.out.println("Error en llegir");
        }

        resultComp = servicio.query("for $de in /departamentos/DEP_ROW[DEPT_NO=" + (Integer) num + "] return $de");

        ResourceIterator i;
        i = resultComp.getIterator();

        while (i.hasMoreResources()) {
            Resource r = i.nextResource();
            result = servicio.query("update value /departamentos/DEP_ROW/DNOMBRE[DEPT_NO=" + (Integer) num + "] with " + nom);
            result2 = servicio.query("update value /departamentos/DEP_ROW/LOC[DEPT_NO=" + (Integer) num + "] with " + loc);
        }

    }
}
