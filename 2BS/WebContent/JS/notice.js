$().ready(function(){
	$(".replyView dl").each(function(){
		var replyEdit = $(this).find(".replyEdit");
		var replyConfirm = $(this).find(".replyConfirm");
		
		var replayTextForm = $(this).find("textarea");
		
		replyEdit.click(function(){
			$(this).hide();
			replayTextForm.attr("disabled", false)
						  .css("background","white");
			replyConfirm.show();
		});
		
		replyConfirm.click(function(){
			$(this).hide();
			replayTextForm.attr("disabled", true)
						  .css("background","transparent");
			replyEdit.show();
		});
	});
	
	$(".deleteSelect .close").click(function(){
		$(".darkScreen").hide();
		$(".deleteSelect").hide();
	});
	
	$(".searchWrap").click(function(){
		$(this).addClass("active");
		$(this).animate({
						width: "310px", 
						height: "35px",
						"padding" : "0px 10px"
						},100);
	});
});  
