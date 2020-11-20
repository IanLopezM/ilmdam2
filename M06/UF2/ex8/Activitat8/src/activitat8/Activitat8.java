/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activitat8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.*;
import java.util.*;
/**
 *
 * @author Alumne
 */
public class Activitat8 {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        boolean seguir = true, discapacitado, isRojo;
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String nom, naixement, marca, data;
        int cp, seSigue, anyModel, menu;
        
        
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("$objectdb/db/pActivitat8.odb");
        EntityManager em = emf.createEntityManager();
        
        
        System.out.println("Introdueix el primer propietari");
        em.getTransaction().begin();
        while(seguir == true){
            System.out.println("Nom");
            nom = sc.nextLine();
            
            System.out.println("CP:");
            cp = sc.nextInt();
            
            System.out.println("Data naixement (dd/MM/yyyy)");
            naixement = sc.next();
            Date naixementDef = sdf.parse(naixement);
        
            System.out.println("Discapacitat?");
            discapacitado = sc.nextBoolean();
            
            Propietaris p;
            p = new Propietaris(cp, nom, naixementDef, discapacitado);
            
            em.persist(p);
            
            System.out.println("Un altre propietari? SI:1 / NO:0");
            seSigue = sc.nextInt();
            sc.nextLine();
            
            if(seSigue == 1){
                seguir = true;
            } else {
                seguir = false;
            }
        }
        
        seguir = true;
        System.out.println("Introdueix el primer vehicle");
        while(seguir == true){
            System.out.println("Marca");
            marca = sc.nextLine();
            
            System.out.println("Any model");
            anyModel = sc.nextInt();
            
            
            System.out.println("Data");
            data = sc.next();
            Date dataCompra = sdf.parse(data);
            
            System.out.println("Es vermell?");
            isRojo = sc.nextBoolean();
            
            Vehicles v;
            v = new Vehicles(marca, anyModel, dataCompra, isRojo);
            
            em.persist(v);
            
            System.out.println("Un altre vehicle? SI:1 / NO:0");
            seSigue = sc.nextInt();
            sc.nextLine();
            if(seSigue == 1){
                seguir = true;
            } else {
                seguir = false;
            }
        }
        
        em.getTransaction().commit();
        seguir = true;
        
        while(seguir == true){
            System.out.println("LListar Propietaris 1\nLlistar Vehicles 2");
            menu = sc.nextInt();
            if(menu == 1){
                returnPropietaris(em);
            } else {
                returnVehicles(em);
            }
            
            System.out.println("Vols continuar? SI:1 / NO:0");
            seSigue = sc.nextInt();
            sc.nextLine();
            
            if(seSigue == 1){
                seguir = true;
            } else {
                seguir = false;
            }
        }
    }
    
    public static void returnPropietaris(EntityManager em){
        TypedQuery<Propietaris> query =
        em.createQuery("SELECT p FROM Propietaris p", Propietaris.class);
        List<Propietaris> results = query.getResultList();
        for (Propietaris p : results) {
            System.out.println(p);
        }
    
    }
    
    public static void returnVehicles(EntityManager em){
        TypedQuery<Vehicles> query =
        em.createQuery("SELECT v FROM Vehicles v", Vehicles.class);
        List<Vehicles> results = query.getResultList();
        for (Vehicles v : results) {
            System.out.println(v);
        }
    }
    
}
