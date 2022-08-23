<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOOKS BOOKS BOOKS</title>
</head>
<body>
<h1>Hi!!!</h1>
<h2>
<c:out value = "${currentBook.title}"/>
</h2>

<p>
	Description: <c:out value = "${currentBook.description}"/>
</p>

<p>
	Language: <c:out value = "${currentBook.language}"/>
</p>

<p>
	Number of Pages: <c:out value = "${currentBook.numberOfPages}"/>
</p>

</body>
</html>