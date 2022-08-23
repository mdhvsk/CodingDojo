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
<h1>New Ninja</h1>

<form:form action = "/ninjas/createNinja" method = "post" modelAttribute = "ninja"> 
	<p> 
		<form:errors path = "first_name"></form:errors>
		<form:label path = "first_name">First Name: </form:label>
		<form:input type = "text" path = "first_name"/> 
	</p>
	<p> 
		<form:errors path = "last_name"></form:errors>
		<form:label path = "last_name">Last Name: </form:label>
		<form:input type = "text" path = "last_name"/> 
	</p>
	<p> 
		<form:errors path = "age"></form:errors>
		<form:label path = "age">Age: </form:label>
		<form:input type = "number" path = "age"/> 
	</p>
	<p>
		<form:label path = "dojo"> Select Dojo: </form:label>
		<form:select path = "dojo">
			<c:forEach var = "dojos" items = "${allDojos}"> 
			<form:option value = "${dojos.id}">${dojos.name}</form:option>
			</c:forEach>
			
		</form:select>
	</p>
	
	<input type = "submit" value = "Create">
	
	

</form:form>

</body>
</html>