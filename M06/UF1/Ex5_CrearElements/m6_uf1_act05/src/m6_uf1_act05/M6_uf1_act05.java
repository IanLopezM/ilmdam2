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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class M6_uf1_act5 {

    /**
     * @param args the command line arguments
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
        // TODO code application logic here
        File file = new File("F:\\dam\\m06\\uf1\\ex05\\alumnes.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        
        Scanner sc = new Scanner(System.in);
        int menu = 0, notaF = 0;
        String nom, cognom1, cognom2;
        
        Element nodeArrel = doc.getDocumentElement();
        
        NodeList list = nodeArrel.getChildNodes();
        
        System.out.println("1- crear element");
        System.out.println("2- modificar element");
        System.out.println("3- eliminar element");
        menu = sc.nextInt();
        
        if(menu == 1){
            System.out.println("Nom de l alumne");
            nom = sc.next();
            System.out.println("Primer cognom");
            cognom1 = sc.next();
            System.out.println("Segon cognom");
            cognom2 = sc.next();
            System.out.println("Nota Final");
            notaf = sc.nextInt();
        }
        
        
    }
    
}
