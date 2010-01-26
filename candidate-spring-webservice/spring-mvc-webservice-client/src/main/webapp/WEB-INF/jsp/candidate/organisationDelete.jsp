<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Delete Organisation - <c:out value="${organisation.name}"/></title></head>
<body>
<h1>Delete Organisation - <c:out value="${organisation.name}"/></h1>
<span style="font-weight: bold; color: red;" >
	Are you sure you want to delete <c:out value="${organisation.name}"/>?
</span>
<form:form>
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
		<tr>
			<td><input type="submit" value="Delete Candidate" /></td>
			<td><input type="submit" name="_cancel" value="Cancel"/></td>
		</tr>        
    </table>
</form:form>
</body>
</html>