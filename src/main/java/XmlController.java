import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.Serializable;


@FacesConfig(
        version = FacesConfig.Version.JSF_2_3
)
@Named
@RequestScoped
public class XmlController {


    public void doOutput() {

        Category electro = new Category("Electro");
        Category smartphone = new Category("Smartphone");
        smartphone.setParent(electro);

        Product product = new Product("Apple Iphone X", 1199.99f, "Make all your friends jealous.", "images/products/IphoneX.jpg", smartphone);

        JAXBContext jc;

        {
            try {

                PrintStream ps = new PrintStream(new StringOutputStream(), true);
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
}