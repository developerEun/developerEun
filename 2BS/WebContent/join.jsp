<%@page import="com.bc.model.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="com.bc.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//List<MemberVO> list = MemberDAO.getList4();
	String result = "0";
	result = request.getParameter("result");
	System.out.println("result : " + result);
	pageContext.setAttribute("result", result);

%>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   	<%@include file="common/memberHead.jspf" %>
    <link rel="stylesheet" href="css/Join.css">
    <title>JOIN</title>
    <script>

     $().ready(function(){
    	 var check = $('.check').val();
    	 if(check == 1){
	    	 alert('이미 존재하는 id 입니다');
    	 } else if(check== 2) {
    		 alert('이미 존재하는 전화번호 입니다');
    	 }else{
    		 
    	 }
    	$('.join').click(function(){
    		var id = $('.id').val();
	    	var pwd = $('.pwd').val();
	    	var re_pwd = $('.re_pwd').val();
	    	var name = $('.name').val();
	    	var phone = $('.phone').val();
	    	var s_t = $("input[name='s_t']:checked").val();
	    	if(id == ""){
	    		 alert("ID를 입력하세요");
	    		 $(this).siblings('.id').focus();
	    	}else if(pwd ==""){
	    		alert("비밀번호를 입력하세요");
	    		 $(this).siblings('.pwd').focus();
	    	}else if(name ==""){
	    		alert("이름을 입력하세요");
	    		 $(this).siblings('.name').focus();
	    	}else if(phone ==""){
	    		alert("전화번호를 입력하세요");
	    		 $(this).siblings('.phone').focus();	 
	    	}else{
		     	if(pwd!=re_pwd){
		    		alert("비밀번호를 확인하세요.");
		    	}else{
			    	location.href="membercontroller?type=join&id="+id+"&pwd="+pwd+"&name="+encodeURI(name)+"&phone="+phone+"&s_t="+s_t;
		    	}
	    	}
    	});
    });  
    
    </script>
</head>
<body>
	<%@include file="common/menu.jspf" %>
    <nav class="join_a">
        <form method="post" enctype="multipart/form-data">
	        <div class="main_menu">
	        <p>회원가입</p>
			<input type="radio" id="s_t" name="s_t" checked value="s" >학생&nbsp;&nbsp;&nbsp;
	        <input type="radio" id="s_t" name="s_t" value="t" >선생님
	        <label for="id">아이디</label><input type="text" class="id" id="id" name="id" placeholder = "아이디">
	        <label for="pwd">비밀번호</label><input type="password" class="pwd" id="pwd" name="pwd" placeholder = "비밀번호">
	        <label for="re_pwd">비밀번호 재확인</label><input type="password" class="re_pwd" id="re_pwd" name="re_pwd" placeholder = "비밀번호 재확인">
	        <label for="name">이름</label><input type="text" class="name" id="name" name="name" placeholder = "이름">
	        <label for="phone">휴대전화</label><input type="tel" class="phone" id="phone" name="phone" placeholder = "전화번호">
	        <input type="hidden" class="check" value="${result}">
	        <button type="button" class="join">가입하기</button> 
	        </div>
        </form>
    </nav>
</body>
</html>