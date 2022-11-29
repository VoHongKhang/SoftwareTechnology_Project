<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/student-detai" var="detai" />
<c:url value="/login" var="login" />
<c:url value="/views/" var="views"></c:url>
<c:url value="/student-detai/search" var="search" />
<c:url value="/student-giangvien/search" var="search_ten" />
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
									<li class="active"><a href="${views}student/home.jsp">Home</a></li>
									<li><a href="${detai}">Topic</a></li>
									<li><a href="${search}">Search Topic</a></li>
									<li><a href="${search_ten}">Search Lecturer</a></li>
									<!-- <li><button class="btn green" >Log out</button> </li> -->
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