<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<head>
    <title>Candidate Info</title>

</head>

<body>
<table border="1" cellpadding="5" cellspacing="5">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Surname</td>
        <td>Birthday</td>
        <td>Expected salary</td>
        <td>State</td>
    </tr>
    <tr>
        <td>${candidate.id}</td>
        <td>${candidate.name}</td>
        <td>${candidate.surname}</td>
        <td>${candidate.birthday}</td>
        <td>${candidate.expected_salary}</td>
        <td>${candidate.candidate_state}</td>
    </tr>
</table>

<a href="<%=request.getContextPath()%>/allCandidates">Back</a>
</body>
</html>