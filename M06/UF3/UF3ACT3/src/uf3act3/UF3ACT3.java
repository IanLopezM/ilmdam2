/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf3act3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.xmldb.api.*;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;

/**
 *
 * @author Alumne
 */
public class UF3ACT3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws XMLDBException {
        // TODO code application logic here
        String driver = "org.exist.xmldb.DatabaseImpl";
        Collection col = null;
        String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db";
        String usu = "admin";
        String usuPass = "alumne";
        
        try {
            Class cl = Class.forName(driver);
            Database database = (Database) cl.newInstance();
            DatabaseManager.registerDatabase(database);
        } catch(Exception e) {
            System.out.println("IAN" + e);
        }
        
        col = DatabaseManager.getCollection(URI, usu, usuPass);
        if (col == null)
            System.out.println("No existe");
        
        XPathQueryService servei = 
                (XPathQueryService) col.getService("XPathQueryService", "1.0");
        ResourceSet result = 
                servei.query("for $em in /EMPLEADOS/EMP_ROW[DEPT_NO=20] return $em");
        
        ResourceIterator i;
        i = result.getIterator();
        if (!i.hasMoreResources())
            System.out.println("no torna res");
        while (i.hasMoreResources()) {
            Resource r = i.nextResource();
            System.out.println("" + (String)r.getContent());
        }
        col.close();
    }
    
}
