package com.bc.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.SugangDAO;
import com.bc.model.vo.ReviewVO;

public class DoUpdateReviewCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 전달받은 값 받아오기			
		String re_grade = request.getParameter("grade");
		String re_content = request.getParameter("content");
		String re_num = request.getParameter("re_num");
		String su_num = request.getParameter("su_num");
		System.out.println("su_num : " + su_num);
		System.out.println("re_num : " + re_num);
		
		//2. vo 만들어 DB에 업데이트 처리
		ReviewVO vo = new ReviewVO();
		vo.setRe_grade(re_grade);
		vo.setRe_content(re_content);
		vo.setRe_num(re_num);
		
		int result = SugangDAO.updateReview(vo);
		System.out.println("update review 결과 : " + result);
		
		return "controller?type=classDetail&su_num=" + su_num;
	}

}
