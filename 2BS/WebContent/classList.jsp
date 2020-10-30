<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	String type = "classDetail";
	String go = "classList";
	String paging_str = (String)request.getAttribute("str");
	System.out.println("paging_str : " + paging_str);
	String sub = (String)request.getAttribute("sub");
	pageContext.setAttribute("paging_str", paging_str);
%>
<%-- 강의 선택 페이지 --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>강의 목록</title>
	<%@include file="common/memberHead.jspf" %>
	<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<%@include file="common/menu.jspf" %>
	<%@include file="common/classList.jspf" %>
</body>
</html>