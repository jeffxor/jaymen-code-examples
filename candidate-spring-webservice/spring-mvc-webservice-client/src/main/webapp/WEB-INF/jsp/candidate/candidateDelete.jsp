<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Delete Candidate - <c:out value="${candidate.name}"/></title></head>
<body>
<h1>Delete Candidate - <c:out value="${candidate.name}"/></h1>
<span style="font-weight: bold; color: red;" >
	Are you sure you want to delete <c:out value="${candidate.name}"/>?
</span>
<form:form commandName="candidate">
    <table>
    	<form:hidden path="id" />
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
		<tr>
			<td><input type="submit" value="Delete Candidate" /></td>
			<td><input type="submit" name="_cancel" value="Cancel"/></td>
		</tr>        
    </table>
</form:form>
</body>
</html>