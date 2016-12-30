<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Include meta tag to ensure proper rendering and touch zooming -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Include jQuery Mobile stylesheets -->
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">

<!-- Include the jQuery library -->
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Include the jQuery Mobile library -->
<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>


<link rel="stylesheet" type="text/css" href="<c:url value="/styles/styles.css" />">


<title>ADK Table Tennis Academy</title>
</head>
<body>

<div data-role="page" id="pageone">
<%@ include file="menubar.jsp" %>
 
<div data-role="main" class="ui-content">
	<h2>Society for Promotion of Table Tennis Coaching center, near Omni Bus Stand</h2>
    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3916.211546700944!2d76.97258821388371!3d11.022748792154676!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3ba8585033847601%3A0x0!2zMTHCsDAxJzIxLjkiTiA3NsKwNTgnMjkuMiJF!5e0!3m2!1sen!2sin!4v1483110706596" width="400" height="300" frameborder="0" style="border:0" allowfullscreen></iframe>
	<div>
		<h2><p>Contact</p></h2>
		<p><a href="tel:919443362800" id="callme" data-role="button" data-inline="true" data-theme="b" data-icon="phone">Call in-charge</a></p>
	</div>
</div>
  
 
<%@ include file="footer.jsp" %>

</div>
</body>
</html>