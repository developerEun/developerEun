$().ready(function(){
    function printDays(){ // 캘린더 출력
        var addDays = "";
        
        if(todayMonth < 1){
        	todayYear--;
        	todayMonth = 12;
        } else if(todayMonth > 12){
        	todayYear++;
        	todayMonth = 1;        	
        }
        
        if(todayMonth < 10){
        	todayMonth = "0" + todayMonth;
        } 
        
        $(".year").html(todayYear);
        $(".month").html(todayMonth);
        
    	var todayDateCnt = new Date(todayYear, todayMonth, 0).getDate();
    	var todayDayCnt = new Date(todayYear, todayMonth-1, 1).getDay();

        for(let i=1; i<=todayDateCnt+todayDayCnt; i++){
            if(i%7 == 1){
                addDays += "<tr>"
            }
            
            addDays += "<td><dl>";
            addDays += "<dt>";
            
            if(i <= todayDayCnt){
                addDays += "</dt>";
            }else{
                addDays += "<span>" 
	                	+ (i-todayDayCnt) 
	                	+ "</span><a href='#' class='moreAddTodo'>+</a>" 
	                	+ "</dt>";
            }
            
            addDays += "<dd></dd>";
            addDays += "</dl></td>";
            
            if(i%7 == 0){
                addDays += "</tr>"
            }
        }        
        $("#myCalendar tbody").html(addDays);
    }

    function calendarBtn(){ // todo 수정팝업 닫기
        $(".cancel").click(function(){ 
            $(".darkScreen").hide();
            $(".detailPop").hide();
            $(".send").hide();
        });
    }
    
    function eachDay(){
    	$("#myCalendar td").each(function(){ // 날짜 event
    		var selectDay = $(this).find("dt span").text();
    		
    		if(selectDay < 10){
    			selectDay = "0" + selectDay;
    		}
    		
    		var selectDate = String(todayYear)+String(todayMonth)+String(selectDay);
    		
    		$(this).find("dl").attr("title", selectDate);
    		console.log("selectDay : " + selectDay);
    		console.log("selectDate : " + selectDate);
    		
			$(this).hover(function(){ // 마우스를 올렸을 때
				var title = $(this).find("dt");
				var text = $(this).find("dd");
				var moreAddTodo = $(this).find(".moreAddTodo");
				
				if( title.text() != "" && text.text() == ""){ // 날짜는 있고 내용은 없을 때
					$(this).addClass("null");
					addTodo($(this)); // 일정 추가
				}else{ // 날짜도 있고 내용도 있을 때
			        $(".todoBtn").click(function(){ // todo 수정 버튼 클릭 시
		                $(".darkScreen").show();
		                $(".detailPop").show();
		                $(".update").show();
		                $(".popHeader").text(selectDate + " 일정수정");
			        });
			        
			        addTodo(moreAddTodo); // 일정 추가
				}

			}, function(){
				$(this).removeClass("null");
			});
			
			function addTodo(btn){
				btn.click(function(){ // 일정이 없는 달력 일자를 클릭했을 때
					$(".darkScreen").show();
					$(".detailPop").show();
					$(".insert").show();
					
					$(".popHeader").text(selectDate + " 일정등록");
					$(".date").val(selectDate);					
					$("#title").val("");
					$("#text").val("");
				}); 
			}
    	});
    }
    
    function executeJS(){
        printDays();
        calendarBtn();
        eachDay();
        getTodoTitle();
        getTodoText();   	
    }
    
    
    var today = new Date();
    var todayYear = today.getFullYear();
    var todayMonth = today.getMonth()+1;
    console.log("todayYear : " + todayYear);
    console.log("todayMonth : " + todayMonth);

    
	executeJS();
    
    
    $(".prevMonth").click(function(){ // 1달 전으로 버튼 클릭시
        todayMonth--; 
        executeJS();
    });

    $(".nextMonth").click(function(){ // 1달 후로 버튼 클릭시
        todayMonth++; 
        executeJS();
    });
    

});
