<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Mensajes Recibidos</title></head>
<body>
<h2>Mensajes Recibidos</h2>
<a href="${pageContext.request.contextPath}/messages?action=form">Nuevo Mensaje</a>
<table border="1">
    <thead>
    <tr>
        <th>De</th>
        <th>Contenido</th>
        <th>Fecha</th>
        <th>Leído</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${messages}" var="msg">
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
