<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
	var isDownload = confirm("이미지 파일을 다운로드 하시겠습니까? ");
	if(isDownload){
		location.href= "controller?type=download&path=img&name=${str }";
	
	} else {
		location.href= "controller?type=insertList";
	
	}
</script>