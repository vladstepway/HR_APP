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
    <title>Add interview</title>
    <style>
        .error {
            color: #ff3338;
            font-style: italic;
            font-weight: bold;
        }
    </style>
</head>
<body>

<springForm:form method="POST" modelAttribute="interview"
                 action="/interview/add.do">
    <table>
        <tr>
            <td>Plan date:</td>
            <td><springForm:input path="planDate" placeholder="yyyy-MM-dd"/></td>
            <td><springForm:errors path="planDate" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Fact date:</td>
            <td><springForm:input path="factDate" placeholder="yyyy-MM-dd"/></td>
            <td><springForm:errors path="factDate" cssClass="error"/></td>
        </tr>
        <tr>
            <td><form:label path="vacancyId">Vacancy id</form:label></td>
            <td>
                <form:select path="vacancyId" size="1">
                    <form:options items="${vacancyIdList}"/>
                </form:select>
        </tr>
        <tr>
            <td><form:label path="candidateId">Candidate id:</form:label></td>
            <td>
                <form:select path="candidateId" size="1">
                    <form:options items="${candidateIdList}"/>
                </form:select>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="Add Interview"></td>
        </tr>
    </table>
    <br/><a href="<%=request.getContextPath()%>/allInterviews">Back</a>

</springForm:form>

</body>
</html>
