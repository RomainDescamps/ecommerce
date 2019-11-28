package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.bean.Client;
import com.example.demo.bean.Commande;
import com.example.demo.form.CreationCommandeForm;

@Controller
public class CreerCommandeController {
	public static final String ATT_COMMANDE = "commande";
	public static final String ATT_FORM = "form";
	public static final String SESSION_CLIENTS   = "clients";
    public static final String SESSION_COMMANDES = "commandes";

	@RequestMapping(value = { "/creerCommande" }, method = RequestMethod.GET)

	public String simpleForm() {
		return "creerCommande";

	}

	@RequestMapping(value = { "/creerCommande" }, method = RequestMethod.POST)

	public String commandePost(HttpServletRequest request) {

		CreationCommandeForm form = new CreationCommandeForm();

		Commande commande = form.creerCommande(request);

		request.setAttribute(ATT_COMMANDE, commande);
		request.setAttribute(ATT_FORM, form);

		if ( form.getErreurs().isEmpty() ) {
            /* Alors récupération de la map des clients dans la session */
            HttpSession session = request.getSession();
            @SuppressWarnings("unchecked")
			Map<String, Client> clients = (HashMap<String, Client>) session.getAttribute( SESSION_CLIENTS );
            /* Si aucune map n'existe, alors initialisation d'une nouvelle map */
            if ( clients == null ) {
                clients = new HashMap<String, Client>();
            }
            /* Puis ajout du client de la commande courante dans la map */
            clients.put( commande.getClient().getNom(), commande.getClient() );
            /* Et enfin (ré)enregistrement de la map en session */
            session.setAttribute( SESSION_CLIENTS, clients );
 
            /* Ensuite récupération de la map des commandes dans la session */
            @SuppressWarnings("unchecked")
			Map<String, Commande> commandes = (HashMap<String, Commande>) session.getAttribute( SESSION_COMMANDES );
            /* Si aucune map n'existe, alors initialisation d'une nouvelle map */
            if ( commandes == null ) {
                commandes = new HashMap<String, Commande>();
            }
            /* Puis ajout de la commande courante dans la map */
            commandes.put( commande.getStatutLivraison(), commande );
            /* Et enfin (ré)enregistrement de la map en session */
            session.setAttribute( SESSION_COMMANDES, commandes );

            /* Affichage de la fiche récapitulative */
			return "affichageCommande";
		} else {
			/* Sinon, ré-affichage du formulaire de création avec les erreurs */
			return "creerCommande";
		}

	}

}
