 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf2_act4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Alumne
 */
public class M9_uf2_act4 {
    
    static class Client implements Runnable {
        
        private int numeroCliente;
        private int[] timposPosibles = {2, 3, 4, 5, 6, 7, 8};
        private int articlesRandom = (int) (Math.random() * (30 - 1 + 1)) + 1;
        
        public Client(int numeroCliente) {
            this.numeroCliente = numeroCliente;
            System.out.println("Creat el client " + numeroCliente + " amb " + articlesRandom + " articles");            
        }

        @Override
        public void run() {
            int unsegundo = 1000;
            int tempsRandom;
            
            System.out.println("Client " + numeroCliente + " passa per caixa ...");
            for (int j = 1; j < articlesRandom + 1; j++) {
                tempsRandom = (int) (Math.random() * (6 - 0 + 1));
                try {
                    Thread.sleep(timposPosibles[tempsRandom] * unsegundo);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                System.out.print("Client " + numeroCliente + " article " + j + "/" + articlesRandom + " (" + timposPosibles[tempsRandom] + " segons)");
                
                if (j == articlesRandom) {
                    System.out.print(" FINALITZAT");
                }
                
                System.out.println("");
            }
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // TODO code application logic here
        int totalClientes = 50;
        int miliSegundos = 3000;
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool (5);
        
        for(int i = 0; i <= totalClientes; i++) {
            Client task = new Client(i);
            Thread.sleep(miliSegundos);
            executor.execute(task);
            //executor.scheduleWithFixedDelay(task, 0, 3, TimeUnit.SECONDS);
            //executor.schedule(task, 3, TimeUnit.SECONDS);
        }
       
        executor.shutdown();
        
    }
    
}
