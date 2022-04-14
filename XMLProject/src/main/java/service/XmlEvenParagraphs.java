/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author alexi
 */
public class XmlEvenParagraphs {

    public void findEvenParagraphs(OutputStream out, String filename) throws XMLStreamException, ParserConfigurationException, SAXException, IOException {
        File file = new File(filename);
        XMLOutputFactory output = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = output.createXMLStreamWriter(out, "UTF-8");

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(filename));
        doc.getDocumentElement().normalize();

        writer.writeStartDocument("utf-8", "1.0");
        writer.writeCharacters("\n\t");
        writer.writeStartElement("book");
        writer.writeCharacters("\n\t\t");
        writer.writeStartElement("chapter");
        NodeList list = doc.getElementsByTagName("paragraph");
        for (int temp = 0; temp < list.getLength(); temp++) {
            Node node = list.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String x = element.getAttribute("paragraphID");
                int pID= Integer. parseInt(x);
                if (pID %2 == 1) {
                    continue;
                }
            
            writer.writeCharacters("\n\t\t\t");
            writer.writeStartElement("paragraph");
            writer.writeAttribute("paragraphID", pID + "");
            }

            NodeList list2 = node.getChildNodes();
            for (int temp2 = 0; temp2 < list2.getLength(); temp2++) {
                Node node2 = list2.item(temp2);
                if (node2.getNodeType() == Node.ELEMENT_NODE) {
                    Element element2 = (Element) node2;
                    String lID = element2.getAttribute("lineID");
                    String text = element2.getTextContent();
                    writer.writeCharacters("\n\t\t\t\t");
                    writer.writeStartElement("line");
                    writer.writeAttribute("lineID", lID + "");
                    writer.writeCharacters(text);
                    writer.writeEndElement();
                }
            }
            writer.writeCharacters("\n\t\t\t");
            writer.writeEndElement();

        }
        writer.writeCharacters("\n\t\t");
        writer.writeEndElement();
        writer.writeCharacters("\n\t");
        writer.writeEndElement();
    }

}
