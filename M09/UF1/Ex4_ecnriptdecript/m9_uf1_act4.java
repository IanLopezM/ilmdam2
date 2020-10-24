
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class M6_uf1_act5 {

    public static Scanner scan = new Scanner(System.in);
    public static File file;
    public static DocumentBuilderFactory dbFactory;
    public static DocumentBuilder dBuilder;
    public static Document doc;
    public static Element nodeArrel;

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {

        file = new File("E:\\dam\\m06\\uf1\\ex05\\alumnes.xml");
        dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(file);
        nodeArrel = doc.getDocumentElement();
        boolean sortir = false;
        int opcio;

        while (!sortir) {
            System.out.println("1-Afegir\n2.Modificar\n3.Eliminar\n"
                    + "4.Mostrar XML\n5.Sortir");
            opcio = scan.nextInt();
            
            if (opcio == 1) {
                afegirElement();
            } else if (opcio == 2) {
                modificarElement();
            } else if (opcio == 3) {
                eliminarElement();
            } else if (opcio == 4) {
                String espai = "";
                mostraInformacioNode(nodeArrel, espai);
            } else if (opcio == 5) {
                sortir = true;
                while (true) {
                    
                    System.out.println("Vols guardar els canvis");
                    System.out.println("1.Si 2.No");
                    opcio = scan.nextInt();
                    if (opcio == 1) {
                        guardar();
                    } else if (opcio == 2) {
                        System.exit(0);
                    }
                }
            }
        }
    }

    public static void afegirElement() {
        
        boolean fin = false;
        while (!fin) {
            
            System.out.println("Que vols afegir");
            System.out.println("1.Element 2.Atribut");
            int opcio = scan.nextInt();
            
            if (opcio == 1) {
                
                System.out.println("Introdueix les dades de l'alumne");
                System.out.println("Introdueix un id");
                String id = scan.next();
                System.out.println("Introdueix un nom");
                String nom = scan.next();
                System.out.println("Introdueix el primer cognom");
                String cognom1 = scan.next();
                System.out.println("Introdueix el segon cognom");
                String cognom2 = scan.next();
                System.out.println("Introdueix la nota");
                String nota = scan.next();
                
                Element elementNom = doc.createElement("nom");
                elementNom.appendChild(doc.createTextNode(nom));
                Element elementCognom1 = doc.createElement("cognom1");
                elementCognom1.appendChild(doc.createTextNode(cognom1));
                Element elementCognom2 = doc.createElement("cognom2");
                elementCognom2.appendChild(doc.createTextNode(cognom2));
                Element elementNota = doc.createElement("nota");
                elementNota.appendChild(doc.createTextNode(nota));
                Element element = doc.createElement("alumne");
                nodeArrel.appendChild(element);
                
                element.setAttribute("id", id);
                element.setIdAttribute("id", true);
                element.appendChild(elementNom);
                element.appendChild(elementCognom1);
                element.appendChild(elementCognom2);
                element.appendChild(elementNota);
                
                fin = true;
            } else if (opcio == 2) {
                opcio = 0;
                while (!fin) {
                    System.out.println("Introdueix el id del alumne");
                    String id = scan.next();
                    Element element = doc.getElementById(id);
                    System.out.println("On vols afegir l'atribut");
                    System.out.println("1.Element pare 2.Element fill");
                    opcio = scan.nextInt();
                    if (opcio == 1) {
                        System.out.println("Introdueix un nom per l'atribut");
                        String attrNom = scan.next();
                        System.out.println("Introdueix un valor per l'atribut");
                        String attrValor = scan.next();
                        element.setAttribute(attrNom, attrValor);
                        fin = true;
                    } else if (opcio == 2) {
                        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
                            if (element.getChildNodes().item(i).hasChildNodes()) {
                                System.out.println("Vols introduir atribut per el element "
                                        + element.getChildNodes().item(i).getNodeName());
                                System.out.println("1.Si 2.No");
                                opcio = scan.nextInt();
                                if (opcio == 1) {
                                    System.out.println("Introdueix un nom per l'atribut");
                                    String attrNom = scan.next();
                                    System.out.println("Introdueix un valor per l'atribut");
                                    String attrValor = scan.next();
                                    Element fill = (Element) element.getChildNodes().item(i);
                                    fill.setAttribute(attrNom, attrValor);
                                }
                            }

                        }
                        fin = true;
                    }
                }
            }
        }

    }

    public static void modificarElement() {
        boolean fin = false;
        int opcio = 0;
        
        while (!fin) {
            
            System.out.println("Introdueix el id de l'alumne a modificar");
            String id = scan.next();
            Node element = doc.getElementById(id);
            System.out.println("Que vols modificar:");
            System.out.println("1.Element 2.Atribut");
            opcio = scan.nextInt();
            
            if (opcio == 1) {
                while (element.hasChildNodes()) {
                    
                    element.removeChild(element.getFirstChild());
                }
                
                System.out.println("Introdueix un nom");
                String nom = scan.next();
                System.out.println("Introdueix el primer cognom");
                String cognom1 = scan.next();
                System.out.println("Introdueix el segon cognom");
                String cognom2 = scan.next();
                System.out.println("Introdueix la nota");
                String nota = scan.next();
                
                Node elementNom = doc.createElement("nom");
                elementNom.appendChild(doc.createTextNode(nom));
                Node elementCognom1 = doc.createElement("cognom1");
                elementCognom1.appendChild(doc.createTextNode(cognom1));
                Node elementCognom2 = doc.createElement("cognom2");
                elementCognom2.appendChild(doc.createTextNode(cognom2));
                Node elementNota = doc.createElement("nota");
                elementNota.appendChild(doc.createTextNode(nota));
                
                element.appendChild(elementNom);
                element.appendChild(elementCognom1);
                element.appendChild(elementCognom2);
                element.appendChild(elementNota);
                fin = true;
            } else if (opcio == 2) {
                
                opcio = 0;
                while (!fin) {
                    String nomAttr;
                    String valorAttr;
                    System.out.println("Quin element vols editar els atributs");
                    System.out.println("1.Element pare 2.Element fill");
                    opcio = scan.nextInt();
                    if (opcio == 1) {
                        for (int i = 0; i < element.getAttributes().getLength(); i++) {
                            
                            opcio = 0;
                            Node atribut = element.getAttributes().item(i);
                            System.out.println("Vols editar el atribut " + element.getAttributes().item(i).getNodeName());
                            System.out.println("1.Si 2.No");
                            opcio = scan.nextInt();
                            if (opcio == 1) {
                                
                                System.out.println("Introdueix un valor");
                                valorAttr = scan.next();
                                atribut.setNodeValue(valorAttr);

                            }
                        }
                        fin = true;
                    } else if (opcio == 2) {
                        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
                            if (element.getChildNodes().item(i).hasChildNodes()) {
                                for (int j = 0; j < element.getChildNodes().item(i).getAttributes().getLength(); j++) {
                                    
                                    opcio = 0;
                                    Node atribut = element.getChildNodes().item(i).getAttributes().item(j);
                                    System.out.println("Vols modificar el atribut "
                                            + element.getChildNodes().item(i).getAttributes().item(j).getNodeName()
                                            + " al element " + element.getChildNodes().item(i).getNodeName());
                                    System.out.println("1.Si 2.No");
                                    opcio = scan.nextInt();
                                    
                                    if (opcio == 1) {
                                        
                                        System.out.println("Introdueix un valor");
                                        valorAttr = scan.next();
                                        atribut.setNodeValue(valorAttr);
                                    }
                                }
                            }

                        }
                        fin = true;
                    }
                }
            }
        }
    }

    public static void eliminarElement() {
        
        boolean fin = false;
        int opcio = 0;
        
        while (!fin) {
            System.out.println("Introdueix el id de l'alumne");
            String id = scan.next();
            Element element = doc.getElementById(id);
            System.out.println("Que vols eliminar");
            System.out.println("1.Element 2.Atribut");
            opcio = scan.nextInt();
            
            if (opcio == 1) {
                nodeArrel.removeChild(element);
                fin = true;
            } else if (opcio == 2) {
                
                while (!fin) {
                    
                    opcio = 0;
                    System.out.println("A quin element vols eliminar l'atribut");
                    System.out.println("1.Element pare 2.Elements fills");
                    opcio = scan.nextInt();
                    
                    if (opcio == 1) {
                        if (element.hasAttributes()) {
                            for (int i = 0; i < element.getAttributes().getLength(); i++) {
                                
                                opcio = 0;
                                System.out.println("Vols eliminar l'atribut " + element.getAttributes().item(i).getNodeName());
                                System.out.println("1.Si 2.No");
                                opcio = scan.nextInt();
                                if (opcio == 1) {
                                    element.removeAttribute(element.getAttributes().item(i).getNodeName());
                                }
                            }
                        }
                        fin = true;
                    } else if (opcio == 2) {
                        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
                            if (element.getChildNodes().item(i).hasChildNodes()) {
                                
                                Element elementFill = (Element) element.getChildNodes().item(i);
                                for (int j = 0; j < element.getChildNodes().item(i).getAttributes().getLength(); j++) {
                                    
                                    opcio = 0;
                                    Node atribut = element.getChildNodes().item(i).getAttributes().item(j);
                                    System.out.println("Vols eliminar l'atribut " + atribut.getNodeName()
                                            + " de l'element " + elementFill.getNodeName());
                                    System.out.println("1.Si 2.No");
                                    opcio = scan.nextInt();
                                    
                                    if (opcio == 1) {
                                        elementFill.removeAttribute(atribut.getNodeName());
                                    }
                                }
                            }
                        }
                        fin = true;
                    }
                }
                fin = true;
            }
        }
    }

    public static void guardar() throws TransformerException {
        
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        StreamResult result = new StreamResult(new File("E:\\dam\\m06\\uf1\\ex05\\alumnesnew.xml"));
        DOMSource source = new DOMSource(doc);
        trans.transform(source, result);
        System.exit(0);
    }

    public static void mostraInformacioNode(Node element, String espai) {
        
        System.out.println(espai + element.getNodeName());
        System.out.println(espai + "  " + element.getFirstChild().getNodeValue());
        
        if (element.hasAttributes()) {
            for (int i = 0; i < element.getAttributes().getLength(); i++) {
                System.out.println(espai + element.getAttributes().item(i));
            }
        }
        
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            if (element.getChildNodes().item(i).hasChildNodes()) {
                mostraInformacioNode(element.getChildNodes().item(i), espai + "  ");
            }
        }
        
        System.out.println(espai + element.getNodeName());
    }
}
