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
<h1>Expense Details</h1>
<table>
	<tr> 
		<td> Expense Name: </td>
		<td> <c:out value = "${expense.name}"/>
	</tr>
	<tr> 
		<td> Vendor: </td>
		<td> <c:out value = "${expense.vendor}"/>
	</tr>
	<tr> 
		<td> Price : </td>
		<td> <c:out value = "${expense.price}"/>
	</tr>
	<tr> 
		<td> Created at: </td>
		<td> <c:out value = "${expense.createdAt}"/>
	</tr>
	<tr> 
		<td> Updated at: </td>
		<td> <c:out value = "${expense.updatedAt}"/>
	</tr>
</table>
</body>
</html>