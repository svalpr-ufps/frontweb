<%@ page isErrorPage="true" %>
<html>
<head><title>Error</title></head>
<body>
<h1>Ha ocurrido un error inesperado</h1>
<p><strong>Mensaje:</strong> ${requestScope["javax.servlet.error.message"]}</p>
<p><strong>Estado:</strong> ${requestScope["javax.servlet.error.status_code"]}</p>
<p><strong>Ruta:</strong> ${requestScope["javax.servlet.error.request_uri"]}</p>
<a href="${pageContext.request.contextPath}/">Volver al inicio</a>
</body>
</html>
