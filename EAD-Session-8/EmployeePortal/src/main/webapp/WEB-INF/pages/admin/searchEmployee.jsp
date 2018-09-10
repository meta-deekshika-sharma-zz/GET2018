<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="searchEmployee" method="post">
		<table>
			<tr>
		     	<td>
		     	    <select name = "select">
		     	        <option value="name">By Name</option>
		     	        <option value="project">By Project</option>
		     	        <option value="skill">By Skill</option>
		     	        <option value="experience">By Total Experience</option>
		     	    </select>
		     	</td>
			</tr>
			<tr>
			    <td><input type="text" name="search"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Search" /></td>
			</tr>
		</table>	
	</form>
</body>
</html>