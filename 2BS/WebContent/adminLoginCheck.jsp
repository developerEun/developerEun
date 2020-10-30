<%@page import="com.bc.model.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%

 	String check = "정보가 일치하지 않습니다."; 
    pageContext.setAttribute("check", check);
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<script type="text/javascript">
	alert("${check}");
	location.href="MemberLogin.jsp";
</script>
</head>
<body>

</body>
</html>