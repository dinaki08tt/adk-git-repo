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
    	<h2><p>Search a Racket</p></h2>
		<p><a target="_blank" class="btn btn-warning btn-lg btn3d" href="https://www.amazon.in/gp/search?ie=UTF8&tag=dinaki08tt-21&linkCode=ur2&linkId=c648f97d9dd77cb64c9c619937604c1d&camp=3638&creative=24630&index=sporting&keywords=Table Tennis">Search</a><img src="//ir-in.amazon-adsystem.com/e/ir?t=dinaki08tt-21&l=ur2&o=1" width="1" height="1" border="0" alt="" style="border:none !important; margin:0px !important;" /></p>
	  </div>
           <%@ include file="contact.jsp" %>
    </div>
    <div class="col-sm-8 text-left"> 
	<h2>Department of Physical Education, PSG Tech</h2>
    <div class="embed-responsive embed-responsive-16by9">
    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3916.184119555375!2d77.00063761480298!3d11.024808592153274!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3ba8582f1435fa59%3A0x137d95bfd8909293!2sPSG+College+Of+Technology!5e0!3m2!1sen!2sin!4v1481878467653" width="400" height="300" frameborder="0" style="border:0" allowfullscreen></iframe>
	</div>
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