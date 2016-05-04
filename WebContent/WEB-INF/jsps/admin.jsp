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
<title>Admin Page</title>
</head>
<body>
	<h3> Authorized Users Only </h3>
<sf:form method="GET" action="${pageContext.request.contextPath}/edituser" >
	
<table class="events wrapper">
	<thead>
	<tr><th> Name </th><th> Username </th><th> Email </th> <th> Role </th> <th> Enabled </th> <th> Edit </th><th> Delete </th><th> Events </th></tr>
	</thead>
	<tbody>
	<c:forEach var="user" items="${users}">
		<tr>
			<td> <c:out value="${user.name}"></c:out> </td>
			
			<td> <c:out value="${user.username}"></c:out> </td>
			
			<td> <c:out value="${user.email}"></c:out> </td>
			
			<td> <c:out value="${user.authority}"></c:out> </td>
			
			<td> <c:out value="${user.enabled}"></c:out> </td>
			
			<td><input type = "button" name="edit" value="EDIT" onclick="location.href='${pageContext.request.contextPath}/edituser?user_id=${user.user_id}'" /></td>
			
			<td><input type = "button" name="delete" value="DELETE" onclick="location.href='${pageContext.request.contextPath}/edituser?delete_id=${user.user_id}'" /></td>
			
			<td><input type = "button" name="events" value="${user.name}'s EVENTS" onclick="location.href='${pageContext.request.contextPath}/edituser?event_id=${user.user_id}'" /></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</sf:form>
</body>
</html>