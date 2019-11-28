<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8" />
<title>Welcome</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/style.css" />
</head>
<body>
	<h1>Commande en ligne</h1>
	<h2>${message}</h2>
	<c:import url="menu.jsp" />
</body>
</html>