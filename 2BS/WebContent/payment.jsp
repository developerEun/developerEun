<%@page import="com.bc.model.vo.CartVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>결제 페이지</title>
   	<%@include file="common/memberHead.jspf" %>
	<link href="css/style.css" rel="stylesheet" type= "text/css">
	<style>
		table, th, td{ border: 1px solid black;}
	</style>
	<script>
		function doPayment(frm){
			var firstForm = document.forms[0];
			for(var i=0; i<firstForm.elements.length; i++){
				if(firstForm.elements[i].value.trim() == ""){
					
					if(i==1){ 
						alert(firstForm.elements[i].title + "를 선택해주세요.");
					}else {
						alert(firstForm.elements[i].title + "을 입력해주세요.");
					}
					
					firstForm.elements[i].value="";
					firstFrom.elements[i].focus();
					return;
				}
				
				if(i>=4 && i<=7){
					if(firstForm.elements[i].value.length < 4 || firstForm.elements[i].value.length > 4){
						alert("카드 번호(16자리)를 입력해주세요.");
						firstForm.elements[i].value="";
						firstFrom.elements[i].focus();
						return;
					}
				}
				
				if(i>=8 && i<=9){
					if(firstForm.elements[i].value.length <2 || firstForm.elements[i].value.length >2){
						alert("카드 유효기간(월/년 각 2자리)를 모두 입력해주세요.");
						firstForm.elements[i].value="";
						firstFrom.elements[i].focus();
						return;
					}
				}
				
				if(i==10){
					if(firstForm.elements[i].value.length<6 || firstForm.elements[i].value.length>6){
						alert("생년월일(YYMMDD)를 모두 입력해주세요.");
						firstForm.elements[i].value="";
						firstFrom.elements[i].focus();
						return;
					}
				}
				
			}
			
			frm.action ="controller?type=doPayment"
			frm.submit();
		}
	</script>
</head>
<body>
	<%@include file="common/menu.jspf" %>
	<form name="frm" id="paymentForm" method="post">
	<h1 class="cartTitle">결제하기</h1>
		<table> <!-- 결제 목록 보여주는 테이블 -->
			<tr>
				<th>No</th>
				<th>상품명</th>
				<th>가격</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td class="fifteencenter">${vo.su_num }</td>
					<td>
						<a href="controller?type=classDetail&su_num=${vo.su_num }&cPage=1">${vo.su_name }</a>
					</td>
					<td class="thirtyright">${vo.price }원</td>
				</tr>
			</c:forEach>
		</table>
		총 결제 예상 금액 : <input type="text" id="totalPrice" value="${totalPrice }" readonly> 원
		<table class="pay"> <!-- 결제할 카드 정보 입력받을 테이블 -->
			<tr>
				<th>카드사 선택</th>
				<td>
					<select name="cardCompany" title="카드사">
						<option value="" selected disabled>선택</option>
						<option value=0>국민</option>
						<option value=1>비씨</option>
						<option value=2>신한</option>
						<option value=3>현대</option>
						<option value=4>삼성</option>
						<option value=5>롯데</option>
						<option value=6>외환</option>
						<option value=7>NH</option>
						<option value=8>하나</option>
						<option value=9>우리</option>
						<option value=10>광주</option>
						<option value=11>수협</option>
						<option value=12>씨티</option>
						<option value=13>전북</option>
						<option value=14>제주</option>
						<option value=15>카카오뱅크</option>
						<option value=16>케이뱅크</option>
						<option value=16>기타</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>할부기간</th>
				<td>
					<select name="Installment" title="할부기간">
						<option value=0 selected>일시불</option>
						<option value=2>2개월</option>
						<option value=3>3개월</option>
						<option value=4>4개월</option>
						<option value=5>5개월</option>
						<option value=6>6개월</option>
						<option value=7>7개월</option>
						<option value=8>8개월</option>
						<option value=9>9개월</option>
						<option value=10>10개월</option>
						<option value=11>11개월</option>
						<option value=12>12개월</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>카드 주 이름</th>
				<td>
					<input class="name" type="text" name="name" title="카드 주 이름">
				</td>
			</tr>
			<tr>
				<th>카드번호</th>
				<td>
					<input type="number" class="card" size=4 maxlength="4" name="card1" title="카드번호">-
					<input type="number" class="card" size=4 maxlength="4" name="card2" title="카드번호">-
					<input type="number" class="card" size=4 maxlength="4" name="card3" title="카드번호">-
					<input type="number" class="card" size=4 maxlength="4" name="card4" title="카드번호">
				</td>
			</tr>
			<tr>
				<th>유효기간</th>
				<td>
					<input type="number" class="date" size=2 maxlength=2 name="cartMM" title="유효기간(월)">월/
					<input type="number" class="date" size=2 maxlength=2 name="cartYY" title="유효기간(년)">년
				</td>
			</tr>
			<tr>
				<th>생년월일 앞자리(ex: 780101)</th>
				<td>
					<input type="number" class="birth" maxlength=6 size=6 name="birth" title="생년월일">
				</td>
			</tr>
		</table>
		<div id="paybuttonArea">
		<input type="button" value="결제하기" onclick="doPayment(this.form)"> 
		</div>
	</form>
</body>
</html>