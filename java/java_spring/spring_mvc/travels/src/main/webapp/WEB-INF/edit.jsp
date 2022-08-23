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

<h1>New Expense</h1>
<form:form action="/expenses/${expense.id}" method="post" modelAttribute="expense">
    <input type="hidden" name="_method" value="put">

    <p>
        <form:label path="name">Expense Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="vendor">Vendor</form:label>
        <form:errors path="vendor"/>
        <form:textarea path="vendor"/>
    </p>
    <p>
        <form:label path="price">Price</form:label>
        <form:errors path="price"/>
        <form:input type = "number" step = "0.01" path="price"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>     
        <form:input path="description"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>    

</body>
</html>