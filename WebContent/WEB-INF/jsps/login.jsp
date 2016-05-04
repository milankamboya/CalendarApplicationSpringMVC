<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>Login Page</title>
<link href="${pageContext.request.contextPath}/static/main.css" rel="stylesheet" type="text/css" />

</head>
<body onload='document.f.j_username.focus();'>
	<h3>Welcome to LogIn Page</h3>
	
	<h3><c:if test="${param.error != null}">
		<p class="error"> Login Failed. Check that your username and password are correct. </p>
	</c:if>
	</h3>
	<form id="loginForm" name='f' action='${pageContext.request.contextPath}/login' method='POST'>
		<table class="formtable">
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td>Remember Me:</td>
				<td><input type="checkbox" name='remember-me' checked="checked" /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
	</form>
	<h3><a href='<c:url value="/newAccount"></c:url>'>Create New Account</a></h3>
</body>
</html>