/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6_uf1_act5;

/**
 *
 * @author Alumne
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class M6_uf1_act5 {

    public static Scanner sc = new Scanner(System.in);
    public static File file;
    public static DocumentBuilderFactory dbFactory; 
    public static DocumentBuilder dBuilder;
    public static Document doc;
    public static Element nodeArrel;
    
    /**
     * @param args the command line arguments
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     * @throws javax.xml.transform.TransformerConfigurationException
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
    
        boolean fin = false;
        int menu = 0;
        
        file = new File("E:\\dam\\m06\\uf1\\ex05\\alumnes.xml");
	dbFactory = DocumentBuilderFactory.newInstance();
	dBuilder = dbFactory.newDocumentBuilder();
	doc = dBuilder.parse(file);
	nodeArrel = doc.getDocumentElement();
        
        while(!fin){
            System.out.println("1- Afegir un node o atribut\n"
                    + "2- Modificar un node o atribut\n"
                    + "3- Eliminar un node o atribut"
                    + "4- Mostrar l estructura de l XML"
                    + "5- Finalitzar el programa");
            menu = sc.nextInt();
            
            if(menu == 1){
                boolean fin1 = false;
                int opcio = 0;
                while(!fin1){
                    System.out.println("Vols afegir un element(1) o un atribut(2)");
                    opcio = sc.nextInt();
                    
                    if(opcio == 1){
                        String id, nom, cognom1, cognom2, nota;
			System.out.println("Quin sera l id de l alumne");
			id = sc.next();			
			System.out.println("Quin es el seu nom");
			nom = sc.next();	
			System.out.println("Quin es el seu primer cognom");
			cognom1 = sc.next();	
			System.out.println("Quin es el seu segon cognom");
			cognom2 = sc.next();		
			System.out.println("Quina es la seva nota final");
			nota = sc.next();
                        
                        Element elementNom = doc.createElement("nom");
                        Element elementCognom1 = doc.createElement("cognom1");
                        Element elementCognom2 = doc.createElement("cognom2");
                        Element elementNota = doc.createElement("nota");
                        Element element = doc.createElement("alumne");
                        
			elementNom.appendChild(doc.createTextNode(nom));	
			elementCognom1.appendChild(doc.createTextNode(cognom1));
			elementCognom2.appendChild(doc.createTextNode(cognom2));
			elementNota.appendChild(doc.createTextNode(nota));
                        nodeArrel.appendChild(element);
                        
                        element.setAttribute("id", id);
			element.setIdAttribute("id", true);
			element.appendChild(elementNom);
			element.appendChild(elementCognom1);
			element.appendChild(elementCognom2);
			element.appendChild(elementNota);
                        
                        fin1 = true;
                    }
                }
            }
            
        }
        
    }
    
}
