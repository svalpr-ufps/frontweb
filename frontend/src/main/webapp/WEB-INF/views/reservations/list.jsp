<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Lista de Reservas</title></head>
<body>
<h2>Reservas</h2>
<a href="${pageContext.request.contextPath}/reservations/form">Nueva Reserva</a>
<table border="1">
    <thead>
    <tr>
        <th>ID</th><th>Fecha Inicio</th><th>Fecha Fin</th><th>Tipo de Sala</th><th>Estado</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="r" items="${reservations}">
        <tr>
            <td>${r.id}</td>
            <td>${r.startDate}</td>
            <td>${r.endDate}</td>
            <td>${r.roomType}</td>
            <td>${r.status}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
