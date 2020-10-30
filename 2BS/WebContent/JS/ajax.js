function getTodoTitle() { // 날짜 일정에 맞게 일정버튼 추가
	$.ajax({
		url : "getTodoController",
		type : "get",
		dataType : "json",
		success : function(data){
			var list = data.todo;
			
			$.each(list, function(){
				var todoDate = this.date;
				var todoTitle = this.title;
				var todoCalNum = this.calNum;
				var todoColor = this.color;
				$("#myCalendar dl").each(function(){
					var dates = this.title;
					if(todoDate == dates){
						let dateDetail = $(this).find("dd").html();
						dateDetail += "<p class='todoBtnWrap " + todoColor + "'>"
									+ "<span class='todoBtn'>"+todoTitle+"</span>"
									+ "<a href='CustomerController?type=delTodo&calNum=" + todoCalNum + "' class='close'>x</a>" 
									+ "</p>";
						$(this).find("dd").html(dateDetail);
					}
					if($(this).find("p").length){
						$(this).find(".moreAddTodo").show();
					}
				});
			});
		}
	});
}

function getTodoText() { // 수정 클릭시 내용 불러오기
	$.ajax({
		url : "getTodoController",
		type : "get",
		dataType : "json",
		success : function(data){
			var list = data.todo;
			
			$.each(list, function(){
				var todoCalNum = this.calNum;
				var todoDate = this.date;
				var todoTitle = this.title;
				var todoText = this.text;
				$(".todoBtn").click(function(){
					var thisTitle = $(this).text();
					if(todoTitle == thisTitle){
						$(".detailPop .calNum").val(todoCalNum);
						$(".detailPop #title").val(thisTitle);
						$(".detailPop #text").val(todoText);
					}
				});
			});
		}
	});
}

function getMainNotice(){
	$.ajax({
		url : "GetMainNoticeController",
		type : "get",
		dataType : "json",
		success : function(data){
			var list = data.mainNotice;
			
			var all = $(".mainNoticeInfo").eq(0);
			var allResult = all.html();
			var allCnt = 0;
			
			var red = $(".mainNoticeInfo").eq(1);
			var redResult = red.html();
			var redCnt = 0;
			
			var blue = $(".mainNoticeInfo").eq(2);
			var blueResult = blue.html();
			var blueCnt = 0;
			
			var orange = $(".mainNoticeInfo").eq(1);
			var orangeResult = orange.html();
			var orangeCnt = 0;
			
			
			$.each(list, function(){
		
				var rNum = this.R_NUM;
				var memberName = this.MEMBER_NAME;
				var notName = this.NOT_NAME;
				var notMonth = this.NOT_MONTH;
				var notDay = this.NOT_DAY;
				var notType = this.NOT_TYPE;
				
				if(notType == '긴급'){
					if(redCnt < 4){
						redResult += noticeResult(notMonth, notDay, notName, memberName, notType);
						redCnt++;
					}
				} else if(notType == '신청'){
					if(blueCnt < 4){
						blueResult += noticeResult(notMonth, notDay, notName, memberName, notType);
						blueCnt++;
					}
				} else {
					if(orangeCnt < 4){
						orangeResult += noticeResult(notMonth, notDay, notName, memberName, notType);
						orangeCnt++;
					}
				}
				
				if(allCnt < 4){
					allResult += noticeResult(notMonth, notDay, notName, memberName, notType);
					allCnt++;
				}
				
			});
			
			$(".mainNoticeInfo").eq(0).html(allResult);
			$(".mainNoticeInfo").eq(1).html(redResult);
			$(".mainNoticeInfo").eq(2).html(blueResult);
			$(".mainNoticeInfo").eq(3).html(orangeResult);
		}
	});	
}


function noticeResult(notMonth, notDay, notName, memberName, notType){
	var result = "";
	
	result += "<a href='#' class='eachNotice'>";
	result += "<dl><dd>";
	result += notMonth + "월<span class='date'>" + notDay + "</span>";
	result += "</dd><dt>";
	if(notType == '긴급'){
		result += "<span class='noticeType red'>긴급</span> ";
	}else if(notType == '신청'){
		result += "<span class='noticeType blue'>신청</span> ";
	}else{
		result += "<span class='noticeType orange'>변경</span> ";
	}	
	result += notName;
	result += "<span class='writer'>" + memberName + " 선생님</span>";
	result += "</dt></dl></a>";	
	
	return result;
}	


