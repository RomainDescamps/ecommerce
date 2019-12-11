<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Liste des catégories existantes</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="style.css"/>" />
</head>
<body>
	<c:import url="menu.jsp" />
	<div id="corps">
		<c:choose>
			<%-- Si aucune catégories n'existe en session, affichage d'un message par défaut. --%>
			<c:when test="${ empty categories }">
				<p class="erreur">Aucune catégorie enregistrée.</p>
			</c:when>
			<%-- Sinon, affichage du tableau. --%>
			<c:otherwise>
				<table>
					<tr>
						<th>Identifiant</th>
						<th>Nom</th>			
						<th class="action">Action</th>
					</tr>
					<%-- Parcours de la Map des clients en session, et utilisation de l'objet varStatus. --%>
					<c:forEach items="${ categories }" var="mapCategories"
						varStatus="boucle">
						<%-- Simple test de parité sur l'index de parcours, pour alterner la couleur de fond de chaque ligne du tableau. --%>
						<tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
							<%-- Affichage des propriétés du bean Client, qui est stocké en tant que valeur de l'entrée courante de la map --%>
							<td><c:out value="${ mapCategories.value.idCategory }" /></td>
							<td><c:out value="${ mapCategories.value.name }" /></td>
							<%-- Lien vers la servlet de suppression, avec passage du nom du client - c'est-à-dire la clé de la Map - en paramètre grâce à la balise <c:param/>. --%>
							<td class="action"><a
								href="<c:url value="suppressionCategory"><c:param name="nomCategory" value="${ mapCategories.key }" /></c:url>">
									<img src="<c:url value="supprimer.png"/>" alt="Supprimer" />
							</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
