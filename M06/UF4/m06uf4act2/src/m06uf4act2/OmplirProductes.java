/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act02_omplirvenda;

import ElsMeusBeans.Producte;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/**
 *
 * @author maria
 */
public class OmplirProductes {
    public static void main(String[] args) {
        //Obrir la base de dades
        ODB odb = ODBFactory.open("Producte_com.BD");
        
        //Creo un array de 10 productes
        Producte p1 = new Producte(1, "Pulpo Reversible azul", 10, 3, 50);
        Producte p2 = new Producte(2, "Pulpo Reversible verde", 20, 6, 50);
        Producte p3 = new Producte(3, "Pulpo Reversible amarillo", 30, 9, 50);
        Producte p4 = new Producte(4, "Pulpo Reversible rosa", 40, 12, 50);

        //S'emmagatzema els productes
        odb.store(p1);
        odb.store(p2);
        odb.store(p3);
        odb.store(p4);
        
        //Es tanca la base de dades
        odb.close();        
    }  
}