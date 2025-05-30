<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="co.edu.frontend.model.GradeResponse" %>
<%@ page import="java.util.List" %>
<html>
<head><title>Listado de Calificaciones</title></head>
<body>
<h2>Listado de Calificaciones</h2>
<a href="grades?action=form">Registrar Nueva</a><br/><br/>
<form method="get" action="grades">
    <label>Filtrar por ID Estudiante:</label>
    <input type="text" name="studentId" required>
    <input type="submit" value="Buscar">
</form>
<br/>
<table border="1">
    <tr>
        <th>Asignatura</th>
        <th>Curso</th>
        <th>Periodo</th>
        <th>Nota</th>
        <th>Estado</th>
    </tr>
    <%
        List<GradeResponse> grades = (List<GradeResponse>) request.getAttribute("grades");
        if (grades != null) {
            for (GradeResponse g : grades) {
    %>
    <tr>
        <td><%= g.getSubjectName() %></td>
        <td><%= g.getPeriod() %></td>
        <td><%= g.getValue() %></td>
        <td><%= g.getStatus() %></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
