<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Search Candidate</title></head>
<body>
<h1>Search Candidate</h1>
<form:form>
    <table>
        <tr>
            <td>Candidate Name: (% is wildcard)</td>
            <td><input name="candidateName" value=""/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
            <td><input type="submit" name="_cancel" value="Cancel"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>