<%@ page language="Java" contentType="text/jsp; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
<meta charset="UTF-8" />
<title>Welcome</title>
</head>
<body>
	<h1>Welcome ${name}</h1>
	<c:out value="${name}" />
</body>
</html>