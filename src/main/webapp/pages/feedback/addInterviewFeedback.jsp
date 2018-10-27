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
    <title>Ad feedback</title>
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
            <td><form:label path="interview_id">Interview id</form:label>:</td>
            <td>

                <form:select path="interview_id" size="1">
                    <form:options items="${interviewIdList}"/>
                </form:select>
        </tr>
        <tr>
            <td><form:label path="interviewer_id">Interviewer id</form:label>:</td>
            <td>

                <form:select path="interviewer_id" size="1">
                    <form:options items="${interviewerIdList}"/>
                </form:select>
        </tr>
        <tr>
            <td><form:label path="feedback_state">Feedback state</form:label>:</td>
            <td>

                <form:select path="feedback_state" size="1">
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

</springForm:form>

</body>
</html>
