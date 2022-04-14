/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author alexi
 */
public class XMLReader {

    private static final String FILENAME = "book.xml";

    public static void ReadXml() {
        try {
            printXmlByXmlCursorReader(Paths.get(FILENAME));
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static void printXmlByXmlCursorReader(Path path) throws FileNotFoundException, XMLStreamException {

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(new FileInputStream(path.toFile()));

        int eventType = reader.getEventType();
        System.out.println(eventType); // 7, START_DOCUMENT
        System.out.println(reader); // xerces

        while (reader.hasNext()) {
            eventType = reader.next();
            if (eventType == XMLEvent.START_ELEMENT) {
                switch (reader.getName().getLocalPart()) {
                    case "book":
                        System.out.printf("Book \n");
                        break;

                    case "chapter":
                        String ChapterId = reader.getAttributeValue(null, "chapterID");
                        System.out.printf("Chapter id : %s%n", ChapterId);
                        break;

                    case "paragraph":
                        String ParagraphId = reader.getAttributeValue(null, "paragraphID");
                        System.out.printf("Paragraph id : %s%n", ParagraphId);
                        break;

                    case "line":
                        String LineId = reader.getAttributeValue(null, "lineID");
                        eventType = reader.next();
                        if (eventType == XMLEvent.CHARACTERS) {
                            String words = reader.getText();
                            System.out.printf("Line Id: [" + LineId + "] [words] :"
                                    + words + "\n");
                        }
                        break;

                    case "statistics":
                        System.out.printf("Statistics \n");
                        break;

                    case "paragraphs":
                        eventType = reader.next();
                        if (eventType == XMLEvent.CHARACTERS) {
                            String paragraphsNumber = reader.getText();
                            System.out.printf("Number of Paragraphs: " + paragraphsNumber + "\n");
                        }
                        break;

                    case "lines":
                        eventType = reader.next();
                        if (eventType == XMLEvent.CHARACTERS) {
                            String linessNumber = reader.getText();
                            System.out.printf("Number of lines: " + linessNumber + "\n");
                        }
                        break;

                    case "words":
                        eventType = reader.next();
                        if (eventType == XMLEvent.CHARACTERS) {
                            String wordsNumber = reader.getText();
                            System.out.printf("Number of Paragraphs: " + wordsNumber + "\n");
                        }
                        break;

                    case "distinctWords":
                        eventType = reader.next();
                        if (eventType == XMLEvent.CHARACTERS) {
                            String distinctwordsNumber = reader.getText();
                            System.out.printf("Number of Paragraphs: " + distinctwordsNumber + "\n");
                        }
                        break;

                }

            }

            if (eventType == XMLEvent.END_ELEMENT) {

                if (reader.getName().getLocalPart().equals("staff")) {
                    System.out.printf("%n%s%n%n", "---");
                }
            }

        }

    }

}
