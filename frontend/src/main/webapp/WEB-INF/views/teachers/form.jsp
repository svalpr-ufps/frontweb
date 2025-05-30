<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>${teacherId == null ? 'Crear Docente' : 'Editar Docente'}</title>
</head>
<body>
<h1>${teacherId == null ? 'Nuevo Docente' : 'Editar Docente'}</h1>

<form:form method="post"
           modelAttribute="teacher"
           action="${teacherId == null ?
                   pageContext.request.contextPath + '/teachers/save' :
                   pageContext.request.contextPath + '/teachers/update/' + teacherId}">

    <label>Nombre:</label>
    <form:input path="firstName" /><br/>

    <label>Apellido:</label>
    <form:input path="lastName" /><br/>

    <label>Email:</label>
    <form:input path="email" type="email" /><br/>

    <label>Especialización:</label>
    <form:input path="specialization" /><br/>

    <button type="submit">Guardar</button>
</form:form>

<a href="${pageContext.request.contextPath}/teachers">Volver</a>
</body>
</html>
