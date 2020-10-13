/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llegirxml;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Alumne
 */
public class LlegirXml {

    /**
     * @param args the command line arguments
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
        File file = new File("F:\\dam\\m06\\uf1\\ex04\\rows.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);

        Element nodeArrel = doc.getDocumentElement();
        
        NodeList list = nodeArrel.getChildNodes();
        
        for(int i = 0; i < list.getLength(); i++){
            Node nodeRow = list.item(i);
            System.out.println("Nom del node: " + nodeRow.getNodeName());
            
            System.out.println("Noms dels nodes fills i els seus continguts");
            for(int j = 0; j < nodeRow.getChildNodes().getLength(); j++){
                Node nodeRowChild = nodeRow.getChildNodes().item(j);
                System.out.println("Nom del node fill: " + nodeRowChild.getNodeName() + "   Contingut: "+ nodeRowChild.getTextContent());
            }
            
            System.out.println("Noms dels atributs i els seus continguts");
            for(int k = 0; k < nodeRow.getAttributes().getLength();k++){
                Node nodeRowAtt = nodeRow.getAttributes().item(k);
                System.out.println("Nom de l atribut: " + nodeRowAtt.getNodeName() + "   Contingut: " + nodeRowAtt.getTextContent());
            }
            System.out.println("\n");
        }
        
    }
    
}
