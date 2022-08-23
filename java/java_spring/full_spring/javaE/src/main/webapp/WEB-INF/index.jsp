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
<div class = "container">
	<h1>Course Platform Instructors</h1>
	<div class = "main d-flex">
		<div class = "register col-9">
		<h2>Register</h2>
		<form:form action ="/register" method = "post" modelAttribute="newUser">
			<div class = "form-group">
				<form:label path = "firstName">First Name: </form:label>
				<form:input type = "text" path = "firstName"/>
				<form:errors class = "text-danger" path = "firstName"/>
			</div>
			<div class = "form-group">
				<form:label path = "lastName">Last Name: </form:label>
				<form:input type = "text" path = "lastName"/>
				<form:errors class = "text-danger" path = "lastName"/>
			</div>
			<div class = "form-group">
				<form:label path = "email">Email: </form:label>
				<form:input type = "text" path = "email"/>
				<form:errors class = "text-danger" path = "email"/>
			</div>
			<div class = "form-group">
				<form:label path = "password">Password: </form:label>
				<form:input type = "text" path = "password"/>
				<form:errors class = "text-danger" path = "password"/>
			</div>
			<div class = "form-group">
				<form:label path = "confirmPassword">Confirm Password : </form:label>
				<form:input type = "text" path = "confirmPassword"/>
				<form:errors class = "text-danger" path = "confirmPassword"/>
			</div>
			<input type = "submit" value="Register">
		</form:form>
		
		</div>
		
		<div class = "register col-9">
		
		<form:form action = "/login" method = "post" modelAttribute = "newLogin">
		<h2>Login</h2>
			<div class = "form-group">
				<form:label path = "email">Email: </form:label>
				<form:input type = "text" path = "email"/>
				<form:errors class = "text-danger" path = "email"/>
			</div>
			<div class = "form-group">
				<form:label path = "password">Password: </form:label>
				<form:input type = "text" path = "password"/>
				<form:errors class = "text-danger" path = "password"/>
			</div>
			<input type = "submit" value="Register">
			
		</form:form>
		</div>
	</div>

</div>
</body>
</html>