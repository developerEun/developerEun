<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <div class="preview">
        	<div>
				<c:if test="${empty prevNotice.not_name }">
	        		<img src="img/left_arrow.png" alt="이전">
	        		이전 글 <span class="bar">|</span>이전글이 없습니다.
				</c:if>
				<c:if test="${not empty prevNotice.not_name }">
	        		<a href="CustomerController?type=detailNotice&rNum=${prevNotice.r_num }&notNum=${prevNotice.not_num}">
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
	        		<a href="CustomerController?type=detailNotice&rNum=${nextNotice.r_num }&notNum=${nextNotice.not_num}">
		        		${nextNotice.not_name }<span class="bar">|</span>
		        		다음글<img src="img/right_arrow.png" alt="다음">
	        		</a>
				</c:if>	        	
        	</div>
        </div>