<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<title>Add Customer</title>
	<style>
.error {
color: #EF1313;
font-style: italic;
}
.center {
  margin: auto;
  width: 30%;
  border: 3px solid black;
  padding: 10px;
  margin-top:20px;
  display:flex;
flex-direction: column;
    align-items: center;
  height:550px;
  box-shadow: 10px 5px 5px black;
}
.submit-button{
display: flex;
    justify-content: center;
    margin-top: 40px;
}
.intfield{
width: 270px;
border-radius: 11px;
height: 38px;
margin-top:5px;
}
.labfield{
font-size: 20px;
  font-weight: bold;

}
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}
.input-field-de{
display:flex;
flex-direction: column;
}
</style>

</head>
<body>
 <button type="button" style="margin-top:10px;margin-left:10px" class="btn btn-info"><a href="maker" style="text-decoration:none; color:white;"><spring:message code="userform.back" text="Default Back"/></a></button>


<!--  Register Customer Form -->

<div  class="center">

<h1>Register</h1>

<form:form style="margin-top:25px;" action="register" method="post" modelAttribute="employee">

<div class="form-div" style="display:flex;flex-direction:row; padding-left:40px;">
<div class="left" style="width:50%;margin-right:10px">

<div class="input-field-de">
<label class="labfield"for="inputEmail4"> Name:</label>
 <form:input class="intfield" path="employeeName"  maxlength="10"/> <form:errors path="employeeName" class="error"/>
</div>

<div class="input-field-de">
<label class="labfield" for="inputEmail4">Father Name:</label>
 <form:input class="intfield" path="fatherName"  maxlength="30"/> <form:errors path="fatherName" class="error"/>
</div>
<div class="input-field-de">
<label class="labfield"for="inputEmail4"> D.O.B:</label>
 <form:input class="intfield" path="dateOfBirth"  maxlength="10"/> <form:errors path="dateOfBirth" class="error"/>
</div>

<div class="input-field-de">
<label class="labfield" for="inputEmail4">Email</label>
 <form:input class="intfield" path="emailId"  maxlength="30"/> <form:errors path="emailId" class="error"/>
</div>
<div class="input-field-de">
<label class="labfield" for="inputEmail4">Mobile No:</label>
 <form:input class="intfield" path="mobileNumber"  maxlength="30"/> <form:errors path="mobileNumber" class="error"/>
</div>


<div class="submit-button" >
<button class="btn btn-primary" type="submit">Register</button>

 </div>

</form:form>
</div>
<!--  End of add customer form -->
</body>
</html>