<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<%@include file="common/memberHead.jspf" %>
    <link rel="stylesheet" href="css/noticeCommon.css">
    <script src="js/sendData.js"></script>
    <script src="js/notice.js"></script>
    <title>Notice</title>
</head>

<body>
	<%@include file="common/menu.jspf" %>
    <div class="noticeWrap">
        <h1>공지사항</h1>
        <table class="notice">
            <colgroup>
                <col width="10%"/>
                <col width="5%"/>
                <col width="35%"/>
                <col width="10%"/>
                <col width="25%"/>
                <col width="15%"/>
            </colgroup>
            <thead>
                <tr>
                    <th></th>
                    <th>No</th>
                    <th>제목</th>
                    <th>첨부파일</th>
                    <th>작성일</th>
                    <th>작성자</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="importNotice" items="${importList }">
	                <tr class="importNotice">
						<c:choose>
							<c:when test="${importNotice.not_type == '긴급' }">
								<td><span class="noticeType red">${importNotice.not_type }</span></td>
							</c:when>
							<c:when test="${importNotice.not_type == '변경' }">
								<td><span class="noticeType orange">${importNotice.not_type }</span></td>
							</c:when>
							<c:when test="${importNotice.not_type == '신청' }">
								<td><span class="noticeType blue">${importNotice.not_type }</span></td>
							</c:when>
						</c:choose>	                	
	                    <td>${importNotice.r_num }</td>
	                    <td>
		                    <a href="CustomerController?type=detailNotice&rNum=${importNotice.r_num }&notNum=${importNotice.not_num }" class="noticeTitle">${importNotice.not_name }</a>
	                    </td>
						<c:if test="${empty importNotice.not_file }">
							<td></td>
						</c:if>
						<c:if test="${not empty importNotice.not_file }">
							<td><a href="file/${importNotice.not_file_ori }" download><img src="img/fileRed.png" alt="첨부파일" height="100%"></a></td>
						</c:if>		                
	                    <td>${importNotice.not_date }</td>
	                    <td>${importNotice.member_name } 선생님</td>
	                </tr>
            	</c:forEach>
            	<c:forEach var="notice" items="${list }">
	                <tr>
						<c:choose>
							<c:when test="${notice.not_type == '긴급' }">
								<td><span class="noticeType red">${notice.not_type }</span></td>
							</c:when>
							<c:when test="${notice.not_type == '변경' }">
								<td><span class="noticeType orange">${notice.not_type }</span></td>
							</c:when>
							<c:when test="${notice.not_type == '신청' }">
								<td><span class="noticeType blue">${notice.not_type }</span></td>
							</c:when>
						</c:choose>	                	
	                    <td>${notice.r_num }</td>
	                    <td>
		                    <a href="CustomerController?type=detailNotice&rNum=${notice.r_num }&notNum=${notice.not_num }" class="noticeTitle">${notice.not_name }</a>
	                    </td>
						<c:if test="${empty notice.not_file }">
							<td></td>
						</c:if>
						<c:if test="${not empty notice.not_file }">
							<td><a href="file/${notice.not_file_ori }" download><img src="img/file.png" alt="첨부파일" height="100%"></a></td>
						</c:if>		                    
	                    
	                    
	                    <td>${notice.not_date }</td>
	                    <td>${notice.member_name } 선생님</td>
	                </tr>
            	</c:forEach>
            </tbody>
        </table>
        <div class="searchWrap">
        	<form class="searchForm" method="post">
	        	<select name="idx">
	        		<option value="0">NO</option>
	        		<option value="1">제목</option>
	        		<option value="2">작성자</option>
	        	</select>
		       	<input type="text" name="keyword" placeholder="글번호를 입력해주세요">
		       	<input type="button" onclick="searchGo(this.form);">  
        	</form>
        </div>
        <div class="paging">
			<ol>
				<c:choose>
					<c:when test="${pvo.beginPage == 1}">
						<li class="disable prev">
							<img src="img/left_arrow.png" alt="이전">
						</li>
					</c:when>
					<c:otherwise>
						<li class="prev">
							<a href="CustomerController?type=getNotice&cPage=${pvo.beginPage-1}"><img src="img/left_arrow.png" alt="이전"></a>
						</li>
					</c:otherwise>
				</c:choose>
				<%-- 블록내에 표시할 페이지 태그 작성(시작페이지~끝페이지) --%>
				<c:forEach var="pageNo" begin="${pvo.beginPage}" end="${pvo.endPage}">
					<c:choose>
						<c:when test="${pageNo == pvo.nowPage }">
							<li class="active"><a href="#">${pageNo}</a></li>
						</c:when>
						<c:otherwise>
							<li>
								<a href="CustomerController?type=getNotice&cPage=${pageNo}">${pageNo}</a>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<%-- 사용불가(disable) --%>
					<c:when test="${pvo.endPage >= pvo.totalPage }">
						<li class="disable next"><img src="img/right_arrow.png" alt="다음"></li>
					</c:when>
					<c:otherwise>
						<li class="next">
							<a href="CustomerController?type=getNotice&cPage=${pvo.endPage + 1}"><img src="img/right_arrow.png" alt="다음"></a>
						</li>
					</c:otherwise>
				</c:choose>
			</ol>
        </div>
    </div>
</body>
</html>