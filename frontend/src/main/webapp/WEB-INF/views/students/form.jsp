<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Formulario Estudiante</title></head>
<body>
<h2>Formulario de Estudiante</h2>
<form action="${pageContext.request.contextPath}/students/guardar" method="post">
    <label>Código:</label>
    <input type="text" name="studentCode" value="${student.studentCode}" required/><br/>

    <label>Nombre:</label>
    <input type="text" name="firstName" value="${student.firstName}" required/><br/>

    <label>Apellido:</label>
    <input type="text" name="lastName" value="${student.lastName}" required/><br/>

    <label>Email:</label>
    <input type="email" name="email" value="${student.email}" required/><br/>

    <label>Teléfono:</label>
    <input type="text" name="phone" value="${student.phone}" /><br/>

    <label>Fecha de Nacimiento:</label>
    <input type="date" name="birthDate" value="${student.birthDate}" /><br/>

    <label>Contraseña:</label>
    <input type="password" name="password" /><br/>

    <label>Fecha de Inscripción:</label>
    <input type="date" name="enrollmentDate" value="${student.enrollmentDate}" /><br/>

    <label>ID de Rol:</label>
    <input type="text" name="roleId" value="${student.roleId}" /><br/>

    <input type="submit" value="Guardar" />
</form>
<a href="${pageContext.request.contextPath}/students">Volver</a>
</body>
</html>
