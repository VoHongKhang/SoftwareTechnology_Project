<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url value="/templates/" var="URL"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QLDT</title>
</head>
<body>
	<div class="container" style=" margin-top: 100px; margin-bottom: 100px;">
		<div class="flex-container" style="display: flex; justify-content: center;background-color: #6161c8;padding: 50px 0;">
			<div class="card" style="width: 300px; margin: 0 30px;">

				<div class="card-body">
					<h4 class="card-title" style="color: blue;font-weight: 800;">Thông tin cá nhân</h4>
					<p class="card-text" style="margin-bottom: 20px;">Tên: ${ten}</p>
					<p class="card-text" style="margin-bottom: 20px;">Chuyên ngành: ${chuyennganh}</p>
					<p class="card-text" style="margin-bottom: 20px;">Email: ${email}</p>
					<p class="card-text" style="margin-bottom: 20px;">Năm sinh: ${namsinh}</p>
					<a href="#" class="btn btn-primary">Cập nhật</a>
				</div>
			</div>
			<div class="card" style="width: 300px; margin: 0 30px;">

				<div class="card-body">
					<h4 class="card-title" style="color: red;font-weight: 800;">Thông tin tài khoản</h4>
					<!-- <p class="card-text" style="margin-bottom: 20px;" >Tên đăng nhập</p> -->
					
					<p class="card-text" style="margin-bottom: 20px;" >Tên Đăng nhập: ${tendangnhap}</p>
					<!-- <p class="card-text" style="margin-bottom: 20px;" >Mật khẩu</p> -->
					
					<p class="card-text" style="margin-bottom: 20px;" >Mật Khẩu: ${matkhau}</p>
					
					<a href=<c:url value="/giangvien/thongtin/edit"/> class="btn btn-primary" style="margin-top: 87px;">Đổi mật khẩu</a>
				</div>
			</div>
			<div class="card" style="width: 300px; margin: 0 30px;">
				<img class="card-img-top" src="${URL}images/img_avatar1.png"
					alt="Card image">
			</div>
		</div>
	</div>
</body>
</html>