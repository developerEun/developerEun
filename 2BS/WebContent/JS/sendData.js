
/********************* 캘린더 *********************/

function insertTodo(frm) { // 일정 추가 데이터 전달
	var title = $("#title").val();
	var text = $("#text").val();
	
	if(title == ""){
		alert("제목을 입력해주세요.");
	}else if(text == ""){
		alert("내용을 입력해주세요.");
	}else{
		frm.action = "CustomerController?type=insertTodo";
		frm.submit();		
	}
}
function admin_login(frm) {
	frm.action="membercontroller?type=admin_login";
	frm.submit();
}
function updateTodo(frm) { // 일정 수정 데이터 전달
	frm.action = "CustomerController?type=updateTodo";
	frm.submit();
}

/********************* 공지사항 *********************/

function updateNotice(frm) { 
	var importCnt = $(".importCnt").text();
	var kind = $('input[name="kind"]:checked').val();
	if(kind == "긴급"){
		if(importCnt == 5){
			alert("긴급 공지가 많습니다.");
			$(".darkScreen").show();
			$(".deleteSelect").show();
			
			return false;
		}	
	}	
	frm.action = "ManagerController?type=updateNotice";
	frm.submit();
}

function insertNotice(frm){ // 공지사항 추가 데이터 전달
	var importCnt = $(".importCnt").text();
	var kind = $('input[name="kind"]:checked').val();
	if(kind == "긴급"){
		if(importCnt == 5){
			alert("긴급 공지가 많습니다.");
			$(".darkScreen").show();
			$(".deleteSelect").show();
			
			return false;
		}	
	}
	frm.action = "ManagerController?type=insertNotice";
	frm.submit();
}

function getNotice(){ // 공지 가져오기
	location.href="CustomerController?type=getNotice&cPage=1";
}

function getNoticeWrite(){ // 공지 작성 페이지로 이동
	location.href="ManagerController?type=getNoticeWriter";
}

function searchGoM(frm){ // 검색 후 데이터 처리
	frm.action = "ManagerController?type=getNoticeSearch";
	frm.submit();	
}

function searchGo(frm){ // 검색 후 데이터 처리 (매니저)
	frm.action = "CustomerController?type=getNoticeSearch";
	frm.submit();	
}

function replyInsert(frm){ // 공지 상세페이지 댓글 작성
	frm.action="CustomerController?type=InNoticeReply";
	frm.submit();
}

function deleteImport(frm){ // 공지 타입="긴급" 5개 초과 시 선택삭제 후 데이터 처리
	frm.action="ManagerController?type=deleteImport";
	frm.submit();
}

function updateReply(frm){ // 공지 상세페이지 댓글 수정
	frm.action="CustomerController?type=NoticeReply&change=update";
	frm.submit();
}

function deleteReply(frm){ // 공지 상세페이지 댓글 삭제
	frm.action="CustomerController?type=NoticeReply&change=delete";
	frm.submit();
}
