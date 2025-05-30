<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Subjects</title>
</head>
<body>
<h2>Subjects</h2>
<a href="${pageContext.request.contextPath}/subjects/create">Create New Subject</a>
<table border="1">
    <thead>
    <tr>
        <th>Code</th>
        <th>Name</th>
        <th>Schedule</th>
        <th>Classroom</th>
        <th>Capacity</th>
        <th>Course</th>
        <th>Teacher</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="subject" items="${subjects}">
        <tr>
            <td>${subject.code}</td>
            <td>${subject.name}</td>
            <td>${subject.schedule}</td>
            <td>${subject.classroom}</td>
            <td>${subject.capacity}</td>
            <td>${subject.course.name}</td>
            <td>${subject.teacher.name}</td>
            <td>
                <a href="${pageContext.request.contextPath}/subjects/details/${subject.id}">View</a>
                <a href="${pageContext.request.contextPath}/subjects/edit/${subject.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
