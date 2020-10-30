<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
				<h1>공지사항</h1>
		        <table class="noticeDetail">
		            <colgroup>
		                <col width="60%"/>
		                <col width="20%"/>
		                <col width="20%"/>
		            </colgroup>
		            <thead>
		                <tr>
							<c:choose>
								<c:when test="${notice.not_type == '긴급' }">
									<th><h3><span class="noticeType red">${notice.not_type }</span>&nbsp;&nbsp;&nbsp;${notice.not_name }</h3></th>
								</c:when>
								<c:when test="${notice.not_type == '변경' }">
									<th><h3><span class="noticeType orange">${notice.not_type }</span>&nbsp;&nbsp;&nbsp;${notice.not_name }</h3></th>
								</c:when>
								<c:when test="${notice.not_type == '신청' }">
									<th><h3><span class="noticeType blue">${notice.not_type }</span>&nbsp;&nbsp;&nbsp;${notice.not_name }</h3></th>
								</c:when>
							</c:choose>
		                    <th>${notice.member_name } 선생님</th>
		                    <th>${notice.not_date }</th>
		                </tr>
		            </thead>
		            <tbody>
		                <tr>
		                    <td colspan="3">${notice.not_content }</td>
		                </tr>
		                <tr>
							<c:if test="${empty notice.not_file }">
								<td colspan="3"></td>
							</c:if>                
							<c:if test="${not empty notice.not_file }">
			                    <td colspan="3">
			                    	<a href="file/${notice.not_file_ori }" download>
			                    		<img src="img/file.png" alt="첨부파일" height="100%">
			                    		${notice.not_file }
			                   		</a>
			                    </td>
							</c:if> 
						</tr>      
		            </tbody>
		        </table>