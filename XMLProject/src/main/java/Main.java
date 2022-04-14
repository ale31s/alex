
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.stream.XMLStreamException;
import service.XMLReader;
import service.XMLWriter;
import service.XmlValidator;




public class Main {
        public static void main(String[] args) throws FileNotFoundException, XMLStreamException, IOException {
XMLWriter write = new XMLWriter();


        try (FileOutputStream out = new FileOutputStream("book.xml")) {
            write.XMLWriter("book.txt", out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File xsdFile = new File("book_xsd.xsd");
        File xmlFile = new File("book.xml");
        XmlValidator xmlv = new XmlValidator();
        boolean a = xmlv.validateXMLSchema(xsdFile, xmlFile);
        if (a) {
            System.out.println("validated xml ");
        }
        XMLReader.ReadXml();
    }
    
}
