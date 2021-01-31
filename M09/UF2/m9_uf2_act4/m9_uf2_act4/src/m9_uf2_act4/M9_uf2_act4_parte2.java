/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf2_act4;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author Alumne
 */
public class M9_uf2_act4_parte2 {

    static class GrupBombolla implements Runnable {
        int grup;
        int[] grupBombolla;
        
        public GrupBombolla(int grup, int[] grupBombolla) {
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
    
    static int[] grupContador = {0, 0, 0, 0};
    
    public static void main(String[] args) {
        
        int size = 5;
        int[] rand = new int[10];
        int fils = 4;
        //quatre arrays per al grupbombolla
        GrupBombolla[] grupBombolla = new GrupBombolla[4];
        
        rand = generaRand(rand, size);
        
        System.out.println("El grup generat es " + 
                Arrays.toString(rand));
        
        grupBombolla = grupsBombolles(grupBombolla, rand);
        
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) 
                Executors.newFixedThreadPool(fils);
        
        threadPoolExecutor = executa(grupBombolla, threadPoolExecutor);
        threadPoolExecutor.shutdown();
        
        int grupBombollaOrdenat[] = new int[grupBombolla[0].grupBombolla.length 
                * 4];
    }
    
    public static int[] generaRand(int[] rand, int size){
        int i;
        for(i = 0; i < rand.length; i++){
            rand[i] = (int) (Math.random() * size) + 1;
        }
        return rand;
    }
    
    public static GrupBombolla[] grupsBombolles(GrupBombolla[] grupBombolla,
            int[] rand){
        int auxiliarC = 0, i, j;
        int[] auxiliarGrup;
        for(i = 0; i < grupBombolla.length; i++) {
            auxiliarGrup = new int[rand.length / 4];
            for(j = 0; j < auxiliarGrup.length; j++) {
                auxiliarGrup[j] = rand[auxiliarC];
                auxiliarC++;
            }
            GrupBombolla grupetBombolla = new GrupBombolla(i, auxiliarGrup);
            grupBombolla[i] =  grupetBombolla;
        }
        return grupBombolla;
    }
    
    public static ThreadPoolExecutor executa(GrupBombolla[] grupBombolla, 
            ThreadPoolExecutor threadPoolExecutor){
        int i;
        for(i = 0; i < grupBombolla.length; i++){
            threadPoolExecutor.execute(grupBombolla[i]);
        }
        return threadPoolExecutor;
    }
    
    public static void ordenaBombolla(int[] grupBombollaOrdenat,
            GrupBombolla[] grupBombolla, int[] grupContador) {
        int i, auxiliar;
        for(i = 0; i < grupBombollaOrdenat.length; i++) {
            auxiliar = menorQue(
                    grupBombolla[0].grupBombolla[grupContador[0]],
                    grupBombolla[1].grupBombolla[grupContador[1]],
                    grupBombolla[2].grupBombolla[grupContador[2]],
                    grupBombolla[3].grupBombolla[grupContador[3]],
                    grupContador);
            grupBombollaOrdenat[i] = auxiliar;
            System.out.println(Arrays.toString(grupContador) + "\t-\t");
        }
        System.out.println(Arrays.toString(grupBombollaOrdenat) + "\t");
    }
    
    
    private static int menorQue(int grupBombolla0, int grupBombolla1, 
            int grupBombolla2, int grupBombolla3, int[] grupContador) {
        int[] test = {grupBombolla0, grupBombolla1, 
            grupBombolla2, grupBombolla3};
        boolean check = false;
        int minim = grupBombolla0;
        int pos = 0;
        for (int i = 0; i < test.length; i++) {
            if (grupContador[i] < 4) {
                if (test[i] <= minim ) {
                    minim = test[i];
                    pos = i;
                    check = true;
                }
            }
        }
        if (check) {
            grupContador[pos]++;
        }
        return minim;
    }
}
