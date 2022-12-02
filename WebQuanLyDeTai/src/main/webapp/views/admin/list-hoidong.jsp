<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url value="/templates/" var="URL"></c:url>
<!DOCTYPE html>
<html lang="fr">
<head>
<!-- Site meta -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>QLDT</title>

<!-- CSS -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600"
	rel="stylesheet" type="text/css">

<link href="${URL}css/styles.css" rel="stylesheet" type="text/css">

</head>
<body>
	<div class="page-content-wrapper" style="margin-left: 40px; margin-right: 40px;">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN EXAMPLE TABLE PORTLET-->
					<div class="portlet box grey-cascade">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-globe"></i>Quản lý Hội Đồng
							</div>
							<div class="tools">
								<a href="javascript:;" class="collapse"> </a> <a
									href="#portlet-config" data-toggle="modal" class="config">
								</a> <a href="javascript:;" class="reload"> </a> <a
									href="javascript:;" class="remove"> </a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-toolbar">
								<!-- Hiển thị thông báo -->
								<%@include file="/common/info.jsp"%>
								<!-- Kết thúc hiển thị thông báo -->
								<div class="row">
									<div class="col-md-3">
										<div class="row">
											<div class="col-md-9">
												<form action="#" method="post" enctype="multipart/form-data">
													<br />

													<div class="form-group">
														<label for="mahoidong">Mã hội đồng:</label> <input
															type="text" name="mahoidong"
															value="${hoidong.mahoidong}" id="mahoidong"
															class="form-control"/>
													</div>
													<div class="form-group">
<<<<<<< HEAD
														<label for="tenhoidong">Tên hội đồng:</label> <input type="text"
															class="form-control" name="tenhoidong" id="tenhoidong"
															value="${hoidong.tenhoidong}" />
=======
														<label for="username">Tên tài khoản:</label> <input type="text"
															class="form-control" name="username" id="username"
															value="${taikhoan.username}" />
>>>>>>> 5a5fd0d1e4feaf4ab33ce42197ed0bfe6359c1f2
													</div>
													

													<br />
													<hr>
													<div class="form-group">
														<button class="btn green"
<<<<<<< HEAD
															formaction="<c:url value="/admin-hoidong/create"/>">
															Create <i class="fa fa-plus"></i>
														</button>
														<button class="btn btn-success"
															formaction="${pageContext.request.contextPath}/admin-hoidong/reset">
=======
															formaction="<c:url value="/admin-taikhoan/create"/>">
															Create <i class="fa fa-plus"></i>
														</button>
														<button class="btn btn-success"
															formaction="${pageContext.request.contextPath}/admin-taikhoan/reset">
>>>>>>> 5a5fd0d1e4feaf4ab33ce42197ed0bfe6359c1f2
															Reset <i class="fa fa-undo"></i>
														</button>

													</div>
												</form>
											</div>
										</div>
									</div>

									<div class="col-md-9" style="padding-right: 25px">
										<div class="row">
											<table class="table table-striped table-bordered table-hover"
												id="sample_2">
												<!-- <table id="sample_2" class="table table-striped table-bordered table-hover" style="width: 100%"> -->
												<thead>
													<tr>
<<<<<<< HEAD
														<th>Mã hội đồng</th>
														<th>Tên hội đồng</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="item" items="${hoidongs}">
														<tr class="odd gradeX">

															<td>${item.mahoidong}</td>
															<td>${item.tenhoidong}</td>
															
=======
														<th>Tên tài khoản</th>
														<th>Mật khẩu</th>
														<th>Quyền</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="item" items="${taikhoans}">
														<tr class="odd gradeX">

															<td>${item.username}</td>
															<td>${item.password}</td>
															
															<td>
															<c:if test="${item.phanquyen == 0}">
																<span class="label label-sm label-success">Admin </span>
															</c:if> 
															<c:if test="${item.phanquyen == 1}">
																<span class="label label-sm label-warning">Trưởng bộ môn</span>
															</c:if>
															<c:if test="${item.phanquyen == 2}">
																<span class="label label-sm label-warning">Giảng viên</span>
															</c:if>
															<c:if test="${item.phanquyen == 3}">
																<span class="label label-sm label-warning">Sinh viên</span>
															</c:if>
															</td>
															
														<td>
>>>>>>> 5a5fd0d1e4feaf4ab33ce42197ed0bfe6359c1f2
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
					<!-- END EXAMPLE TABLE PORTLET-->
				</div>
			</div>
		</div>
	</div>
</body>
</html>