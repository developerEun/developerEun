$().ready(function(){
	$(".menu li").each(function(){
		var menu = $(this);
		var idx = menu.index();
		var content = $(".menuContents li").eq(idx);
		
		$(menu, content).mouseenter(function(){
			$(".menu li").removeClass("on");
			$(".menuContents li").removeClass("active");
			
			menu.addClass("on");
			content.addClass("active");
		});
		
		$(menu).mouseleave(function(){
			if(!(content.hasClass("active"))){
				menu.removeClass("on");
			}
		})
		
		$(content).mouseleave(function(){
			menu.removeClass("on");
			content.removeClass("active");
		});
	});
});
