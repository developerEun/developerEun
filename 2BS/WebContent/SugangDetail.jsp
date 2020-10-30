<%@page import="com.bc.model.vo.MemberVO"%>
<%@page import="com.bc.model.vo.QAVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="common/memberHead.jspf" %>
<script src="JS/script.js"></script>

<link href="css/QAstyle.css" rel="stylesheet" type="text/css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${su_name }</title>
</head>
<body>
<%@include file="common/menu.jspf" %>
<div id=page>
<%@include file="common/form.jspf" %>
<%@include file="common/search.jspf" %>	
</div>
<br><br><br><br><br><br>
</body>
</html>