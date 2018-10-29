<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<title>Feedback Info</title>
<body>

<table border="1" cellpadding="5" cellspacing="5">
    <tr>
        <td>Interview id</td>
        <td>Interviewer id</td>
        <td>Feedback state</td>
        <td>Reason</td>
    </tr>
    <tr>
        <td>${interviewFeedback.interviewId}</td>
        <td>${interviewFeedback.interviewerId}</td>
        <td>${interviewFeedback.feedbackState}</td>
        <td>${interviewFeedback.reason}</td>
    </tr>
</table>
<a href="<%=request.getContextPath()%>/allInterviewFeedbacks">Back</a>
</body>
</html>