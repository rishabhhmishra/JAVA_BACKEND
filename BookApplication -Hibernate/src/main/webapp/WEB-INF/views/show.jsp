<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.bookapp.model.dto.Book"%>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.18/css/jquery.dataTables.css"/>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.js"></script>
    <script>
    $(document).ready( function () {
        $('#amit').DataTable();
    } );
    </script>
<title>customer app</title>
</head>
<body>
<a href="addBook">add Book</a>
<table id="amit" border=1>
    <thead>
    <tr>
        <th>book id</th>
        <th>isbn</th>
        <th>title</th>
        <th>author</th>
        <th>price</th>
        <th>update</th>
        <th>delete</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id } </td>
            <td>${book.isbn} </td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>
            <td><a href="update?id=${book.id }">update</a></td>
            <td><a href="delete?id=${book.id}">delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>