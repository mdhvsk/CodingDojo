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
<h3>Here's your Okimuji</h3>
 <p>
 In <c:out value = "${years}"/> years you will live
 in <c:out value = "${city}"/> with <c:out value = "${person}"/>
 as your roommate, selling <c:out value = "${activity}"/> for a living.
 Next time you see a <c:out value = "${living_thing}"/>, you will have good luck.
  Also <c:out value = "${message}"/>. 
  </p>
  
  <a href = "/omikuji">Go back</a>
</body>
</html>