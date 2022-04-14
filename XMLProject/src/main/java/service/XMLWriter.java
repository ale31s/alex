/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author alexi
 */
public class XMLWriter {

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {

//        try (FileOutputStream out = new FileOutputStream("book.xml")) {
//            XMLWriter("book.txt", out);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        File xsdFile = new File("book_xsd.xsd");
        File xmlFile = new File("book.xml");
        XmlValidator xmlv = new XmlValidator();
        boolean a = xmlv.validateXMLSchema(xsdFile, xmlFile);
        if (a) {
            System.out.println("validated xml ");
        }
        XMLReader.ReadXml();
    }

    public  void XMLWriter(String filename, OutputStream out) throws XMLStreamException, FileNotFoundException {
        File file = new File(filename);
        XMLOutputFactory output = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = output.createXMLStreamWriter(out, "UTF-8");

        Scanner fileReader = new Scanner(file);
        int paragraphCounter = 0;
        int lineCounter = 0;
        int chapterCounter = 0;
        int wordCounter = 0;
        int distinctWordCounter = 0;
        List<String> wordList = new ArrayList<>();
        Set<String> wordSet = new HashSet<>();

        writer.writeStartDocument("utf-8", "1.0");
        writer.writeCharacters("\n\t");
        writer.writeStartElement("book");
        writer.writeCharacters("\n\t\t");
        writer.writeStartElement("chapter");
        writer.writeAttribute("chapterID", chapterCounter + "");

        while (fileReader.hasNext()) {
            String paragraph = fileReader.nextLine();
            if (paragraph.equals("")) {
                continue;
            }
            writer.writeCharacters("\n\t\t\t");
            writer.writeStartElement("paragraph");
            writer.writeAttribute("paragraphID", paragraphCounter + "");
            writer.writeCharacters("\n\t\t\t\t");
            String[] lines = paragraph.split("\\.");
            for (String line : lines) {

                String words[] = line.split("[\\W\\.\\,]");

                for (String word : words) {
                    if (word.equals("")) {
                        continue;
                    }
                    wordList.add(word);
                    wordSet.add(word);
                }
                wordCounter = +wordList.size();
                distinctWordCounter = +wordSet.size();

                writer.writeStartElement("line");
                writer.writeAttribute("lineID", lineCounter + "");
                writer.writeCharacters(line);
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t\t\t");
                lineCounter++;
            }
            writer.writeCharacters("\n\t\t\t");
            writer.writeEndElement();
            paragraphCounter++;

        }
        writer.writeCharacters("\n\t\t");
        writer.writeEndElement();
        writer.writeCharacters("\n\t\t");
        writer.writeStartElement("statistics");
        writer.writeCharacters("\n\t\t\t");

        writer.writeStartElement("paragraphs");
        writer.writeCharacters(paragraphCounter - 1 + "");
        writer.writeEndElement();
        writer.writeCharacters("\n\t\t\t");

        writer.writeStartElement("lines");
        writer.writeCharacters(lineCounter - 1 + "");
        writer.writeEndElement();
        writer.writeCharacters("\n\t\t\t");

        writer.writeStartElement("words");
        writer.writeCharacters(wordCounter - 1 + "");
        writer.writeEndElement();
        writer.writeCharacters("\n\t\t\t");

        writer.writeStartElement("distinctWords");
        writer.writeCharacters(distinctWordCounter - 1 + "");
        writer.writeEndElement();
        writer.writeCharacters("\n\t\t");

        writer.writeEndElement();
        writer.writeCharacters("\n\t");

        writer.writeEndElement();
        writer.flush();
        writer.close();

    }
}
