<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Nueva Reserva</title>
</head>
<body>
<h2>Crear Reserva</h2>
<form action="/reservations/save" method="post">

    <label for="startDate">Fecha/Hora Inicio:</label>
    <input type="datetime-local" name="startDate" required /><br/>

    <label for="endDate">Fecha/Hora Fin:</label>
    <input type="datetime-local" name="endDate" required /><br/>

    <label for="subjectId">ID de la Materia (opcional):</label>
    <input type="text" name="subjectId" /><br/>

    <label for="purpose">Propósito:</label>
    <input type="text" name="purpose" required /><br/>

    <button type="submit">Guardar</button>
</form>
</body>
</html>
