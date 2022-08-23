<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) --> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Functions --> 
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Dashboard, Welcome <c:out value = "${user.firstName}"/> </h1>
<a href ="/books/new">+Add to my shelf</a>
<table>
	<thead>
		<th>ID</th>
		<th>Title</th>
		<th>Author</th>
		<th>Posted By</th>
	</thead>
	
	<c:forEach var = "book" items="${allBooks}">
	<tr> 
		<td><a href = "/books/${book.id}">${book.id}</a></td>
		<td>${book.title}</td>
		<td>${book.author}</td>
		<td>${book.user.id}</td>
	</tr>
	</c:forEach>
</table>


<a href = "/logout">Logout</a>
</body>
</html>