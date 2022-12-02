<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/" var="URL"></c:url>
<c:url value="/admin-sinhvien" var="sinhvien" />
<c:url value="/admin-giangvien" var="giangvien" />
<c:url value="/admin-truongbomon" var="truongbomon" />
<c:url value="/admin-taikhoan" var="taikhoan" />
<c:url value="/admin-detai" var="detai" />
<c:url value="/login" var="login" />
<c:url value="/views/" var="views"></c:url>
<c:url value="/admin-detai/search" var="search" />
<c:url value="/admin-detai/ma" var="search_ma" />
<c:url value="/admin-giangvien/searchten" var="search_ten" />
<c:url value="/admin-thongbao" var="thongbao" />
<c:url value="/admin/home" var="home" />
<c:url value="/admin-hoidong" var="hoidong" />

<header>
	<!-- header inner -->
	<div class="header">

		<div class="container">
			<div class="row">
				<div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col logo_section">
					<div class="full">
						<div class="center-desk">
							<div class="logo">
								<a href="${home}"><img
									src="${URL}images/hcmute.jpg" alt="#"></a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
					<div class="menu-area">
						<div class="limit-box">
							<nav class="main-menu" style="margin-right: -118px; width:1000px">
								<ul class="menu-area-main">
									<li class="active"><a href="${home}">Trang chủ</a></li>
									<li><a href="${sinhvien}">Sinh Viên</a></li>
									<li><a href="${taikhoan}">Tài Khoản</a></li>
									<li><a href="${giangvien}">Giảng Viên</a></li>
									<li><a href="${detai}">Đề Tài</a></li>
									<li><a href="${thongbao}">Thông báo</a></li>
									<li><a href="${login}">Đăng xuất</a></li>

								</ul>
						
								<ul class="menu-area-main">
<<<<<<< HEAD
								
									<li><a href="${hoidong}">Hội đồng</a></li>
									<li><a href="${search}">Tìm kiếm đề tài</a></li>
									<%-- <li><a href="${search_ma}">Tìm kiếm đề tài</a></li> --%>
=======

									<li><a href="${search}">Tìm kiếm đề tài</a></li>
									<li><a href="${search_ma}">Tìm kiếm đề tài</a></li>
>>>>>>> 5a5fd0d1e4feaf4ab33ce42197ed0bfe6359c1f2
									<li><a href="${search_ten}">Tìm kiếm giảng viên</a></li>

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