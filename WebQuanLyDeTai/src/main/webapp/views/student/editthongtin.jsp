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
								<i class="fa fa-globe"></i> Tài khoản
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
												
													<br />
													</div>
														<div class="form-group">
														<label for="loaidetai"> Mật Khẩu cũ:</label> <input
															type="text" class="form-control" name="loaidetai"
															value="${matkhaucu}" id="loaidetai" />
													</div>
													
													
													<	<div class="form-group">
														<label for="loaidetai">Mật khẩu mới:</label> <input
															type="text" class="form-control" name="loaidetai"
															value="${matkhaumoi}" id="loaidetai" />
													</div>
													<br />
													<hr>
													<div class="form-group">

														<a
																href="<c:url value='/student/thongtin/update'/>"
																class="center">update</a>
														

													</div>
												
											</div>
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