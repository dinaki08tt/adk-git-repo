<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Security</title>
</head>
<body>
    <center>
        <b>${topic}</b>
 
<h2>${description}</h2>
 
 
<h3>
            <a href="<c:url value="/j_spring_security_logout" />">Logout</a>
        </h3>
 
    </center>
</body>
</html>