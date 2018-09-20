<%@page import="com.metacube.training.service.SearchService"%>
<%@page import="com.metacube.training.service.AdminService"%>
<%@page import="com.metacube.training.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      <table border="1px">
           <tr>
             <td>Employee Code</td>
               <td>First Name</td>
               <td>Middle Name</td>
               <td>Last Name</td>
               <td>DOB</td>
               <td>Email</td>
               <td>Skype Id</td>
               <td>Primary Contact no.</td>
               <td>Secondary Contact No.</td>
           </tr>
           
               <c:forEach items="${searchResult}" var="search">
                    <tr>
                        <td>${search.code}</td>
                        <td>${search.firstName}</td>
                        <td>${search.middleName}</td>
                        <td>${search.lastName}</td>
                        <td>${search.dob}</td>
                        <td>${search.emailId}</td>
                        <td>${search.skypeId}</td>
                        <td>${search.primaryContactNo}</td>
                        <td>${search.secondaryContactNo}</td>
                        <td><a href="updateEmployee?id=${search.code}">Update</a></td>
                        <td><a onclick="return confirm('Are you sure you want to delete?')" href="deleteEmployee?id=${search.code}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
         </table>
</body>
</html>