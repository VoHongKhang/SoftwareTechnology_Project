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
							<nav class="main-menu">
								<ul class="menu-area-main">
									<li class="active"><a href="${home}">Home</a></li>
									<li><a href="${sinhvien}">Student</a></li>
									<li><a href="${taikhoan}">Account</a></li>
									<li><a href="${giangvien}">Lecturer</a></li>
									<li><a href="${detai}">Topic</a></li>
									<li><a href="${thongbao}">Thong bao</a></li>
									<li><a href="${login}">Log out</a></li>

								</ul>
								<ul class="menu-area-main">

									<li><a href="${search}">Search Topic By Name</a></li>
									<li><a href="${search_ma}">Search Topic By Id</a></li>
									<li><a href="${search_ten}">Search Lecturer</a></li>

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