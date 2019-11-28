package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.bean.Utilisateur;
import com.example.demo.form.ConnexionForm;

@Controller
public class ConnexionController {
	
	
    public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    
    
	
	
	@RequestMapping(value = { "/connexion" }, method = RequestMethod.GET)
    public String connexionGet() {
		 
        return "connexion";
	}
	
	@RequestMapping(value = { "/connexion" }, method = RequestMethod.POST)
	public String connexionPost(HttpServletRequest request) {
		
		
        ConnexionForm form = new ConnexionForm();

        /* Traitement de la requête et récupération du bean en résultant */
        Utilisateur utilisateur = form.connecterUtilisateur( request );

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
		
		
        if ( form.getErreurs().isEmpty() ) {
            session.setAttribute( ATT_SESSION_USER, utilisateur );
        } else {
            session.setAttribute( ATT_SESSION_USER, null );
        }
		
		
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, utilisateur );
	    
        
        
        
		return "connexion";
	}
	
	
	@RequestMapping(value = { "/deconnexion" }, method = RequestMethod.GET)
    public String deconnexionGet(HttpServletRequest request) {
		
        HttpSession session = request.getSession();
        session.invalidate();

		 
        return "connexion";
	}
	   
  
	 

}
