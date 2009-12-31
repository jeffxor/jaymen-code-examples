<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Organisation - <c:out value="${organisation.name}"/></title></head>
<body>

    <table>
    	<tr>
    		<td colspan="2"><c:out value="${organisation.name}"/></td>
    	</tr>
        <tr>
            <td>Id:</td>
            <td><c:out value="${organisation.id}"/></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><c:out value="${organisation.address}"/></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><c:out value="${organisation.phone}"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><c:out value="${organisation.email}"/></td>
        </tr>
    </table>
</body>
</html>