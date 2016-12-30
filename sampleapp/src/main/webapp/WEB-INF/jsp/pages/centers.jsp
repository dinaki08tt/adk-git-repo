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
	<h2>Other Centers</h2>
    <ul data-role="listview" data-inset="true">    
      <li data-icon="location" data-transition="turn"><a href="adk">ADK Table Tennis Academy</a></li>
      <li data-icon="location" data-transition="turn"><a href="psg">Department of Physical Education, PSG Tech</a></li>   
      <li data-icon="location" data-transition="turn"><a href="spott">Society for Promotion of Table Tennis Coaching Center</a></li>   
      <li data-icon="location" data-transition="turn"><a href="srivari">Sri Vari Mansarovar Apartment</a></li>   
      </ul>
  </div>
<%@ include file="footer.jsp" %>

</div>
</body>
</html>