<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Registrar Calificación</title></head>
<body>
<h2>Registrar Calificación</h2>
<form action="${pageContext.request.contextPath}/grades" method="post">
    <label>Código Estudiante:</label><input type="text" name="studentCode" required><br/>
    <label>Código Asignatura:</label><input type="text" name="subjectCode" required><br/>
    <label>Código Curso:</label><input type="text" name="courseCode"><br/>
    <label>Nombre Curso:</label><input type="text" name="courseName"><br/>
    <label>Periodo:</label><input type="text" name="period"><br/>
    <label>Valor:</label><input type="number" step="0.1" name="value" required><br/>
    <label>Comentarios:</label><input type="text" name="comments"><br/>
    <input type="submit" value="Guardar">
</form>
</body>
</html>
