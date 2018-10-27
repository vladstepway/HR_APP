<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Menu</title>
    <style type="text/css">
        button {
            width: 150px;
            height: 75px;
            font-size: 20px;
            font-weight: bold;

        }
    </style>
</head>
<body>
<div align="center">
    <table>
        <tr>
            <td>
                <form action="/allUsers" method="get">
                    <p>
                        <button>User</button>
                    </p>
                </form>
            </td>
            <td>
                <form action="/allCandidates" method="get">
                    <p>
                        <button>Candidate</button>
                    </p>
                </form>
            </td>
            <td>
                <form action="/allInterviews" method="get">
                    <p>
                        <button>Interview</button>
                    </p>
                </form>
            </td>
            <td>
                <form action="/allSkills" method="get">
                    <p>
                        <button>Skill</button>
                    </p>
                </form>
            </td>
            <td>
                <form action="/allInterviewFeedbacks" method="get">
                    <p>
                        <button>Feedback</button>
                    </p>
                </form>
            </td>
            <td>
                <form action="/allVacancies" method="get">
                    <p>
                        <button>Vacancy</button>
                    </p>
                </form>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
