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
								<i class="fa fa-globe"></i>Hội đồng
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


												<div class="form-group" hidden="hidden">
													<label for="UserID">Mã hội đồng:</label> <input type="text"
														name="mahoidong" value="${mahoidong}" id="mahoidong"
														class="form-control" readonly />
												</div>

												<div class="form-group" hidden="hidden">
													<label for="UserID">Trưởng hội dồng:</label> <input
														type="text" name="truonghoidong" value="${truonghoidong}"
														id="truonghoidong" class="form-control" readonly />
												</div>

												<table
													class="table table-striped table-bordered table-hover"
													id="sample_2">
													<!-- <table id="sample_2" class="table table-striped table-bordered table-hover" style="width: 100%"> -->
													<thead>
														<tr>
															<th>Danh sách thành viên</th>



														</tr>
													</thead>
													<tbody>

														<c:forEach var="item" items="${thamgiahoidongs}">
															<c:set var="mahoidong1" scope="session"
																value="${item.mahoidong}" />
															<c:if test="${mahoidong1 ==mahoidong}">


																<tr class="odd gradeX">

																	<td>${item.magiangvien}</td>

																</tr>
															</c:if>
														</c:forEach>
													</tbody>
												</table>


											</div>
										</div>
									</div>

									<div class="col-md-9" style="padding-right: 25px">
										<div class="row">
											Danh sách đề tài quản lý
											<table class="table table-striped table-bordered table-hover"
												id="sample_2">
												<!-- <table id="sample_2" class="table table-striped table-bordered table-hover" style="width: 100%"> -->
												<thead>
													<tr>

														<th>Tên đề tài</th>
														<th>Điểm</th>
														<th>Giảng viên hướng dẫn</th>

													</tr>
												</thead>
												<tbody>
													<c:forEach var="item" items="${detai}">
														<c:set var="mahoidong2" scope="session"
															value="${item.hoidong}" />

														<c:if test="${mahoidong2 ==mahoidong}">
															<tr class="odd gradeX">

																<td>${item.tendetai}</td>
																<td><c:if
																		test="${sessionScope.acc.username==truonghoidong }">
																		<c:forEach var="bangdiem" items="${bangdiem}">

																			<c:set var="diem" scope="session"
																				value="${bangdiem.madetai }" />

																			<c:if test="${bangdiem!=null  && bangdiem.madetai==item.madetai}">
																				<a>${bangdiem.diem }</a>
																			</c:if>
																			<c:if test="${diem==null }">
																				<label for="diemso">Đánh giá:</label>
																				<form action="#" method="post"
																					enctype="multipart/form-data">
																					<input type="text" class="form-control"
																						name="diemso" id="diemso" value="${diemso} " />

																					<button class="btn btn-success"
																						formaction="${pageContext.request.contextPath}/giangvien-hoidong/diem?madetai=${item.madetai}">
																						Luu <i class="fa fa-undo"></i>
																					</button>
																				</form>
																			</c:if>

																		</c:forEach>


																	</c:if> <c:if
																		test="${sessionScope.acc.username!=truonghoidong }">


																		<c:forEach var="bangdiem" items="${bangdiem}">

																			<c:set var="diem" scope="session"
																				value="${bangdiem.madetai}" />

																			<c:if test="${diem==item.madetai}">
																				<a>${bangdiem.diem }</a>


																			</c:if>
																		</c:forEach>


																	</c:if></td>
																<td>${item.giangvien}</td>

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