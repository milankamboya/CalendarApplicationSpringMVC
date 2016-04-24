<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="${pageContext.request.contextPath}/static/main.css" rel="stylesheet" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Events</title>
</head>
<body>
<table class="events">
<tr><td>Name</td><td>Street</td><td>City</td><td>State</td><td>Date</td></tr>
<c:forEach var="event" items="${events}">

<tr>
	<td><c:out value="${event.name}"></c:out> </td>
	
	<td><c:out value="${event.street}"></c:out> </td>
	
	<td><c:out value="${event.city}"></c:out> </td>
	
	<td><c:out value="${event.state}"></c:out> </td>
	
	<td><c:out value="${event.date}"></c:out> </td>
</tr>

</c:forEach>
</table>
<p><a href="${pageContext.request.contextPath}/createEvent">Create Event</a></p>
</body>
</html>