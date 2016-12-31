<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><meta http-equiv="Expires" CONTENT="0">
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

</head>
<body>
<div data-role="page" id="pageone">
<header data-role="header" data-position="fixed">
<h1>ADK Table Tennis Academy</h1>
<div data-role="navbar">
<ul>
<li><a href="static/home" class="ui-btn-active" data-icon="home" data-theme="b">Home</a></li>
<li><a href="photos" data-icon="star" data-theme="b">Photo Gallery</a></li>
<li><a href="centers" data-icon="grid" data-theme="b">Coaching Centers</a></li>
</ul>
</div>
</header>
 
<div data-role="main" class="ui-content">
	<div>
		<h1>Ball landed outside the Table. Check out my <a href="http://www.adktta.com/">Go to Home Page</a></h1>
	</div>
</div>
  
<div data-role="footer" data-position="fixed">
<div data-role="navbar">
<ul>
<li><a href="tel:919176158249" data-icon="phone" data-theme="b">Call me</a></li>
<li><a href="mailto:dinaki08tt@gmail.com" class="ui-btn-active" data-icon="mail" data-theme="b">Email</a></li>
<li><a href="whatsapp://send?text=www.adktta.com" data-icon="phone" data-theme="b" data-action="share/whatsapp/share">Whatsapp</a></li>
</ul>
</div>
<p align="center">ADK Table Tennis Academy is affiliated to Coimbatore District Table Tennis Association</p>
</div>
</div>

</body>
</html>