<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!DOCTYPE html>
<html>
<%@ include file="head.jsp" %>
<body>

<%@ include file="menubar.jsp" %>
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <div class="well">
    	<h2><p>Beginner Racket</p></h2>
		<p><a target="_blank" class="btn btn-primary btn-lg btn3d" href="https://www.amazon.in/GKI-Kung-Fu-Tennis-Racquet/dp/B00I7QXEZW/ref=sr_1_2?s=sports&ie=UTF8&qid=1483286589&sr=1-2&keywords=gki+kungfu+dx&_encoding=UTF8&tag=dinaki08tt-21&linkCode=ur2&linkId=f13c64058c775c9a4afc3aabdb0b59f2&camp=3638&creative=24630">GKI Kungfu</a><img src="//ir-in.amazon-adsystem.com/e/ir?t=dinaki08tt-21&l=ur2&o=1" width="1" height="1" border="0" alt="" style="border:none !important; margin:0px !important;" /></p>
	  </div>
     <%@ include file="contact.jsp" %>
    </div>
    <div class="col-sm-8 text-left"> 
    	<h2>One Month Certification, course content</h2>
	
    	<img id="image-1" style="float:left" class="img-responsive" width="50" height="30" alt="Open in Google Drive" src="<c:url value="/img/gdrive_icon.jpg" />"/>
    	<a class="btn btn-primary btn-lg btn3d" target="_blank" href="https://drive.google.com/file/d/0B4L6qN0xPYMQQ1MweURKckNKTzg/view?usp=sharing">Open in Google Drive</a>
      <hr>
    </div>
    <div class="col-sm-2 sidenav">
      <div class="well">
	<%@ include file="amazon_ads.jsp" %>
	 </div>
      
    </div>
  </div>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>