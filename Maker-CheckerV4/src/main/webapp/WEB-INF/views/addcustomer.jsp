<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Customer</title>
</head>
<body>
<form:form action="addcustomer" method="post" modelAttribute="customer">
	Enter CustomerCode : <form:input path="customerCode"  required="required"/> <br>
	Enter Name : <form:input path="customerName" required="required"/> <br>
	Enter Address 1 : <form:input path="customerAddress1" required="required"/> <br>
	Enter Address 2: <form:input path="customerAddress2" required="required"/> <br>
	Enter Pincode : <form:input path="customerPinCode" required="required"/> <br>
	Enter Email : <form:input path="email" required="required"/> <br>
	Enter Contact Number : <form:input path="contact" required="required"/> <br>
	Enter Contact Person : <form:input path="primaryContactPerson" required="required"/> <br>
	<input type="submit">
</form:form>
</body>
</html>