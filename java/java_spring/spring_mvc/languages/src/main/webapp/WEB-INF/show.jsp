<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Language Details</h1>
<table>
	<tr> 
		<td>  Name: </td>
		<td> <c:out value = "${language.name}"/>
	</tr>
	<tr> 
		<td> Creator: </td>
		<td> <c:out value = "${language.creator}"/>
	</tr>
	<tr> 
		<td> Version : </td>
		<td> <c:out value = "${language.version}"/>
	</tr>
</table>
</body>
</html>