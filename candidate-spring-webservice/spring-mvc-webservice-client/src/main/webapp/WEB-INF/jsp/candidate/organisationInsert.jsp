<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Insert Organisation - <c:out value="${organisation.name}"/></title></head>
<body>
<h1>Insert Organisation - <c:out value="${organisation.name}" /></h1>
<form:form commandName="organisation">
	<table>
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
			<td>Fax Number:</td>
			<td><form:input path="fax" /></td>
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