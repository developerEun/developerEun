<%@page import="com.bc.model.vo.SugangVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	String type = "classDetail";
	String go = "classList";
	String paging_str = (String)request.getAttribute("str");
	System.out.println("paging_str : " + paging_str);
	String sub = (String)request.getAttribute("sub");
	SugangVO sugang = new SugangVO();
	sugang.getSu_num();
%>
<%-- 강의 선택 페이지 --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>강의 목록</title>
	<%@include file="common/memberHead.jspf" %>
	<link href="css/style.css" rel="stylesheet" type= "text/css">
</head>
<body>
	<%@include file="common/menu.jspf" %>
	<%@include file="common/QAClassList.jspf" %>
</body>
</html>