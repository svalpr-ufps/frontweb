<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Subject Form</title>
</head>
<body>
<h2>${subject.id == null ? 'Create Subject' : 'Edit Subject'}</h2>

<form:form modelAttribute="subject" method="post"
           action="${pageContext.request.contextPath}/subjects/${subject.id == null ? 'save' : 'update/' += subject.id}">
    <table>
        <tr>
            <td>Code:</td>
            <td><form:input path="code"/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Schedule:</td>
            <td><form:input path="schedule"/></td>
        </tr>
        <tr>
            <td>Classroom:</td>
            <td><form:input path="classroom"/></td>
        </tr>
        <tr>
            <td>Capacity:</td>
            <td><form:input path="capacity" type="number"/></td>
        </tr>
        <tr>
            <td>Course ID:</td>
            <td><form:input path="courseId"/></td>
        </tr>
        <tr>
            <td>Teacher ID:</td>
            <td><form:input path="teacherId"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save"/></td>
        </tr>
    </table>
</form:form>

<a href="${pageContext.request.contextPath}/subjects">Back to list</a>
</body>
</html>
