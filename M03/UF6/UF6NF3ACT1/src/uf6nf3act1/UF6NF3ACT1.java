/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf6nf3act1;

import java.util.Scanner;

/**
 *
 * @author Alumne
 */
public class UF6NF3ACT1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String num = "a", num2;
        int numnum = 100, numnum2 = 0, calcul;
        Scanner sc = new Scanner(System.in);

        while (!num.equalsIgnoreCase("q")) {
            System.out.println("Num");

            num = sc.nextLine();

            if (!num.equalsIgnoreCase("q")) {
                System.out.println("Num2");
                num2 = sc.nextLine();

                try {
                    numnum = Integer.valueOf(num);
                    numnum2 = Integer.valueOf(num2);
                } catch (Exception e) {
                    System.out.println("You entered bad data");
                    System.out.println("Please try again");
                }

                if (numnum2 != 0) {
                    calcul = numnum / numnum2;
                    System.out.println(numnum + " / " + numnum2 + " = " + calcul);
                }

            }
        }
    }

}
