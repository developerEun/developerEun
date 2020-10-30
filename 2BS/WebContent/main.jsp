<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="css/swiper.css">
    <link rel="stylesheet" href="css/animate.min.css">
    
	<%@include file="common/memberHead.jspf" %>
	
    <link rel="stylesheet" href="css/main.css">
    <script src="JS/swiper.min.js"></script>
    <script src="JS/swiper.animate1.0.3.min.js"></script>
    <script src="JS/ajax.js"></script>
    <script src="JS/main.js"></script>
    <title>2BS</title>
</head>
<body>
	<%@include file="common/menu.jspf" %>
    <div class="mainRolling">
        <div class="swiper-container">
            <div class="swiper-wrapper">
                <div class="swiper-slide">
                    <dl class="swiperText">
                        <dt>
                            <p class="tit">쉽고 짧게 즐기는 인강!</p>
                            <p class="txt">7일 무료체험을 놓치지마세요</p>
                        </dt>
                        <dd><a href="#">More</a></dd>
                    </dl>
                </div>
                <div class="swiper-slide">
                    <dl class="swiperText">
                        <dt>
                            <p class="tit">쉽고 짧게 즐기는 인강!</p>
                            <p class="txt">7일 무료체험을 놓치지마세요</p>
                        </dt>
                        <dd><a href="#">More</a></dd>
                    </dl>
                </div>
            </div>
            <div class="swiper-pagination_main">
                <dl class="swiperText">
                    <dt>
                        <p class="tit">쉽고 짧게 즐기는 인강!</p>
                        <p class="txt">7일 무료체험을 놓치지마세요</p>
                    </dt>
                    <dd><a href="#">More</a></dd>
                </dl>
            </div>
        </div>
    </div>    
    <div class="mainWrap">
        <h2>공지사항</h2>
        <div class="mainNotice">
            <ol class="mainNoticeBtn">
                <li class="active">전체</li>
                <li>긴급</li>
                <li>신청</li>
                <li>변경</li>
            </ol>
            <div class="mainNoticeCont">
                <div class="mainNoticeInfo active"></div>
                <div class="mainNoticeInfo"></div>
                <div class="mainNoticeInfo"></div>
                <div class="mainNoticeInfo"></div>
            </div>
        </div>
    </div>
    <footer>
        <div class="mainWrap">
            <ol class="footerBtns">
                <li><a href="#">2BS 소개</a></li>
                <li><a href="#">2BS 공고</a></li>
                <li><a href="#">제휴문의</a></li>
                <li><a href="#">협찬/광고문의</a></li>
                <li><a href="#">개인정보처리방침</a></li>
            </ol>
            <ol class="footerInfo">
                <li>10393 경기도 고양시 일산동구 한류월드로 281 한국교육방송공사</li>
                <li>사업자등록번호 : 229-82-01343 (한국교육방송공사사장 김명중)</li>
                <br/>
                <li>시청자불만전담 : hotline@ebs.co.kr</li>
                <li>부가통신사업신고 : 10077 통신판매업신고 : 고양일산동-1415호[사업자정보확인]</li>
            </ol>
            <p class="copyRight">Copyright ⓒ EBS. All Rights Reserved.</p>
        </div>
    </footer>
</body>
</html>