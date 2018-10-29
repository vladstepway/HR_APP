<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update Feedback</title>
</head>
<body>
<c:if test="${not empty msg}">
    ${msg}
</c:if>
<form method="POST" name="update_interviewFeedback"
      action="<%=request.getContextPath()%>/interviewFeedback/update">

    <table>
        <tr>
            <td><form:label path="interviewFeedback.interviewId">Interview id:</form:label></td>
            <td>

                <form:select path="interviewFeedback.interviewId" size="1">
                    <form:options items="${interviewIdList}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="interviewFeedback.interviewerId">Interviewer id</form:label></td>
            <td>

                <form:select path="interviewFeedback.interviewerId" size="1">
                    <form:options items="${interviewerIdList}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="interviewFeedback.feedbackState">Feedback State</form:label></td>
            <td>
                <form:select path="interviewFeedback.feedbackState" size="1">
                    <form:options items="${feedbackStatesList}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Reason:</td>
            <td><springForm:input path="interviewFeedback.reason"/></td>
            <td><springForm:errors path="interviewFeedback.reason" cssClass="error"/></td>
        </tr>
    </table>
    <input value="Update InterviewFeedback" type="submit"/>
    <br/><a href="<%=request.getContextPath()%>/allInterviewFeedbacks">Back</a>
</form>
</body>
</html>