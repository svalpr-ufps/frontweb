<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Detalles del Docente</title>
</head>
<body>
<h1>Detalles del Docente</h1>

<p><strong>Nombre:</strong> ${teacher.firstName} ${teacher.lastName}</p>
<p><strong>Email:</strong> ${teacher.email}</p>
<p><strong>Especialización:</strong> ${teacher.specialization}</p>
<p><strong>Código:</strong> ${teacher.teacherCode}</p>

<!-- Asignar asignatura -->
<form action="${pageContext.request.contextPath}/teachers/${teacher.id}/assign-subject" method="post">
    <label>Asignar asignatura (UUID):</label>
    <input type="text" name="subjectId" placeholder="UUID de la asignatura" required />
    <button type="submit">Asignar</button>
</form>

<c:if test="${not empty teacher.subjects}">
    <h3>Asignaturas Asignadas:</h3>
    <ul>
        <c:forEach var="subject" items="${teacher.subjects}">
            <li>${subject}</li>
        </c:forEach>
    </ul>
</c:if>

<a href="${pageContext.request.contextPath}/teachers">Volver</a>
</body>
</html>
