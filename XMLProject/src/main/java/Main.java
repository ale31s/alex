
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import org.xml.sax.SAXException;
import service.XMLReader;
import service.XMLWriter;
import service.XmlEvenParagraphs;
import service.XmlValidator;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException, IOException, ParserConfigurationException, SAXException {

        // TXT doc to XML 
        XMLWriter write = new XMLWriter();
        try (FileOutputStream out = new FileOutputStream("book.xml")) {
            write.XMLWriter("book.txt", out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //XML validator based on xsd file
        File xsdFile = new File("book_xsd.xsd");
        File xmlFile = new File("book.xml");
        XmlValidator xmlv = new XmlValidator();
        boolean valid = xmlv.validateXMLSchema(xsdFile, xmlFile);
        if (valid) {
            System.out.println("validated xml ");
        }
        //XML Reader
        XMLReader.ReadXml();

        //create a new xml with the even id of paragraphs
        XmlEvenParagraphs even = new XmlEvenParagraphs();
        try (FileOutputStream out = new FileOutputStream("bookaa.xml")) {
            even.findEvenParagraphs(out, "book.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
