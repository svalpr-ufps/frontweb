<%@ page contentType="text/html;charset=UTF-8" %>
<a href="${pageContext.request.contextPath}/">Inicio</a>

<html>
<head><title>Dashboard</title></head>
<body>
<h2>Bienvenido, ${usuario}</h2>
<p>Rol: ${rol}</p>
<a href="${pageContext.request.contextPath}/logout">Cerrar sesión</a>
</body>
</html>
