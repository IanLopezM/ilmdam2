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
public class M9_uf2_act4_parte3arecursiu {
    
    public static int calculaX(int i, int j){
        boolean out = false;
        if(i == 0){
            out = true;
        }
        
        if(out == true){
            return 1;
        } else {
            return calculaX(i-1,j)*j;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(calculaX(2,4));
    }
    
}
