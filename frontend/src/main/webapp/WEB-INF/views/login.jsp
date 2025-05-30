<%@ page contentType="text/html;charset=UTF-8" %>
<a href="${pageContext.request.contextPath}/">Inicio</a>

<html>
<head><title>Login</title></head>
<body>
<h2>Iniciar Sesión</h2>
<form method="post" action="${pageContext.request.contextPath}/login">
    <label>Correo:</label>
    <input type="text" name="usuario" required><br/>
    <label>Clave:</label>
    <input type="password" name="clave" required><br/>
    <input type="submit" value="Ingresar">
</form>
<br/>
<c:if test="${not empty error}">
    <p style="color:rgba(19,207,212,0.93)">${error}</p>
</c:if>
</body>
</html>
