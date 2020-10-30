<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	session.setAttribute("teacherList", request.getAttribute("list"));
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>강의 추가 페이지</title>
	<link href="css/reset.css" rel="stylesheet" type= "text/css">
	<link href="css/style.css" rel="stylesheet" type= "text/css">
	<script>
		function insertClass(frm) {
			var firstForm = document.forms[0];
			for(var i = 0; i<firstForm.elements.length; i++){
				if(i==4) continue;
				if(firstForm.elements[i].value.trim() == ""){
					alert(firstForm.elements[i].title +"을 입력해주세요.");
					firstForm.elements[i].value = "";
					firstForm.elements[i].focus();
					return;
				}
			}
			
			frm.action ="controller?type=addClass";
			frm.submit();
		}
		
		function goClassAdmin(){
			location.href="controller?type=insertList";
		}
	</script>
</head>
<body>
	<form name="frm" id="upReview" method="post" enctype="multipart/form-data">
		<h1>상품 추가</h1>
		<table>
			<tr>
				<th>과목</th>
				<td>
					<select name="code" id="code" title="과목">
						<option value="" selected disabled>선택</option>
						<option value=0>국어</option>
						<option value=1>수학</option>
						<option value=2>영어</option>
						<option value=3>사탐</option>
						<option value=4>과탐</option>
					</select>
				</td>
				<th>강사</th>
				<td>
					<select name="teacher" id="teacher" title="강사">
						<option value="" selected disabled>선택</option>
						<c:forEach var="tea" items="${list }">
							<option value="${tea.member_num }">${tea.name }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>가격</th>
				<td colspan="3">
					<input type="number" id="price" name="price" title="가격"/>원
				</td>
			</tr>
			<tr>
				<th>수업명</th>
				<td colspan="3">
					<input type="text" id="su_name" name="su_name" title="수업명"/>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="file" name="img"/>
				</td>
			</tr>
		</table>
		<div id="ButtonArea"> 
		<input type="button" value="저장" onclick="insertClass(this.form)" >
		<input type="reset" value="초기화">
		<input type="button" value="목록으로" onclick="goClassAdmin()">
		</div>
	</form>


</body>
</html>