<%@page import="com.bc.model.vo.CartVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>내 장바구니</title>
	<%@include file="common/memberHead.jspf" %>
	<link href="css/style.css" rel="stylesheet" type= "text/css">
	<script>
		$(function(){
			var total = 0;
			$("#selectAll").change(function(){
				if(this.checked){
					$(".price").prop("checked", true);
					
					$(".price").each(function(){
						var price = $(this).attr("data-index");
						total += parseInt(price);
					})
					
					$("#totalPrice").val(total);
					
				} else {
					$(".price").prop("checked", false);
					
					total = 0;
					$("#totalPrice").val(total);
				}
			});
			
			$(".price").change(function(){
				var price = $(this).attr("data-index");
				if(this.checked){
					total += parseInt(price);
				} else {
					total -= parseInt(price);
				}
				
				$("#totalPrice").val(total);
			});
		});
		
		function deleteCart(cart_num){
			location.href = "controller?type=deleteCart&cart_num=" + cart_num;
		}
		
		
		function doPayment(frm){
			/* 장바구니에 아무것도 선택되지 않았으면 넘어가지 못하게 하기 */
			frm.action = "controller?type=payment";
			frm.submit();
		}
	</script>
</head>
<body>
   	<%@include file="common/menu.jspf" %>
	<form id="tableSpace" name="tableSpace" method="post">
		<h1 class="cartTitle">내 장바구니</h1>
		<table id="cart"> 
			<tr>
				<th class="ten">No</th>
				<th>상품명</th>
				<th class="twenty">가격</th>
				<th class="five"><input type="checkbox" name="selectAll" id="selectAll"/></th>
				<th class="cartDelete"> </th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td class="center">${vo.su_num }</td>
					<td>
						<a href="controller?type=classDetail&su_num=${vo.su_num }&cPage=1">${vo.su_name }</a>
					</td>
					<td class="center">${vo.price }</td>
					<td class="center">
						<input type="checkbox" data-index="${vo.price }" value="${vo.cart_num }" class="price" name="cart_num"/>
					</td>
					<td class="center">
						<input type="button" value="삭제" onclick="deleteCart(${vo.cart_num})"/>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div id="totalArea">
		총 결제 예상 금액 : <input type="text" id="totalPrice" value="0" readonly>원
		<input type="button" id="paybutton" value="결제하기" onclick="doPayment(this.form)"> 
		</div>
	</form>
</body>
</html>