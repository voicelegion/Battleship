<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: roman.pipchenko
  Date: 10/4/2017
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Battleship placement</title>
</head>
<body>
<h1>Hello, ${playerManager.player.userName}, </h1>
<h2 style="color:aqua">Please set your ships</h2>
<form method="post" action="<c:url value ="/placement"/>">
    <table>
        <c:forEach var="rows" items="1,2,3,4,5,6,7,8,9,10">
            <tr>
                <c:forEach var="cols" items="A,B,C,D,E,F,G,H,I,J">
                    <td>
                        <c:set var="addr" value="${cols}${rows}"/>
                        <input type="checkbox" name="cell" value="${addr}" <c:if test="${playerManager.player.myField.content[addr] eq 'SHIP'}">checked</c:if>>
                    </td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
    <button>Ready</button>
    <c:if test="${errorNotEnough}">Not enough ships</c:if>
    <c:if test="${errorTooMany}">Too many ships</c:if>
</form>
</body>
</html>
