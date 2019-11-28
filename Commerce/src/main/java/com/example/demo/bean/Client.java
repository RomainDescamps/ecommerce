package com.example.demo.bean;

import org.springframework.stereotype.Repository;

@Repository
public class Client  {
    /**
	 * 
	 */
	

	/* Propriétés du bean */
	private int id;
    private String nom;
    private String prenom;
    private String adresse;
	private String telephone;
    private String email;
    
    
 @Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", telephone="
				+ telephone + ", email=" + email + "]";
	}
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setAdresse( String adresse ) {
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone( String telephone ) {
        this.telephone = telephone;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}