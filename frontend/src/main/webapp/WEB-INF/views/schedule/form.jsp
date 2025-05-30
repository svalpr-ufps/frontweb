<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Crear Horario</title></head>
<body>
<h2>Crear Nuevo Horario</h2>

<c:if test="${not empty message}">
  <p style="color:green">${message}</p>
</c:if>

<form method="post" action="${pageContext.request.contextPath}/schedules">
  <label>ID del Curso:</label><br>
  <input type="text" name="courseId" required><br>

  <label>ID del Salón:</label><br>
  <input type="text" name="roomId" required><br>

  <label>Día de la semana:</label><br>
  <select name="day">
    <option value="MONDAY">Lunes</option>
    <option value="TUESDAY">Martes</option>
    <option value="WEDNESDAY">Miércoles</option>
    <option value="THURSDAY">Jueves</option>
    <option value="FRIDAY">Viernes</option>
    <option value="SATURDAY">Sábado</option>
    <option value="SUNDAY">Domingo</option>
  </select><br>

  <label>Hora de inicio (HH:mm):</label><br>
  <input type="text" name="startTime" required><br>

  <label>Hora de fin (HH:mm):</label><br>
  <input type="text" name="endTime" required><br><br>

  <button type="submit">Crear Horario</button>
</form>
</body>
</html>
