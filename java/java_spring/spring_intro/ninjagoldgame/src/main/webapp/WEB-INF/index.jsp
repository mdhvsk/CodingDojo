<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Your Gold: <c:out value ="${count}"/> </h3>
<div id = "options">
	<div class = "findGold">
		<h4>Farm</h4>
		<p>(earns 10-20 gold)</p>
		<form action = "/findGold" method = "post">
			<input type = "hidden" name = "selection" value = "farm">
			<input type = "submit" value = "Find Gold!">
		</form>
	</div>
	
	<div class = "findGold">
		<h4>Cave</h4>
		<p>(earns 10-20 gold)</p>
		<form action = "/findGold" method = "post">
				<input type = "hidden" name = "selection" value = "cave">
				<input type = "submit" value = "Find Gold!">
		</form>
	</div>
	
	<div class = "findGold">
		<h4>House</h4>
		<p>(earns 10-20 gold)</p>
		<form action = "/findGold" method = "post">
			<input type = "hidden" name = "selection" value = "house">
			<input type = "submit" value = "Find Gold!">
		</form>	
	</div>
	<div class = "findGold">
		<h4>Quest</h4>
		<p>(earns/takes 0-50 gold)</p>
		<form action = "/findGold" method = "post">
			<input type = "hidden" name = "selection" value = "quest">
			<input type = "submit" value = "Find Gold!">
		</form>	
	</div>
</div>
</body>
</html>