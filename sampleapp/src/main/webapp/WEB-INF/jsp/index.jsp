<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<%@ include file="./pages/head.jsp" %>

<body>
<%@ include file="./pages/menubar.jsp" %>
<div class="jumbotron text-center">
  <h1>ADK Table Tennis Academy</h1> 
  <p>We specialize in Table Tennis Personal Coaching</p> 
</div>
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <%@ include file="./pages/contact.jsp" %>
      <div class="well">
		<h2><p>Butterfly Products</p></h2>
		<p><a target="_blank" class="btn btn-success btn-lg btn3d" href="https://www.amazon.in/gp/search/ref=sr_nr_p_89_0?fst=as%3Aoff&rh=n%3A1984443031%2Cn%3A3403668031%2Ck%3AButterfly+Rubbers%2Cp_89%3AButterfly&keywords=Butterfly+Rubbers&ie=UTF8&qid=1483285970&rnid=3837712031&_encoding=UTF8&tag=dinaki08tt-21&linkCode=ur2&linkId=98d5aa15d57f2c372c3365f9f972f8c4&camp=3638&creative=24630">Products</a><img src="//ir-in.amazon-adsystem.com/e/ir?t=dinaki08tt-21&l=ur2&o=1" width="1" height="1" border="0" alt="" style="border:none !important; margin:0px !important;" /></p>	
      </div>
  
    </div>
    <div class="col-sm-8 text-left"> 
      <h1>Our Goal</h1>
      <p><img style="float:left" class="img-responsive" src="<c:url value="/img/homepage_img.jpg" />"/></p>
      <p> Welcome to my web application! Myself Dinesh Krishnan A, I provide personal coaching for beginners, Intermediate table tennis players. 
  My Goal is to create quality Table Tennis players in Coimbatore district. 
  I run an Academy which is affiliated to Coimbatore District Table Tennis Association and closely associated with Society for Promotion of Table Tennis. 
  Year 2017 will be full packed training session in apartments around Hope College and peelemedu with a mission to produce atleast 20 players from the area. 
 </p>
      <hr>
    </div>
    <div class="col-sm-2 sidenav">
      <div class="well">
     	<%@ include file="./pages/amazon_ads.jsp" %>
      </div>
    </div>
  </div>
</div>

<%@ include file="./pages/footer.jsp" %>

</body>
</html>