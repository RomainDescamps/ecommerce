<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Création d'un client</title>
<link type="text/css" rel="stylesheet" href="<c:url value="style.css"/>" />
</head>
<body>
	<c:import url="menu.jsp" />
	<div>
		<form method="post" action="<c:url value="creerClient"/>">
			<fieldset>
				<legend>Informations client</legend>
				<c:import url="inc_client_form.jsp" />
			</fieldset>
			<p class="info">${ form.resultat }</p>
			<input type="submit" value="Valider" /> <input type="reset"
				value="Remettre à zéro" /> <br />
		</form>
	</div>
</body>
</html>