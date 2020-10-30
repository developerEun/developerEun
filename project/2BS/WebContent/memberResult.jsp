<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/memberlist.css">
<title>Insert title here</title>
</head>
<body>
	    <h1>member List</h1>
    
    <table class = "member_table" border = "solid 1px black" >
		<thead class="title">
		 	<tr>	
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>전화번호</td>
				<td>ST</td>
				<td>t_code</td>
			</tr>	
		</thead>		
		<tbody class="table_body">
		<c:forEach var="membervo" items="${list}">
			<tr class="element">
				<td>${membervo.id}</td>
				<td>${membervo.pwd}</td>
				<td>${membervo.name}</td>
				<td>${membervo.phone}</td>
				<td>${membervo.s_t}</td>
				<td>${membervo.t_code}</td>
			</tr>
		</c:forEach>
		</tbody>
		<tfoot class ="table_boot">
			<tr>	
				<td colspan="6">
					<ol class="paging">
					<c:choose><%--[이전으로]에 대한 사용여부처리 --%>
						<%--사용불가(disable) 또는 안보이게(hidden) : 첫번째 블록인 경우 --%>
						<c:when test="${pvo.beginPage == 1}">
							<li class="disable">이전으로</li>
						</c:when>
						<c:otherwise>
							<li>
								<a href="membercontroller?type=member&keyword=${searchvo.keyword }&idx=${searchvo.idx }&cPage=${pvo.beginPage - 1 }">이전으로</a>
							</li>
						</c:otherwise>
					</c:choose>
					<%-- 블록내에 표시할 페이지 태그 작성(시작페이지~끝페이지) --%>	
					<c:forEach var="pageNo" begin="${pvo.beginPage }" end="${pvo.endPage }">
					<c:choose>
						<c:when test="${pageNo == pvo.nowPage }">
							<li class="now">${pageNo }</li>
						</c:when>
						<c:otherwise>
							<li>
								<a href="membercontroller?type=member&keyword=${searchvo.keyword }&idx=${searchvo.idx }&cPage=${pageNo }">${pageNo }</a>
							</li>
						</c:otherwise>
					</c:choose>
					</c:forEach>
						
					<c:choose><%--[다음으로]에 대한 사용여부처리 --%>
						<%--사용불가(disable) 또는 안보이게(hidden) : 마지막 블록인 경우
							endPage가 전체페이지수와 같거나 큰 경우 --%>
						<c:when test="${pvo.endPage >= pvo.totalPage }">
							<li class="disable">다음으로</li>
						</c:when>
						<c:otherwise>
							<li><a href="membercontroller?type=member&keyword=${searchvo.keyword }&idx=${searchvo.idx }&cPage=${pvo.endPage + 1 }">다음으로</a></li>
						</c:otherwise>
					</c:choose>
					</ol>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>