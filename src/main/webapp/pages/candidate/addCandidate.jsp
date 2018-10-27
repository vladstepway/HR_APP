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
    <title>
        Add Candidate
    </title>
    <style>
        .error {
            color: #ff0000;
            font-style: italic;
            font-weight: bold;
        }
    </style>
</head>
<body>
<%--<c:if test="${not empty msg}">--%>
<%--${msg}--%>
<%--</c:if>--%>
<springForm:form method="POST" modelAttribute="candidate"
                 action="/candidate/add.do">
    <table>
        <tr>
            <td>Name:</td>
            <td><springForm:input path="name"/></td>
            <td><springForm:errors path="name" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Surname:</td>
            <td><springForm:input path="surname"/></td>
            <td><springForm:errors path="surname" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Birthday:</td>
            <td><springForm:input path="birthday"/></td>
            <td><springForm:errors path="birthday" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Expected salary:</td>
            <td><springForm:input path="expected_salary"/></td>
            <td><springForm:errors path="expected_salary" cssClass="error"/></td>
        </tr>
        <tr>
            <td>
                <form:label path="candidate_state">State:</form:label>
            </td>
            <td>
                <form:select path="candidate_state" size="1">
                    <form:options items="${candidateStateList}"/>
                </form:select>
            </td>

        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="Add Candidate"></td>
        </tr>
    </table>

</springForm:form>

</body>
</html>
