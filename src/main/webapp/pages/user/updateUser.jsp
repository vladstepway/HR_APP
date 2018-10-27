<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<html>
<title>Update User</title>
<body>
<c:if test="${not empty msg}">
    ${msg}
</c:if>
<h3>Update User</h3>
<form method="POST" name="update_user"
      action="<%=request.getContextPath()%>/user/update/">
    <input hidden="hidden" name="id" value="${user.id}" type="text"/>
    First Name:
    <td><springForm:input path="user.firstName"/></td>
    <td><springForm:errors path="user.firstName" cssClass="error"/></td>
    <br/> Last Name:
    <td><springForm:input path="user.surname"/></td>
    <td><springForm:errors path="user.surname" cssClass="error"/></td>
    <br/> Email:
    <td><springForm:input path="user.email"/></td>
    <td><springForm:errors path="user.email" cssClass="error"/></td>
    <br/> Password:
    <td><springForm:input path="user.password"/></td>
    <td><springForm:errors path="user.password" cssClass="error"/></td>
    <br/>
    <td>User Role:</td>
    <td><springForm:select path="user.userRole">
        <springForm:option value="${user.userRole}" label="Select user role"/>
        <springForm:option value="manager" label="manager"/>
        <springForm:option value="developer" label="developer"/>
        <springForm:option value="interviewer" label="interviewer"/>
        <springForm:option value="admin" label="admin"/>
    </springForm:select></td>
    <td><springForm:errors path="user.userRole" cssClass="error"/></td>
    <br/>
    <br/> <input value="Update User" type="submit"/>
    <br/><a href="<%=request.getContextPath()%>/allUsers">Back</a>
</form>
</body>
</html>