<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<title>Update candidate</title>
<body>
<c:if test="${not empty msg}">
    ${msg}
</c:if>
<form method="POST" name="update_candidate"
      action="<%=request.getContextPath()%>/candidate/update/">
    <input hidden="hidden" name="id" value="${candidate.id}" type="text"/>

    <table>
        <tr>
            <td> First Name:</td>
            <td><springForm:input path="candidate.name"/></td>
            <td><springForm:errors path="candidate.name" cssClass="error"/></td>
        </tr>
        <tr>
            <td> Last Name:</td>
            <td><springForm:input path="candidate.surname"/></td>
            <td><springForm:errors path="candidate.surname" cssClass="error"/></td>
        </tr>
        <tr>
            <td>BirthDay</td>
            <td><springForm:input path="candidate.birthday"/></td>
            <td><springForm:errors path="candidate.birthday" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Expected Salary:</td>
            <td><springForm:input path="candidate.expected_salary"/></td>
            <td><springForm:errors path="candidate.expected_salary" cssClass="error"/></td>
        </tr>
        <tr>
            <td>State:</td>
            <td><form:select path="candidate.candidate_state" size="1">
                <form:options items="${candidateStateList}"/>
            </form:select>
            </td>
        </tr>

    </table>
    <input value="Update Candidate" type="submit"/>
    <br/><a href="<%=request.getContextPath()%>//allCandidates">Back</a>
</form>
</body>
</html>