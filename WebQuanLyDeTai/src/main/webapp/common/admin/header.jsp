<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/admin-category" var="category" />
<c:url value="/admin-video" var="video" />
<c:url value="/admin-video/detail" var="detail" />
<c:url value="/admin-video/pagesize" var="videopagesize" />
<c:url value="/admin-video/search" var="search" />

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand bg-success" href="#">Bài tập JPA</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse bg-success" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="${category}">Category
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="${video}">Video</a></li>
			<li class="nav-item"><a class="nav-link" href="${videopagesize}">Video phân trang</a></li>
			<li class="nav-item"><a class="nav-link" href="${detail}">Hiển thị video theo category</a></li>
			<li class="nav-item"><a class="nav-link" href="${search}">Search Video</a></li>
		</ul>
	</div>
</nav>