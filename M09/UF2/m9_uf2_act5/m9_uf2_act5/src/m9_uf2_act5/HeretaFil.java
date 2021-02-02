/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf2_act5;

/**
 *
 * @author ianlo
 */
public class HeretaFil extends Thread{

    String strImprimir;
    public HeretaFil(String strP) {
        strImprimir=strP;
    }

    public void run(){
    for(int x=0;x<5;x++){
        System.out.println(strImprimir+ " " + x);
    }
 }

 public static void main(String[] args) {

    Thread primer = new HeretaFil("Fil 1");
    Thread segon = new HeretaFil("Fil 2");
    Thread tercer = new HeretaFil("Fil 3");
    Thread quart = new HeretaFil("Fil 4");
    Thread cinque = new HeretaFil("Fil 5");
    Thread sise = new HeretaFil("Fil 6");
    Thread sete = new HeretaFil("Fil 7");
    Thread vuite = new HeretaFil("Fil 8");
    Thread nove = new HeretaFil("Fil 9");
    Thread dece = new HeretaFil("Fil 10");
    // Hem creat dos fils primer i segon, però no s’han executat.
    // Per poder−lo executar s’ha de cridar al mètode start()
    primer.run();
    segon.run();
    tercer.run();
    quart.run();
    cinque.run();
    sise.run();
    sete.run();
    vuite.run();
    nove.run();
    dece.run();
    

    System.out.println("Final Fil Principal");
 }
}