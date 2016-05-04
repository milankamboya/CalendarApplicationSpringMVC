<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/jspf/header.jspf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/main.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Your Events </title>
</head>
<body>

<sf:form method="GET" action="${pageContext.request.contextPath}/edityourevent" >

<table class="events wrapper">
<thead>
<tr><th>Creator</th><th>Name</th><th>Street</th><th>City</th><th>State</th><th>ZipCode</th><th>Date</th><th>Edit</th><th>Delete</th></tr>
</thead>
<tbody>
<c:forEach var="yourevent" items="${yourEvents}">

<tr>

	<td><c:out value="${yourevent.user.name}"></c:out> </td>
	
	<td><c:out value="${yourevent.event_name}"></c:out> </td>
	
	<td><c:out value="${yourevent.street}"></c:out> </td>
	
	<td><c:out value="${yourevent.city}"></c:out> </td>
	
	<td><c:out value="${yourevent.state}"></c:out> </td>
	
	<td><c:out value="${yourevent.zipcode}"></c:out> </td>
	
	<td><c:out value="${yourevent.date}"></c:out> </td>
	
	<td><input type = "button" name="edit" value="EDIT" onclick="location.href='${pageContext.request.contextPath}/edityourevent?event_id=${yourevent.event_id}'" /></td>
	
	<td><input type = "button" name="delete" value="DELETE" onclick="location.href='${pageContext.request.contextPath}/edityourevent?delete_id=${yourevent.event_id}'" /></td>
	
</tr>

</c:forEach>
</tbody>
</table>
</sf:form>
</body>
</html>