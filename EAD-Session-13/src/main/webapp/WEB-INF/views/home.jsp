<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Home</title>
</head>
<body>
	<c:choose>
		<c:when test="${pageContext.request.userPrincipal.name != null}">
			<h1>${title}</h1>
			<h2>${message}</h2>
			<h2>Welcome : ${pageContext.request.userPrincipal.name}</h2>
			<a href="../Logout">Logout</a>
		</c:when>
		<c:otherwise>
			<c:redirect url="/login"></c:redirect>
		</c:otherwise>

	</c:choose>
</body>
</html>

