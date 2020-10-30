<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/managerHeader.jsp" %>
<body>
    <header>
		<%@ include file="include/managerLoginInfo.jsp" %>
        <ol id="menu">
            <li><a href="managerCustomer.jsp">고객관리</a></li>
            <li><a href="controller?type=insertList">상품관리</a></li>
            <li class="active"><a href="ManagerController?type=getNotice&screenType=1">공지관리</a></li>
        </ol>
    </header>
    <section>
        <div class="content">
		    <div class="noticeWrap">
		        <%@ include file="include/noticeDetailInfo.jsp" %>
		        <div class="preview">
		        	<div>
						<c:if test="${empty prevNotice.not_name }">
			        		<img src="img/left_arrow.png" alt="이전">
			        		이전 글 <span class="bar">|</span>이전글이 없습니다.
						</c:if>
						<c:if test="${not empty prevNotice.not_name }">
			        		<a href="CustomerController?type=detailNotice&screenType=1&rNum=${prevNotice.r_num }&notNum=${prevNotice.not_num}">
				        		<img src="img/left_arrow.png" alt="이전">
				        		이전 글 <span class="bar">|</span>${prevNotice.not_name }        		
			        		</a>
						</c:if>	        	
		       		</div>
		        	<div>
						<c:if test="${empty nextNotice.not_name }">
			        		다음글이 없습니다.<span class="bar">|</span>
			        		다음글<img src="img/right_arrow.png" alt="다음">
						</c:if>
						<c:if test="${not empty nextNotice.not_name }">
			        		<a href="CustomerController?type=detailNotice&screenType=1&rNum=${nextNotice.r_num }&notNum=${nextNotice.not_num}">
				        		${nextNotice.not_name }<span class="bar">|</span>
				        		다음글<img src="img/right_arrow.png" alt="다음">
			        		</a>
						</c:if>	        	
		        	</div>
		        </div>
		        <div class="noticeBtns">
		        	<div class="btnLeft">
				        <a href="ManagerController?type=getNotice&screenType=1" class="notBtn">목록</a>		        		        	
		        	</div>
		        	<div class="btnRight">
				        <a href="ManagerController?type=goEditNotice&notNum=${notice.not_num }&screenType=1" class="notBtn">수정</a>
				        <a href="ManagerController?type=deleteNotice&notNum=${notice.not_num }&screenType=1" class="notBtn">삭제</a>		        	
		        	</div>
		        </div>
		    </div>    
        </div>
    </section>
</body>
</html>