<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/managerHeader.jsp" %> 
<body class="login">

    <h1>
        <img src="img/managerLogin.png" width="100%" alt="">
    </h1>
    <div class="loginInfo">
        <form method = "post">
            <label for="id">ID</label>
            <input type="text" name="id" id="id" class="inputText" placeholder="아이디를 입력하세요.">
            <label for="pwd">PASSWORD</label>
            <input type="password" name="pwd" id="pwd" class="inputText" placeholder="비밀번호를 입력하세요.">     
            <input type="button" value="LOGIN" class="loginBtn" onclick="admin_login(this.form)">
            <span>본 페이지는 2BS 관리자 전용 페이지입니다.</span>
        </form>
    </div>
</body>
</html>