<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<% response.setHeader("Pragma","No-cache");response.setHeader("Cache-Control","no-cache");response.setDateHeader("Expires", 0);%>

<!DOCTYPE HTML>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Photo-Hub Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<!--webfont-->
<link href='http://fonts.useso.com/css?family=Quicksand:300,400,700'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.useso.com/css?family=Open+Sans:300,400,600,700,800'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script src="js/menu_jquery.js"></script>
</head>
<body>
	<div class="banner">
		<div class="container">
			<div class="logo">
				<h1>
					<a href="index.jsp">WSDM Files</a>
				</h1>
			</div>
		</div>
		<div class="container">
			<div class="span_1_of_1">
				<h2>Files Search Engine</h2>
				<div class="search">
				<form action="search" method="get">
			      <ul class="nav1">
		            <li id="search">
						
							<input type="text" name="search_text" id="search_text" placeholder="Search"/>
							<input type="submit" name="search_button" id="search_button" value=" ">
							
						
					</li>
					<select style="width:100px;height:50px;" name="choice" />
						<option value="1">search All</option>
						<option value="3">Abstract</option>
						<option value="4">Author</option>
						<option value="5">Title</option>
						</select>
	              </ul>
	              </form>
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="grid_3">
		<div class="container">
			<ul id="footer-links">
				<li><a href="#">Terms of Use</a></li>
				<li><a href="#">Royalty Free License</a></li>
				<li><a href="#">Extended License</a></li>
				<li><a href="#">Privacy</a></li>
				<li><a href="support.html">Support</a></li>
				<li><a href="about.html">About Us</a></li>
				<li><a href="faq.html">FAQ</a></li>
				<li><a href="#">Categories</a></li>
			</ul>
			<p>
				Copyright &copy; 2019.Southwestern University of Finance and Economics.<a
					target="_blank" href="http://www.777moban.com/">777模板</a>
			</p>
		</div>
	</div>
</body>
</html>
