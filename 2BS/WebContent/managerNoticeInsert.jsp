<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/managerHeader.jsp" %>
<body>
    <header>
		<%@ include file="include/managerLoginInfo.jsp" %>
        <ol id="menu">
            <li><a href="managerCustomer.jsp">고객관리</a></li>
            <li><a href="classAdmin.jsp">상품관리</a></li>
            <li class="active"><a href="ManagerController?type=getNotice&screenType=1">공지관리</a></li>
        </ol>
    </header>
    <section>
        <div class="content">
		    <form method="post" enctype="multipart/form-data">
			    <div class="noticeWrap">
			        <h1>공지사항 작성하기<span class="importCnt" style="display: none;">${importCnt }</span></h1>
		            <table class="writeNotice">
		                <colgroup>
		                    <col width="20%">
		                </colgroup>
		                <tbody>
		                    <tr>
		                        <th>종류</th>
		                        <td>
		                            <input type="radio" name="kind" value="긴급" id="red" checked>
		                            <label for="red"><span class="noticeType red">긴급</span></label>
		                            <input type="radio" name="kind" value="변경" id="orange">
		                            <label for="orange"><span class="noticeType orange">변경</span></label>
		                            <input type="radio" name="kind" value="신청" id="blue">
		                            <label for="blue"><span class="noticeType blue">신청</span></label>
		                        </td>
		                    </tr>
		                    <tr>
		                        <th>제목</th>
		                        <td><input type="text" name="title" placeholder="제목을 입력하세요"></td>
		                    </tr>
		                    <tr>
		                        <th>내용</th>
		                        <td><textarea name="text" rows="10" class="text" placeholder="내용을 입력하세요"></textarea></td>
		                    </tr>
		                    <tr>
		                        <th>첨부파일</th>
		                        <td><input type="file" name="file"></td>
		                    </tr>
		                </tbody>
		            </table>
			        <div class="noticeBtns">
				        <input type="button" value="등록하기" class="notBtn" onclick="insertNotice(this.form);">
			        </div>		
			    </div>
			    <dl class="deleteSelect">
			    	<dt>
			    		삭제하실 공지를 선택해주세요.
			    		<span class="close">X</span>
			    	</dt>
			    	<dd>
			    		<table>
			    			<colgroup>
			    				<col width="10%">
			    				<col width="15%">
			    				<col width="75%">
			    			</colgroup>
			    			<thead>
			    				<tr>
			    					<th></th>
			    					<th>NO</th>
			    					<th>제목</th>
			    				</tr>
			    			</thead>
			    			<tbody>
			    				<c:forEach var="importNotice" items="${importList }">
				    				<tr>
				    					<td><input type="checkbox" name="deleteSelect" value="${importNotice.not_num }"></td>
				    					<td>${importNotice.not_num }</td>
				    					<td>${importNotice.not_name }</td>
				    				</tr>
			    				</c:forEach>
			    			</tbody>
			    		</table>
			    		<div class="deleteBtn">
			    			<input type="button" value="삭제하기" onclick="deleteImport(this.form);">
			    		</div>
			    	</dd>
			    </dl>
			    <div class="darkScreen"></div>
		    </form>   	              
        </div>
    </section>
</body>
</html>