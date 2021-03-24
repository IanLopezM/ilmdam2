/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf6act8;

import java.util.Scanner;

/**
 *
 * @author Alumne
 */
public class UF6ACT8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int costats, resultat = 0;
        costats = sc.nextInt();
        resultat = form(costats);
        System.out.println(resultat);

    }

    private static int form(int costats) {
        if (costats == 1) {
            return 4;
        } else {
            return ((4 * costats) + (4 * form(costats / 2)));
        }
    }

}
