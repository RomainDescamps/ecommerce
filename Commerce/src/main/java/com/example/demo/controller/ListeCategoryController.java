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

import com.example.demo.bean.Category;
import com.example.demo.bean.Client;
import com.example.demo.map.CategoryMapper;

@Controller
public class ListeCategoryController {
	public static final String ATT_CATEGORY = "category";
	public static final String ATT_FORM = "form";
	public static final String PARAM_NOM_CATEGORY = "nomCategory";
	public static final String SESSION_CATEGORY = "categories";
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@RequestMapping(value = { "/listeCategories" }, method = RequestMethod.GET)
	public String doGet(HttpServletRequest request) {
		/* À la réception d'une requête GET, affichage de la liste des clients */
		
		/* Récupération de la Map des clients enregistrés en session */
		//	HttpSession session = request.getSession();
	//	@SuppressWarnings("unchecked")
	//	Map<String, Client> clients = (HashMap<String, Client>) session.getAttribute(SESSION_CLIENTS);
		
		Map<String, Category> mapcategory = new HashMap<> ();
		
		
		List<Category> categoriesBDD = this.categoryMapper.findAll();
		
		
		for (int i = 0; i < categoriesBDD.size(); i++) {
			Category categorybdd = new Category();
			categorybdd.setIdCategory(categoriesBDD.get(i).getIdCategory());
			categorybdd.setName(categoriesBDD.get(i).getName());
			
			
			mapcategory.put(categoriesBDD.get(i).getIdCategory()+categoriesBDD.get(i).getName(), categorybdd);
			
		}
		
		request.setAttribute(SESSION_CATEGORY, mapcategory);
	
	
		//session.setAttribute(SESSION_CLIENTS, clients);
		
		return "listeClients";
	}

	@RequestMapping(value = { "/suppressionCategory" }, method = RequestMethod.GET)
	public String suppression(HttpServletRequest request) {
		/* À la réception d'une requête GET, affichage de la liste des clients */
		/* Récupération du paramètre */
		String nomCategory = getValeurParametre(request, PARAM_NOM_CATEGORY);

		/* Récupération de la Map des clients enregistrés en session */
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		Map<String, Category> categories = (HashMap<String, Category>) session.getAttribute(SESSION_CATEGORY);

		/* Si le nom du client et la Map des clients ne sont pas vides */
		if (nomCategory != null && categories != null) {
			/* Alors suppression du client de la Map */
			categories.remove(nomCategory);
			/* Et remplacement de l'ancienne Map en session par la nouvelle */
			session.setAttribute(SESSION_CATEGORY, categories);
		}

		/* Redirection vers la fiche récapitulative */
		
		
		
		
		
		return "listeCategories";
		
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
