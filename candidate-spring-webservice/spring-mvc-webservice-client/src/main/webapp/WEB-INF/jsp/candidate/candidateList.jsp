<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Candidate List</title></head>
<body>
<h2>Candidate List</h2>
    <table>
    	<thead>
    		<tr>
    			<th>Id</th>
    			<th>Name</th>
    			<th>Address</th>
    			<th>Email</th>
    			<th>Phone</th>
    			<th>Operations</th>
    		</tr>
    	</thead>
    	<c:forEach var="candidate" items="${candidateList}"> 
    		<c:url value="/candidate.do" var="candidateUrl">
   				<c:param name="candidateId" value="${candidate.id}" />
			</c:url>
			<c:url value="/updateCandidate.do" var="candidateUpdateUrl">
   				<c:param name="candidateId" value="${candidate.id}" />
			</c:url>
			<c:url value="/deleteCandidate.do" var="candidateDeleteUrl">
   				<c:param name="candidateId" value="${candidate.id}" />
			</c:url>
    		<tr>
    			<td><a href='<c:out value="${candidateUrl}"/>'><c:out value="${candidate.id}"/></a></td>    		
	    		<td><a href='<c:out value="${candidateUrl}"/>'><c:out value="${candidate.name}"/></a></td>	            
	            <td><c:out value="${candidate.address}"/></td>
	            <td><c:out value="${candidate.email}"/></td>
	            <td><c:out value="${candidate.phone}"/></td>
            	<td>
            		<a href='<c:out value="${candidateUrl}"/>'>View</a>
            		<a href='<c:out value="${candidateUpdateUrl}"/>'>Update</a>
            		<a href='<c:out value="${candidateDeleteUrl}"/>'>Delete</a>
            	</td>
        	</tr>
        </c:forEach>
    </table>
	<a href='<c:url value="/insertCandidate.do"/>'>Add Candidate</a>
</body>
</html>