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
<form:form action = "/languages/edit/${language.id}" method = "post" modelAttribute = "language">
    <input type="hidden" name="_method" value="put">
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
	<form:label path="name">Version: </form:label>
        <form:errors path="version"/>
        <form:input type = "number" step = "0.01" path="version"/>
	</p>
	<input type="submit" value="Submit"/>
	

</form:form>
</body>
</html>