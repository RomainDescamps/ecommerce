<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="menu">

	<p>
		<a href="<c:url value="index"/>">Accueil</a>
	</p>
	<p>
		<a href="<c:url value="creerClient"/>">Créer un nouveau client</a>
	</p>
	<p>
		<a href="<c:url value="creerCommande"/>">Créer une nouvelle
			commande</a>
	</p>
	<p>
		<a href="<c:url value="/listeClients"/>">Voir les clients
			existants</a>
	</p>
	<p>
		<a href="<c:url value="/listeCommandes"/>">Voir les commandes
			existantes</a>
	</p>
</div>