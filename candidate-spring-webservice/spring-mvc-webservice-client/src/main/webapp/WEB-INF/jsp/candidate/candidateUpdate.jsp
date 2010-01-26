<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Update Candidate - <c:out value="${candidate.name}" /></title>
</head>
<body>
<h1>Update Candidate - <c:out value="${candidate.name}" /></h1>
<form:form commandName="candidate">
	<table>
		<form:hidden path="id" />
		<form:errors path="*" cssClass="errorBox" />
		<tr>
			<td>Name:</td>
			<td><form:input path="name" /></td>
		</tr>

		<tr>
			<td>Address:</td>
			<td><form:input path="address" /></td>
		</tr>
		<tr>
			<td>Phone:</td>
			<td><form:input path="phone" /></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Save Changes" /></td>
			<td><input type="submit" name="_cancel" value="Cancel"/></td>
		</tr>
	</table>
</form:form>
</body>
</html>