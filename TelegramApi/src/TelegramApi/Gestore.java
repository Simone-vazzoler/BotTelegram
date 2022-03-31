/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelegramApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author vazzoler_simone
 */
public class Gestore {
    Document document;
    String filename;

    public Gestore(String filename) {
        this.filename = filename;
    }
    
    public void creaLista() throws SAXException, IOException, ParserConfigurationException{
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Element root, node;
        NodeList nodelist;
        
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        
        document = builder.parse(filename);
        
        
        root = document.getDocumentElement();
        
        List<String> coordinate = new ArrayList<String>();
//        String latitudine = "";
//        String longitudine = "";
        nodelist = root.getElementsByTagName("place");   //prendere tag lat e long dall'xml
        
        for (int i = 0; i < nodelist.getLength(); i++) {
            
            node = (Element)nodelist.item(i);
            coordinate.add(getLatitudine(node));
            coordinate.add(getLongitudine(node));
        }
        stampa(coordinate);
    }
    
    
    public String getLatitudine(Element nodo){
  
        String latitudine = nodo.getAttribute("lat");
        return latitudine;
    }
    
    public String getLongitudine(Element nodo){
        String longitudine = nodo.getAttribute("lon");
        return longitudine;
    }
    
    public void stampa(List<String> lista){
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }
    }
}
