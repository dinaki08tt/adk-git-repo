<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Favicon -->
<link rel="apple-touch-icon" sizes="57x57" href="img/favicon/apple-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60" href="img/favicon/apple-icon-60x60.png">
<link rel="apple-touch-icon" sizes="72x72" href="img/favicon/apple-icon-72x72.png">
<link rel="apple-touch-icon" sizes="76x76" href="img/favicon/apple-icon-76x76.png">
<link rel="apple-touch-icon" sizes="114x114" href="img/favicon/apple-icon-114x114.png">
<link rel="apple-touch-icon" sizes="120x120" href="img/favicon/apple-icon-120x120.png">
<link rel="apple-touch-icon" sizes="144x144" href="img/favicon/apple-icon-144x144.png">
<link rel="apple-touch-icon" sizes="152x152" href="img/favicon/apple-icon-152x152.png">
<link rel="apple-touch-icon" sizes="180x180" href="img/favicon/apple-icon-180x180.png">
<link rel="icon" type="image/png" sizes="192x192"  href="img/favicon/android-icon-192x192.png">
<link rel="icon" type="image/png" sizes="32x32" href="img/favicon/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="96x96" href="img/favicon/favicon-96x96.png">
<link rel="icon" type="image/png" sizes="16x16" href="img/favicon/favicon-16x16.png">
<link rel="manifest" href="img/favicon/manifest.json">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage" content="img/favicon/ms-icon-144x144.png">
<meta name="theme-color" content="#ffffff">
<!-- favicon ends -->

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

<script src="js/tour.js"></script>

<link rel="stylesheet" type="text/css" href="styles/styles.css">

<script type="text/javascript">
// $(document).ready(function() { /*code here */ 
	
	
// 	$().headerOnAllPages();
// });


// $.fn.headerOnAllPages = function() {
//     var theHeader = $('#constantheader-wrapper').html();
//     var allPages = $('div[data-role="page"]');

//     for (var i = 1; i < allPages.length; i++) {
//         allPages[i].innerHTML = theHeader + allPages[i].innerHTML;
//     }
// };
</script>

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
<marquee>Site under construction, please visit my blog <a href="https://tt-india.blogspot.in">Table Tennis India</a></marquee>
  <img src="<c:url value="../img/homepage_img.jpg" />" alt="Our Goal" width="1600" height="800">
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