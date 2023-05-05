<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Book</title>
</head>
<body>
<form:form action="addbook" method="post" modelAttribute="book">
	<form:hidden path="id"/>
	Enter Isbn : <form:input path="isbn" readonly="true"/> <br>
	Enter Title : <form:input path="title" readonly="true"/> <br>
	Enter Author : <form:input path="author" readonly="true"/> <br>
	Enter Price : <form:input path="price"/> <br>
	<input type="submit">
</form:form>
</body>
</html>