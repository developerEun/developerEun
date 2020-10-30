<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
   <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Member Profile</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/member.css">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <script>
      function member(frm) {
    	frm.action="membercontroller?type=member";
    	frm.submit();
    } 
    
    
    </script>
</head>
<body>
    <div class="main"> 
        <form method = "post">
            <h1>회원조회</h1>
        <div class="search_a"> 
            <select name="idx" class="idx">
                <option value="1">이름</option>
                <option value="2">아이디</option>
                <option value="3">전화번호</option>
                <option value="4">과목코드</option>
                <option value="5">전체조회</option>
            </select>
                <input type="text" name="keyword" class="keyword"  placeholder="검색어를 입력하세요">
                <button type="button" id="button" onclick="member(this.form)"><i class="fas fa-search"></i></button>
                              
        </div>
        </form>  
    </div>    
</body>
</html>