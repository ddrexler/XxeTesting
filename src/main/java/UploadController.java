import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.io.StringReader;
import java.util.Scanner;

//import org.apache.myfaces.custom.fileupload.UploadedFile;

@FacesConfig(
        version = FacesConfig.Version.JSF_2_3
)
@Named
@SessionScoped
public class UploadController implements Serializable {
    private Part file;

    private String xmlString;

    public void doOutput(Product product) {

        if (product == null) return;

        Category electro = new Category("Electro");
        Category smartphone = new Category("Smartphone");
        smartphone.setParent(electro);

        JAXBContext jc;

        {
            try {

                PrintStream ps = new PrintStream(new StringOutputStream(), true);

//                PrintStream ps = new PrintStream(new File("product.xml"));
                System.setOut(ps);

                jc = JAXBContext.newInstance(Product.class);

                Marshaller marshaller = jc.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(product, System.out);


            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    }

    public void upload() {
        try {
            setXmlString(new Scanner(file.getInputStream())
                    .useDelimiter("\\A").next());

            Product product = deserializeProduct(getXmlString());

            InitBean.addToProducts(product);

            doOutput(product);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }


    public String getXmlString() {
        return xmlString;
    }

    public void setXmlString(String pXmlString) {
        xmlString = pXmlString;
    }

    //Parsing xml back to object (+vuln) -> should eventally go into another class


    public Product deserializeProduct(String xmlString) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Product.class);

            XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
            xmlInputFactory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, true);
            xmlInputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, true);
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new StringReader(xmlString));

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            return (Product) unmarshaller.unmarshal(xmlStreamReader);

        } catch (JAXBException pE) {
            pE.printStackTrace();
            return null;
        } catch (XMLStreamException pE) {
            pE.printStackTrace();
            return null;
        }
    }


}