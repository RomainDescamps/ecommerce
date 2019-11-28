package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.bean.Commande;

@Controller
public class ListCommandesController {
	 public static final String ATT_COMMANDE = "commande";
	    public static final String ATT_FORM     = "form";
	    public static final String PARAM_STATUT= "statutLivraison";
	    public static final String SESSION_COMMANDES   = "commandes";
   

    
    @RequestMapping(value = { "/listeCommandes" }, method = RequestMethod.GET)
    public String doGet( HttpServletRequest request){
        /* À la réception d'une requête GET, affichage de la liste des commande */
       
        return "listeCommandes";
    }
    
    
    
    @RequestMapping(value = { "/suppressionCommande" }, method = RequestMethod.GET)
	public String suppression(HttpServletRequest request) {
		/* À la réception d'une requête GET, affichage de la liste des commande */
		/* Récupération du paramètre */
		String statutLivraison = getValeurParametre(request, PARAM_STATUT);

		/* Récupération de la Map des commande enregistrés en session */
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		Map<String, Commande> commandes = (HashMap<String, Commande>) session.getAttribute(SESSION_COMMANDES);

		/* Si le nom du client et la Map des commande ne sont pas vides */
		if (statutLivraison != null && commandes != null) {
			/* Alors suppression du commande de la Map */
			commandes.remove(statutLivraison);
			/* Et remplacement de l'ancienne Map en session par la nouvelle */
			session.setAttribute(SESSION_COMMANDES, commandes);
		}

		/* Redirection vers la fiche récapitulative */
		return "listeCommandes";
	}

	/*
	 * Méthode utilitaire qui retourne null si un paramètre est vide, et son contenu
	 * sinon.
	 */
	private static String getValeurParametre(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur;
		}
	}
}