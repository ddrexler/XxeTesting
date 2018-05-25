import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import java.io.Serializable;

@FacesConfig(
        version = FacesConfig.Version.JSF_2_3
)

@Named
@SessionScoped
public class NbtController implements Serializable {

    private static String log = ""; // The property linked to my <h:outputText />
//ex : <h:outputText id="logger" value="#{Nbt.log}" />

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        NbtController.log = log;
    }

    public static String getConsole() {
        return log;
    }

    public static void appendConsole(String s) {
        log += s;
    }
}