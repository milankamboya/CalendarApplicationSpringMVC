<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Calendar Application</title>
</head>
<body>
<h3> hello </h3>

<sql:query var="rs" dataSource="jdbc/Calendar">
select id, name, password, email from accounts
</sql:query>

<c:forEach var="row" items="${rs.rows}">
    ID: ${row.id}<br/>
    Name: ${row.name}<br/>
    Password: ${row.password}<br/>
    Email: ${row.email}<br/>
</c:forEach>

</body>
</html>