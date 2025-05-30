<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista de Calificaciones</title>
</head>
<body>
<h2>Lista de Calificaciones</h2>
<a href="grades?action=form">Nueva Calificación</a>
<table border="1">
    <thead>
    <tr>
        <th>Estudiante</th>
        <th>Materia</th>
        <th>Periodo</th>
        <th>Nota</th>
        <th>Estado</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="grade" items="${grades}">
        <tr>
            <td>${grade.studentCode}</td>
            <td>${grade.subjectName}</td>
            <td>${grade.period}</td>
            <td>${grade.value}</td>
            <td>${grade.status}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
