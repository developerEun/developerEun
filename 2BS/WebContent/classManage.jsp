<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("teacherList", request.getAttribute("list"));
%>
<%@ include file="include/managerHeader.jsp" %>


<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>수업 상세 페이지</title>
	<link href="css/reset.css" rel="stylesheet" type= "text/css">
	<link href="css/style.css" rel="stylesheet" type= "text/css">
	<script src="//code.jquery.com/jquery.min.js"></script>
	<script>
		$().ready(function(){
			$("#teacher option").each(function(){
				if(this.value == "${detail.member_num }"){
					$(this).attr("selected", true);				
				}				
			});
		});
	
		function updateDetail(frm){
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
			
			frm.action="controller?type=updateClass"
			frm.submit();
		}
		function deleteClass(){
			var isDelete = confirm("정말 삭제하시겠습니까?");
			if(isDelete) {
				location.href= "controller?type=classDelete&su_num=${detail.su_num}";
			} else {
				return;
			}
			
		}
		
		function goList(){
			location.href = "controller?type=insertList";
		}
		
		function delete_review(re_num) {
			var isDelete = confirm("정말 삭제하시겠습니까?");
			if(isDelete){
				location.href = "controller?type=delReview&admin=Y&su_num=${detail.su_num }&re_num=" + re_num;
			} else {
				return;
			}
		}
		
	</script>
</head>
<body>
 <header>
		<%@ include file="include/managerLoginInfo.jsp" %>
        
        <ol id="menu">
            <li><a href="managerCustomer.jsp">고객관리</a></li>
            <li class="active"><a href="controller?type=insertList">상품관리</a></li>
            <li><a href="ManagerController?type=getNotice&screenType=1">공지관리</a></li>
        </ol>
    </header>
    <section>
        <div class="content">
	<h1 class="title">${detail.su_name } 수정페이지</h1>
	<form name="frm" method="post" enctype="multipart/form-data">
	<table class="detailTable">
		<tbody>
			<tr>
				<th>강의명</th>
				<td colspan="3">
					<input type="text" name="su_name" value="${detail.su_name }"/>
				</td>
			</tr>
			<tr>
				<th>수강번호</th>
				<td>
					<input type="text" class="center" name="su_num" value="${detail.su_num}" readonly />
				</td>
				<th>강사</th>
				<td>
					<select name="teacher" id="teacher">
						<c:forEach var="vo" items="${list }">
							<option value="${vo.member_num }">${vo.name }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td class="center">${detail.su_date}</td>
				<th>가격</th>
				<td>
					<input type="text" class="right" name="price" value="${detail.price}"/> 원
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="file" name="img" value="${detail.img}"/>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4">
					<input type="button" value="수정" onclick="updateDetail(this.form)"/>
					<input type="button" value="삭제" onclick="deleteClass()"/>
					<input type="button" value="목록" onclick="goList()"/>
				</td>
			</tr>
		</tfoot>
	</table>
	</form>
	<hr>
	<!-- 리뷰게시판 -->
	<table id="review_space">
		<caption>리뷰게시판</caption>
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
							<td colspan="6" class="review_td2">${review.re_content }</td>
							<td class="review_td">
								<input type="button" value="삭제" onclick="delete_review(${review.re_num})">
							</td>
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
							<c:when test="${rpvo.beginPage ==1 }">
								<li class= "disable">이전</li>
							</c:when>
							<c:otherwise>
								<li>
									<a href="controller?type=classDetail&su_num=${detail.su_num }&manage=classManage.jsp&cPage=${rpvo.beginPage -1}">이전</a>
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
										<a href="controller?type=classDetail&su_num=${detail.su_num }&manage=classManage.jsp&cPage=${pageNo }">${pageNo }</a>
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
								<li><a href="controller?type=classDetail&su_num=${detail.su_num }&manage=classManage.jsp&cPage=${rpvo.endPage + 1 }">다음</a><li>
							</c:otherwise>
						</c:choose>	
					</ol>
				</td>
			</tr>
		</tfoot>
	</table>
        </div>
    </section>
</body>
</html>