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


	<div class="page-content-wrapper" style="margin: 0 180px;">
		<div class="page-content">
			<div class="row">
				<div class="col">
					<form action="" method="get" enctype="multipart/form-data">
						<br />
						<div class="form-group">
							<label for="title" style="font-size: 24px; font-weight: 600;">Tên
								đề tài:</label> <input type="text" class="form-control" name="tendetai"
								id="tendetai" />
						</div>
						<br />
						<hr>
						<div class="form-group">
							<button class="btn green" style="background-color: #17a65b;"
								formaction="<c:url value="/student-detai/search"/>">
								Search <i class="fa fa-search"></i>
							</button>
						</div>
					</form>
				</div>
			</div>
			<div class="row">
				<table class="table table-striped table-bordered table-hover"
					style="margin-top: 20px;" id="sample_2">
					<thead>
						<tr>

							<th>Tên đề tài</th>
							<th>Loại đề tài</th>
							<th>Số lượng sinh viên</th>
							<th>Giảng viên hướng dẫn</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${detais}">
							<tr class="odd gradeX">

								<td>${item.tendetai}</td>
								<td>${item.loaidetai}</td>
								<td>${item.soluongsv}</td>
								<td>${item.giangvien}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>


</body>
</html>