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
<h1>Change your Entry</h1>

<form:form action = "/editBook" method = "put" modelAttribute = "book"> 
    <input type="hidden" name="_method" value="put">

		<p> 
			<form:label path="title">Title: </form:label>
	        <form:errors path="title"/>
	        <form:input path="title" value = "${currentBook.title}"/>
		</p>
		<p> 
			<form:label path="author">Author: </form:label>
	        <form:errors path="author"/>
	        <form:input path="author" value = "${currentBook.author}"/>
		</p>
		<p> 
			<form:label path="thoughts">Thoughts: </form:label>
	        <form:errors path="thoughts"/>
	        <form:input path="thoughts" value = "${currentBook.thoughts}"/>
		</p>
		<input type = "submit" value = "Create">
		
	</form:form>
</body>
</html>