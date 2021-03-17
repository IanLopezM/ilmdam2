/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf6actnf2act;

/**
 *
 * @author Alumne
 */
public class UF6ACTNF2ACT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int piedras = 6;
        
        calcul(1, piedras);
    }

    private static void calcul(int filas, int piedras) {
        if (filas == piedras) {
            System.out.println("Fila " + filas + " piedras restantes 0");
        } else if (filas > piedras) {
            filas = filas -1;
            System.out.println("Fila " + filas + " piedras restantes " + piedras);
        } else {
            piedras = piedras - filas;
            filas = filas + 1;
            calcul(filas, piedras);
        }
        
    }
    
}
