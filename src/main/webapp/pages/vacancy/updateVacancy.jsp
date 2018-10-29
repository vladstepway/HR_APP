<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update Vacancy</title>
</head>
<body>
<c:if test="${not empty msg}">
    ${msg}
</c:if>
<form method="POST" name="update_vacancy"
      action="<%=request.getContextPath()%>/vacancy/update">
    <input hidden="hidden" name="id" value="${id}" type="text"/>
    <table>
        <tr>
            <td> Position:</td>
            <td><input name="pos" value="${vacancy.position}" type="text"/></td>
        </tr>

        <tr>
            <td> Salary from :</td>
            <td><input name="sal_from" value="${vacancy.salaryFrom}" type="text"/></td>
        </tr>
        <tr>
            <td>Salary to:</td>
            <td><input name="sal_to" value="${vacancy.salaryTo}"
                       type="text"/></td>
        </tr>

        <tr>
            <td>Vacancy state:</td>
            <td><input name="vac_state" value="${vacancy.vacancyState}"
                       type="text"/></td>
        </tr>
        <tr>
            <td>Experience:</td>
            <td><input name="exp_years" value="${vacancy.experienceYearsRequire}"
                       type="text"/></td>
        </tr>
        <tr>
            <td>Creator of vacancy:</td>
            <td>
                <form:select path="vacancy.creatorId" size="1">
                    <form:options items="${developerIDList}"/>
                </form:select>

        </tr>
    </table>
    <input value="Update Vacancy" type="submit"/>
    <br/><a href="<%=request.getContextPath()%>/allVacancies">Back</a>
</form>
</body>
</html>

