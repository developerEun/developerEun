<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>결제 결과</title>
   	<%@include file="common/memberHead.jspf" %>
	<link href="css/style.css" rel="stylesheet" type= "text/css">
	<script>
		function go_list(){
			location.href = "controller?type=classList";
		}
	</script>
</head>
<body>
	<%@include file="common/menu.jspf" %>
	<div id="payment_ok">
	<c:choose>
		<c:when test="${result == 1 }">
			<h1 class="cartTitle">결제되었습니다!</h1>
			<table>
				<c:forEach var="vo" items="${list }">
					<tr>
						<td class="first">${vo.su_num }</td>
						<td>
							<a href="controller?type=classDetail&su_num=${vo.su_num }&cPage=1">${vo.su_name }</a>
						</td>
						<td class="price">${vo.price }원</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1>결제에 실패했습니다!</h1>
			<p>관리자에게 문의해주세요.</p>
		</c:otherwise>
	</c:choose>
	<input type="button" value="목록으로 " onclick="go_list()">
	</div>
</body>
</html>