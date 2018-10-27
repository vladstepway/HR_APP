<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<title></title>
<body>
<a href="<%=request.getContextPath()%>/">Menu</a>
<form action="/user/add" method="get">
    <p>
        <button>Add</button>
    </p>
</form>
<c:if test="${not empty msg}">
    ${msg}
</c:if>
<c:choose>
    <c:when test="${user != null}">
        <h3>List of Users</h3>
        <table cellpadding="5" cellspacing="5" border="1">
            <thead>
            <tr>
                <th>
                    <a href="<%=request.getContextPath()%>/users/sorting/${order}/sortBy/id">ID</a>
                </th>
                <th>
                    <a href="<%=request.getContextPath()%>/users/sorting/${order}/sortBy/name">Name</a>
                </th>
                <th>
                    <a href="<%=request.getContextPath()%>/users/sorting/${order}/sortBy/surname">Surname</a>
                </th>
                <th>Email</th>
                <th>Password</th>
                <th>UserRole</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${user}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.firstName}</td>
                    <td>${user.surname}</td>
                    <td>${user.email}</td>
                    <td>${user.password}</td>
                    <td>${user.userRole}</td>

                    <td><a href="<%=request.getContextPath()%>/user/update/${user.id}">Update</a>
                        &nbsp;
                        <a href="<%=request.getContextPath()%>/user/delete/${user.id}"
                           onclick="return confirm('Do you really want to delete?')">Delete</a>
                        &nbsp;
                        <a href="<%=request.getContextPath()%>/user/${user.id}">View</a>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        No User found in the DB!
    </c:otherwise>
</c:choose>
</body>
</html>