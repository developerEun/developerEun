<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>리뷰 수정</title>
   	<%@include file="common/memberHead.jspf" %>
	<link href="css/style.css" rel="stylesheet" type= "text/css">
	<script>
		$().ready(function(){
			$("#grade option").each(function(){
				if(this.value == "${review.re_grade}"){
					$(this).attr("selected", true);				
				}				
			});
		});
		
		function upd_review(frm){
			if(frm.content.value.trim() != ""){
				frm.action = "controller?type=doUpdateReview&su_num=${review.su_num }&re_num=${review.re_num}";
				frm.submit();
			}else{
				alert("내용을 입력해주세요.");
				frm.content.value="";
				frm.content.focus();
				return false;
			}
		}
		
		function go_back(){
			history.back();
		}
		
	</script>
</head>
<body>
	<%@include file="common/menu.jspf" %>
	<form name="frm" id="upReview" method="post">
		<h1>리뷰 수정</h1>
		<table>
			<tbody>
				<tr>
					<th class="ten">번호</th>
					<td class="ten">${review.re_num }</td>
					<th class="ten">평점</th>
					<td class="ten">
						<select name="grade" id="grade">
							<option value="5">5점</option>
							<option value="4">4점</option>
							<option value="3">3점</option>
							<option value="2">2점</option>
							<option value="1">1점</option>
						</select>
					</td>
					<td>${review.id }</td>
					<td class="twenty">${review.re_date }</td>
				</tr>
				<tr>
					<td colspan="5">
						<textarea name="content" rows="4" cols="50">${review.re_content }</textarea> 
					</td>
					<td>
						<input type="button" value="저장" onclick="upd_review(this.form)">
						<input type="button" value="취소" onclick="go_back()">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>