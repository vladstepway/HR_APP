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
    <title>Add Vacancy</title>
    <style>
        .error {
            color: #ff3338;
            font-style: italic;
            font-weight: bold;
        }
    </style>
</head>
<body>

<springForm:form method="POST" modelAttribute="vacancy"
                 action="/vacancy/add.do">
    <table>
        <tr>
            <td>Position:</td>
            <td><springForm:input path="position"/></td>
            <td><springForm:errors path="position" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Salary from:</td>
            <td><springForm:input path="salaryFrom"/></td>
            <td><springForm:errors path="salaryFrom" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Salary to:</td>
            <td><springForm:input path="salaryTo"/></td>
            <td><springForm:errors path="salaryTo" cssClass="error"/></td>
        </tr>
        <tr>
            <td>User Role:</td>
            <td><springForm:select path="vacancyState">
                <springForm:option value="OPENED" label="OPENED"/>
                <springForm:option value="CLOSED" label="CLOSED"/>
            </springForm:select></td>

        </tr>
        <tr>
            <td>Experience:</td>
            <td><springForm:input path="experienceYearsRequire"/></td>
            <td><springForm:errors path="experienceYearsRequire" cssClass="error"/></td>
        </tr>
        <tr>
            <td><form:label path="creatorId">Developer ID:</form:label></td>
            <td>

                <form:select path="creatorId" size="1">
                    <form:options items="${developerIDList}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="Add Interview"></td>
        </tr>
    </table>

    <br/><a href="<%=request.getContextPath()%>/allVacancies">Back</a>
</springForm:form>

</body>
</html>
