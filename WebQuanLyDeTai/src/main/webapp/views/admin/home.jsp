<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url value="/templates/" var="URL"></c:url>
<c:url value="/admin-sinhvien" var="sinhvien" />
<c:url value="/admin-giangvien" var="giangvien" />
<c:url value="/admin-taikhoan" var="taikhoan" />
<c:url value="/admin-detai" var="detai" />
<c:url value="/views/" var="views"></c:url>

<!DOCTYPE html>
<html lang="en">

<head>
<!-- basic -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- mobile metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<!-- site metas -->
<title>MobiShop</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">
<!-- bootstrap css -->
<link rel="stylesheet" href="${URL}css/bootstrap.min.css">
<!-- style css -->
<link rel="stylesheet" href="${URL}css/style.css">
<!-- Responsive-->
<link rel="stylesheet" href="${URL}css/responsive.css">
<!-- fevicon -->
<link rel="icon" href="${URL}images/fevicon.png" type="image/gif" />
<!-- Scrollbar Custom CSS -->
<link rel="stylesheet" href="${URL}css/jquery.mCustomScrollbar.min.css">
<!-- Tweaks for older IEs-->
<link rel="stylesheet"
	href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
<!-- owl stylesheets -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${URL}css/owl.carousel.min.css">
<link rel="stylesheet" href="${URL}css/owl.theme.default.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css"
	media="screen">
<link href="${URL}css/owl.carousel.min.css" rel="stylesheet"
	type="text/css">
<link href="${URL}css/owl.theme.default.min.css" rel="stylesheet"
	type="text/css">
<link href="${URL}css/jquery.mCustomScrollbar.min.css" rel="stylesheet"
	type="text/css">
<link href="${URL}css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="${URL}css/style.css" rel="stylesheet" type="text/css">
<link href="${URL}css/responsive.css" rel="stylesheet" type="text/css">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<!-- body -->

