package com.omerkocbil;

import com.omerkocbil.model.Personel;
import com.omerkocbil.service.PersonelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.faces.component.UIColumn;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/")
public class PersonelController {

	@Autowired
	PersonelService personelService;

	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String goToIndexPage(ModelMap model) {
		//model.addAttribute("user", "Aliii");
		return "index";
	}

	@RequestMapping(value = "/ekle", method = RequestMethod.GET)
	public String goToEklePage(){
		if (RedirectPage.yPersonel != null) {
			personelService.personelEkle(RedirectPage.yPersonel);
		}
		return "ekle";
	}

	@RequestMapping(value = "/ara", method = RequestMethod.GET)
	public String goToAraPage(){
		return "ara";
	}

	@RequestMapping(value = "/duzenle", method = RequestMethod.GET)
	public String goToDuzenlePage() {
		if (RedirectPage.yPersonel != null) {
			personelService.personelDuzenle(RedirectPage.yPersonel);
		}
		return "duzenle";
	}

	@RequestMapping(value = "/tumkayitlar", method = RequestMethod.GET)
	public String goToTumKayitlarPage(){
		return "tumkayitlar";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(){
		personelService.personelEkle(RedirectPage.yPersonel);
		return "index";
	}

}