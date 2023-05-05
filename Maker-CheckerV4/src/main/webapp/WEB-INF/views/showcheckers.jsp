<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Maker Checker App</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
                <link rel="stylesheet" type="text/css"
                  href="https://cdn.datatables.net/1.10.18/css/jquery.dataTables.css" />
                <script type="text/javascript" src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.js"></script>
                <script>        $(document).ready(function () { $('#myTable').DataTable(); });        </script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
     integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <style>
    *{
    font-size:12px;
    }
    </style>
  </head>
  <body>

<div class="mx-3 my-3">
</div>
    <table id="myTable" border="1">
          <thead>
            <tr>
              <th>Customer code</th>
              <th>Customer Name</th>
              <th>Customer Address 1</th>
              <th>Customer Address 2</th>
              <th>Customer Pin Code</th>
              <th>Email Address</th>
              <th>Contact Number</th>
              <th>Contact Person</th>
              <th>Record Status</th>
              <th>Create Date</th>
              <th>Created By</th>
              <th>Modified Date</th>
              <th>Modified By</th>
              <th>Authorized Date</th>
              <th>Authorized By</th>
            </tr>
          </thead>
          <tbody>
<c:forEach items="${customerMastList}" var="customer">
        <tr>
                      <td><c:out value="${customer.customerCode}"/></td>
                      <td><c:out value="${customer.customerName}"/></td>
                      <td><c:out value="${customer.customerAddress1}"/></td>
                      <td><c:out value="${customer.customerAddress2}"/></td>
                      <td><c:out value="${customer.customerPinCode}"/></td>
                      <td><c:out value="${customer.email}"/></td>
                      <td><c:out value="${customer.contact}"/></td>
                      <td><c:out value="${customer.primaryContactPerson}"/></td>
                      <td><c:out value="${customer.recordStatus}"/></td>
                      <td><c:out value="${customer.createDate}"/></td>
                      <td><c:out value="${customer.createdBy}"/></td>
                      <td><c:out value="${customer.modifiedDate}"/></td>
                      <td><c:out value="${customer.modifiedBy}"/></td>
                      <td><c:out value="${customer.authorizedDate}"/></td>
                      <td><c:out value="${customer.authorizedBy}"/></td>
                      <th>
                       <div style="display: flex;flex-direction: row;">

                      <button type="button" class="btn btn-danger"><a href="reject?code=<c:out value="${customer.customerCode}"/>" style="text-decoration:none; color:white;">Reject</a></button>


                       <c:if test="${customer.recordStatus!='MR'}">
                        <button type="button" class="btn btn-success"><a href="approve?code=<c:out value="${customer.customerCode}"/>" style="text-decoration:none; color:white;">Approve</a></button>
                       </c:if>
 </div>
                      </th>
        </tr>
        </c:forEach>
        </tbody>
          </table>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<c:url var="logout" value="/logout"></c:url>
<form:form action="${logout }" method ="post">
<input type="submit" value="logout">
</form:form>
</body>
</html>





