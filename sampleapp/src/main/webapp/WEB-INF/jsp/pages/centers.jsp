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
    	<h2><p>Buy 3star Balls</p></h2>
		<p><a target="_blank" class="btn3d btn btn-default btn-lg" href="https://www.amazon.in/s/ref=nb_sb_noss_2?url=node%3D3403668031&field-keywords=Balls&rh=n%3A3403668031%2Ck%3ABalls&_encoding=UTF8&tag=dinaki08tt-21&linkCode=ur2&linkId=1f513a895c5f01a82f8e9106b98282d8&camp=3638&creative=24630">Buy TT Balls</a><img src="//ir-in.amazon-adsystem.com/e/ir?t=dinaki08tt-21&l=ur2&o=1" width="1" height="1" border="0" alt="" style="border:none !important; margin:0px !important;" /></p>
	  </div>
        <%@ include file="contact.jsp" %>
    </div>
    <div class="col-sm-8 text-left"> 
    	<h2>Other Centers</h2>
  <div class="list-group">
    <a href="adk" class="list-group-item list-group-item disabled">ADK Table Tennis Academy <i class="fa fa-location-arrow" aria-hidden="true"></i></a>
    <a href="cdtta" class="list-group-item list-group-item-info">CDTTA, Esso bunk <i class="fa fa-location-arrow" aria-hidden="true"></i></a>
    <a href="psg" class="list-group-item list-group-item-warning">Department of Physical Education, PSG Tech <i class="fa fa-location-arrow" aria-hidden="true"></i></a>
    <a href="spott" class="list-group-item list-group-item-danger">Society for Promotion of Table Tennis Coaching Center, Lady trainers available <i class="fa fa-location-arrow" aria-hidden="true"></i></a>
    <a href="srivari" class="list-group-item list-group-item-success">Sri Vari Mansarovar Apartment <i class="fa fa-location-arrow" aria-hidden="true"></i></a>
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