<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<head>
    <title>User Info</title>

</head>

<body>

    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Surname</td>
            <td>Email</td>
            <td>Role</td>
        </tr>
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.surname}</td>
            <td>${user.email}</td>
            <td>${user.userRole}</td>
        </tr>
    </table>
    <a href="<%=request.getContextPath()%>/allUsers">Back</a>

</body>
</html>