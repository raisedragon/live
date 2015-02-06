<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Organization Management System</title>
<%@include file="../commons/imports.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<tiles:insertAttribute name="header"></tiles:insertAttribute>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span3">
				<tiles:insertAttribute name="menu"></tiles:insertAttribute>
			</div>
			<div class="span9">
				<tiles:insertAttribute name="body"></tiles:insertAttribute>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span12">
				<tiles:insertAttribute name="footer"></tiles:insertAttribute>
			</div>
		</div>
	</div>
</body>
</html>