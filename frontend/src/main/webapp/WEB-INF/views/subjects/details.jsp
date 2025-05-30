<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Detalle de Materia</title>
</head>
<body>
<h1>Detalle de la Materia</h1>
<p><strong>Código:</strong> ${subject.code}</p>
<p><strong>Nombre:</strong> ${subject.name}</p>
<p><strong>Horario:</strong> ${subject.schedule}</p>
<p><strong>Aula:</strong> ${subject.classroom}</p>
<p><strong>Capacidad:</strong> ${subject.capacity}</p>
<p><strong>Créditos:</strong> ${subject.credits}</p>

<h2>Curso</h2>
<p>${subject.course.code} - ${subject.course.name} (${subject.course.credits} créditos)</p>

<h2>Profesor</h2>
<p>${subject.teacher.teacherCode} - ${subject.teacher.firstName} ${subject.teacher.lastName}</p>

<h2>Recursos Académicos</h2>
<ul>
    <c:forEach var="resource" items="${subject.resources}">
        <li>${resource.name} (${resource.type})</li>
    </c:forEach>
</ul>

<a href="${pageContext.request.contextPath}/subjects">Volver a la lista</a>
</body>
</html>
