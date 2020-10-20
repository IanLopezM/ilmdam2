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
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
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
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException{
        // TODO code application logic here
        File file = new File("F:\\dam\\m06\\uf1\\ex05\\alumnes.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        
        Scanner sc = new Scanner(System.in);
        int menu = 0;
        String nom, cognom1, cognom2, id, nota;
        
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
            nota = sc.next();
            System.out.println("ID de l alumne");
            id = sc.next();
            
            Element newEl = doc.createElement("alumne");
            Element nodenom = doc.createElement("nom");
            Element nodecognom1 = doc.createElement("cognom1");
            Element nodecognom2 = doc.createElement("cognom2");
            Element nodenota = doc.createElement("notaFinal");
            
            nodenom.appendChild(doc.createTextNode(nom));
            nodecognom1.appendChild(doc.createTextNode(cognom1));
            nodecognom2.appendChild(doc.createTextNode(cognom2));
            nodenota.appendChild(doc.createTextNode(nota));
            
            newEl.appendChild(nodenom);
            newEl.appendChild(nodecognom1);
            newEl.appendChild(nodecognom2);
            newEl.appendChild(nodenota);
            
            nodeArrel.appendChild(newEl);
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            Result output = new StreamResult(new File("F:\\dam\\m06\\uf1\\ex05\\alumnesnew.xml"));
            Source input = new DOMSource(doc);

            transformer.transform(input, output);
            
        }
        
        
    }
    
}
