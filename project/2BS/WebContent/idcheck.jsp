<%@page import="com.bc.model.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  	MemberVO member1 = (MemberVO) request.getAttribute("find_id");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Find ID</title>
   	<%@include file="common/memberHead.jspf" %>
    <link rel="stylesheet" href="css/Joinsuccess.css">
	<title>Insert title here</title>
</head>
<body>

</head>
<body>
	<%@include file="common/menu.jspf" %> 
    <div class="main">
        
        <p class="text_title">회원님의 아이디는</p>
        <p class="text_box">
            <span id="text1"><%=member1.getId() %></span>
            <span id="text2"> 입니다.</span>
        </p>
        <p class="button_a">
            <button id="button1" type="button"> <a href="main.jsp">메인 페이지로 이동</a></button>
        </p>
    </div>
</body>
</html>
</body>
</html>