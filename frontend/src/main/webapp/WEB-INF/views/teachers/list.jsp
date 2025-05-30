<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Docentes</title>
</head>
<body>
<h1>Lista de Docentes</h1>
<a href="${pageContext.request.contextPath}/teachers/create">Nuevo Docente</a>
<table border="1">
    <thead>
    <tr>
        <th>Nombre</th>
        <th>Email</th>
        <th>Especialización</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="teacher" items="${teachers}">
        <tr>
            <td>${teacher.firstName} ${teacher.lastName}</td>
            <td>${teacher.email}</td>
            <td>${teacher.specialization}</td>
            <td>
                <a href="${pageContext.request.contextPath}/teachers/view/${teacher.id}">Ver</a> |
                <a href="${pageContext.request.contextPath}/teachers/edit/${teacher.id}">Editar</a> |
                <a href="${pageContext.request.contextPath}/teachers/delete/${teacher.id}" onclick="return confirm('¿Seguro que desea eliminar este docente?')">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
