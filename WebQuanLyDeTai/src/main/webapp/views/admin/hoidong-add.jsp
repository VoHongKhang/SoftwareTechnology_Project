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
													<div class="form-group" hidden="hidden">
														<label for="UserID">Mã hội đồng:</label> <input
															type="text" name="mahoidong" value="${mahoidong}"
															id="mahoidong" class="form-control" readonly />
													</div>

													<label for="truonghoidong" class="form-lablel">
														Danh sách giảng viên: </label> <br>
													<div class="dropdown">

														<label class="dropdown-menu">Danh sách giảng viên:
														</label> <select id="dropdownMenuButton1" name="truonghoidong">
															<c:forEach items="${giangvien}" var="giangvien">
																<option class="dropdown-item"
																	value="${giangvien.magiangvien}">${giangvien.ten}</option>
															</c:forEach>
														</select> <br>

													</div>
													<div class="form-group">
														<button class="btn green"
															formaction="<c:url value="/admin-hoidong/add"/>">
															Add Trưởng hội đồng <i class="fa fa-plus"></i>
														</button>
													</div>

													<br />
													<div class="form-group">
														<button class="btn green"
															formaction="<c:url value="/admin-hoidong/addthanhvien"/>">
															Thêm thành viên hội đồng <i class="fa fa-plus"></i>
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
														<th>Danh sách thành viên</th>
														<th></th>


													</tr>
												</thead>
												<tbody>

													<c:forEach var="item" items="${thamgiahoidongs}">
														<c:set var="mahoidong1" scope="session"
															value="${item.mahoidong}" />
														<c:if test="${mahoidong1 ==mahoidong}">


															<tr class="odd gradeX">

																<td><c:forEach var="giangvien"
																		items="${giangviens}">
																		<c:if test="${item.magiangvien==giangvien.magiangvien}">
															${giangvien.ten}
															</c:if>
																	</c:forEach></td>

																<td><a
																	href="<c:url value='/admin-hoidong/deletethanhvien?ma=${item.magiangvien}'/>"
																	class="center">Delete</a></td>
															</tr>
														</c:if>
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