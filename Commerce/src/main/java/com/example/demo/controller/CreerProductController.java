package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.bean.Product;
import com.example.demo.form.CreationProductForm;
import com.example.demo.map.ProductMapper;

@Controller
public class CreerProductController {

	
	@Autowired
	private final ProductMapper productMapper;
	
	public CreerProductController(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}
	
	@RequestMapping(value = { "/creerProduct" }, method = RequestMethod.GET)

	public String simpleForm() {
		return "creerProduct";

	}
	
	@RequestMapping(value = { "/creerProduct" }, method = RequestMethod.POST)

	public String productPost(HttpServletRequest request) {

		CreationProductForm form = new CreationProductForm();

		Product product = form.creerProduct(request);

//		request.setAttribute(ATT_CLIENT, client);
//		request.setAttribute(ATT_FORM, form);

		if (form.getErreurs().isEmpty()) {
			
            
            
            this.productMapper.insert(product);
            
            
			return "affichageProduct";
		} else {
			/* Sinon, ré-affichage du formulaire de création avec les erreurs */
			return "creerProduct";
		}

	}
}
