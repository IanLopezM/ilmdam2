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
public class M9_uf2_act4_parte3bforkjoin extends RecursiveTask<Long>{
    long num1;
    long num2;

    public M9_uf2_act4_parte3bforkjoin(long num1, long num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    protected Long compute() {
        if (num2 == 0) {
            return num1;
        } else {
            M9_uf2_act4_parte3bforkjoin aux = 
                    new M9_uf2_act4_parte3bforkjoin(num2, num1%num2);
            aux.fork();
            return aux.join();
        }
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println(pool.invoke(new M9_uf2_act4_parte3bforkjoin(3, 5)));

    }
}
