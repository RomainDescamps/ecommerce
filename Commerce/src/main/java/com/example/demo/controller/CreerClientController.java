package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.bean.Client;
import com.example.demo.form.CreationClientForm;
import com.example.demo.map.ClientMapper;

@Controller
public class CreerClientController {

	public static final String ATT_CLIENT = "client";
	public static final String ATT_FORM = "form";
	public static final String SESSION_CLIENTS = "clients";
	@Autowired
	private final ClientMapper clientMapper;

	public CreerClientController(ClientMapper clientMapper) {
		this.clientMapper = clientMapper;
	}

	@RequestMapping(value = { "/creerClient" }, method = RequestMethod.GET)

	public String clientGet() {
		return "creerClient";

	}

	@RequestMapping(value = { "/creerClient" }, method = RequestMethod.POST)

	public String clientPost(HttpServletRequest request) {

		CreationClientForm form = new CreationClientForm();

		Client client = form.creerClient(request);

		request.setAttribute(ATT_CLIENT, client);
		request.setAttribute(ATT_FORM, form);

		if (form.getErreurs().isEmpty()) {
			/* Si aucune erreur, alors affichage de la fiche récapitulative */
			
			HttpSession session = request.getSession();
            @SuppressWarnings("unchecked")
			Map<String, Client> clients = (HashMap<String, Client>) session.getAttribute( SESSION_CLIENTS );
            if ( clients == null ) {
                clients = new HashMap<String, Client>();
            }
            /* Puis ajout du client courant dans la map */
            clients.put( client.getNom(), client );
            /* Et enfin (ré)enregistrement de la map en session */
            session.setAttribute( SESSION_CLIENTS, clients );
            
            
            this.clientMapper.insert(client);
            
            
			return "affichageClient";
		} else {
			/* Sinon, ré-affichage du formulaire de création avec les erreurs */
			return "creerClient";
		}

	}

}
