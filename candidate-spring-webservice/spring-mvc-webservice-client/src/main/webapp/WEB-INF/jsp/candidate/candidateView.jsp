<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Candidate - <c:out value="${candidate.name}"/></title></head>
<body>

    <table>
    	<tr>
    		<td colspan="2"><c:out value="${candidate.name}"/></td>
    	</tr>
        <tr>
            <td>Id:</td>
            <td><c:out value="${candidate.id}"/></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><c:out value="${candidate.address}"/></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><c:out value="${candidate.phone}"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><c:out value="${candidate.email}"/></td>
        </tr>
    </table>

</body>
</html>