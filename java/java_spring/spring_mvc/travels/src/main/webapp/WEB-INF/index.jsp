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
<h1>Save Travels</h1>
<table>
	<thead> 
		<tr>
			<th>Expense</th>
			<th>Vendor</th>
			<th>Amount</th>
			<th>Action</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody> 
		<c:forEach var="listItem" items = "${expenses}">
			<tr> 
				<td><a href = "/expenses/${listItem.id}/show" method = "get"><c:out value = "${listItem.name}"/></a></td>
				<td><c:out value = "${listItem.vendor}"/></td>
				<td><c:out value = "${listItem.price}"/></td>
				<td><a href = "/expenses/${listItem.id}/edit">Edit</a></td>
				<td><form action="/expenses/${listItem.id}/delete" method="post">
    				<input type="hidden" name="_method" value="delete">
    				<input type="submit" value="Delete">
					</form>
				</td>
				
			</tr>
		</c:forEach>
		
	</tbody>
	
	
</table>


  
<h1>New Expense</h1>
<form:form action="/expenses/create" method="post" modelAttribute="expense">
    <p>
        <form:label path="name">Expense Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="vendor">Vendor</form:label>
        <form:errors path="vendor"/>
        <form:textarea path="vendor"/>
    </p>
    <p>
        <form:label path="price">Price</form:label>
        <form:errors path="price"/>
        <form:input type = "number" step = "0.01" path="price"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>     
        <form:input path="description"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>    



</body>
</html>