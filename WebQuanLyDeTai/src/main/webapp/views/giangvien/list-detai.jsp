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
								<i class="fa fa-globe"></i>Quản lý Đề Tài
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
														<label for="madetai">Mã đề tài:</label> <input type="text"
															name="madetai" value="${madetai}" id="madetai"
															class="form-control" readonly />
													</div>

													<div class="form-group" hidden="hidden">
														<label for="giangvien">GiangVien:</label> <input
															type="text" name="giangvien"
															value="${giangvien = sessionScope.acc.username}"
															id="madetai" class="form-control" readonly />
													</div>


													<div class="form-group">
														<label for="tendetai">Tên đề tài:</label> <input
															type="text" class="form-control" name="tendetai"
															id="tendetai" value="${tendetai}" />
													</div>

													Loại đề tài <label class="dropdown-menu">Loại đề
														tài: </label> <select id="dropdownMenuButton1" name="loaidetai">
														<c:forEach items="${thongbaos}" var="thongbao">
															<option class="dropdown-item"
																value="${thongbao.loaidetai}">${thongbao.loaidetai}</option>
														</c:forEach>
													</select> <br>


													<%-- <div class="form-group">
														<label for="loaidetai">Loại đề tài:</label> <input
															type="text" class="form-control" name="loaidetai"
															value="${loaidetai}" id="loaidetai" />
													</div> --%>

													<div class="dropdown">
														Chuyên ngành <label class="dropdown-menu">Chuyên
															ngành: </label> <select id="dropdownMenuButton1"
															name="chuyennganh" value="${chuyennganh}">
															<option class="dropdown-item" value="cong nghe phan mem">Công
																nghệ phần mềm</option>
															<option class="dropdown-item" value="He thong thong tin">Hệ
																thống thông tin</option>
															<option class="dropdown-item"
																value="mang va an ninh mang">Mạng và an ninh
																mạng</option>
															<option class="dropdown-item" value="tri tue nhan tao">Trí
																tuệ nhân tạo</option>
														</select> <br> <br>

													</div>
													<div class="form-group">
														<label for="soluongsv">Số lượng sinh viên:</label> <input
															type="text" class="form-control" name="soluongsv"
															id="soluongsv" value="${soluongsv}" />
													</div>


													<br />
													<hr>
													<div class="form-group">
														<button class="btn green"
															formaction="<c:url value="/giangvien-detai/create"/>">
															Create <i class="fa fa-plus"></i>
														</button>
														<button class="btn btn-warning"
															formaction="<c:url value="/giangvien-detai/update"/>">
															Update <i class="fa fa-edit"></i>
														</button>
														<br /> <br />
														<button class="btn btn-danger"
															formaction="<c:url value="/giangvien-detai/delete"/>">
															Delete <i class="fa fa-trash"></i>
														</button>
														<button class="btn btn-success"
															formaction="${pageContext.request.contextPath}/giangvien-detai/reset">
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
														<th>Tên đề tài</th>
														<th>Loai đề tài</th>
														<th>Chuyên ngành</th>
														<th>Số lượng sinh viên</th>
														<th>Giảng viên hướng dẫn</th>
														<th>Hành động</th>
														<th>Tình trạng</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="item" items="${detais}">
														<tr class="odd gradeX">

															<td><a
																href="<c:url value='/giangvien-detai/detail?madetai=${item.madetai}'/>"
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
																href="<c:url value='/giangvien-detai/edit?madetai=${item.madetai}'/>"
																class="center">Edit</a> | <a
																href="<c:url value='/giangvien-detai/delete?madetai=${item.madetai}'/>"
																class="center">Delete</a></td>

															<td><c:if test="${item.tinhtrang==0}">
																Chưa duyệt
																</c:if> <c:if test="${item.tinhtrang==1}">
																Đã duyệt
																</c:if></td>
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