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

	<h1> Create a Course </h1>
	
	<form:form action = "/create" method = "post" modelAttribute = "course"> 
		<div class = "mb-3">
		<form:label path="name" class = "form-label">Name: </form:label>
	        <form:errors path="name" class = "text-danger" />
	        <form:input path="name"/>
		</div>
			
		<div class = "mb-3"> 
			<form:label path="dayOfWeek">Day of Week: </form:label>
	        <form:errors path="dayOfWeek" class = "text-danger" />
	        <form:input path="dayOfWeek"/>
		</div>
		<div class = "mb-3"> 
			<form:label path="price">Drop-in Price: </form:label>
	        <form:errors path="price" class = "text-danger" />
	        <form:input type = "number" step = "0.01" path="price"/>
		</div>
		<div class = "mb-3"> 
			<form:label path="description">Description: </form:label>
	        <form:errors path="description" class = "text-danger" />
	        <form:input path="description"/>
		</div>
		<a href = "/dashboard">Cancel</a>
		<input type = "submit" value = "Create">
		
	</form:form>

</body>
</html>