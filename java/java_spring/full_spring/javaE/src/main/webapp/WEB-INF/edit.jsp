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
<h1><c:out value = "${currentCourse.name}"/></h1>

<form:form action = "/edit/${currentCourse.id}" method = "post" modelAttribute = "currentCourse"> 
    <input type="hidden" name="_method" value="put">

		<p> 
			<form:label path="name">Name: </form:label>
	        <form:input path="name" value = "${currentCourse.name}" />
	        <form:errors path="name"/>
	        
		</p>
		<p> 
			<form:label path="dayOfWeek">Day of Week: </form:label>
	        <form:input path="dayOfWeek" value = "${currentCourse.dayOfWeek}" />
	        <form:errors path="dayOfWeek"/>
	        
		</p>
		<p> 
			<form:label path="price">Drop-in Price: </form:label>
	        <form:input type = "number" step = "0.01" path="price" value = "${currentCourse.price}"/>
	        <form:errors path="price"/>
	        
		</p>
		<p> 
			<form:label path="description">Description: </form:label>
	        <form:input path="description" value = "${currentCourse.description}"/>
	        <form:errors path="description"/>
	        
		</p>
		
		<input type = "submit" value = "Update">
	</form:form>
		
		
		<form action = "/delete/${currentCourse.id}" method = "post">
			<input type = "hidden" name = "_method" value = "delete"/>
			<button class = "btn btn-outline-danger">Delete</button>
		</form>
		<a href = "/dashboard">Cancel</a>
		
	
</body>
</html>