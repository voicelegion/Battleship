<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: roman.pipchenko
  Date: 10/2/2017
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Welcome to battleship</h1>
    <form method="post" action="<c:url value="/registration"/>">
        <label>Enter your name: </label>
        <input type="text" name="userName">
        <button>Start</button>
    </form>
</body>
</html>
