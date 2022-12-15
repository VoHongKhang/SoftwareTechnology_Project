<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url value="/templates/" var="URL"></c:url>
<c:url value="/admin/home" var="home" />
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
	<a> Trường ĐH Sư phạm Kỹ thuật TP. HCM Cộng hòa xã hội chủ nghĩa
		Việt Nam </a>
	<br>
	<a> Khoa Công nghệ thông tin Độc lập - Tự do - Hạnh phúc </a>
	<br>


	<div class="col-md-9" style="padding-right: 25px">
		<div class="row">
			<table class="table table-striped table-bordered table-hover"
				id="sample_2">
				<!-- <table id="sample_2" class="table table-striped table-bordered table-hover" style="width: 100%"> -->
				<thead>
					<tr>
						<th></th>
						<th>Mô tả</th>

					</tr>
				</thead>
				<tbody>
					<c:set var="item" scope="session" value="${thongbaos}">
					</c:set>				

					<tr class="odd gradeX">
						<td>Thông báo</td>
						<td>${item.tenthongbao}</td>
					</tr>

					<tr class="odd gradeX">
						<td>Mô tả</td>
						<td>${item.mota}</td>
					</tr>
					<tr class="odd gradeX">
						<td>Mô tả</td>
						<td>${item.loaidetai}</td>
					</tr>
					<tr class="odd gradeX">
						<td>Giảng viên đăng ký đề tài từ ngày:</td>
						<td>${item.ngaybatdauGV}</td>
					</tr>

					<tr class="odd gradeX">
						<td>Sinh viên đăng ký từ ngày:</td>
						<td>${item.ngaybatdau}</td>
					</tr>
					
					<tr class="odd gradeX">
						<td>Hạn cuối đăng ký:</td>
						<td>${item.ngayketthuc}</td>
					</tr>


				</tbody>
			</table>
		</div>
	</div>


</body>
</html>