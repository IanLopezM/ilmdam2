
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

        // Indiquem el fitxer d'on treurem el XML
        file = new File("E:\\dam\\m06\\uf1\\ex05\\alumnes.xml");
        dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(file);
        nodeArrel = doc.getDocumentElement();

        // Farem que els atributs id es comportin com un id
        assignaId(nodeArrel);
        // Executem el menu
        menu();
    }

    public static void menu() throws TransformerException {
        boolean sortir = false;
        int opcio;
        while (!sortir) {
            System.out.println("Introdueix una opcio:");
            System.out.println("1-Afegir\n2-Modificar\n3-Eliminar\n4-Mostrar XML\n5-Sortir");

            opcio = scan.nextInt();
            // Opció de afegir element/atribut
            if (opcio == 1) {
                afegirElement();
                // Opció de modificar element/atribut
            } else if (opcio == 2) {
                modificarElement();
                // Opció de eliminar element/atribut
            } else if (opcio == 3) {
                eliminarElement();
                // Opció de mostrar XML
            } else if (opcio == 4) {
                String espai = "";
                mostraInformacioNode(nodeArrel, espai);
                // Opció per sortir del programa
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
        boolean sortir = false;
        while (!sortir) {
            System.out.println("Que vols afegir");
            System.out.println("1.Element 2.Atribut");
            int opcio = scan.nextInt();
            // Opcio per afegir element
            if (opcio == 1) {
                // Demanem les dades dels elements fills
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
                // Creem els nodes fills i els assignem els valors
                Element elementNom = doc.createElement("nom");
                elementNom.appendChild(doc.createTextNode(nom));
                Element elementCognom1 = doc.createElement("cognom1");
                elementCognom1.appendChild(doc.createTextNode(cognom1));
                Element elementCognom2 = doc.createElement("cognom2");
                elementCognom2.appendChild(doc.createTextNode(cognom2));
                Element elementNota = doc.createElement("nota");
                elementNota.appendChild(doc.createTextNode(nota));
                // Creem el element alumne
                Element element = doc.createElement("alumne");
                // Afegim alumne com a node fill de alumnes
                nodeArrel.appendChild(element);
                // Afegim el atribut id i els nodes fills
                element.setAttribute("id", id);
                element.setIdAttribute("id", true);
                element.appendChild(elementNom);
                element.appendChild(elementCognom1);
                element.appendChild(elementCognom2);
                element.appendChild(elementNota);
                sortir = true;
                // Opcio per afegir atribut
            } else if (opcio == 2) {
                opcio = 0;
                while (!sortir) {
                    // Introduïm el id del alumne i ens situem al element
                    System.out.println("Introdueix el id del alumne");
                    String id = scan.next();
                    Element element = doc.getElementById(id);
                    System.out.println("On vols afegir l'atribut");
                    System.out.println("1.Element pare 2.Element fill");
                    opcio = scan.nextInt();

                    // Opció per afegir un atribut al node alumne
                    if (opcio == 1) {
                        // Demanem les dades del atribut i l'afegim al node alumne
                        System.out.println("Introdueix un nom per l'atribut");
                        String attrNom = scan.next();
                        System.out.println("Introdueix un valor per l'atribut");
                        String attrValor = scan.next();
                        element.setAttribute(attrNom, attrValor);
                        sortir = true;
                        // Opció per afegir un atribut als nodes fills de alumne
                    } else if (opcio == 2) {
                        // Recorrem els nodes fills i preguntem si volem afegir un atribut a cada node fill
                        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
                            if (element.getChildNodes().item(i).hasChildNodes()) {
                                System.out.println("Vols introduir atribut per el element "
                                        + element.getChildNodes().item(i).getNodeName());
                                System.out.println("1.Si 2.No");
                                opcio = scan.nextInt();

                                // Opció per afegir un atribut al node fill actual
                                if (opcio == 1) {
                                    // Demanem les dades del atribut i l'afegim al node fill actual
                                    System.out.println("Introdueix un nom per l'atribut");
                                    String attrNom = scan.next();
                                    System.out.println("Introdueix un valor per l'atribut");
                                    String attrValor = scan.next();
                                    Element fill = (Element) element.getChildNodes().item(i);
                                    fill.setAttribute(attrNom, attrValor);
                                }
                            }

                        }
                        sortir = true;
                    }
                }
            }
        }

    }

    public static void modificarElement() {
        boolean sortir = false;
        int opcio = 0;
        while (!sortir) {
            // Introduïm el id d'un node alumne i ens situem en el node
            System.out.println("Introdueix el id de l'alumne a modificar");
            String id = scan.next();
            Node element = doc.getElementById(id);
            System.out.println("Que vols modificar:");
            System.out.println("1.Element 2.Atribut");
            opcio = scan.nextInt();
            // Opció per modificar el node alumne
            if (opcio == 1) {
                // Eliminem els nodes fills
                while (element.hasChildNodes()) {
                    element.removeChild(element.getFirstChild());
                }
                // Introduïm les dades dels nous nodes fills
                System.out.println("Introdueix un nom");
                String nom = scan.next();
                System.out.println("Introdueix el primer cognom");
                String cognom1 = scan.next();
                System.out.println("Introdueix el segon cognom");
                String cognom2 = scan.next();
                System.out.println("Introdueix la nota");
                String nota = scan.next();
                // Creem els nodes fills i els assignem els valors
                Node elementNom = doc.createElement("nom");
                elementNom.appendChild(doc.createTextNode(nom));
                Node elementCognom1 = doc.createElement("cognom1");
                elementCognom1.appendChild(doc.createTextNode(cognom1));
                Node elementCognom2 = doc.createElement("cognom2");
                elementCognom2.appendChild(doc.createTextNode(cognom2));
                Node elementNota = doc.createElement("nota");
                elementNota.appendChild(doc.createTextNode(nota));
                // Afegim els nodes fills al node alumne
                element.appendChild(elementNom);
                element.appendChild(elementCognom1);
                element.appendChild(elementCognom2);
                element.appendChild(elementNota);
                sortir = true;
                // Opció per modificar un atribut
            } else if (opcio == 2) {
                opcio = 0;
                while (!sortir) {
                    String nomAttr;
                    String valorAttr;
                    System.out.println("Quin element vols editar els atributs");
                    System.out.println("1.Element pare 2.Element fill");
                    opcio = scan.nextInt();
                    // Opció per modificar l'atribut del node alumne
                    if (opcio == 1) {
                        // Recorrem els atributs del node alumne
                        for (int i = 0; i < element.getAttributes().getLength(); i++) {
                            opcio = 0;
                            Node atribut = element.getAttributes().item(i);
                            System.out.println("Vols editar el atribut " + element.getAttributes().item(i).getNodeName());
                            System.out.println("1.Si 2.No");
                            opcio = scan.nextInt();
                            // Opció per modificar l'atribut actual del node alumne
                            if (opcio == 1) {
                                // Introduïm el valor del atribut
                                System.out.println("Introdueix un valor");
                                valorAttr = scan.next();
                                atribut.setNodeValue(valorAttr);

                            }
                        }
                        sortir = true;
                        // Opció per afegir un atribut als nodes fills del node alumne
                    } else if (opcio == 2) {
                        // Recorrem els fills del node alumne
                        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
                            if (element.getChildNodes().item(i).hasChildNodes()) {
                                // Recorrem els atributs dels nodes fills
                                for (int j = 0; j < element.getChildNodes().item(i).getAttributes().getLength(); j++) {
                                    opcio = 0;
                                    Node atribut = element.getChildNodes().item(i).getAttributes().item(j);
                                    System.out.println("Vols modificar el atribut "
                                            + element.getChildNodes().item(i).getAttributes().item(j).getNodeName()
                                            + " al element " + element.getChildNodes().item(i).getNodeName());
                                    System.out.println("1.Si 2.No");
                                    opcio = scan.nextInt();
                                    // Opció per modificar l'atribut actual del node fill
                                    if (opcio == 1) {
                                        // Introduïm el valor del atribut
                                        System.out.println("Introdueix un valor");
                                        valorAttr = scan.next();
                                        atribut.setNodeValue(valorAttr);
                                    }
                                }
                            }

                        }
                        sortir = true;
                    }
                }
            }
        }
    }

    public static void eliminarElement() {
        boolean sortir = false;
        int opcio = 0;
        while (!sortir) {
            // Demanem el id del node alumne i ens situem
            System.out.println("Introdueix el id de l'alumne");
            String id = scan.next();
            Element element = doc.getElementById(id);
            System.out.println("Que vols eliminar");
            System.out.println("1.Element 2.Atribut");
            opcio = scan.nextInt();
            // Opció per eliminar el node alumne
            if (opcio == 1) {
                nodeArrel.removeChild(element);
                sortir = true;
                // Opció per eliminar un atribut
            } else if (opcio == 2) {
                while (!sortir) {
                    opcio = 0;
                    System.out.println("A quin element vols eliminar l'atribut");
                    System.out.println("1.Element pare 2.Elements fills");
                    opcio = scan.nextInt();
                    // Opció per eliminar els atributs del node alumne
                    if (opcio == 1) {
                        if (element.hasAttributes()) {
                            // Recorrem els atributs
                            for (int i = 0; i < element.getAttributes().getLength(); i++) {
                                opcio = 0;
                                System.out.println("Vols eliminar l'atribut " + element.getAttributes().item(i).getNodeName());
                                System.out.println("1.Si 2.No");
                                opcio = scan.nextInt();
                                // Opció per eliminar l'atribut actual del node alumne
                                if (opcio == 1) {
                                    element.removeAttribute(element.getAttributes().item(i).getNodeName());
                                }
                            }
                        }
                        sortir = true;
                        // Opció per eliminar els atributs dels nodes fills de alumne
                    } else if (opcio == 2) {
                        // Recorrem els nodes fills del node alumne
                        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
                            if (element.getChildNodes().item(i).hasChildNodes()) {
                                // Guardem el node fill actual
                                Element elementFill = (Element) element.getChildNodes().item(i);
                                // Recorrem els atributs del node fill actual
                                for (int j = 0; j < element.getChildNodes().item(i).getAttributes().getLength(); j++) {
                                    opcio = 0;
                                    Node atribut = element.getChildNodes().item(i).getAttributes().item(j);
                                    System.out.println("Vols eliminar l'atribut " + atribut.getNodeName()
                                            + " de l'element " + elementFill.getNodeName());
                                    System.out.println("1.Si 2.No");
                                    opcio = scan.nextInt();
                                    // Opcio per eliminar l'atribut actual del node fill actual
                                    if (opcio == 1) {
                                        elementFill.removeAttribute(atribut.getNodeName());
                                    }
                                }
                            }
                        }
                        sortir = true;
                    }
                }
                sortir = true;
            }
        }

    }

    public static void guardar() throws TransformerException {
        // Guardem el XML modificat en el arxiu alumnes2.xml i acabem el programa
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        StreamResult result = new StreamResult(new File("E:\\dam\\m06\\uf1\\ex05\\alumnesnew.xml"));
        DOMSource source = new DOMSource(doc);
        trans.transform(source, result);
        System.exit(0);
    }

    public static void assignaId(Node element) {

        // Assignem id als atributs id dels nodes alumne
        if (element.hasAttributes()) {
            for (int i = 0; i < element.getAttributes().getLength(); i++) {
                if (element.getAttributes().item(i).getNodeName().equals("id")) {
                    ((Element) element).setIdAttribute("id", true);
                }
            }
        }

        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            if (element.getChildNodes().item(i).hasChildNodes()) {
                assignaId(element.getChildNodes().item(i));
            }

        }

    }

    public static void mostraInformacioNode(Node element, String espai) {
		// Mostrem els nodes del XML
        // Mostrem el nom del node i el valor
        System.out.println(espai + element.getNodeName());
        System.out.println(espai + "  " + element.getFirstChild().getNodeValue());
        // Si el node conte atributs mostrem els mostrem
        if (element.hasAttributes()) {
            for (int i = 0; i < element.getAttributes().getLength(); i++) {
                System.out.println(espai + element.getAttributes().item(i));
            }
        }
        // Recorrem els nodes fills i mostrem les dades
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            if (element.getChildNodes().item(i).hasChildNodes()) {
                mostraInformacioNode(element.getChildNodes().item(i), espai + "  ");
            }

        }

        // Mostrem el tancament del node
        System.out.println(espai + element.getNodeName());

    }

}
