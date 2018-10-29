<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="springForm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add feedback</title>
    <style>
        .error {
            color: #ff1c21;
            font-style: italic;
            font-weight: bold;
        }
    </style>
</head>
<body>

<springForm:form method="POST" modelAttribute="interviewFeedback"
                 action="/interviewFeedback/add.do">
    <table>
        <tr>
            <td><form:label path="interviewId">Interview id</form:label>:</td>
            <td>

                <form:select path="interviewId" size="1">
                    <form:options items="${interviewIdList}"/>
                </form:select>
        </tr>
        <tr>
            <td><form:label path="interviewerId">Interviewer id</form:label>:</td>
            <td>

                <form:select path="interviewerId" size="1">
                    <form:options items="${interviewerIdList}"/>
                </form:select>
        </tr>
        <tr>
            <td><form:label path="feedbackState">Feedback state</form:label>:</td>
            <td>

                <form:select path="feedbackState" size="1">
                    <form:options items="${feedbackStatesList}"/>
                </form:select>
        </tr>
        <tr>
            <td>Reason:</td>
            <td><springForm:input path="reason"/></td>
            <td><springForm:errors path="reason" cssClass="error"/></td>
        </tr>

        <tr>
            <td colspan="3"><input type="submit" value="Add interviewFeedback"></td>
        </tr>
    </table>
    <br/><a href="<%=request.getContextPath()%>/allInterviewFeedbacks">Back</a>
</springForm:form>

</body>
</html>
