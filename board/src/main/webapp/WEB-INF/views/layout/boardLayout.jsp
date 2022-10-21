<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
	
	<!-- Jquery -->
	<script src="/resources/js/jquery3.3.1.min.js"></script>
	
	<!-- vue -->
	<script src="/resources/js/vue/lodash.js"></script>
	<script src="/resources/js/vue/vue.js"></script>
	<script src="/resources/js/vue/vue-pagination.min.js"></script>
	<link rel="stylesheet" href="/resources/css/reset.css">
	<link rel="stylesheet" href="/resources/css/board.css">
	<title>게시판 예제</title>
</head>
<body style="text-align: center;">
	<tiles:insertAttribute name="header" ignore="true"></tiles:insertAttribute>
	<tiles:insertAttribute name="body" ignore="true"></tiles:insertAttribute>
</body>
</html>