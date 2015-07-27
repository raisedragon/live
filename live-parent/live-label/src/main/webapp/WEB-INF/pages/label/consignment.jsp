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
<script type="text/javascript" src="${ctx}/js/jquery-validation-1.13.1/jquery.validate.js"></script>
<script src="${ctx}/js/local/label/consignment.js"></script>
<script>
	$(function(){
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
			<form id="consignmentForm" class="form-horizontal" role="form" >
				<div class="form-group">
					<label for="documentNo" class="control-label col-xs-2">Document No</label>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="documentNo" name="documentNo"  value="123456"
							placeholder="Document No">
					</div>

					<label for="logisticsCode" class="control-label col-xs-2">Logistics Type</label>
					<div class="col-xs-4">
						<select class="form-control" id="logisticsCode" name="logisticsCode" >
							<c:forEach items="${deliveryWays}" var="item">
								<option value="${item.code}">${item.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="bg-primary">Order Infomation</div>
				<div class="form-group">
					<label for="length" class="control-label col-xs-2">Length</label>
					<div class="col-xs-4">
						<input type="number" class="form-control" id="length" name="length" value="1">
					</div>
					<label for="width" class="control-label col-xs-2">Width</label>
					<div class="col-xs-4">
						<input type="number" class="form-control" id="width" name="width"  value="1">
					</div>
					<label for="height" class="control-label col-xs-2">height</label>
					<div class="col-xs-4">
						<input type="number" class="form-control" id="height" name="height"  value="1">
					</div>
					<label for="weight" class="control-label col-xs-2">Weight</label>
					<div class="col-xs-4">
						<input type="number" class="form-control" id="weight" name="weight" value="1">
					</div>
				</div>

				<div class="bg-primary">Consigee Infomation</div>
				<div class="form-group">
					<label for="name" class="control-label col-xs-2">name</label>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="name" name="name" value="tom">
					</div>
					<label for="countryCode" class="control-label col-xs-2">countryCode</label>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="countryCode" name="countryCode" value="GB">
					</div>
					<label for="state" class="control-label col-xs-2">state</label>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="state" name="state" value="london">
					</div>
					<label for="city" class="control-label col-xs-2">city</label>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="city" name="city"  value="london">
					</div>
					<label for="address1" class="control-label col-xs-2">address1</label>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="address1" name="address1"  value="london">
					</div>
					<label for="address2" class="control-label col-xs-2" >address2</label>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="address2" name="address2">
					</div>
					<label for="postcode" class="control-label col-xs-2">postcode</label>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="postcode" name="postcode"  value="0000">
					</div>
					<label for="houseNo" class="control-label col-xs-2">houseNo</label>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="houseNo" name="houseNo">
					</div>
					<label for="phone" class="control-label col-xs-2">phone</label>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="phone" name="phone">
					</div>
					<label for="email" class="control-label col-xs-2">email</label>
					<div class="col-xs-4">
						<input type="email" class="form-control" id="email" name="email">
					</div>
				</div>
				<div class="bg-primary">Product Infomation</div>
				<div class="form-group">
					<div class="col-xs-11"></div>
					<div class="col-xs-1">
						<a class="pull-right" id="addProduct" href="#">添加产品</a>
					</div>
				</div>
				<div class="form-group">
				<div class="col-xs-10"></div>
					<div class="col-xs-1">
						<button type="reset" class="btn btn-default">Reset</button>
					</div>
					<div class="col-xs-1">
						<button name="save" type="button" class="btn btn-default">Submit</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<div id="template" style="display: none">
		<div id="template-product-form-group">
			<div class="form-group self-product-info" >
				<label for="productName" class="control-label col-xs-2">name</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" name="productName">
				</div>
				<label for="productLength" class="control-label col-xs-2">Length</label>
				<div class="col-xs-4">
					<input type="number" class="form-control" name="productLength">
				</div>
				<label for="productWidth" class="control-label col-xs-2">Width</label>
				<div class="col-xs-4">
					<input type="number" class="form-control" name="productWidth">
				</div>
				<label for="productHeight" class="control-label col-xs-2">height</label>
				<div class="col-xs-4">
					<input type="number" class="form-control" name="productHeight">
				</div>
				<label for="productWeight" class="control-label col-xs-2">Weight</label>
				<div class="col-xs-4">
					<input type="number" class="form-control" name="productWeight">
				</div>
				<label for="productValue" class="control-label col-xs-2">Value</label>
				<div class="col-xs-4">
					<input type="number" class="form-control" name="productValue">
				</div>
				<label for="productSku" class="control-label col-xs-2">Sku</label>
				<div class="col-xs-4">
					<input type="number" class="form-control" name="productSku">
				</div>
				<label for="productQuantity" class="control-label col-xs-2">Quantity</label>
				<div class="col-xs-4">
					<input type="number" class="form-control" name="productQuantity">
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/pages/commons/footer.jsp"%>
</body>
</html>
