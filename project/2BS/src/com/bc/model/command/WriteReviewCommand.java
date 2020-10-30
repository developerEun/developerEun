package com.bc.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bc.model.SugangDAO;
import com.bc.model.vo.ReviewVO;

public class WriteReviewCommand implements Command {

	//리뷰 쓰기
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String su_num = request.getParameter("su_num");
		HttpSession session = request.getSession();
		//매개변수로 줄 VO 객체 생성
		ReviewVO vo = new ReviewVO();
		vo.setSu_num(su_num);
		int member = (int) session.getAttribute("member_num");
		vo.setMember_num(Integer.toString(member)); //session에서 받아와주기!!!!!!!
		vo.setRe_grade(request.getParameter("grade"));
		vo.setRe_content(request.getParameter("content"));
		
		//입력처리
		int result = SugangDAO.insertReview(vo);
		System.out.println("reviewWrite result : " + result);
		
		return "controller?type=classDetail&su_num=" + su_num;
	}

}
