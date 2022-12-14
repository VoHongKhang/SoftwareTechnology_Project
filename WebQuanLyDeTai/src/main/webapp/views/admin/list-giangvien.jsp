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
	<div class="page-content-wrapper"
		style="margin-left: 40px; margin-right: 40px;">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN EXAMPLE TABLE PORTLET-->
					<div class="portlet box grey-cascade">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-globe"></i>Quản lý Giảng Viên
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
														<label for="magiangvien">Mã giảng viên:</label> <input
															type="text" name="magiangvien"
															value="${giangvien.magiangvien}" id="magiangvien"
															class="form-control"/>
													</div>
													<div class="form-group">
														<label for="ten">Họ và tên:</label> <input type="text"
															class="form-control" name="ten" id="ten"
															value="${giangvien.ten}" />
													</div>
													<div class="form-group">
														<label for="namsinh">Năm sinh:</label> <input type="text"
															class="form-control" name="namsinh"
															value="${giangvien.namsinh}" id="namsinh" />
													</div>
													<div class="form-group">
														<label for="email">Email:</label> <input type="text"
															class="form-control" name="email" id="email"
															value="${giangvien.email}" />
													</div>
													<div class="form-group">
														<label for="chuyennganh">Chuyên ngành:</label> <input
															type="text" class="form-control" name="chuyennganh"
															id="chuyennganh" value="${giangvien.chuyennganh}" />
													</div>
													<div class="form-group">
														<label for="phanquyen">Chức vụ:
															<div>0. Giảng viên</div>
															<div>1. Trưởng bộ môn</div>


														</label> <input type="text" class="form-control" name="phanquyen"
															id="phanquyen" value="${giangvien.latruongbomon}" />
													</div>
													<br />
													<hr>
													<div class="form-group">
														<button class="btn green"
															formaction="<c:url value="/admin-giangvien/create"/>">
															Create <i class="fa fa-plus"></i>
														</button>
														<button class="btn btn-warning"
															formaction="<c:url value="/admin-giangvien/update"/>">
															Update <i class="fa fa-edit"></i>
														</button>
														<br /> <br />
														<button class="btn btn-danger"
															formaction="<c:url value="/admin-giangvien/delete"/>">
															Delete <i class="fa fa-trash"></i>
														</button>
														<button class="btn btn-success"
															formaction="${pageContext.request.contextPath}/admin-giangvien/reset">
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
														<th>Mã giảng viên</th>
														<th>Tên</th>
														<th>Năm sinh</th>
														<th>Email</th>
														<th>Chuyên ngành</th>
														<th>Chức vụ</th>
														<th>Hành động</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="item" items="${giangviens}">
														<tr class="odd gradeX">
	
															<td>${item.magiangvien}</td>
															<td>${item.ten}</td>
															<td>${item.namsinh}</td>
															<td>${item.email}</td>
															<td>${item.chuyennganh}</td>
															<td><c:if test="${item.latruongbomon == 0}">
																	<span class="label label-sm label-success">Giảng
																		viên</span>
																</c:if> <c:if test="${item.latruongbomon == 1}">
																	<span class="label label-sm label-warning">Trưởng
																		bộ môn</span>
																</c:if></td>
															<td><a
																href="<c:url value='/admin-giangvien/edit?magiangvien=${item.magiangvien}'/>"
																class="center">Edit</a> | <a
																href="<c:url value='/admin-giangvien/delete?magiangvien=${item.magiangvien}'/>"
																class="center">Delete</a></td>
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