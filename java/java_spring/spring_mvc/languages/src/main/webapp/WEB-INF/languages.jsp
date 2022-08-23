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
<h1> Languages</h1>
<table>
	<thead> 
		<tr> 
		<th>Name</th>
		<th>Creator</th>
		<th>Version</th>
		<th>Action</th>
		<th>Action</th>
		</tr>
		<c:forEach var="listItem" items = "${languages}">
			<tr> 
				<td><a href = "/languages/show/${listItem.id}" method = "get"><c:out value = "${listItem.name}"/></a></td>
				<td><c:out value = "${listItem.creator}"/></td>
				<td><c:out value = "${listItem.version}"/></td>
				<td><a href = "/languages/editPage/${listItem.id}">Edit</a></td>
				<td><form action="/languages/delete/${listItem.id}" method="post">
    				<input type="hidden" name="_method" value="delete">
    				<input type="submit" value="Delete">
					</form>
				</td>
				
			</tr>
		</c:forEach>
	</thead>
</table>

<form:form action = "/languages/create" method = "post" modelAttribute = "language">
	<p>
	<form:label path="name">Language Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
	</p>
	<p>
	<form:label path="creator">Creator: </form:label>
        <form:errors path="creator"/>
        <form:input path="creator"/>
	</p>
	<p>
	<form:label path="name">Language Name</form:label>
        <form:errors path="version"/>
        <form:input type = "number" step = "0.01" path="version"/>
	</p>
	<input type="submit" value="Submit"/>
	

</form:form>

</body>
</html>