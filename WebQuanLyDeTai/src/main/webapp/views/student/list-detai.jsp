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
								<i class="fa fa-globe"></i>Danh Sách Đề Tài
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
								<%-- <%@include file="/common/info.jsp"%> --%>
								<!-- Kết thúc hiển thị thông báo -->

								<c:if test="${message != null}">

									<div class="alert alert-primary" role="alert">

										<i>${message}</i>

									</div>

								</c:if>

								<div class="form-group" hidden="hidden">
									<label for="UserID">loaidetai:</label> <input type="text"
										name="loaidetai" value="${loaidetai}" id="loaidetai"
										class="form-control" readonly />
								</div>




								<div class="col-md-9" style="padding-right: 25px">
									<div class="row">
										<table class="table table-striped table-bordered table-hover"
											id="sample_2">
											<!-- <table id="sample_2" class="table table-striped table-bordered table-hover" style="width: 100%"> -->
											<thead>
												<tr>
													<th>Tên đề tài</th>
													<th>Loai đề tài</th>
													<th>Chuyên ngành</th>
													<th>Số lượng sinh viên</th>
													<th>Giảng viên hướng dẫn</th>

													<th></th>


												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${detais}">
													<tr class="odd gradeX">

														<td><a
															href="<c:url value='/student-detai/detail?madetai=${item.madetai}'/>"
															class="center">${item.tendetai}</a></td>
														<td>${item.loaidetai}</td>
														<td>${item.chuyennganh}</td>
														<td>${item.soluongsv}</td>
														<td><c:forEach var="giangvien" items="${giangviens}">
																<c:if test="${item.giangvien==giangvien.magiangvien}">
															${giangvien.ten}
															</c:if>
															</c:forEach></td>



														<td><a
															href="<c:url value='/student-detai/register?madetai=${item.madetai}'/>"
															class="center">Đăng ký</a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>


										Danh sách đề tài đã đăng ký <br>

										<div class="col-md-9" style="padding-right: 25px">
											<div class="row">
												<table
													class="table table-striped table-bordered table-hover"
													id="sample_2">
													<!-- <table id="sample_2" class="table table-striped table-bordered table-hover" style="width: 100%"> -->
													<thead>
														<tr>
															<th>Tên đề tài</th>
															<th>Loai đề tài</th>
															<th>Chuyên ngành</th>
															<th>Số lượng sinh viên</th>
															<th>Giảng viên hướng dẫn</th>

															<th></th>


														</tr>
													</thead>
													<tbody>
														<c:forEach var="item" items="${detaidk}">
															<c:forEach var="bangdiem" items="${detaidangky}">
																<tr class="odd gradeX">

																	<c:if
																		test="${item.madetai==bangdiem.madetai && bangdiem.masinhvien==sessionScope.acc.username }">


																		<td>${item.tendetai}</td>
																		<td>${item.loaidetai}</td>
																		<td>${item.chuyennganh}</td>
																		<td>${item.soluongsv}</td>
																		<td><c:forEach var="giangvien"
																				items="${giangviens}">
																				<c:if
																					test="${item.giangvien==giangvien.magiangvien}">
															${giangvien.ten}
															</c:if>
																			</c:forEach></td>



																		<td><a
																			href="<c:url value='/student-detai/xoadangky?madetai1=${item.madetai}'/>"
																			class="center">xoá đăng ký</a></td>
																	</c:if>
																</tr>
															</c:forEach>
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
</body>
</html>