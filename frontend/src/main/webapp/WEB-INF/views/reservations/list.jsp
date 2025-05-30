<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Reservas</title>
</head>
<body>
<h2>Listado de Reservas</h2>
<a href="/reservations/form">Nueva Reserva</a>
<table border="1">
    <thead>
    <tr>
        <th>Tipo</th>
        <th>Inicio</th>
        <th>Fin</th>
        <th>Propósito</th>
        <th>Estado</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="r" items="${reservations}">
        <tr>
            <td>${r.resourceType}</td>
            <td>${r.startDate}</td>
            <td>${r.endDate}</td>
            <td>${r.purpose}</td>
            <td>${r.status}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
