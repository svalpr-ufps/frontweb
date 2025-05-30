<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Detalles del Estudiante</title>
</head>
<body>
<h1>Detalles del Estudiante</h1>

<p><strong>Nombre:</strong> ${student.firstName} ${student.lastName}</p>
<p><strong>Email:</strong> ${student.email}</p>
<p><strong>Teléfono:</strong> ${student.phone}</p>
<p><strong>Fecha de Nacimiento:</strong> ${student.birthDate}</p>
<p><strong>Fecha de Ingreso:</strong> ${student.enrollmentDate}</p>
<p><strong>Código:</strong> ${student.studentCode}</p>
<p><strong>Estado:</strong> ${student.status}</p>

<a href="${pageContext.request.contextPath}/students">Volver</a>
</body>
</html>
