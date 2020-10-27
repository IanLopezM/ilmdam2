/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6_uf1_act6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Alumne
 */
public class M6_uf1_act6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PropertyException, JAXBException, FileNotFoundException, IOException {
        // TODO code application logic here
        JAXBContext context = JAXBContext.newInstance(Rows.class);
        Marshaller marshaller = context.createMarshaller();
	marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        Rows rows = ompleRows();
        
        //marshaller.marshal(rows, System.out);
        
        FileOutputStream fos = new FileOutputStream("rows_xml");
        marshaller.marshal(rows, fos);
        fos.close();
        
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Rows rowsAux = (Rows) unmarshaller.unmarshal(new File("rows_xml"));
        System.out.println("********* Alumnes carregat desde fitxer XML***************");
        marshaller.marshal(rowsAux, System.out);
        
        
       Rows rows2 = JAXB.unmarshal(new FileReader("rows2.xml"), Rows.class);
       JAXB.marshal(rows2, System.out);
        
    }

    private static Rows ompleRows() {
        String _ids[] = {"row-mvai_6cu2~ijgv", "row-mvai_6cu2~ijgz", "row-mvai_6cu2~ijgb"};
        String _uuids[] = {"00000000-0000-0000-A01C-1DDE08356FD2", "00000000-1111-0000-A01C-1DDE08356FD2", "00000000-2222-0000-A01C-1DDE08356FD2"};
        String _positions[] = {"1", "2", "3"};
        String _addresss[] = {"https://analisi.transparenciacatalunya.cat/resource/_9qmy-ujbd/row-mvai_6cu2~ijgv", 
            "https://analisu.transparenciacatalunya.cat/resource/_9qmy-ujbd/row-mvai_6cu2~ijgv", 
            "https://analiso.transparenciacatalunya.cat/resource/_9qmy-ujbd/row-mvai_6cu2~ijgv"};
        String noms[] = {"hola", "adios", "hasta mañana"};
        String adre_as[] = {"Moll Gregal, 18", "Moll Gregal, 19", "Moll Gregal, 20"};
        String codi_postals[] = {"12345", "23456", "34567"};
        String municipis[] = {"barcelona", "tarragona", "girona"};
        String comarcas[] = {"Baix Camp", "Alt Camp", "Valls"};
        String modalitats[] = {"esports", "cuina", "poblacions"};
        Row[] ArrayRows = new Row[3];
        
        for (int i = 0; i < 3; i++) {
            ArrayRows[i] = new Row();
            ArrayRows[i].setId(_ids[i]);
            ArrayRows[i].setUuid(_uuids[i]);
            ArrayRows[i].setPosition(_positions[i]);
            ArrayRows[i].setAddress(_addresss[i]);
            ArrayRows[i].setNom(noms[i]);
            ArrayRows[i].setAdre_a(adre_as[i]);
            ArrayRows[i].setCodi_postal(codi_postals[i]);
            ArrayRows[i].setMunicipi(municipis[i]);
            ArrayRows[i].setComarca(comarcas[i]);
            ArrayRows[i].setModalitat(modalitats[i]);
        }
        
        Rows rows = new Rows();
        rows.setRow(ArrayRows);
        
        return rows;
    }
    
}
