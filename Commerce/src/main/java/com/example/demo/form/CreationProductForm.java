package com.example.demo.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.bean.Product;

public final class CreationProductForm {
	
	private static final String CHAMP_NAME = "nameProduct";
	private static final String CHAMP_DESCRIPTION = "nameDescription";
	private static final String CHAMP_PRICE= "namePrice";
	
	private String              resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }
    
    public Product creerProduct( HttpServletRequest request ) {
        

        String name = getValeurChamp( request, CHAMP_NAME);
        String description = getValeurChamp( request, CHAMP_DESCRIPTION);
        double price = -1;

        Product product = new Product();

        product.setName( name );
        product.setDescription( description );
        
        try {
			price = validationPrice(getValeurChamp( request, CHAMP_PRICE ));
		} catch (Exception e) {
			setErreur(CHAMP_PRICE, e.getMessage());
		}
        product.setPrice( price );
        
        product.setLastUpdate(new Date());

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la création du produit.";
        } else {
            resultat = "Échec de la création du produit.";
        }
        return product;
    }
    
    private double validationPrice( String Price ) throws Exception {
        double temp;
        if ( Price != null ) {
            try {
                temp = Double.parseDouble( Price );
                if ( temp < 0 ) {
                    throw new Exception( "Le Prix doit être un nombre positif." );
                }
            } catch ( NumberFormatException e ) {
                temp = -1;
                throw new Exception( "Le Prix doit être un nombre." );
            }
        } else {
            temp = -1;
            throw new Exception( "Merci d'entrer un Prix." );
        }
        return temp;
    }
    
    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}
