<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<title>Interview Info</title>
<body>

<table border="1" cellpadding="5" cellspacing="5">
    <tr>
        <td>ID</td>
        <td>Plan date</td>
        <td>Fact date</td>
        <td>Vacancy id</td>
        <td>Candidate id</td>
    </tr>
    <tr>
        <td>${interview.id}</td>
        <td>${interview.plan_date}</td>
        <td>${interview.fact_date}</td>
        <td>${interview.vacancy_id}</td>
        <td>${interview.candidate_id}</td>
    </tr>
</table>

<a href="<%=request.getContextPath()%>/allInterviews">Back</a>

</body>
</html>