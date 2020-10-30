package com.bc.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.SugangDAO;
import com.bc.model.vo.ReviewVO;

public class UpdateReviewCommand implements Command {

	//리뷰 수정페이지로 보내주기
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 전달받은 값으로 DB에서 데이터 처리
		//String su_num = request.getParameter("su_num");
		String re_num = request.getParameter("re_num");
		
		ReviewVO vo = SugangDAO.getReview(re_num);
		
		//2. 응답페이지에 데이터 전달
		request.setAttribute("review", vo);
		
		return "updateReview.jsp";
	}

}
