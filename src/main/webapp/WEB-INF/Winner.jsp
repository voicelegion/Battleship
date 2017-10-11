<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: roman.pipchenko
  Date: 10/11/2017
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BattleShip</title>
</head>
<body>
<h1>${playerManager.player.userName}, You won the game.</h1>
<form method="post" action="<c:url value="/index.jsp"/>">
    <button type=submit value="Start again">Start a new game!</button>
</form>
</body>
</html>
