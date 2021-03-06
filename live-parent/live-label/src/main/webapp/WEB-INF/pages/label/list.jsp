<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commons/public.jsp"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title></title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">

<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
<style>
body {
	padding-top: 50px;
	padding-bottom: 20px;
}
</style>
<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/css/bootstrap-theme.min.css">

<link rel="stylesheet" href="${ctx}/css/main.css">
<link rel="stylesheet" href="${ctx}/css/docs.css">
<script src="${ctx}/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
<script src="${ctx}/js/vendor/jquery-1.11.2.min.js"></script>
<script src="${ctx}/js/vendor/bootstrap.min.js"></script>
<script src="${ctx}/js/main.js"></script>
<script src="${ctx}/js/vendor/bootbox.js"></script>
<link rel="stylesheet"
	href="${ctx}/js/jquery/plugins/DataTables-1.10.2/media/css/jquery.dataTables.css">
<script
	src="${ctx}/js/jquery/plugins/DataTables-1.10.2/media/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="${ctx}/js/jquery-validation-1.13.1/jquery.validate.js"></script>
<script src="${ctx}/js/local/label/list.js"></script>
<script>
	$(function() {
		// 		Main.init();
		App.init();
	})
</script>

</head>
<body>
	<!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">PRAISE THE LORD</a>
			</div>

			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li data-toggle="tab"><a href="#"> 人间 </a></li>
					<li data-toggle="tab"><a href="#"> 天堂 </a></li>
					<li data-toggle="tab"><a href="#"> 地狱 </a></li>
				</ul>

				<form class="navbar-form navbar-right" role="form">
					<div class="form-group">
						<input type="text" placeholder="Email" class="form-control">
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" class="form-control">
					</div>
					<button type="submit" class="btn btn-success">Sign in</button>
				</form>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		<div class="container">
			<table
				class="table table-striped table-bordered table-hover table-full-width table-condensed"
				id="labelTablelist">
				<thead>
					<tr>
						<th>Document No</th>
						<th>Tracking No</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>

	<%@ include file="/WEB-INF/pages/commons/footer.jsp"%>
</body>
</html>
