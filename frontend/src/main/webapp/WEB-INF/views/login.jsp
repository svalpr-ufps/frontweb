<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="<c:url value='/css/styles.css' />" />
</head>
<body>
<div class="container">
    <h2>Iniciar Sesión</h2>
    <form method="post" action="/login">
        <div class="form-group">
            <label for="usuario">Usuario:</label>
            <input type="text" name="usuario" id="usuario" required />
        </div>
        <div class="form-group">
            <label for="clave">Contraseña:</label>
            <input type="password" name="clave" id="clave" required />
        </div>
        <button type="submit" class="login-button">Ingresar</button>
    </form>
    <c:if test="${not empty error}">
        <p class="error-message">${error}</p>
    </c:if>
</div>
</body>
</html>
