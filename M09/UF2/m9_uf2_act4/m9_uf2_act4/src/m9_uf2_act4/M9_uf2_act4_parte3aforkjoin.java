/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf2_act4;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author ianlo
 */
public class M9_uf2_act4_parte3aforkjoin extends RecursiveTask<Long>{
    int i;
    int j;

    public M9_uf2_act4_parte3aforkjoin (int i, int j){
        this.i = i;
        this.j = j;
    }

    public static int calculaX(int i, int j){
        if(i == 0){
            return 1;
        } else {
            return calculaX(i - 1, j) * j;
        }
    }

    @Override
    protected Long compute(){
        if (i == 0){
            return (long) 1;
        } else {
            M9_uf2_act4_parte3aforkjoin aux = 
                    new M9_uf2_act4_parte3aforkjoin(i-1,j);
            aux.fork();
            return aux.join() * j;
        }
    }
    
    public static void main(String[] args) {
        
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println(pool.invoke(new M9_uf2_act4_parte3aforkjoin(2,4)));

    }
}
