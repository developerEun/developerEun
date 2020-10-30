package com.bc.model.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.SugangDAO;
import com.bc.model.paging.doPaging;
import com.bc.model.vo.ClassVO;
import com.bc.model.vo.MemberVO;

public class UpdateDeleteClassCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 전달받은 값으로 DB에서 데이터 받아오기
		String su_num = request.getParameter("su_num");
		System.out.println("cm su_num : " + su_num);
		ClassVO vo = SugangDAO.get_classDetail(su_num);
		List<MemberVO> list = SugangDAO.teacherList();
		String cPage = request.getParameter("cPage");
		
		//페이징 처리
		doPaging.reviewPaging(request, response, su_num, cPage);
		
		//2. 응답페이지에 데이터 전달
		request.setAttribute("detail", vo);
		request.setAttribute("list", list);
		
		return "classManage.jsp";
	}

}
