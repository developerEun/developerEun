<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="common/menu.jspf" %>
</head>
<body>
	<form action="QAcontroller" method="get">
		<input type="hidden" name="id" value="sun">
		<input type="hidden" name="t_code" value="102">
		<input type="hidden" name="type" value="sugangDetail">
		 
		<input type="submit" value="detail"> 
	</form>
</body>
</html>