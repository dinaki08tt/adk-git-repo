<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Expires" CONTENT="0">
<meta http-equiv="Cache-Control" CONTENT="no-cache">
<meta http-equiv="Pragma" CONTENT="no-cache">
<!-- Include meta tag to ensure proper rendering and touch zooming -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Include jQuery Mobile stylesheets -->
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">

<!-- Include the jQuery library -->
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Include the jQuery Mobile library -->
<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>


<link rel="stylesheet" type="text/css" href="<c:url value="/styles/styles.css" />">

<meta charset="ISO-8859-1">
<title>ADK Table Tennis Academy</title>
</head>
<body>

<div data-role="page" id="pageone">
<%@ include file="menubar.jsp" %>
<div data-role="main" class="ui-content">
	<h2>One Month Certification, course content</h2>
	<table>
	<tr>
	<td><img id="image-1" width="30" height="60" alt="Open in Google Drive" src="<c:url value="/img/gdrive_icon.jpg" />"/></td>
	<td><a target="_blank" href="https://drive.google.com/file/d/0B4L6qN0xPYMQQ1MweURKckNKTzg/view?usp=sharing" class="ui-btn">Open in Google Drive</a></td>
	</tr>
	</table>
    
    
    <div>
		<h2><p>Contact</p></h2>
		<p><a href="tel:919176158249" id="callme" data-role="button" data-inline="true" data-theme="b" data-icon="phone">Call in-charge</a></p>
	</div>
  </div>
<%@ include file="footer.jsp" %>
</div>
</body>
</html>