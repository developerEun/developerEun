<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<%@include file="common/menu.jspf" %>
<meta charset="UTF-8">
<title>임시페이지</title>
<script>
	function get_class(frm) {  //학생용 
		frm.action = "controller?type=classList";
		frm.submit(); 
	}
	
	function insert_class(frm) {   //관리자 페이지
		frm.action = "controller?type=insertList";
		frm.submit();
	}
	
	function go_Cart (frm) {
		frm.action = "controller?type=myCart";
		frm.submit();
	}
	
</script>
</head>
<body>

	<h1>임시페이지</h1>
	<form method="post">
		<input type="button" value="상품 보기" onclick="get_class(this.form)">
		<input type="button" value="상품 추가" onclick="insert_class(this.form)">
		<input type="button" value="장바구니로 가기" onclick="go_Cart(this.form)">
	</form>

	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>








