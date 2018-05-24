package controllers;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import java.io.Serializable;


@FacesConfig(
        version = FacesConfig.Version.JSF_2_3
)


@Named
@RequestScoped
public class SomeController {

    public String getBla() {
        return bla;
    }

    public void setBla(String bla) {
        this.bla = bla;
    }

    private String bla = "deiMurdar";


}
