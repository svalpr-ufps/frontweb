<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" href="<c:url value='/css/styles.css' />" />
</head>
<body>
<div class="dashboard-container">
    <h2>Bienvenido, <c:out value="${usuario}" />!</h2>
    <p>Tu rol es: <c:out value="${rol}" /></p>
    <a href="/logout" class="logout-button">Cerrar sesión</a>
</div>
</body>
</html>
