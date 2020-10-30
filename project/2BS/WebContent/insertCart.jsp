<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	if("${insertCartResult}" == 1){ //장바구니에 담기 성공
		var goCart = confirm("장바구니 담기에 성공했습니다!\n장바구니로 가시겠습니까?");
		if(goCart){ //장바구니로 가기
			location.href = "controller?type=myCart"; //장바구니 목록 불러오는 컨트롤러로 이동
		}else{ //원래 페이지로 돌아가기
			location.href = "controller?type=classDetail&su_num=${su_num }";
		}
	}else{ //장바구니에 담기 실패
		alert("장바구니 담기에 실패했습니다.\n관리자에게 문의해주세요.");
		location.href = "controller?type=classDetail&su_num=${su_num }";
	}
</script>