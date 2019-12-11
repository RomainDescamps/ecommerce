<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="menu">
	<c:if test="${empty sessionScope.sessionUtilisateur}">
	<p>
		<a href="<c:url value="connexion"/>">Connexion</a>
	</p>
	<p>
		<a href="<c:url value="index"/>">Accueil</a>
	</p>
	
	</c:if>
	<%-- Vérification de la présence d'un objet utilisateur en session --%>
	<c:if test="${!empty sessionScope.sessionUtilisateur}">
		<%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
		<p class="succes">Vous êtes connecté(e) avec l'adresse :
			${sessionScope.sessionUtilisateur.email}</p>
	
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
	<p>
		<a href="<c:url value="/deconnexion"/>">Deconnexion</a>
	</p>
	
	</c:if>
</div>