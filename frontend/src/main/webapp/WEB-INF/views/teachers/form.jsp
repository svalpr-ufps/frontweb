<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Formulario de Profesor</title>
</head>
<body>
<h2>Formulario de Profesor</h2>
<form action="${teacherId == null ? '/teachers/save' : '/teachers/update/' + teacherId}" method="post">
    <label>Nombre:</label>
    <input type="text" name="firstName" value="${teacher.firstName}" required/><br/>

    <label>Apellido:</label>
    <input type="text" name="lastName" value="${teacher.lastName}" required/><br/>

    <label>Email:</label>
    <input type="email" name="email" value="${teacher.email}" required/><br/>

    <c:if test="${teacherId == null}">
        <label>Contraseña:</label>
        <input type="password" name="password" required/><br/>
    </c:if>

    <label>Especialización:</label>
    <input type="text" name="specialization" value="${teacher.specialization}" required/><br/>

    <button type="submit">Guardar</button>
</form>
</body>
</html>
