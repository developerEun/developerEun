<%@page import="com.bc.model.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="com.bc.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String result = "0";
	result = request.getParameter("result");
	System.out.println("result : " + result);
	pageContext.setAttribute("result", result);
%>    
<!DOCTYPE html>
<html lang="en">
<head>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<%@include file="common/memberHead.jspf" %>
    <title>FIND PASSWORD</title>
    <link rel="stylesheet" href="css/Join.css">
    <script>
	    $().ready(function() {
	    	var id_namecheck = $('.id_namecheck').val();
	    	if(id_namecheck == 1) {
	    		alert('ID/이름을 확인하세요');
	    	}
	  		
			$('.findPassword').click(function(){
				var id = $(this).siblings('#id').val();
		    	var name = $(this).siblings('#name').val();
		    	if(id == ""){
		    		 alert("ID를 입력하세요");
		    		 $(this).siblings('#id').focus();
				}else if(name ==""){
		    		alert("이름을 입력하세요");
		    		 $(this).siblings('#name').focus(); 
			    }else{
				   	location.href="membercontroller?type=find_p&id="+id+"&name="+encodeURI(name);
			    }
			});
		});
	    
    </script>
	    
</head>
<body>
	<%@include file="common/menu.jspf" %>
    <nav class="login_a">   
     	<form method = "post">
	        <div class="main_menu">
	        <p>비밀번호 찾기</p>
	        <label for="id">아이디</label><input type="text" id="id" name="id" placeholder = "아이디">
	        <label for="name">이름</label><input type="text" id="name" name="name" placeholder = "이름">
	        <input type = "hidden" class = "id_namecheck" value="${result}">
	        <button type="button" class ="findPassword">비밀번호 찾기</button>
	    	</div>
	    </form>
	 </nav>   
</body>
</html>