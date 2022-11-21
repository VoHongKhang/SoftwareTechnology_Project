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
<title>Free Bootstrap 4 Ecommerce Template</title>

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
	<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN EXAMPLE TABLE PORTLET-->
					<div class="portlet box grey-cascade">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-globe"></i>Quản lý Sinh Viên
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

													<div class="form-group" hidden="hidden">
														<label for="UserID">Mã sinh viên:</label> <input
															type="text" name="categoryId"
															value="${sinhvien.masinhvien}" id="categoryId"
															class="form-control" readonly />
													</div>
													<div class="form-group">
														<label for="ten">Họ và tên:</label> <input type="text"
															class="form-control" name="ten" id="ten"
															value="${sinhvien.ten}" />
													</div>
													<div class="form-group">
														<label for="namsinh">Năm sinh:</label> <input type="text"
															class="form-control" name="namsinh"
															value="${sinhvien.namsinh}" id="namsinh" />
													</div>
													<div class="form-group">
														<label for="khoahoc">Khóa học:</label> <input type="text"
															class="form-control" name="khoahoc" id="khoahoc"
															value="${sinhvien.khoahoc}" />
													</div>
													<div class="form-group">
														<label for="chuyennganh">Chuyên ngành:</label> <input
															type="text" class="form-control" name="chuyennganh"
															id="chuyennganh" value="${sinhvien.chuyennganh}" />
													</div>

													<br />
													<hr>
													<div class="form-group">

														<button class="btn btn-warning"
															formaction="<c:url value="/admin-sinhvien/update"/>">
															Update <i class="fa fa-edit"></i>
														</button>
														<button class="btn btn-success"
															formaction="${pageContext.request.contextPath}/admin-sinhvien/reset">
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
														<th>Tên</th>
														<th>Năm sinh</th>
														<th>Khóa học</th>
														<th>Chuyên ngành</th>
														<th>Hành động</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="item" items="${sinhviens}">
														<tr class="odd gradeX">

															<td>${item.ten}</td>
															<td>${item.namsinh}</td>
															<td>${item.khoahoc}</td>
															<td>${item.chuyennganh}</td>
															<td><a
																href="<c:url value='/admin-sinhvien/edit?masinhvien=${item.masinhvien}'/>"
																class="center">Edit</a>
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