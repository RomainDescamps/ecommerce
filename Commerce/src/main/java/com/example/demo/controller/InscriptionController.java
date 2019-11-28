package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.bean.Utilisateur;
import com.example.demo.form.InscriptionForm;





@Controller
public class InscriptionController {
	
	
    public static final String ATT_USER = "utilisateur";
    public static final String ATT_FORM = "form";
    
	
	
	@RequestMapping(value = { "/inscription" }, method = RequestMethod.GET)
    public String inscriptionGet() {
		 
        return "inscription";
	}
	
	@RequestMapping(value = { "/inscription" }, method = RequestMethod.POST)
	public String inscriptionPost(HttpServletRequest request) {
		InscriptionForm form = new InscriptionForm();
		Utilisateur utilisateur = form.inscrireUtilisateur(request);
		
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, utilisateur );
	    
		return "inscription";
	}
	   
  
	 

}
