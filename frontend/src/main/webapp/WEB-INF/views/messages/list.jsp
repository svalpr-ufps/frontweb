<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Mensajes Recibidos</title>
</head>
<body>
<h2>Mensajes Recibidos</h2>
<a href="messages?action=form">Nuevo Mensaje</a>
<table border="1">
    <thead>
    <tr>
        <th>Remitente</th>
        <th>Contenido</th>
        <th>Fecha de Envío</th>
        <th>Leído</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="msg" items="${messages}">
        <tr>
            <td>${msg.senderName}</td>
            <td>${msg.content}</td>
            <td>${msg.sentAt}</td>
            <td><c:choose>
                <c:when test="${msg.read}">Sí</c:when>
                <c:otherwise>No</c:otherwise>
            </c:choose></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
