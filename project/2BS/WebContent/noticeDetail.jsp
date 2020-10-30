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
    <script src="JS/sendData.js"></script>
    <script src="JS/notice.js"></script>
    <title>Notice</title>
</head>
<body>
<%@include file="common/menu.jspf" %>    
    <div class="noticeWrap">
        <%@ include file="include/noticeDetailInfo.jsp" %>
        <div class="replyForm">
        	<form method="post">
		        <div class="reply">
	        		<input type="text" class="user" name="" value="${member.name }" readonly>
		        	<textarea id="user" name="rep_content"></textarea>
		        	<input type="button" value="등록" onclick="replyInsert(this.form);">
		        	<input type="hidden" name="rNum" value="${notice.r_num }">
		        	<input type="hidden" name="notNum" value="${notice.not_num }">
		        </div>
		        <div class="replyView">
		        	<c:forEach var="reply" items="${replyList }">
			        	<dl>
			        		<dt class="user">
			        			${reply.name }
			        			<span class="date">${reply.rep_date }</span>
			        			<c:if test="${member_num == reply.member_num }">
				        			<div class="replyBtnWrap">
				        				<input type="button" value="수정" class="replyEdit">
				        				<input type="button" value="확인" class="replyConfirm" onclick="updateReply(this.form);">
				        				<input type="button" value="삭제" onclick="deleteReply(this.form);">
				        				
				        				<input type="hidden" name="repNum" value="${reply.rep_num }">
				        			</div>
			        			</c:if>
			        		</dt>
			        		<dd>
			        			<textarea name="repContent" disabled="disabled">${reply.rep_content }</textarea>
			        		</dd>
			        	</dl>     	
		        	</c:forEach>
		        </div>
  	        </form>
        </div>
        <%@ include file="include/noticeDetailPreview.jsp" %>
        <div class="noticeBtns">
	        <a href="CustomerController?type=getNotice" class="notBtn">목록</a>
        </div>
    </div>
</body>
</html>