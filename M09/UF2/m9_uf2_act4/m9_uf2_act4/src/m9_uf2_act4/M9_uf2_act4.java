 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf2_act4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author Alumne
 */
public class M9_uf2_act4 {
    
    static class Client implements Callable<Integer> {
        
        private int totalProductos;
        
        public Client(int productos) {
            totalProductos = productos;
        }
        
        @Override
        public Integer call() throws Exception {
            return 0;
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int TOTAL_CLIENTS = 50;
        int nombreArticles, tempsArticle;
        Client[] arrayClient = new Client[TOTAL_CLIENTS];
        
        ThreadPoolExecutor executor = (ThreadPoolExecutor)  
                Executors.newFixedThreadPool(50);
        List<Client> llistaTasques = new ArrayList<Client>();
        
        
        
    }
    
}
