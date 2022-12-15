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
								<i class="fa fa-globe"></i>Chi tiết đề tài
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


									<div class="form-group" hidden="hidden">
										<label for="UserID">:</label> <input type="text" name="detai"
											value="${detai}" id="detai" class="form-control" readonly />
									</div>

									<div class="col-md-9" style="padding-right: 25px">
										<div class="row">
											<table class="table table-striped table-bordered table-hover"
												id="sample_2">
												<!-- <table id="sample_2" class="table table-striped table-bordered table-hover" style="width: 100%"> -->
												<thead>
													<tr>
														<th></th>
														<th></th>

													</tr>
												</thead>
												<tbody>

													<tr class="odd gradeX">


														<td>Tên đề tài</td>
														<td>${detai.tendetai}</td>
													</tr>

													<tr class="odd gradeX">


														<td>Số lượng cho phép</td>
														<td>${detai.soluongsv}</td>
													</tr>

													<tr class="odd gradeX">


														<td>Số lượng đã đăng ký</td>
														<td>${soluong}</td>

													</tr>
													<tr class="odd gradeX">


														<td>Được phép đăng ký</td>
														<td>${dangky}</td>

													</tr>

													<tr class="odd gradeX">


														<td>Danh sách sinh viên đăng ký</td>
														<td><c:forEach var="danhsach" items="${danhsach}">
														${danhsach.masinhvien } - ${danhsach.ten}													
														<br>
															</c:forEach></td>

													</tr>
													<tr class="odd gradeX">


														<td>Nhóm trưởng</td>
														<td>${nhomtruong.masinhvien } - ${nhomtruong.ten}</td>

													</tr>
													

													<tr class="odd gradeX">


														<td>Chuyên ngành</td>
														<td>${detai.chuyennganh}</td>

													</tr>


													<tr class="odd gradeX">


														<td>Loại đề tài</td>
														<td>${detai.loaidetai}</td>

													</tr>


													<tr class="odd gradeX">


														<td>Điểm đề tài</td>
														<td>${diem}</td>

													</tr>
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