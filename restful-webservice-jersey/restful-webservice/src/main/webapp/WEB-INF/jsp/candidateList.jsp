<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<title>Candidate List</title>
	
	<script type="text/javascript" src="${ctx}/js/jquery-1.4.1.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery.autocomplete.js"></script>
	<link rel="stylesheet" href="${ctx}/css/main.css" type="text/css"/>
	<link rel="stylesheet" href="${ctx}/css/jquery.autocomplete.css" type="text/css"/>
	
    <script type="text/javascript">
    $(document).ready(function() {			       
    	$.ajax({
        	type: 'GET',
        	url: 'http://localhost:8080/restful-webservice/resources/candidateService/json',
        	dataType: 'json',
        	success: function(json, textStatus, XMLHttpRequest) {    		    			
    			$.each(json['candidate'], function($entryIndex, $entry) {
    				var $html = '<tr class="candidate" id>';
    				$html += '<td>'+ $entry['id'] +'</td>';
    				$html += '<td>'+ $entry['name'] +'</td>';
    				$html += '<td>'+ $entry['address'] +'</td>';
    				$html += '<td>'+ $entry['phone'] +'</td>';
    				$html += '<td>'+ $entry['email'] +'</td>';
    				$html += '</td>';
    				$('#candidates').append($html);
    			});  				
        	},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
        		alert('Error has occured!\n XMLHttpRequest: ' + XMLHttpRequest
                		+ '\ntextStatus:' + textStatus
                		+ '\nerrorThrown:' + errorThrown);
        		}
        	});

    	$('#candidateName').autocomplete('http://localhost:8080/restful-webservice/resources/candidateService/name', {
    		width: 260,
    		minChars: 3,    		
    		parse: function(json){
    			var parsed = [];
	    		$.each(json['candidate'], function($entryIndex, $entry) {    				
	    			parsed[parsed.length] = {
	    				data: $entry,
						value: $entry['name'],
						result: $entry['name']};	    					    		
	    		});    	
	    		return parsed;
    		},
    		formatItem : function(row, index, length, value, term){
        		return '<li>'+ value + '</li>';
    		}
    	});		    
    });
    </script>	
</head>
<body>
<h2>Candidate List</h2>
<div id="content"> 
	
	<form autocomplete="off"> 
		<p> 
			<label>Candidate Name:</label> 
			<input type="text" id="candidateName" /> 
			<input type="button" value="Get Candidate" /> 
		</p>
		
	</form>	
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
    	<tbody class="candidates" id="candidates">
    	</tbody>
    </table>
   
 </div>	
</body>
</html>