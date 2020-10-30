<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="include/managerHeader.jsp" %>
<%
	String type = "classManage";
	String go = "classAdmin";
	String paging_str = (String)request.getAttribute("str");
	System.out.println("paging_str : " + paging_str);
	String sub = (String)request.getAttribute("sub");
%>
<%-- 관리자 강의 선택 페이지 --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>강의 목록</title>
	<link href="css/reset.css" rel="stylesheet" type= "text/css">
	<link href="css/style.css" rel="stylesheet" type= "text/css">
	<script>
		function insertClass(){
			location.href = "controller?type=insertClass"
		}
	</script>
</head>
<body>
	<header>
		<%@ include file="include/managerLoginInfo.jsp" %>
        
        <ol id="menu">
            <li><a href="managerCustomer.jsp">고객관리</a></li>
            <li class="active"><a href="controller?type=insertList">상품관리</a></li>
            <li><a href="ManagerController?type=getNotice&screenType=1">공지관리</a></li>
        </ol>
    </header>
    <section>
        <div class="content">
		<%@include file="common/classList.jspf" %>
		<div id="insertBottonArea">
			<input type="button" value="상품 추가" onclick="insertClass()">
		</div>
	 </div>
    </section>
</body>
</html>