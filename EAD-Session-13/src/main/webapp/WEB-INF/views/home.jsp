<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Home</title>
</head>
<body>
   	<h1>Title : ${title}</h1>	
	<h2>Message : ${message}</h2>	
	
	<c:if test="${pageContext.request.userPrincipal.name != null}">
	    <h2>Welcome : ${pageContext.request.userPrincipal.name}</h2>
	</c:if>
	<a href = "../Logout">Logout</a>
</body>
</html>