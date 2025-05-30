<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<a href="${pageContext.request.contextPath}/">Inicio</a>

<html>
<head>
    <title>Inicio - Kampus</title>
</head>
<body>
<h1>Bienvenido a Kampus</h1>

<c:choose>
    <c:when test="${not empty nombre}">
        <p>Hola, <strong>${nombre}</strong> (${rol})</p>
        <p><a href="dashboard">Ir al Panel</a> | <a href="logout">Cerrar sesión</a></p>
    </c:when>
    <c:otherwise>
        <p><a href="login">Iniciar Sesión</a></p>
    </c:otherwise>
</c:choose>
</body>
</html>
