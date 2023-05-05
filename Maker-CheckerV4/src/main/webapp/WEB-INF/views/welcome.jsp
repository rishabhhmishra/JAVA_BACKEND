<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOC TYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <style>
    *{
               margin: 0;
               padding: 0;
               box-sizing: border-box;

           }
           .main{
               width: 40vw;
               height: 60vh;
               margin-left:29%;
               margin-top: 9%;
               display: flex;
               align-items: center;
               justify-content: space-around;
           }
           button{
               width: 10rem;
               height: 3rem;
               background-color: #757575;
               border: none;
               border-radius:20%;
           }
           a{
               text-decoration: none;
               color: black;
               font-size: 2rem;
           }
           button:hover{
              background-color:#e0f7fa;
           }
</style>
</head>
<body>
    <div class="main">
        <button><a href="maker">Maker</a></button>
        <button><a href="checker">Checker</a></button>
    </div>
</body>
</html>
