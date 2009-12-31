<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Find Organisation</title></head>
<body>
<form method="get" action='<c:url value="/organisation.do"/>'>

    <table>
        <tr>
            <td>Organisation Id:</td>
            <td><input name="organisationId" value=""/></br> OR</td>
        </tr>
        <tr>
            <td>Organisation Name: (% is wildcard)</td>
            <td><input name="organisationName" value=""/></td>
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