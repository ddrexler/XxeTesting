import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.util.Scanner;

//import org.apache.myfaces.custom.fileupload.UploadedFile;

@FacesConfig(
        version = FacesConfig.Version.JSF_2_3
)
@Named
@RequestScoped
public class UploadController implements Serializable {
    private Part file;
    private Document xmlFile;


    public void upload() {
        try {
            String fileContent = new Scanner(file.getInputStream())
                    .useDelimiter("\\A").next();
            setXmlFile(loadXMLFromString(fileContent));

        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Document loadXMLFromString(String xml) throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        return builder.parse(is);
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

        public Document getXmlFile() {
        return xmlFile;
    }

    public void setXmlFile(Document xmlFile) {
        this.xmlFile = xmlFile;
    }


}