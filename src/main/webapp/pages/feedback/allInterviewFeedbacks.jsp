<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<a href="<%=request.getContextPath()%>/">Menu</a>
<form action="/interviewFeedback/add" method="get">
    <p>
        <button>Add</button>
    </p>
</form>
<c:if test="${not empty msg}">
    ${msg}
</c:if>
<c:choose>
    <c:when test="${interviewFeedback != null}">
        <table cellpadding="3" cellspacing="5" border="1">
            <thead>
            <tr>
                <th>Interview ID</th>
                <th>Interviewer ID</th>
                <th>Feedback state</th>
                <th>Reason</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="interviewFeedback" items="${interviewFeedback}">
                <tr>
                    <td>${interviewFeedback.interviewId}</td>
                    <td>${interviewFeedback.interviewerId}</td>
                    <td>${interviewFeedback.feedbackState}</td>
                    <td>${interviewFeedback.reason}</td>
                    <td>
                        <a href="<%=request.getContextPath()%>/interviewFeedback/update/${interviewFeedback.interviewId}">Update</a>
                        &nbsp;
                        <a href="<%=request.getContextPath()%>/interviewFeedback/delete/${interviewFeedback.interviewId}"
                           onclick="return confirm('Do you really want to delete?')">Delete</a>
                        &nbsp;
                        <a href="<%=request.getContextPath()%>/interviewFeedback/${interviewFeedback.interviewId}">View</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        No feedback found in the DB!
    </c:otherwise>
</c:choose>
</body>
</html>