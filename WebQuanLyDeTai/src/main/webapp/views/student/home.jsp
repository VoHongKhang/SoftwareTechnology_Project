<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url value="/templates/" var="URL"></c:url>
<c:url value="/student-detai" var="detai" />
<c:url value="/views/" var="views"></c:url>
<c:url value="/login" var="login" />
<c:url value="/student-detai/search" var="search" />
<c:url value="/student-giangvien/search" var="search_ten" />
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
<title>UTE</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">
<!-- bootstrap css -->
<link rel="stylesheet" href="${URL}css/bootstrap.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
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

	
	<div class="contact">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="titlepage">
						<h4
							style="font-size: 30px; line-height: 40px; font-weight: bold; padding: 0;">Thông
							báo</h4>
					</div>
					
					
							<div class="col-md-9" style="padding-right: 25px">
						<div class="row">
							<table class="table table-striped table-bordered table-hover"
								id="sample_2">
								<!-- <table id="sample_2" class="table table-striped table-bordered table-hover" style="width: 100%"> -->
								<thead>
									<tr>

										<th>Thong bao</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${thongbaos}">
										<tr class="odd gradeX">

											<td> <a href="${pageContext.request.contextPath}/student/home/thongbao?id=${item.id}">${item.tenthongbao} </a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>




<div class="contact">
		<div class="container">
			<div class="row" style="display: flex;justify-content: center;">
				<div class="titlepage">
					<h4
						style="font-size: 30px; line-height: 40px; font-weight: bold; padding: 0;">Các
						chủ nhiệm bộ môn</h4>
				</div>
				<div class="flex-container"
					style="display: flex; justify-content: center;">


					<div class="card" style="width: 300px; margin: 0 30px;">
						<img class="card-img-top" src="${URL}images/img_avatar1.png"
							alt="Card image">
						<div class="card-body">
							<h4 class="card-title">Chủ nhiệm Bộ môn CÔNG NGHỆ PHẦN MỀM</h4>
							<p class="card-text" style="margin-bottom: 20px;">Huỳnh Xuân
								Phụng</p>
							<p class="card-text" style="margin-bottom: 20px;">phunghx@hcmute.edu.vn</p>
							<a href="#" class="btn btn-primary">See Profile</a>
						</div>

					</div>
					<div class="card" style="width: 300px; margin: 0 30px;">
						<img class="card-img-top" src="${URL}images/img_avatar1.png"
							alt="Card image">
						<div class="card-body">
							<h4 class="card-title">Chủ nhiệm Bộ môn HỆ THỐNG THÔNG TIN</h4>
							<p class="card-text" style="margin-bottom: 20px;">Nguyễn
								Thành Sơn</p>
							<p class="card-text" style="margin-bottom: 20px;">sonnt@hcmute.edu.vn</p>
							<a href="#" class="btn btn-primary">See
								Profile</a>
						</div>
					</div>
					<div class="card" style="width: 300px; margin: 0 30px;">
						<img class="card-img-top" src="${URL}images/img_avatar5.png"
							alt="Card image">
						<div class="card-body">
							<h4 class="card-title">Chủ nhiệm Bộ môn MẠNG VÀ AN NINH MẠNG</h4>
							<p class="card-text" style="margin-bottom: 20px;">Nguyễn Thị
								Thanh Vân</p>
							<p class="card-text" style="margin-bottom: 20px;">vanntth@hcmute.edu.vn</p>
							<a href="#" class="btn btn-primary">See Profile</a>
						</div>
					</div>
					<div class="card" style="width: 300px; margin: 0 30px;">
						<img class="card-img-top" src="${URL}images/img_avatar1.png"
							alt="Card image">
						<div class="card-body">
							<h4 class="card-title">Chủ nhiệm Bộ môn TRÍ TUỆ NHÂN TẠO</h4>
							<p class="card-text" style="margin-bottom: 20px;">Trần Tiến
								Đức</p>
							<p class="card-text" style="margin-bottom: 20px;">ductt@hcmute.edu.vn</p>
							<a href="#" class="btn btn-primary">See
								Profile</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- contact -->
	<div class="contact">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="titlepage">
						<h4
							style="font-size: 30px; line-height: 40px; font-weight: bold; padding: 0;">Đặt
							câu hỏi cho Khoa</h4>
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
								<button class="send" style="background-color: #135fab;">Send</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="contact">
		<div class="container">
			<div class="panel panel-default" id="thongke_right">
				<div class="panel-heading">
					<h4
						style="font-size: 30px; line-height: 40px; font-weight: bold; padding: 0;">Thống
						kê</h4>
				</div>
				<a class="list-group-item" style="margin-top: 20px;"><img
					src="http://dkdt.fit.hcmute.edu.vn/Content/public/images/user-group-icon%20(1).png"
					width="24" height="24"> Lượt truy cập : <span class="badge"
					style="color: #0d6efd;">99999</span></a> <a
					style="text-decoration: underline;" data-toggle="modal"
					data-target="#who_online" title="Who is online ?"
					href="javascript:void();" class="list-group-item"><img
					src="http://dkdt.fit.hcmute.edu.vn/Content/public/images/online-icon.png"
					width="24" height="24"> Đang trực tuyến: <span class="badge"
					style="color: #0d6efd;">1</span></a>

			</div>
		</div>
	</div>
	<!-- end contact -->


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
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>

</html>