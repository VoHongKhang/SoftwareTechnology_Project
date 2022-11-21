<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/admin-sinhvien" var="sinhvien" />
<c:url value="/admin-giangvien" var="giangvien" />
<c:url value="/admin-truongbomon" var="truongbomon" />
<c:url value="/admin-taikhoan" var="taikhoan" />


<nav class="navbar navbar-expand-lg navbar-light bg-light" id="banner-desktop">
	<a class="navbar-brand bg-success" href="#">Quản lý đề tài</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse bg-success" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="${sinhvien}">Student
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="${giangvien}">Lecturer</a></li>
			<li class="nav-item"><a class="nav-link" href="${truongbomon}">Head_Lecturer</a></li>
			<li class="nav-item"><a class="nav-link" href="${taikhoan}">Account</a></li>
	
		</ul>
	</div>
</nav>