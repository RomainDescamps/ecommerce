package com.example.demo.bean;



public class Utilisateur {

    private String email;
    private String motdepasse;
    private String nom;

    public void setEmail(String email) {
	this.email = email;
    }
    public String getEmail() {
	return email;
    }

    public void setMotDePasse(String motdepasse) {
	this.motdepasse = motdepasse;
    }
    public String getMotDePasse() {
	return motdepasse;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }
    public String getNom() {
	return nom;
    }
}