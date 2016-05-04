<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/header.jspf" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="${pageContext.request.contextPath}/static/main.css" rel="stylesheet" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Events</title>
</head>
<body>
<table class="events wrapper">
<thead>
<tr><th>Creator</th><th>Name</th><th>Street</th><th>City</th><th>State</th><th>Date</th></tr>
</thead>
<tbody>
<c:forEach var="event" items="${events}">

<tr>
	<td><c:out value="${event.user.name}"></c:out> </td>
	
	<td><c:out value="${event.event_name}"></c:out> </td>
	
	<td><c:out value="${event.street}"></c:out> </td>
	
	<td><c:out value="${event.city}"></c:out> </td>
	
	<td><c:out value="${event.state}"></c:out> </td>
	
	<td><c:out value="${event.date}"></c:out> </td>
</tr>

</c:forEach>
</tbody>
</table>
</body>
</html>