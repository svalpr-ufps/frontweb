<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Listado de Estudiantes</title></head>
<body>
<h2>Estudiantes</h2>
<a href="${pageContext.request.contextPath}/students/nuevo">Crear Nuevo</a>
<table border="1">
    <thead>
    <tr>
        <th>Código</th>
        <th>Nombre</th>
        <th>Email</th>
        <th>Teléfono</th>
        <th>Estado</th>
        <th>Rol</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${lista}">
        <tr>
            <td>${student.studentCode}</td>
            <td>${student.firstName} ${student.lastName}</td>
            <td>${student.email}</td>
            <td>${student.phone}</td>
            <td>${student.status}</td>
            <td>${student.roleName}</td>
            <td>
                <a href="${pageContext.request.contextPath}/students/ver/${student.studentCode}">Ver</a> |
                <a href="${pageContext.request.contextPath}/students/editar/${student.studentCode}">Editar</a> |
                <a href="${pageContext.request.contextPath}/students/eliminar/${student.studentCode}">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
