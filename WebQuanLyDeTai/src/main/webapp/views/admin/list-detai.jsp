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
<title>Quản lý đề tài</title>

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
								<i class="fa fa-globe"></i>Quản lý đề tài
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
														<label for="id">Mã đề tài:</label> <input type="text"
															name="id" value="${detai.id}" id="id"
															class="form-control" readonly />
													</div>
													<div class="form-group">
														<label for="username">Tên đề tài:</label> <input
															type="text" class="form-control" name="tendetai"
															id="tendetai" value="${detai.tendetai}" />
													</div>
													<div class="form-group">
														<label for="password">Loại đề tài: </label> <input
															type="text" class="form-control" name="loaidetai"
															value="${detai.loaidetai}" id="loaidetai" />
													</div>
													<div class="form-group">
														<label for="password">Số lượng sinh viên </label> <input
															type="text" class="form-control" name="soluongsv"
															value="${detai.soluongsv}" id="soluongsv" />
													</div>

													<div class="form-group">
														<label for="password">Giảng viên </label> <input
															type="text" class="form-control" name="giangvien"
															value="${detai.giangvien}" id="giangvien" />
													</div>


													<br />
													<hr>
													<div class="form-group">
														<button class="btn green"
															formaction="<c:url value="/admin-detai/create"/>">
															Create <i class="fa fa-plus"></i>
														</button>
														<button class="btn btn-danger"
															formaction="<c:url value="/admin-detai/delete"/>">
															Delete <i class="fa fa-trash"></i>
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
														<th>Tên Đề tài</th>
														<th>Loại đề tài</th>
														<th>Số lượng sinh viên</th>
														<th>Giảng viên</th>
														<th>Hành động</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="item" items="${detais}">
														<tr class="odd gradeX">

															<td>${item.tendetai}</td>
															<td>${item.loaidetai}</td>
															<td>${item.soluongsv}</td>
															<td>${item.giangvien}</td>
															<td><a
																href="<c:url value='/admin-detai/edit?madetai=${item.madetai}'/>"
																class="center">Edit</a> | <a
																href="<c:url value='/admin-detai/delete?madetai=${item.madetai}'/>"
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