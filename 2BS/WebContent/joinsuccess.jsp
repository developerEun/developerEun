<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String id = request.getParameter("id");
		pageContext.setAttribute("id", id);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="common/menu.jspf" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Thank you</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/Joinsuccess.css">

</head>
<body>
    <div class="main">
        
        <p class="text_title">가입을 축하합니다.</p>
        <p class="text_box">
            <span id="text1">${id}</span>
            <span id="text2"> 님</span>
        </p>
        <p class="button_a">
           <a href="test.jsp">메인 페이지로 이동</a>
        </p>
    </div>
</body>
</html>