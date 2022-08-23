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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body>
<h1>Namaste, <c:out value = "${user.firstName}"/> </h1>
<a href = "/logout">Logout</a>
<p>Course Schedule </p>
<table class = "table table-striped">
	<thead>
		<th> Class Name </th>
		<th> Instructor </th>
		<th> Weekday </th>
		<th> Price </th>
	</thead>
	<c:forEach var = "course" items = "${allClasses}">
		<tr> 
			<td> <a href = "/course/${course.id}">${course.name} </a>
			<c:if test = "${user.firstName == course.instructor}">
			<p> <a href = "/classes/${course.id}/edit">Edit</a></p>
			</c:if>
				</td>
			</td>
			<td> ${course.instructor} </td>
			<td> ${course.dayOfWeek} </td>
			<td> $${course.price} </td>
			
		</tr>
	</c:forEach>
	
</table>

<a href = "classes/new"> +new course</a>
</body>
</html>