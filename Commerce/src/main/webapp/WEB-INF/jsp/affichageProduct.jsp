<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Affichage d'un produit</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/style.css"/>" />
</head>
<body>
	<c:import url="menu.jsp" />
	<div id="corps">
		<p class="info">${ form.resultat }</p>
		<p>Produit</p>
		<p>
			Nom :
			<c:out value="${ product.name }" />
		</p>
		<p>
			Description :
			<c:out value="${ product.description}" />
		</p>
		<p>
			Dernière MAJ :
			<c:out value="${ product.lastUpdate}" />
		</p>
		<p>
			Prix :
			<c:out value="${ product.price}" /> €
		</p>
	</div>
</body>
</html>