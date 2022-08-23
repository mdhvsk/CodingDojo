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
<h1>${dojo.name} Location Table</h1>

<table>
	<thead> 
		<th>First Name</th>
		<th>Last Name</th>
		<th>Age</th>
	</thead>
	<c:forEach var = "ninja" items = "${allNinjas}">
		<tr> 
		<td>${ninja.first_name}</td>
		<td>${ninja.last_name}</td>
		<td>${ninja.age}</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>