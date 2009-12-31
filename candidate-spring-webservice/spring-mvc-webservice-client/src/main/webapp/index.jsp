<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Simple Candidate MVC Application</h2>
<ul>
	<li><a href='<c:url value="/candidate/seach.do"/>'>Find a Candidate</a></li>
	<li><a href='<c:url value="/candidates.do"/>'>View All Candidates</a></li>
	<li><a href='<c:url value="/organisation/search.do"/>'>Find an Organisation</a></li>
	<li><a href='<c:url value="/organisations.do"/>'>View All Organisations</a></li>
</ul>
</body>
</html>
