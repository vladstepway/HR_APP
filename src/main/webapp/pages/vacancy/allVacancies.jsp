<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<title></title>
<body>
<a href="<%=request.getContextPath()%>/">Menu</a>
<form action="/vacancy/add" method="get">
    <p>
        <button>Add</button>
    </p>
</form>
<c:if test="${not empty msg}">
    ${msg}
</c:if>
<c:choose>
    <c:when test="${vacancy != null}">
        <h3>List of Vacancies</h3>
        <table cellpadding="5" cellspacing="5" border="1">
            <thead>
            <tr>
                <th>ID</th>
                <th>Position</th>
                <th>Salary from</th>
                <th>Salary to</th>
                <th>Vacancy state</th>
                <th>Experience</th>
                <th>Developer(id)</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="vacancy" items="${vacancy}">
                <tr>
                    <td>${vacancy.id}</td>
                    <td>${vacancy.position}</td>
                    <td>${vacancy.salaryFrom}</td>
                    <td>${vacancy.salaryTo}</td>
                    <td>${vacancy.vacancyState}</td>
                    <td>${vacancy.experienceYearsRequire}</td>
                    <td>${vacancy.creatorId}</td>

                    <td><a href="<%=request.getContextPath()%>/vacancy/update/${vacancy.id}">Update</a>
                        &nbsp;
                        <a href="<%=request.getContextPath()%>/vacancy/delete/${vacancy.id}"
                           onclick="return confirm('Do you really want to delete?')">Delete</a>
                        &nbsp;
                        <a href="<%=request.getContextPath()%>/vacancy/${vacancy.id}">View</a>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        No Vacancy found in the DB!
    </c:otherwise>
</c:choose>
</body>
</html>