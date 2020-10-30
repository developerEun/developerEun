package com.bc.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.SugangDAO;

public class DeleteReviewCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 전달받은 값으로 DB에서 데이터 처리
		String su_num = request.getParameter("su_num");
		String re_num = request.getParameter("re_num");
		String admin = request.getParameter("admin");
		int result = SugangDAO.deleteReview(re_num);
		
		System.out.println("deleteReview 처리건수  : " + result);
		
		//다시 돌아가기
		if("Y".equals(admin)) {
			return "controller?type=classManage&su_num=" + su_num;				
		} else {
			return "controller?type=classDetail&su_num=" + su_num;
		}
	}

}
