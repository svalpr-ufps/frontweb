<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Enviar Mensaje</title></head>
<body>
<h2>Enviar Nuevo Mensaje</h2>
<form action="${pageContext.request.contextPath}/messages" method="post">
    <label for="receiverId">ID del destinatario:</label>
    <input type="text" name="receiverId" required /><br/>

    <label for="content">Contenido:</label>
    <textarea name="content" required></textarea><br/>

    <button type="submit">Enviar</button>
</form>
</body>
</html>
