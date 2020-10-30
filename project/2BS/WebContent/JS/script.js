

var qa_num = 0;
	var t_code = -1;
	var su_num = -1;
	var indexNo = 0;
	var indexNo1 = 0;
	var name = 0;
	var content = "";
	var su_name = "";
 	 $().ready(function(){
 		 dblclick_go();
	     click_go();      
	 }); 
 	 
 	function QA_insert(frm){
 		var title = $(".insertsubject").val().trim();
		var text = $(".insertcontent").val().trim();
		if(title == ""){
		    alert("제목을 입력해주세요.");
		    return false;
		}else if(text == ""){
			alert("내용을 입력해주세요.");
			return false;
		}else{
		   frm.action="QAcontroller?type=QA_insert";
		   frm.submit();
	    }	
 		
 	}
	
 	function back(){
 		t_code = $('.t_code').val();
 		su_num = $('.su_num').val();
 		location.href="QAcontroller?type=sugangDetail&t_code="+t_code+"&su_num="+su_num+"&su_name="+su_name;	
 	}
	function click_go(){
		var type = "";
		$('.repInsert').click(function(){
			type = 'Rep_insert';	
			reply = $(this).siblings('.replyView').val().trim();
			if(reply == ""){
				alert("내용을 입력해주세요.");
				return false;
			}else{
				location.href="QAcontroller?type="+type+"&qa_num="+qa_num+"&t_code="+t_code+"&su_num="+su_num+"&reply="+encodeURI(reply)+"&su_name="+su_name;				
			}
		
		});
		$('.repUpdate').click(function(){
			var result = confirm("정말 수정하시겠습니까?");
			if(result){
			type = 'Rep_update';
			reply = $(this).siblings('.replyView').val().trim();
				if(reply == ""){
					alert("내용을 입력해주세요.");
					return false;
				}else{
					location.href="QAcontroller?type="+type+"&qa_num="+qa_num+"&t_code="+t_code+"&su_num="+su_num+"&reply="+encodeURI(reply)+"&su_name="+su_name;	
				}
	
			}
		});
		$('.repDelete').click(function(){
			var result = confirm("정말 삭제하시겠습니까?");
			if(result){
			type = 'Rep_delete';
	 		location.href="QAcontroller?type="+type+"&qa_num="+qa_num+"&t_code="+t_code+"&su_num="+su_num+"&su_name="+su_name;
			}
		});
		$('.QA_delete').click(function(){
			var result = confirm("정말 삭제하시겠습니까?");
			if(result){
			type = 'QA_delete';
	 		location.href="QAcontroller?type="+type+"&qa_num="+qa_num+"&t_code="+t_code+"&su_num="+su_num+"&su_name="+su_name;
			}
		});
		$('.QA_update').click(function(){
			var result = confirm("정말 수정하시겠습니까?");
			if(result){
			type = 'QA_update';
			content = $(this).siblings('.content').val().trim();
			names = $(this).parent().parent().prev().find('.names').val().trim();
				if(names == ""){
					alert("제목을 입력해주세요.");
					return false;
				}else if(content == ""){
					alert("내용을 입력해주세요.");
					return false;
				}else{
					location.href="QAcontroller?type="+type+"&qa_num="+qa_num+"&content="+encodeURI(content)+"&name="+names+"&t_code="+t_code+"&su_num="+su_num+"&su_name="+su_name;		
				}
			
			}
		});
    	$('.update').click(function(){
    		$('.content').prop('readonly', false);
    		$('.names').prop('readonly', false);
    		$('.QA_update').attr('disabled', false);
		});
       	$('.repclick').click(function(){
    		$('.replyView').prop('readonly', false);
    		$('.repUpdate').attr('disabled', false);
    		$('.reset').attr('disabled', false);

		});
	}
	
	 function insertTodo() { // QA 추가 데이터 전달
		   var title = $("#QAsubject").val().trim();
		   var text = $("#InSertcontent").val().trim();
		   if(title == ""){
		      alert("제목을 입력해주세요.");
		   }else if(text == ""){
		      alert("내용을 입력해주세요.");
		   }else{
			  frm.submit();      
		      return true;
		   }
		}
	function dblclick_go(){
        $('.user').dblclick(function(){
        	name = $(this).find('.names');
        	t_code = $(this).find('.t_code').val();
        	su_num = $(this).find('.su_num').val();
        	qa_num = $(this).find('.qa_num').val();
        	content = $(this).find('.content').val();
        	su_name = $(this).find('.su_name').val();
        	var text = $("#text").val()-1;
	        if($(this).next().hasClass('onoff')){
	        	indexNo = $(this).index();
	        	indexNo1 = indexNo+1;
		        $(this).next().removeClass('onoff');
		        $(this).next().next().removeClass('onoff');
 		        /* $(this).siblings(':eq('+indexNo1+')').removeClass('onoff'); */
	       	}else{
	        	$(this).next().addClass('onoff');
	        	$(this).next().next().addClass('onoff');
 	        	/* $(this).siblings(':eq('+indexNo1+')').addClass('onoff'); */
	       		$('.names').prop('readonly', true);
	       		$('.content').prop('readonly', true);
	       	}
        
    	});
	}
	