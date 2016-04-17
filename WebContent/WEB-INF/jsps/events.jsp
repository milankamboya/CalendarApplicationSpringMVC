<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Events</title>
</head>
<body>
<c:forEach var="row" items="${events}">
    ID: ${row.id}<br/>
    Name: ${row.name}<br/>
    Street: ${row.street}<br/>
    City: ${row.city}<br/>
    State: ${row.state}<br/>
    Time: ${row.time}<br/>
</c:forEach>
</body>
</html>