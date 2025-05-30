<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulario Estudiante</title>
</head>
<body>
<h1>${studentCode == null ? 'Nuevo Estudiante' : 'Editar Estudiante'}</h1>

<form:form method="post"
           modelAttribute="student"
           action="${studentCode == null ?
                   pageContext.request.contextPath + '/students/guardar' :
                   pageContext.request.contextPath + '/students/actualizar/' + studentCode}">

    <label>Nombre:</label>
    <form:input path="firstName" /><br/>

    <label>Apellido:</label>
    <form:input path="lastName" /><br/>

    <label>Email:</label>
    <form:input path="email" /><br/>

    <label>Teléfono:</label>
    <form:input path="phone" /><br/>

    <label>Fecha de Nacimiento:</label>
    <form:input path="birthDate" type="date" /><br/>

    <label>Fecha de Ingreso:</label>
    <form:input path="enrollmentDate" type="date" /><br/>

    <label>Código de Estudiante:</label>
    <form:input path="studentCode" /><br/>

    <button type="submit">Guardar</button>
</form:form>

<a href="${pageContext.request.contextPath}/students">Volver</a>
</body>
</html>
