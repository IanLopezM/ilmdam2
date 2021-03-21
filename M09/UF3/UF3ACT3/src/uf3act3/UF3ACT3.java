/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf3act3;

import java.net.*;
import java.io.*;
import java.util.*;
import java.net.MalformedURLException;

/**
 *
 * @author ianlo
 */
public class UF3ACT3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        String cadena;
        int n = 1;

        try {
            URL url = new URL(args[0]);
            URLConnection conn = url.openConnection();
            System.out.println("Els camps de la capçelera");
            Map camps = conn.getHeaderFields();
            Iterator iterator = camps.entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry map = (Map.Entry) iterator.next();
                System.out.println(map.getKey() + " amb valor "
                        + map.getValue());
                n++;
            }

            for (int i = 1; i <= Integer.valueOf(args[1]); i++) {
                System.out.println(i + " " + conn.getHeaderField(i));
            }

            BufferedReader pagina
                    = new BufferedReader(new InputStreamReader(url.openStream()));
            
            while ((cadena = pagina.readLine()) != null) {
                if (cadena.contains(args[2])) System.out.println(cadena);
            }
            
        } catch (Exception e) {

        }
    }

}
