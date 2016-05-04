<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/main.css"
	rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page : Editing User</title>
</head>

<body>
	<sf:form method="post"
		action="${pageContext.request.contextPath}/doedit" commandName="user">

		<sf:input type="hidden" name="user_id" path="user_id" />
		<table class="formtable">
		
			<tr><td class = "label"> Username : </td><td><sf:input class="control" path="username" name="username" type="text" /><br/><sf:errors path="username" cssClass="error"></sf:errors></td></tr>
			
			<tr><td class = "label"> Email : </td><td><sf:input class="control" path="email" name="email" type="text" /><br/><sf:errors path="email" cssClass="error"></sf:errors></td></tr>
			
			<tr><td class = "label"> Name : </td><td><sf:input class="control" path="name" name="name" type="text" /><br/><sf:errors path="name" cssClass="error"></sf:errors></td></tr>
			
			<tr><td class = "label"></td><td><input class="control" name="update" value="Update User" type="submit" /></td></tr>
		</table>
	</sf:form>
</body>
</html>