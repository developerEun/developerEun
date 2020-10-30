<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/managerHeader.jsp" %>
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

        </div>
    </section>
</body>
</html>