<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<a href="<%=request.getContextPath()%>/">Menu</a>
<form action="/interview/add" method="get">
    <p>
        <button>Add</button>
    </p>
</form>
<c:if test="${not empty msg}">
    ${msg}
</c:if>
<c:choose>
    <c:when test="${interview != null}">
        <h3>List of Interviews</h3>
        <table cellpadding="5" cellspacing="5" border="1">
            <thead>
            <tr>
                <th>ID</th>
                <th>Plan date</th>
                <th>Fact Date</th>
                <th>Vacancy id</th>
                <th>Candidate id</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="interview" items="${interview}">
                <tr>
                    <td>${interview.id}</td>
                    <td>${interview.planDate}</td>
                    <td>${interview.factDate}</td>
                    <td>${interview.vacancyId}</td>
                    <td>${interview.candidateId}</td>
                    <td>
                        <a href="<%=request.getContextPath()%>/interview/update/${interview.id}">Update</a>
                        &nbsp;
                        <a href="<%=request.getContextPath()%>/interview/delete/${interview.id}"
                           onclick="return confirm('Do you really want to delete?')">Delete</a>
                        &nbsp;
                        <a href="<%=request.getContextPath()%>/interview/${interview.id}">View</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:when>
    <c:otherwise>
        No Interview found in the DB!
    </c:otherwise>
</c:choose>
</body>
</html>