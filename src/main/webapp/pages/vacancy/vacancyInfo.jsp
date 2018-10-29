<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<title>Vacancy Info</title>
<body>

<table border="1" cellpadding="5" cellspacing="5">
    <tr>
        <td>ID</td>
        <td>Position</td>
        <td>Salary from</td>
        <td>Salary to</td>
        <td>State</td>
        <td>Experience</td>
        <td>Developer id</td>
    </tr>
    <tr>
        <td>${vacancy.id}</td>
        <td>${vacancy.position}</td>
        <td>${vacancy.salaryFrom}</td>
        <td>${vacancy.salaryTo}</td>
        <td>${vacancy.vacancyState}</td>
        <td>${vacancy.experienceYearsRequire}</td>
        <td>${vacancy.creatorId}</td>
    </tr>
</table>
<a href="<%=request.getContextPath()%>/allVacancies">Back</a>
</body>
</html>