<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Listado de Profesores</title>
</head>
<body>
<h2>Listado de Profesores</h2>
<a href="/teachers/create">Crear Nuevo</a>
<table border="1">
    <thead>
    <tr>
        <th>Código</th>
        <th>Nombre</th>
        <th>Email</th>
        <th>Especialización</th>
        <th>Fecha de Creación</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${teachers}" var="t">
        <tr>
            <td>${t.teacherCode}</td>
            <td>${t.firstName} ${t.lastName}</td>
            <td>${t.email}</td>
            <td>${t.specialization}</td>
            <td>${t.createdAt}</td>
            <td>
                <a href="/teachers/view/${t.id}">Ver</a> |
                <a href="/teachers/edit/${t.id}">Editar</a> |
                <a href="/teachers/delete/${t.id}">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
