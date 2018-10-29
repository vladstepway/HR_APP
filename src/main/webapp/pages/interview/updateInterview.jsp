<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>
        Update Interview
    </title>
</head>
<body>
<c:if test="${not empty msg}">
    ${msg}
</c:if>
<form method="POST" name="update_interview"
      action="<%=request.getContextPath()%>/interview/update">
    <input hidden="hidden" name="id" value="${interview.id}" type="text"/>
    <table>
        <tr>
            <td>
                Plan date:
            </td>
            <td>
                <input name="planDate" value="${interview.planDate}" type="text"/>
            </td>
        </tr>
        <tr>
            <td>
                Fact date:
            </td>
            <td>
                <input name="factDate" value="${interview.factDate}" type="text"/>
            </td>
        </tr>
        <tr>
            <td><form:label path="interview.vacancyId">Vacancy id:</form:label></td>
            <td>
                <form:select path="interview.vacancyId" size="1">
                    <form:options items="${vacancyIdList}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="interview.candidateId">Candidate id:</form:label></td>
            <td>

                <form:select path="interview.candidateId" size="1">
                    <form:options items="${candidateIdList}"/>
                </form:select>
        </tr>
    </table>

    <input value="Update Interview" type="submit"/>
    <br/><a href="<%=request.getContextPath()%>/allInterviews">Back</a>
</form>
</body>
</html>