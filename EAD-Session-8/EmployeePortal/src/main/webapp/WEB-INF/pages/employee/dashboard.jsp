<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1>Welcome ${username}</h1>
	<table>
		<tr>
			<td><a href="editProfile?username=${username}">Edit Employee</a></td>
		</tr>

		<tr>
			<td><a href="searchEmployee">Search Employee</a></td>
		</tr>

		<tr>
			<td><a href="logout">Logout</a></td>
		</tr>
	</table>
</body>
</html>