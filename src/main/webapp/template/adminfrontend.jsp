<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>

<html style="height: auto; min-height: 100%;">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>AdminLTE 2 | Top Navigation</title>
		
		<!-- customized css -->
		<style type="text/css">
		a:hover.cushover{
			background-color: white;
		}
		
		</style>
				<!-- Tell the browser to be responsive to screen width -->
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

		<!-- Bootstrap 3.3.7 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
		<script src="moz-extension://3ac5611c-4de0-48b2-adbb-5c9ebbc91664/page/prompt.js"></script>
		<script src="moz-extension://3ac5611c-4de0-48b2-adbb-5c9ebbc91664/page/runScript.js"></script>

		<!-- Font Awesome -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bower_components/font-awesome/css/font-awesome.min.css">

		<!-- Ionicons -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bower_components/Ionicons/css/ionicons.min.css">

		<!-- Theme style -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/AdminLTE.min.css">

		<!-- AdminLTE Skins. Choose a skin from the css/skins folder instead of downloading all of them to reduce the load. -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/skins/_all-skins.min.css">

		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
  		<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  		<![endif]-->

		<!-- Google Font -->
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

		<!-- jQuery 3 -->
		<script src="${pageContext.request.contextPath}/resources/bower_components/jquery/dist/jquery.min.js"></script>
	
		<!-- Bootstrap 3.3.7 -->
		<script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	
		<!-- SlimScroll -->
		<script src="${pageContext.request.contextPath}/resources/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	
		<!-- FastClick -->
		<script src="${pageContext.request.contextPath}/resources/bower_components/fastclick/lib/fastclick.js"></script>
	
		<!-- AdminLTE App -->
		<script src="${pageContext.request.contextPath}/resources/dist/js/adminlte.min.js"></script>
	
		<!-- AdminLTE for demo purposes -->
		<script src="${pageContext.request.contextPath}/resources/dist/js/demo.js"></script>
	
		
</head>

<!-- ADD THE CLASS layout-top-nav TO REMOVE THE SIDEBAR. -->
<body class="skin-blue layout-top-nav" style="height: auto; min-height: 100%;">
	<div class="wrapper" style="height: auto; min-height: 100%;">
		<header class="main-header" style="padding: 10px; background-color: white; padding-right: 11%; padding-left: 11%">
			<nav class="navbar navbar-static-top">
				<div class="container" style = "width: auto; background-color: white">

					<div class="navbar-header">
						<a class="navbar-brand" href="#" style="color: black"><b>Hireslate</b></a>
					</div>	
					<!-- Collect the nav links, forms, and other content for toggling -->
					
					<!-- /.navbar-collapse -->
					<!-- Navbar Right Menu -->
					<div class="navbar-custom-menu">
						<ul class="nav navbar-nav">
						
							<li class="user user-menu" ><a class="cushover" href="#" style="color: black">Home</a></li>
							<li class="user user-menu" ><a href="#" style="color: black">About</a></li>
							<li class="user user-menu" ><a href="#" style="color: black">Contact</a></li>
							<!-- User Account Menu -->
							<li class="dropdown user user-menu">
								
								<!-- Menu Toggle Button --> 
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> 
									 
									<!-- hidden-xs hides the username on small devices so only the image appears. -->
									<span class="hidden-xs" style="color: black"><%=session.getAttribute("userfname")%> <%=session.getAttribute("userlname") %></span>
								</a>
								
								<ul class="dropdown-menu">
								
									<!-- The user image in the menu -->
									<li class="user-header">
										<p>Alexander Pierce - Web Developer <small>Member since Nov. 2012</small></p>
									</li>
									
									<!-- Menu Body -->
									<li class="user-body">
										<div class="row">
											<div class="col-xs-4 text-center">
												<a href="#">Followers</a>
											</div>
											<div class="col-xs-4 text-center">
												<a href="#">Sales</a>
											</div>
											<div class="col-xs-4 text-center">
												<a href="#">Friends</a>
											</div>
										</div> <!-- /.row -->
									</li>
									
									<!-- Menu Footer-->
									<li class="user-footer">
										<div class="pull-left">
											<a href="/user/editprofile" class="btn btn-default btn-flat">Edit Profile</a>
										</div>
										<div class="pull-right">
											<a href="/user/logout" class="btn btn-default btn-flat">Sign out</a>
										</div>
									</li>
								</ul>
							</li>
						</ul>
					</div>
					<!-- /.navbar-custom-menu -->
				</div>
				<!-- /.container-fluid -->
			</nav>
		</header>
		
		<div class="content-wrapper">

			<tiles:insertAttribute name="adminfrontendcontent"></tiles:insertAttribute>
		</div>
		
		<footer class="main-footer">
			<div class="container">
				<div class="pull-right hidden-xs">
					<b>Version</b> 2.4.13
				</div>
				<strong>Copyright © 2014-2019 <a href="https://adminlte.io">AdminLTE</a>.
				</strong> All rights reserved.
			</div>
			<!-- /.container -->
		</footer>
	</div>
	<!-- ./wrapper -->



</body>
</html>