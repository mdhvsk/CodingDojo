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
	<h1>Hello there...</h1>
	<p>Name: <c:out value ="${name}"/> </p>
	<p>itemName: <c:out value ="${itemName}"/> </p>
	<p>price: <c:out value ="${price}"/> </p>
	<p>description: <c:out value ="${description}"/> </p>
	<p>Vendor: <c:out value ="${vendor}"/> </p>
</body>
</html>