<%@page import="com.bc.model.vo.SearchVO"%><%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="JS/script.js"></script>

<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/QAstyle.css" rel="stylesheet" type="text/css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>동적검색결과</title>
</head>
<!-- <style>
	.onoff {display:none}
</style> -->
<body>

<%@include file="common/menu.jspf" %>
	<br><br>
<div id="page">
<%@include file="common/form.jspf" %>
<%@include file="common/search.jspf" %>	
</div>
</body>
</html>