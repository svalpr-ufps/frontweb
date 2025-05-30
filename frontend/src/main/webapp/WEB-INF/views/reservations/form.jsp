<html>
<head><title>Crear Reserva</title></head>
<body>
<h2>Formulario Reserva</h2>
<form action="${pageContext.request.contextPath}/reservations/save" method="post">
    Fecha Inicio: <input type="datetime-local" name="startDate" required/><br/>
    Fecha Fin: <input type="datetime-local" name="endDate" required/><br/>
    Tipo de Sala:
    <select name="roomType">
        <option value="CLASSROOM">Aula</option>
        <option value="LABORATORY">Laboratorio</option>
        <option value="AUDITORIUM">Auditorio</option>
    </select><br/>
    <button type="submit">Guardar</button>
</form>
<a href="${pageContext.request.contextPath}/reservations">Volver a lista</a>
</body>
</html>
