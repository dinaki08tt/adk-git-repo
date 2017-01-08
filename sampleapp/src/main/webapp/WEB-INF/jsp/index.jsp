<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<%@ include file="./pages/head.jsp"%>

<body>
	<%@ include file="./pages/menubar.jsp"%>
	<div id="jumbo" class="jumbotron text-center">
		<h1>ADK Table Tennis Academy</h1>
		<p>We specialize in Table Tennis Personal Coaching</p>
	</div>
	<!-- FB Script -->
	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/ta_IN/sdk.js#xfbml=1&version=v2.8&appId=1061395957316566";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>
	<!-- FB Script ends -->
	<MARQUEE SCROLLDELAY=150>
		<i id="lady" class="fa fa-female" aria-hidden="true"></i> Lady Trainers
		Available! <i class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></i>
	</MARQUEE>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<div class="well">
					<h2>Tell your friends</h2>
					<div id="fbsend" class="fb-send"
						data-href="http://adktta.com/tabletenniscoimbatore/home"></div>
				</div>
				<div class="well">
					<h2>
						<p>Butterfly Products</p>
					</h2>
					<p id="butterfly">
						<a target="_blank" class="btn btn-success btn-lg btn3d"
							href="https://www.amazon.in/gp/search/ref=sr_nr_p_89_0?fst=as%3Aoff&rh=n%3A1984443031%2Cn%3A3403668031%2Ck%3AButterfly+Rubbers%2Cp_89%3AButterfly&keywords=Butterfly+Rubbers&ie=UTF8&qid=1483285970&rnid=3837712031&_encoding=UTF8&tag=dinaki08tt-21&linkCode=ur2&linkId=98d5aa15d57f2c372c3365f9f972f8c4&camp=3638&creative=24630">Products</a><img
							src="//ir-in.amazon-adsystem.com/e/ir?t=dinaki08tt-21&l=ur2&o=1"
							width="1" height="1" border="0" alt=""
							style="border: none !important; margin: 0px !important;" />
					</p>
				</div>

			</div>
			<div class="col-sm-8 text-left">
				<h1 id="goal">Our Goal</h1>
				<p id="boll">
					<img style="float: left" class="img-responsive"
						src="<c:url value="/img/homepage_img.jpg" />" />
				</p>
				<p>Welcome to the Professional circle of Table Tennis
					Coimbatore! We provide personal coaching for Beginners,
					Intermediate table tennis players. Our Goal is to create quality
					Table Tennis players in Coimbatore district. We run an Academy
					which is affiliated to Coimbatore District Table Tennis Association
					and closely associated with Society for Promotion of Table Tennis.
					Year 2017 will be full packed training session in apartments around
					Hope College and peelemedu with a mission to produce atleast 20
					players from the area.</p>
				<hr>
			</div>
			<div class="col-sm-2 sidenav">
				<div class="well">
					<%@ include file="./pages/amazon_ads.jsp"%>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="./pages/footer.jsp"%>
	<script type="text/javascript">
		var tour = new Tour(
				{
					steps : [
							{
								element : "#title",
								title : "Welcome",
								content : "Welcome to ADK Table Tennis Academy! Just click next button to have a tour.",
								placement: "bottom"
							},
							{
								element : "#centers",
								title : "Coaching Centers",
								content : "Here we have listed other Coaching centers in Coimbatore.",
								placement: "bottom"
							},
							{
								element : "#certify",
								title : "Certification",
								content : "We have one month coaching courses addressing different level of play.",
								placement: "bottom"
							},
							{
								element : "#videos",
								title : "Recent Tournament",
								content : "We are conducting tournaments for Juniors and Seniors at different centers in Coimbatore.",
								placement: "bottom"
							},
							{
								element : "#blog",
								title : "Blogspot",
								content : "I have a habit of writing blog since 2006. please read through it.",
								placement: "bottom"
							},
							{
								element : "#fbsend",
								title : "Facebook Messenger",
								content : "Tell your friends about us."
							},
							{
								element : "#butterfly",
								title : "Butterfly Rackets",
								content : "Buy Butterfly Rackets and Rubbers from the Amazon store."
							},
							{
								element : "#afflitiated",
								title : "Affiliated",
								content : "We are affiliated to Coimbatore District Table Tennis Association",
								placement: "top"
							},
							{
								element : "#profile",
								title : "Profile",
								content : "Here is my Linkedin profile."
							},
							{
								element : "#boll",
								title : "Champions",
								content : "Join hands with us to produce a Timo boll and more Champions from Coimbatore."
							},
							{
								element : "#lady",
								title : "Trainer",
								content : "We have lady trainers @ one of our centers.",
								placement: "bottom"
							},
							{
								element : "#shop",
								title : "Amazon Online Shopping",
								content : "Buy all Sports goods from Amazon online.",
								placement: "bottom"
							},
							{
								element : "#jumbo",
								title : "Personal Trainers",
								content : "We focus on Personal Coaching @ Apartments and Colleges. Champions play untill they get it rite. Are you one among them? Call us.",
								placement: "bottom"
							} ]
				});
		if (tour.ended()) {
			  tour.restart();
			} else {
			  tour.init();
			  tour.start();
			}

		$("#title").click(function(){
			  tour.init();
			  tour.start();
			});
	</script>
</body>
</html>