package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.bean.Client;
import com.example.demo.map.ClientMapper;

@Controller
public class ListeClientsController {
	public static final String ATT_CLIENT = "client";
	public static final String ATT_FORM = "form";
	public static final String PARAM_NOM_CLIENT = "nomClient";
	public static final String SESSION_CLIENTS = "clients";
	
	@Autowired
	private ClientMapper clientMapper;
	
	@RequestMapping(value = { "/listeClients" }, method = RequestMethod.GET)
	public String doGet(HttpServletRequest request) {
		/* À la réception d'une requête GET, affichage de la liste des clients */
		
		/* Récupération de la Map des clients enregistrés en session */
		//	HttpSession session = request.getSession();
	//	@SuppressWarnings("unchecked")
	//	Map<String, Client> clients = (HashMap<String, Client>) session.getAttribute(SESSION_CLIENTS);
		
		Map<String, Client> mapclients = new HashMap<> ();
		
		
		List<Client> clientsBDD = this.clientMapper.findAll();
		
		
		for (int i = 0; i < clientsBDD.size(); i++) {
			Client clientbdd = new Client();
			clientbdd.setId(clientsBDD.get(i).getId());
			clientbdd.setNom(clientsBDD.get(i).getNom());
			clientbdd.setPrenom(clientsBDD.get(i).getPrenom());
			clientbdd.setAdresse(clientsBDD.get(i).getAdresse());
			clientbdd.setTelephone(clientsBDD.get(i).getTelephone());
			clientbdd.setEmail(clientsBDD.get(i).getEmail());
			
			mapclients.put(clientsBDD.get(i).getId()+clientsBDD.get(i).getNom(), clientbdd);
			
		}
		
		request.setAttribute(SESSION_CLIENTS, mapclients);
	
	
		//session.setAttribute(SESSION_CLIENTS, clients);
		
		return "listeClients";
	}

	@RequestMapping(value = { "/suppressionClient" }, method = RequestMethod.GET)
	public String suppression(HttpServletRequest request) {
		/* À la réception d'une requête GET, affichage de la liste des clients */
		/* Récupération du paramètre */
		String nomClient = getValeurParametre(request, PARAM_NOM_CLIENT);

		/* Récupération de la Map des clients enregistrés en session */
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		Map<String, Client> clients = (HashMap<String, Client>) session.getAttribute(SESSION_CLIENTS);

		/* Si le nom du client et la Map des clients ne sont pas vides */
		if (nomClient != null && clients != null) {
			/* Alors suppression du client de la Map */
			clients.remove(nomClient);
			/* Et remplacement de l'ancienne Map en session par la nouvelle */
			session.setAttribute(SESSION_CLIENTS, clients);
		}

		/* Redirection vers la fiche récapitulative */
		
		
		
		
		
		return "listeClients";
		
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
