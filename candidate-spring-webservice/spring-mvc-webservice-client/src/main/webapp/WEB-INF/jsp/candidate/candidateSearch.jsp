<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Find Candidate</title></head>
<body>
<form method="get" action='<c:url value="/candidate.do"/>'>

    <table>
        <tr>
            <td>Candidate Id:</td>
            <td><input name="candidateId" value=""/></br> OR</td>
        </tr>
        <tr>
            <td>Candidate Name: (% is wildcard)</td>
            <td><input name="candidateName" value=""/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>