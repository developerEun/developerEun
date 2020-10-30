<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   	<%@include file="common/memberHead.jspf" %>
    <link rel="stylesheet" href="css/calendar.css">
    <script src="JS/sendData.js"></script>
    <script src="JS/calendar.js"></script>
    <script src="JS/ajax.js"></script>
    <title>myCalendar</title>
</head>
<body>
	<%@include file="common/menu.jspf" %>
    <div class="inner">
        <table id="myCalendar">
            <caption>
                <a href="#" class="prevMonth">◀</a> 
                &nbsp;&nbsp;               
                <span class="year"></span>
                .
                <span class="month"></span>
                &nbsp;&nbsp;
                <a href="#" class="nextMonth">▶</a>
            </caption>
            <colgroup>
                <col width="14.28%" />
                <col width="14.28%" />
                <col width="14.28%" />
                <col width="14.28%" />
                <col width="14.28%" />
                <col width="14.28%" />
                <col width="14.28%" />
            </colgroup>
            <thead>
                <tr>
                    <th>SUN</th>
                    <th>MON</th>
                    <th>TUE</th>
                    <th>WED</th>
                    <th>THR</th>
                    <th>FRI</th>
                    <th>SAT</th>
                </tr>
            </thead>
            <tbody>
                <!-- <tr>
                    <td>
                        <dl title="20200701">
                            <dt>1</dt>
                            <dd></dd>
                        </dl>
                    </td>
                </tr> -->
            </tbody>
        </table>
    </div>
    <div class="detailPop insert">
        <div class="popHeader"></div>
        <form method="post">
            <dl class="popBody">            
            	<dd class="todoColor">
                	<label>배경</label>
                	<input type="radio" name="color" id="orange" value="orange" checked>
                	<label for="orange" style="color: orange">&nbsp;■</label>
                	<input type="radio" name="color" id="skyBlue" value="skyBlue">
                	<label for="skyBlue" style="color: skyBlue">&nbsp;■</label>
                	<input type="radio" name="color" id="yellowgreen" value="yellowgreen">
                	<label for="green" style="color: yellowgreen">&nbsp;■</label>            	
            	</dd>
                <dt class="todoTitle">
                    <label for="title">제목</label>
                    <input type="text" name="title" id="title" cols="10" id="title">
                    <input type="hidden" name="date" class="date">
                    <input type="hidden" name="calNum" class="calNum">
                </dt>
                <dd class="todoText">
                    <label for="text">내용</label> 
                    <textarea name="text" rows="10" id="text"></textarea>
                </dd>
            </dl>
            <div class="btnWrap">
                <input type="button" value="등록" class="send insert" onclick="insertTodo(this.form)">
                <input type="button" value="수정" class="send update" onclick="updateTodo(this.form)">
                <input type="button" class="cancel" value="취소">
            </div>
        </form>
    </div>
    <div class="darkScreen"></div>
    <div class="backImg"></div>
</body>
</html>