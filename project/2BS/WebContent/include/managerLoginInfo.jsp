<%@page import="com.bc.model.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%


	/* session.setAttribute("login", null); */
	MemberVO manager = (MemberVO) session.getAttribute("login");
	if(manager != null){
		session.setAttribute("manager", manager);
	}else{
		
	}

%>
	

<div class="title">
    <img src="img/teacher.png" alt="">
		<c:if test= '${login != null }'>
    	<p>${manager.name } 선생님<br>안녕하세요.</p>
		<a href="MemberLogin.jsp">LOGOUT</a> 
		</c:if>		
    
</div>