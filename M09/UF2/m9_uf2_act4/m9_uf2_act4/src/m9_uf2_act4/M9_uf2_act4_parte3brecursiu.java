/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf2_act4;

/**
 *
 * @author ianlo
 */
public class M9_uf2_act4_parte3brecursiu {
    
    public static int maximComuDivisor(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else{
            return maximComuDivisor(num2, num1 % num2);
        }  
    }
    
    public static void main(String[] args) {
        int num1 = 2, num2 = 3, num3;
        num3  = maximComuDivisor(num1, num2);
        System.out.println("maximComuDivisor" + num1 + ", " + num2 +
                " = " + num3);

    }
    
}
