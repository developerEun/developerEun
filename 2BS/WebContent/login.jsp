<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LOGIN</title>
	<%@include file="common/memberHead.jspf" %>
    <link rel="stylesheet" href="css/Login.css">
    <script>
	function loginUser(frm) {
		frm.action="membercontroller?type=login";
		frm.submit();
	}
	</script>
</head>
<%@include file="common/menu.jspf" %>
<body>
    <nav class="login_a">
		<form method = "post">    	   
	        <div class="main_menu">
	        <p>로그인</p>
	        <label for="id">아이디</label><input type="text" id="id" name="id" placeholder ="아이디를 입력하세요">
	        <label for="pwd">비밀번호</label><input type="password" id="pwd" name="pwd" placeholder = "비밀번호를 입력하세요">
	        <button type="button" onclick="loginUser(this.form)" class="loginBtn">LOGIN</button>
	        <div class="loginBtnBox">
		        <button type="button" id="id_f" onclick="location.href = 'findId.jsp'">ID 찾기</button>
		        <button type="button" id="pwd_f" onclick="location.href = 'findPassword.jsp'">비밀번호 찾기</button>	        
	        </div>
	        </div>
	     </form>   
    </nav>
</body>
</html>