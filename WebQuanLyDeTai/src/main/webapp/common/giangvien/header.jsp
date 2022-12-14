<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/" var="URL"></c:url>
<c:url value="/giangvien-detai" var="detai" />
<c:url value="/login" var="login" />
<c:url value="/views/" var="views"></c:url>
<c:url value="/giangvien-detai/search" var="search" />
<c:url value="/giangvien/home" var="home" />
<c:url value="/giangvien/thongtin" var="thongtin" />
<c:url value="/giangvien-hoidong" var="hoidong" />
<header>
	<!-- header inner -->
	<div class="header">

		<div class="container">
			<div class="row">
				<div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col logo_section">
					<div class="full">
						<div class="center-desk">
							<div class="logo">
								<a href="${home}"><img src="${URL}images/hcmute.jpg" alt="#"></a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
					<div class="menu-area">
						<div class="limit-box">
							<nav class="main-menu">
								<ul class="menu-area-main">
									<li class="active"><a href="${home}">Trang chủ</a></li>
									<li><a href="${detai}">Đề tài</a></li>
									<li><a href="${search}">Tìm kiếm đề tài</a></li>
									<li><a href="${hoidong}">Hội đồng</a></li>
									<!-- <li><button class="btn green" >Log out</button> </li> -->
									<li><a href="${login}">Đăng xuất</a></li>
								</ul>
								<ul class="menu-area-main">
									<li><a href="${thongtin}">Thông tin cá nhân</a></li>
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