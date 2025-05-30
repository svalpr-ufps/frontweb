<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nuevo Mensaje</title>
</head>
<body>
<h2>Enviar Nuevo Mensaje</h2>
<form action="messages" method="post">
    <label>ID del Destinatario: <input type="text" name="receiverId" required /></label><br/>
    <label>Contenido del Mensaje:<br/>
        <textarea name="content" rows="5" cols="50" maxlength="1000" required></textarea>
    </label><br/>
    <input type="submit" value="Enviar" />
</form>
<a href="messages">Volver a la lista</a>
</body>
</html>
