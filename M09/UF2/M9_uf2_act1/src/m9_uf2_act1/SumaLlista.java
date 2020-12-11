package m9_uf2_act1;


import java.util.*;
import java.util.concurrent.*;

public class SumaLlista {
    //clase declarada dins de una altra clase
	static class Suma implements Callable<Integer> {
		private int operador1;
		private int operador2;
		
		public Suma(int operador1, int operador2) {
			this.operador1 = operador1;
			this.operador2 = operador2;
			}
			
		@Override
		public Integer call() throws Exception {
			return operador1 + operador2;
			}
		}

	public static void main(String[] args) throws
		InterruptedException, ExecutionException {
            //Es llançan 5 fils
			ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
            //Es crea una llista
			List<Suma> llistaTasques= new ArrayList<Suma>();
            //S'afegeixen totes les sumes a la llista
			for (int i = 0; i < 25; i++) {
				Suma calcula = new Suma((int)(Math.random()*10), (int)(Math.random()*10));
				llistaTasques.add(calcula);
				}
            //Es crea la llista on s'afegiran els resultats de les sumes i s'executen tots els call que conté la llistaTasques
			List <Future<Integer>> llistaResultats;
			llistaResultats = executor.invokeAll(llistaTasques);
            //S'espera a que terminin tots els fills
			executor.shutdown();
            //Es mostra individualment cada resultat a través d'aquest for
			for (int i = 0; i < llistaResultats.size(); i++) {
				Future<Integer> resultat = llistaResultats.get(i);
				try {
					System.out.println("Resultat tasca "+i+ " és:" +
					resultat.get());
				}
				catch (InterruptedException | ExecutionException e)
					{
					}
				}
		}
	}
