<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>수업 상세 페이지</title>
	<%@include file="common/memberHead.jspf" %>
	<link href="css/style.css" rel="stylesheet" type= "text/css">
	<script>
		function go_classList() {
			location.href = "controller?type=classList";
		}
		function update_review(re_num) {
			location.href = "controller?type=updReview&su_num=${detail.su_num }&re_num=" + re_num;
		}
		function delete_review(re_num) {
			var isDelete = confirm("정말 삭제하시겠습니까?");
			if(isDelete){
				location.href = "controller?type=delReview&admin=N&su_num=${detail.su_num }&re_num=" + re_num;
			} else {
				return;
			}
		}
		function insertReview(frm) {
			if(frm.content.value.trim() == ""){
				alert("내용을 입력해주세요!");
				frm.content.value="";
				frm.content.focus();
				return;
			} 
			
			frm.action = "controller?type=writeReview&su_num=${detail.su_num }";
			frm.submit();
		}
		function insertCart(su_num){
			if("${isInCart}" >= 1){
				var goCart = confirm("이미 장바구니에 담긴 상품입니다.\n장바구니로 가시겠습니까?");
				if(goCart){ //장바구니로 가기
					location.href = "controller?type=myCart"; //장바구니 목록 불러오는 컨트롤러로 이동
				}else{ //원래 페이지로 돌아가기
					location.href = "controller?type=classDetail&su_num=${su_num }";
				}
			}else if("${isOrdered}" >= 1){ 
				alert("이미 구매하신 상품입니다!");
				return;
			}else{
				location.href = "controller?type=insertCart&su_num=" + su_num;
			}
		}
		
		
	</script>
</head>
<body>
	<%@include file="common/menu.jspf" %>	
	<div class="allWrap">
		<h1 class="title">${detail.su_name }</h1>
		<table class="detailTable">
			<colgroup>
				<col width="10%">
				<col width="40%">
				<col width="10%">
				<col width="40%">
			</colgroup>
			<tbody>
				<tr>
					<th>강의명</th>
					<td colspan="3">${detail.su_name }</td>
				</tr>
				<tr>
					<th>수강번호</th>
					<td>${detail.su_num}</td>
					<th>강사</th>
					<td>${detail.name}</td>
				</tr>
				<tr>
					<th>등록일</th>
					<td>${detail.su_date}</td>
					<th>가격</th>
					<td>${detail.price}</td>
				</tr>
				<tr>
					<td colspan="4" id="tableImg">
						<img src="img/${detail.img}"/>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4">
						<input type="button" value="담기" onclick="insertCart(${detail.su_num})"/>
						<input type="button" value="목록" onclick="go_classList()"/>
					</td>
				</tr>
			</tfoot>
		</table>
		<!-- 리뷰작성하기 -->
		<h3 class="reviewTitle">리뷰 작성하기</h3>
		<form method="post" id="form">
			<table class="writeReview">
				<tbody>
					<tr>
						<th>평점</th>
						<td>
							<select name="grade">
								<option value="5">5점</option>
								<option value="4">4점</option>
								<option value="3">3점</option>
								<option value="2">2점</option>
								<option value="1">1점</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td id="textArea">
							<textarea name ="content" id="content" rows="8" cols="50"></textarea>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="button" value="저장" onclick="insertReview(this.form)">
							<input type="reset" value="다시작성">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
		<!-- 리뷰게시판 -->
		<h3 class="reviewTitle">리뷰 게시판</h3>
		<table id="review_space">
			<tbody>
				<c:forEach var="review" items="${reList }">
					<tr><td>
						<table class="review">
							<tr class="review_tr1">
								<th class="review_th">번호</th>
								<td class="review_td_num">${review.re_num }</td>
								<th>평점</th>
								<td class="review_td_grade">${review.re_grade }</td>
								<td class="review_td">${review.re_date }</td>
								<th>작성자</th>
								<td class="review_td3">${review.id }</td>
							</tr>
							<tr class="review_tr2">
								<c:choose>
									<c:when test="${member == review.member_num }">
										<td colspan="5" class="review_td2">${review.re_content }</td>
										<td class="review_td" colspan="2">
											<input type="button" value="수정" onclick="update_review(${review.re_num})">
											<input type="button" value="삭제" onclick="delete_review(${review.re_num})">
										</td>
									</c:when>
									<c:otherwise>
										<td colspan="6">${review.re_content }</td>
									</c:otherwise>
								</c:choose>
							</tr>
						</table>
					</td></tr>
				</c:forEach>
			</tbody>
			<tfoot id="paging">
				<tr>
					<td colspan = "6">
						<ol class="paging">
							<c:choose>
								<c:when test="${rpvo.beginPage == 1 }">
									<li class= "disable">이전</li>
								</c:when>
								<c:otherwise>
									<li>
										<a href="controller?type=classDetail&su_num=${detail.su_num }&cPage=${rpvo.beginPage -1}">이전</a>
									</li>
								</c:otherwise>
							</c:choose>
								
							<%-- 블록 내에 표시할 페이지 태그 작성(시작페이지~끝페이지) --%>
							<c:forEach var="pageNo" begin="${rpvo.beginPage }" end="${rpvo.endPage }">
								<c:choose>
									<c:when test="${pageNo == rpvo.nowPage }">
										<li class="now">${pageNo }</li>
									</c:when>
									<c:otherwise>
										<li>
											<a href="controller?type=classDetail&su_num=${detail.su_num }&cPage=${pageNo }">${pageNo }</a>
										</li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
								
							<c:choose>
								<%-- 사용불가(disable) --%>
								<c:when test="${rpvo.endPage >= rpvo.totalPage }">
									<li class="disable">다음</li>
								</c:when>
								<c:otherwise>
									<li><a href="controller?type=classDetail&su_num=${detail.su_num }&cPage=${rpvo.endPage + 1 }">다음</a><li>
								</c:otherwise>
							</c:choose>	
						</ol>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>