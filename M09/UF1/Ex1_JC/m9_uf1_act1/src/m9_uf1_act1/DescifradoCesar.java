/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf1_act1;

import java.util.Scanner;

/**
 *
 * @author Alumne
 */
public class DescifradoCesar {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String texto = "";
        char abecedario[] = {97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114 , 115, 116, 117, 118, 119, 120, 121, 122, 32};
        int desp = 0;
        int avantdesp = 0;
        
        texto = sc.nextLine();
        desp = sc.nextInt();
        
        for(int j = 0; j < texto.length(); j++){
            for(int i = 0; i < abecedario.length; i++){
                if(abecedario[i] == texto.charAt(j)){
                    if((i - desp) < 0){
                        avantdesp = desp - i;
                        //avantdesp = abecedario.length - 
                        System.out.print(abecedario[abecedario.length - avantdesp]);
                    } else{
                        System.out.print(abecedario[i-desp]);
                    }
                }
            }
        }
        System.out.print("\n");
        
        
    }
}
