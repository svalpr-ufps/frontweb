<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Formulario de Materia</title>
</head>
<body>
<h1>Formulario de Materia</h1>
<form action="${pageContext.request.contextPath}/subjects/save" method="post">
    <input type="hidden" name="id" value="${subject.id}" />

    Código: <input type="text" name="code" value="${subject.code}" /><br/>
    Nombre: <input type="text" name="name" value="${subject.name}" /><br/>
    Horario: <input type="text" name="schedule" value="${subject.schedule}" /><br/>
    Aula: <input type="text" name="classroom" value="${subject.classroom}" /><br/>
    Capacidad: <input type="number" name="capacity" value="${subject.capacity}" /><br/>
    Créditos: <input type="number" name="credits" value="${subject.credits}" /><br/>

    Curso (UUID): <input type="text" name="courseId" value="${subject.courseId}" /><br/>
    Profesor (UUID): <input type="text" name="teacherId" value="${subject.teacherId}" /><br/>

    Recursos (IDs separados por coma):
    <input type="text" name="resourceIds" value="${subject.resourceIds}" /><br/>

    <input type="submit" value="Guardar" />
</form>
<a href="${pageContext.request.contextPath}/subjects">Volver a la lista</a>
</body>
</html>
