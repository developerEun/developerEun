<%@page import="com.bc.model.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="com.bc.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	String result = "0";
	result = request.getParameter("result");
	pageContext.setAttribute("result", result);
%>    
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="common/memberHead.jspf" %>
<script>
    $().ready(function() {
    	var name_phonecheck = $('.name_phonecheck').val();
    	if(name_phonecheck == 1) {
    		alert('이름/전화번호를 확인하세요');
    	}
  		
		$('.findId').click(function(){
	    	var name = $(this).siblings('#name').val();
			var phone = $(this).siblings('#phone').val();
	    	if(name == ""){
	    		 alert("이름을 입력하세요");
	    		 $(this).siblings('#name').focus();
			}else if(phone ==""){
	    		alert("전화번호를 입력하세요");
	    		 $(this).siblings('#phone').focus(); 
		    }else{
			   	location.href="membercontroller?type=find_id&name="+encodeURI(name)+"&phone="+phone;
		    }
		});
	});
    
</script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FIND ID</title>
    <link rel="stylesheet" href="css/Join.css">
    
</head>
<body>
	<%@include file="common/menu.jspf" %> 
    <nav class="login_a">   
     	<form method = "post">
	        <div class="main_menu">
	        <p>ID 찾기</p>
	        <label for="name">이름</label><input type="text" id="name" name="name" placeholder = "이름">
	        <label for="phone">휴대전화</label><input type="text" id="phone" name="phone" placeholder = "전화번호">
	        <input type = "hidden" class = "name_phonecheck" value = "${result}">
	        <button type="button" class ="findId">ID 찾기</button>
	    	</div>
	    </form>
	 </nav>   
</body>
</html>