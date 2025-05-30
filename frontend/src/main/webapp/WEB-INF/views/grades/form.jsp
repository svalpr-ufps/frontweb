<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar Calificación</title>
</head>
<body>
<h2>Registrar Nueva Calificación</h2>
<form action="grades" method="post">
    <label>Código Estudiante: <input type="text" name="studentCode" required /></label><br/>
    <label>Código Materia: <input type="text" name="subjectCode" required /></label><br/>
    <label>Código Curso: <input type="text" name="courseCode" required /></label><br/>
    <label>Nombre del Curso: <input type="text" name="courseName" required /></label><br/>
    <label>Periodo: <input type="text" name="period" required /></label><br/>
    <label>Nota: <input type="number" step="0.1" min="0" max="5" name="value" required /></label><br/>
    <label>Comentarios: <textarea name="comments"></textarea></label><br/>
    <input type="submit" value="Registrar" />
</form>
<a href="grades">Volver a la lista</a>
</body>
</html>
