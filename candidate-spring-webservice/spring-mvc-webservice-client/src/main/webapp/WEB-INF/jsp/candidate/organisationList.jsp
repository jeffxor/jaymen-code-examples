<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Organisation List</title></head>
<body>
<h2>Organisation List</h2>
    <table>
    	<thead>
    		<tr>    			
    			<th>Name</th>
    			<th>Id</th>
    			<th>Address</th>
    			<th>Email</th>
    			<th>Phone</th>
    			<th>Fax</th>
    			<th>Operations</th>
    		</tr>
    	</thead>
    	<c:forEach var="organisation" items="${organisationList}"> 
    		<c:url value="/organisation.do" var="organisationUrl">
   				<c:param name="organisationId" value="${organisation.id}" />
			</c:url>
			<c:url value="/updateOrganisation.do" var="organisationUpdateUrl">
   				<c:param name="organisationId" value="${organisation.id}" />
			</c:url>
			<c:url value="/deleteOrganisation.do" var="organisationDeleteUrl">
   				<c:param name="organisationId" value="${organisation.id}" />
			</c:url>			
    		<tr>    		
	    		<td><a href='<c:out value="${organisationUrl}"/>'><c:out value="${organisation.name}"/></a></td>
	    		<td><a href='<c:out value="${organisationUrl}"/>'><c:out value="${organisation.id}"/></a></td>
	            <td><c:out value="${organisation.address}"/></td>
	            <td><c:out value="${organisation.email}"/></td>
	            <td><c:out value="${organisation.phone}"/></td>
	            <td><c:out value="${organisation.fax}"/></td>
            	<td>
            		<a href='<c:out value="${organisationUrl}"/>'>View</a>
            		<a href='<c:out value="${organisationUpdateUrl}"/>'>Update</a>
            		<a href='<c:out value="${organisationDeleteUrl}"/>'>Delete</a>
            	</td>            
        	</tr>
        </c:forEach>
    </table>
	<a href='<c:url value="/insertOrganisation.do"/>'>Add Candidate</a>
</body>
</html>