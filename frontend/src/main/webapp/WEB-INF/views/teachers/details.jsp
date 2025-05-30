<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Detalles del Profesor</title>
</head>
<body>
<h2>Detalles del Profesor</h2>

<p><strong>ID:</strong> ${teacher.id}</p>
<p><strong>Código:</strong> ${teacher.teacherCode}</p>
<p><strong>Nombre:</strong> ${teacher.firstName} ${teacher.lastName}</p>
<p><strong>Email:</strong> ${teacher.email}</p>
<p><strong>Especialización:</strong> ${teacher.specialization}</p>
<p><strong>Fecha de Registro:</strong> ${teacher.createdAt}</p>

<h3>Materias Asignadas</h3>
<c:choose>
    <c:when test="${not empty teacher.subjects}">
        <ul>
            <c:forEach items="${teacher.subjects}" var="s">
                <li><strong>${s.code}</strong> - ${s.name}</li>
            </c:forEach>
        </ul>
    </c:when>
    <c:otherwise>
        <p>No tiene materias asignadas.</p>
    </c:otherwise>
</c:choose>

<a href="/teachers">Volver al listado</a>

</body>
</html>
