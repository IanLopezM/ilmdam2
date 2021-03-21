/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf3act2ianyjesus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Alumne
 */
public class UF3ACT2IanyJesus {

    /**
     * @param args the command line arguments
     */
    public static void main (String[] args) {
		URL url=null;
		try {
			
			url = new URL("http",args[0], Integer.parseInt(args[1]), "");
			
		} catch (MalformedURLException e) {e.printStackTrace(); }
		
		BufferedReader in;
		
		try {
			
			InputStream inputStream = url.openStream();
			in = new BufferedReader(new InputStreamReader(inputStream));
			
			String inputLine;
			
			while ((inputLine = in.readLine()) != null)
				System.out.println(inputLine);
			in.close();
			
		} catch (IOException e) {e.printStackTrace(); }

	}
    
}
