<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista de Materias</title>
</head>
<body>
<h1>Materias</h1>
<a href="${pageContext.request.contextPath}/subjects/form">Nueva Materia</a>
<table border="1">
    <tr>
        <th>Código</th>
        <th>Nombre</th>
        <th>Horario</th>
        <th>Aula</th>
        <th>Capacidad</th>
        <th>Créditos</th>
        <th>Curso</th>
        <th>Profesor</th>
        <th>Acciones</th>
    </tr>
    <c:forEach var="subject" items="${subjects}">
        <tr>
            <td>${subject.code}</td>
            <td>${subject.name}</td>
            <td>${subject.schedule}</td>
            <td>${subject.classroom}</td>
            <td>${subject.capacity}</td>
            <td>${subject.credits}</td>
            <td>${subject.course.name}</td>
            <td>${subject.teacher.firstName} ${subject.teacher.lastName}</td>
            <td>
                <a href="${pageContext.request.contextPath}/subjects/view/${subject.id}">Ver</a> |
                <a href="${pageContext.request.contextPath}/subjects/form?id=${subject.id}">Editar</a> |
                <a href="${pageContext.request.contextPath}/subjects/delete/${subject.id}" onclick="return confirm('¿Estás seguro?')">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
