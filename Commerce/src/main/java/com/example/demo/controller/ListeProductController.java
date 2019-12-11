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
import com.example.demo.bean.Product;
import com.example.demo.map.ProductMapper;

@Controller
public class ListeProductController {
	public static final String ATT_PRODUCT = "product";
	public static final String ATT_FORM = "form";
	public static final String PARAM_NOM_PRODUCT = "nomProduct";
	public static final String SESSION_PRODUCT = "products";
	
	@Autowired
	private ProductMapper productMapper;
	
	@RequestMapping(value = { "/listeProduits" }, method = RequestMethod.GET)
	public String doGet(HttpServletRequest request) {
		/* À la réception d'une requête GET, affichage de la liste des clients */
		
		/* Récupération de la Map des clients enregistrés en session */
		//	HttpSession session = request.getSession();
	//	@SuppressWarnings("unchecked")
	//	Map<String, Client> clients = (HashMap<String, Client>) session.getAttribute(SESSION_CLIENTS);
		
		Map<String, Product> mapproduct = new HashMap<> ();
		
		
		List<Product> productsBDD = this.productMapper.findAll();
		
		
		for (int i = 0; i < productsBDD.size(); i++) {
			Product productbdd = new Product();
			productbdd.setId(productsBDD.get(i).getId());
			productbdd.setName(productsBDD.get(i).getName());
			productbdd.setDescription(productsBDD.get(i).getDescription());
			productbdd.setLastUpdate(productsBDD.get(i).getLastUpdate());
			productbdd.setPrice(productsBDD.get(i).getPrice());
			
			mapproduct.put(productsBDD.get(i).getId()+productsBDD.get(i).getName(), productbdd);
			
		}
		
		request.setAttribute(SESSION_PRODUCT, mapproduct);
	
	
		//session.setAttribute(SESSION_CLIENTS, clients);
		
		return "listeCategories";
	}

	@RequestMapping(value = { "/suppressionProduct" }, method = RequestMethod.GET)
	public String suppression(HttpServletRequest request) {
		/* À la réception d'une requête GET, affichage de la liste des clients */
		/* Récupération du paramètre */
		String nomCategory = getValeurParametre(request, PARAM_NOM_PRODUCT);

		/* Récupération de la Map des clients enregistrés en session */
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		Map<String, Category> categories = (HashMap<String, Category>) session.getAttribute(SESSION_PRODUCT);

		/* Si le nom du client et la Map des clients ne sont pas vides */
		if (nomCategory != null && categories != null) {
			/* Alors suppression du client de la Map */
			categories.remove(nomCategory);
			/* Et remplacement de l'ancienne Map en session par la nouvelle */
			session.setAttribute(SESSION_PRODUCT, categories);
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
