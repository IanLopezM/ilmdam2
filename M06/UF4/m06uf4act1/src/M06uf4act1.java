import ElsMeusBeans.Comanda;
import ElsMeusBeans.Producte;


/**
 *
 * @author ian
 */
public class M06uf4act1 {
   
    public static void main(String[] args) {
        
        int cont = 0;
        
        Producte[] productes = new Producte[4];
        productes[0] = new Producte(1, "Pulpo Reversible azul", 10, 3, 50);
        productes[1] = new Producte(2, "Pulpo Reversible verde", 20, 6, 50);
        productes[2] = new Producte(3, "Pulpo Reversible amarillo", 30, 9, 50);
        productes[3] = new Producte(4, "Pulpo Reversible rosa", 40, 12, 50);
        
        Comanda comanda = new Comanda();
       
        while (cont < productes.length) {
            productes[cont].addPropertyChangeListener(comanda);
            productes[cont].setStockactual(2);
            if(comanda.isDemana()) {
                System.out.println("Fer comanda en producte: " + productes[cont].getDescripcio());
            } else {
                System.out.println("No és necessari fer la comanda en producte: " + productes[cont].getDescripcio());
            }
            cont++;
        }
    }
   
}