<body class="main-layout ">

	<header>
		<!-- header inner -->
		<div class="header">

			<div class="container">
				<div class="row">
					<div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col logo_section">
						<div class="full">
							<div class="center-desk">
								<div class="logo">
									<a href="${views}admin/home.jsp"><img
										src="${URL}images/hcmute.jpg" alt="#"></a>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
						<div class="menu-area">
							<div class="limit-box">
								<nav class="main-menu">
									<ul class="menu-area-main">
										<li class="active"><a href="${views}admin/home.jsp">Home</a></li>
										<li><a href="${sinhvien}">Student</a></li>
										<li><a href="${taikhoan}">Account</a></li>
										<li><a href="${giangvien}">Lecturer</a></li>
										<li><a href="${detai}">Topic</a></li>
										<li><a href="${login}">Log out</a></li>
									</ul>
								</nav>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- end header inner -->
	</header>
	<!-- about -->
	<div class="about">
		<div class="container">
			<div class="row">
				<div class="col-xl-5 col-lg-5 col-md-5 co-sm-l2">
					<div class="about_img">
						<figure>
							<img src="images/about.png" alt="img" />
						</figure>
					</div>
				</div>
				<div class="col-xl-7 col-lg-7 col-md-7 co-sm-l2">
					<div class="about_box">
						<h3>About Us</h3>
						<span>Our Mobile Shop</span>
						<p>Welcome to our unique and wonderful shop, why is it unique
							you ask, here and only here we have phones you cant find anywhere
							in this world because they're brought to you from outer space. So
							what are you waiting for, spend your money and get your first
							alien mobile phone today.</p>

					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- end about -->

	<!-- brand -->
	<div class="brand">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="titlepage">
						<h2>Our Brand</h2>
					</div>
				</div>
			</div>
		</div>
		<div class="brand-bg">
			<div class="container">
				<div class="row">
					<div class="col-xl-4 col-lg-4 col-md-4 col-sm-6 margin">
						<div class="brand_box">
							<img src="images/1.png" alt="img" />
							<h3>
								<strong class="red">6000</strong>DH
							</h3>
							<span>Samsung S10</span> <i><img src="images/star.png" /></i> <i><img
								src="images/star.png" /></i>
						</div>
					</div>
					<div class="col-xl-4 col-lg-4 col-md-4 col-sm-6 margin">
						<div class="brand_box">
							<img src="images/2.png" alt="img" />
							<h3>
								<strong class="red">7000</strong>DH
							</h3>
							<span>Samsung S11</span> <i><img src="images/star.png" /></i> <i><img
								src="images/star.png" /></i>
						</div>
					</div>
					<div class="col-xl-4 col-lg-4 col-md-4 col-sm-6 margin">
						<div class="brand_box">
							<img src="images/3.png" alt="img" />
							<h3>
								<strong class="red">8000</strong>DH
							</h3>
							<span>Samsung Galaxy Note10 Lite</span> <i><img
								src="images/star.png" /></i> <i><img src="images/star.png" /></i>
							<i><img src="images/star.png" /></i>

						</div>
					</div>
					<div class="col-xl-4 col-lg-4 col-md-4 col-sm-6">
						<div class="brand_box">
							<img src="images/4.png" alt="img" />
							<h3>
								<strong class="red">9000</strong>DH
							</h3>
							<span>Samsung Galaxy A71</span> <i><img src="images/star.png" /></i>
							<i><img src="images/star.png" /></i> <i><img
								src="images/star.png" /></i>

						</div>
					</div>
					<div class="col-xl-4 col-lg-4 col-md-4 col-sm-6 mrgn">
						<div class="brand_box">
							<img src="images/5.png" alt="img" />
							<h3>
								<strong class="red">10000</strong>DH
							</h3>
							<span>Samsung Galaxy S20</span> <i><img src="images/star.png" /></i>
							<i><img src="images/star.png" /></i> <i><img
								src="images/star.png" /></i> <i><img src="images/star.png" /></i>
						</div>
					</div>
					<div class="col-xl-4 col-lg-4 col-md-4 col-sm-6 mrgn">
						<div class="brand_box">
							<img src="images/6.png" alt="img" />
							<h3>
								<strong class="red">11000</strong>DH
							</h3>
							<span>Samsung Galaxy S21</span> <i><img src="images/star.png" /></i>
							<i><img src="images/star.png" /></i> <i><img
								src="images/star.png" /></i> <i><img src="images/star.png" /></i>
							<i><img src="images/star.png" /></i>
						</div>
					</div>
					<div class="col-md-12">
						<a class="read-more">See More</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- end brand -->
	<!-- clients -->
	<div class="clients">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="titlepage">
						<h2>what say our clients</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="clients_red">
		<div class="container">
			<div id="testimonial_slider" class="carousel slide"
				data-ride="carousel">
				<!-- Indicators -->
				<ul class="carousel-indicators">
					<li data-target="#testimonial_slider" data-slide-to="0" class=""></li>
					<li data-target="#testimonial_slider" data-slide-to="1"
						class="active"></li>
					<li data-target="#testimonial_slider" data-slide-to="2" class=""></li>
				</ul>
				<!-- The slideshow -->
				<div class="carousel-inner">
					<div class="carousel-item">
						<div class="testomonial_section">
							<div class="full center"></div>
							<div class="full testimonial_cont text_align_center cross_layout">
								<div class="cross_inner">
									<h3>
										Due markes<br> <strong class="ornage_color">Rental</strong>
									</h3>
									<p>
										Since the invention of internet it has become slowly but
										gradually available for more and more people each day. Now
										that the vast majority of mankind has wifi, it's time to go
										where your customers live: online. If you pride yourself of
										being where your customers are, why aren't you online yet?</i>
									</p>
									<div class="full text_align_center margin_top_30">
										<img src="icon/testimonial_qoute.png">
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="carousel-item active">

						<div class="testomonial_section">
							<div class="full center"></div>
							<div class="full testimonial_cont text_align_center cross_layout">
								<div class="cross_inner">
									<h3>
										Due markes<br> <strong class="ornage_color">Rental</strong>
									</h3>
									<p>
										Since the invention of internet it has become slowly but
										gradually available for more and more people each day. Now
										that the vast majority of mankind has wifi, it's time to go
										where your customers live: online. If you pride yourself of
										being where your customers are, why aren't you online yet?</i>
									</p>
									<div class="full text_align_center margin_top_30">
										<img src="icon/testimonial_qoute.png">
									</div>
								</div>
							</div>
						</div>

					</div>

					<div class="carousel-item">

						<div class="testomonial_section">
							<div class="full center"></div>
							<div class="full testimonial_cont text_align_center cross_layout">
								<div class="cross_inner">
									<h3>
										Due markes<br> <strong class="ornage_color">Rental</strong>
									</h3>
									<p>
										Since the invention of internet it has become slowly but
										gradually available for more and more people each day. Now
										that the vast majority of mankind has wifi, it's time to go
										where your customers live: online. If you pride yourself of
										being where your customers are, why aren't you online yet?</i>
									</p>
									<div class="full text_align_center margin_top_30">
										<img src="icon/testimonial_qoute.png">
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>

		</div>
	</div>
	<!-- end clients -->
	<!-- contact -->
	<div class="contact">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="titlepage">
						<h2>Contact us</h2>
					</div>
					<form class="main_form">
						<div class="row">
							<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6">
								<input class="form-control" placeholder="Your name" type="text"
									name="Your Name">
							</div>
							<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6">
								<input class="form-control" placeholder="Email" type="text"
									name="Email">
							</div>
							<div class=" col-md-12">
								<input class="form-control" placeholder="Phone" type="text"
									name="Phone">
							</div>
							<div class="col-md-12">
								<textarea class="textarea" placeholder="Message"></textarea>
							</div>
							<div class=" col-md-12">
								<button class="send">Send</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- end contact -->

	<!-- footer -->
	<footer>
		<div id="contact" class="footer">
			<div class="container">
				<div class="row pdn-top-30">
					<div class="col-md-12 ">
						<div class="footer-box">
							<div class="headinga">
								<h3>Address</h3>
								<span>1, Võ Văn Ngân, Việt Nam</span>
								<p>
									Trường đại học SPKT thành phố Hồ Chí Minh <br>hcmute.online.edu.vn
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="copyright">
				<div class="container">
					<p>Khoa Công nghệ Thông tin-Đại học Sư phạm Kỹ thuật TP. Hồ Chí
						Minh</p>
					<p>Số 1, Võ Văn Ngân, Thủ Đức, TP. Hồ Chí Minh</p>
				</div>
			</div>
		</div>
	</footer>
	<!-- end footer -->
	<!-- Javascript files-->
	<script src="js/jquery.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/jquery-3.0.0.min.js"></script>
	<script src="js/plugin.js"></script>
	<!-- sidebar -->
	<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="js/custom.js"></script>
	<!-- javascript -->
	<script src="js/owl.carousel.js"></script>
	<script
		src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
	<script>
		$(document).ready(function() {
			$(".fancybox").fancybox({
				openEffect : "none",
				closeEffect : "none"
			});

			$(".zoom").hover(function() {

				$(this).addClass('transition');
			}, function() {

				$(this).removeClass('transition');
			});
		});
	</script>
</body>

</html>