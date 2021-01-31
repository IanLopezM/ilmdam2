/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf2_act4;

import java.util.Arrays;

/**
 *
 * @author Alumne
 */
public class M9_uf2_act4_parte2 {
    
    static class GrupBombolla implements Runnable {
        int grup;
        int[] grupBombolla;
        
        public GrupBombolla(int grup, int[]grupBombolla) {
            this.grup = grup;
            this.grupBombolla = grupBombolla;
        }
        
        @Override
        public void run() {
            int grupAux, i, j;
            int[] grupBombollaAux;
            
            for(i = 1; i < grupBombolla.length; i++){
                for(j = 0; j < grupBombolla.length; j++){
                    if(grupBombolla[j+1] < grupBombolla[j]){
                        grupBombollaAux = grupBombolla.clone();
                        grupAux = grupBombolla[j];
                        grupBombolla[j] = grupBombolla[j+1];
                        grupBombolla[j+1] = grupAux;
                        System.out.println("El grup " + grup + " " + 
                                Arrays.toString(grupBombollaAux) + 
                                " pasa a ser " +
                                Arrays.toString(grupBombolla));
                    }
                }
            }
            System.out.println("L'array resultant es " + 
                    Arrays.toString(grupBombolla));
        }
    }
    
    
}
