<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="${pageContext.request.contextPath}/static/main.css" rel="stylesheet" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Event</title>
</head>
<body>
	<sf:form method="post" action="${pageContext.request.contextPath}/docreate" commandName="event">
	<sf:input type="hidden" name="event_id" path="event_id" />
		<table class = "formtable">
			<tr><td class = "label">Name : </td><td><sf:input class="control" path="event_name" name="event_name" type="text" /><br/><sf:errors path="event_name" cssClass="error"></sf:errors></td></tr>
			<tr><td class = "label">Street : </td><td><sf:input class="control" path="street" name="street" type="text" /><br/><sf:errors path="street" cssClass="error"></sf:errors></td></tr>
			<tr><td class = "label">City : </td><td><sf:input class="control" path="city" name="city" type="text" /><br/><sf:errors path="city" cssClass="error"></sf:errors></td></tr>
			<tr><td class = "label">State : </td><td><sf:input class="control" path="state" name="state" type="text" /><br/><sf:errors path="state" cssClass="error"></sf:errors></td></tr>
			<tr><td class = "label">Zipcode : </td><td><sf:input class="control" path="zipcode" name="zipcode" type="text" /><br/><sf:errors path="zipcode" cssClass="error"></sf:errors></td></tr>
			<tr><td class = "label">Time : </td><td><sf:input class="control" path="date" name="date" type="text" /><br/><sf:errors path="date" cssClass="error"></sf:errors></td></tr>
			<tr><td class = "label"></td><td><input class="control" name="submit" value="Create Event" type="submit" /></td></tr>
			<tr><td class = "label"></td><td><input class="control" name="update" value="Update Event" type="submit" /></td></tr>
		</table>
	</sf:form>
</body>
</html>