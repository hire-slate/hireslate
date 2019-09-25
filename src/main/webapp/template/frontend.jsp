<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Hire Slate</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
     
 
    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:200,300,400,600,700,800,900" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/frontend/css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/frontend/css/animate.css">
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/frontend/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/frontend/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/frontend/css/magnific-popup.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/frontend/css/aos.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/frontend/css/ionicons.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/frontend/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/frontend/css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/frontend/css/flaticon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/frontend/css/icomoon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/frontend/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/frontend/css/mainLogin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/frontend/css/utilLogin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/frontend/css/animsition.min.css">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <!-- registration template css -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/frontend/cregister/css/opensans-font.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/frontend/cregister/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
	<!-- Main Style Css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/frontend/cregister/css/style.css"/>
      
  	<script src="${pageContext.request.contextPath}/resources/frontend/js/jquery.min.js"></script>
  
 		
 
  
  
  </head>
  <body>
    
	  <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="/index">Hireslate</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item active"><a href="index.html" class="nav-link">Home</a></li>      	 
	          <li class="nav-item"><a href="about.html" class="nav-link">About</a></li>
	          <li class="nav-item"><a href="candidates.html" class="nav-link">Candidates</a></li>
	          <li class="nav-item"><a href="blog.html" class="nav-link">Blog</a></li>
	          <li class="nav-item"><a href="contact.html" class="nav-link">Contact</a></li>
	          <li class="nav-item cta mr-md-1 sessionToggle"><a onclick="document.getElementById('login').style.display='block'" class="nav-link">Login</a></li>
	          <li class="nav-item cta cta-colored sessionToggle"><a href="/user/register" class="nav-link">Register</a></li>
			  <li class="nav-item cta mr-md-1 sessionLogout"><i class="fa fa-user-circle"></i></li>
	          		
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->
    
    <%if(session.getAttribute("userId")!=null){%>
    	<script type="text/javascript">
			$('.sessionToggle').hide();
			$('.sessionLogout').show();
    	</script>
    <%System.out.println("for if"+session.getAttribute("userId"));}
    else{%>
    	<script type="text/javascript">
			$('.sessionToggle').show();
			$('.sessionLogout').hide();
    	</script>
    	
    <%System.out.println(session.getAttribute("userId"));} %>
    
  
    <div id="login" class="w3-modal">
	<span onclick="document.getElementById('login').style.display='none'"
		class="w3-button w3-display-topright">&times;</span>

	<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">

		<form class="login100-form validate-form" method="Post" action ="/user/login">

			<span class="login100-form-title p-b-33"> Account Login </span>

			<div class="wrap-input100 validate-input"
				data-validate="Valid email is required: ex@abc.xyz">
				<input class="input100" type="text" name="username" placeholder="Email">
				<span class="focus-input100-1"></span> <span
					class="focus-input100-2"></span>
			</div>

			<div class="wrap-input100 rs1 validate-input"
				data-validate="Password is required">
				<input class="input100" type="password" name="password"
					placeholder="Password"> <span class="focus-input100-1"></span>
				<span class="focus-input100-2"></span>
			</div>

			<div class="container-login100-form-btn m-t-20">
				<input class="login100-form-btn" name="loginBtn" type="submit"  value = "sign in">
			</div>

			<div class="text-center p-t-45 p-b-4">
				<span class="txt1"> Forgot </span> <a href="#" class="txt2 hov1">
					Username / Password? </a>
			</div>
			<div class="text-center">
				<span class="txt1"> Create an account? </span> <a href="#"
					class="txt2 hov1"> Sign up </a>
			</div>
		</form>
	</div>
</div>
    
    
		<tiles:insertAttribute name="frontendContent"></tiles:insertAttribute>  	

    <footer class="ftco-footer ftco-bg-dark ftco-section">
      <div class="container">
        <div class="row mb-5">
        	<div class="col-md">	
             <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">About</h2>
              <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
              <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-3">
                <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">Employers</h2>
              <ul class="list-unstyled">
                <li><a href="#" class="py-2 d-block">How it works</a></li>
                <li><a href="#" class="py-2 d-block">Register</a></li>
                <li><a href="#" class="py-2 d-block">Post a Job</a></li>
                <li><a href="#" class="py-2 d-block">Advance Skill Search</a></li>
                <li><a href="#" class="py-2 d-block">Recruiting Service</a></li>
                <li><a href="#" class="py-2 d-block">Blog</a></li>
                <li><a href="#" class="py-2 d-block">Faq</a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4 ml-md-4">
              <h2 class="ftco-heading-2">Workers</h2>
              <ul class="list-unstyled">
                <li><a href="#" class="py-2 d-block">How it works</a></li>
                <li><a href="#" class="py-2 d-block">Register</a></li>
                <li><a href="#" class="py-2 d-block">Post Your Skills</a></li>
                <li><a href="#" class="py-2 d-block">Job Search</a></li>
                <li><a href="#" class="py-2 d-block">Emploer Search</a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
            	<h2 class="ftco-heading-2">Have a Questions?</h2>
            	<div class="block-23 mb-3">
	              <ul>
	                <li><span class="icon icon-map-marker"></span><span class="text">203 Fake St. Mountain View, San Francisco, California, USA</span></li>
	                <li><a href="#"><span class="icon icon-phone"></span><span class="text">+2 392 3929 210</span></a></li>
	                <li><a href="#"><span class="icon icon-envelope"></span><span class="text">info@yourdomain.com</span></a></li>
	              </ul>
	            </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12 text-center">

            <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart text-danger" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
          </div>
        </div>
      </div>
    </footer>
    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>
  <script src="${pageContext.request.contextPath}/resources/frontend/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/frontend/js/popper.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/frontend/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/frontend/js/jquery.easing.1.3.js"></script>
  <script src="${pageContext.request.contextPath}/resources/frontend/js/jquery.waypoints.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/frontend/js/jquery.stellar.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/frontend/js/owl.carousel.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/frontend/js/jquery.magnific-popup.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/frontend/js/aos.js"></script>
  <script src="${pageContext.request.contextPath}/resources/frontend/js/jquery.animateNumber.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/frontend/js/scrollax.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/frontend/js/google-map.js"></script>
  <script src="${pageContext.request.contextPath}/resources/frontend/js/main.js"></script>
  <script src="${pageContext.request.contextPath}/resources/frontend/js/animsition.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/frontend/js/mainLogin.js"></script>
  </body>
</html>