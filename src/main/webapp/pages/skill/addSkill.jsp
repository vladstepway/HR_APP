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
    <title>Add skill</title>
    <style>
        .error {
            color: #ff2000;
            font-style: italic;
            font-weight: bold;
        }
    </style>
</head>
<body>
<springForm:form method="POST" modelAttribute="skill"
                 action="/skill/add.do">
    <table>
        <tr>
            <td>Name:</td>
            <td><springForm:input path="name"/></td>
            <td><springForm:errors path="name" cssClass="error"/></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="Add Skill"></td>
        </tr>
    </table>
    <br/><a href="<%=request.getContextPath()%>/allSkills">Back</a>

</springForm:form>

</body>
</html>
