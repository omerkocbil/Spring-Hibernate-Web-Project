package com.omerkocbil;

/**
 * Created by jan on 29.06.2016.
 */
import com.omerkocbil.model.Personel;
import com.omerkocbil.service.PersonelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.IOException;
import java.util.List;


@ManagedBean
public class RedirectPage {

    public static Personel yPersonel;

    public void goToEklePage() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8081/ekle");
    }

    public void goToDuzenlePage() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8081/duzenle");
    }

    public void goToAraPage() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8081/ara");
    }

    public void goToTumKayitlarPage() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8081/tumkayitlar");
    }

    public void goToIndexPage() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8081/index");
    }

    public void goToInsertPage(Personel personel) throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8081/ekle");
        yPersonel = personel;
    }

    public void goToEditPage(Personel personel) throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8081/duzenle");
        yPersonel = personel;
    }

}
