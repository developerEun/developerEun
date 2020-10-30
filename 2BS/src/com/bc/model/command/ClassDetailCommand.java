package com.bc.model.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bc.model.SugangDAO;
import com.bc.model.paging.doPaging;
import com.bc.model.vo.ClassVO;

public class ClassDetailCommand implements Command {

	//강의 정보 페이지
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 전달받은 값으로 DB에서 데이터 받아오기
		String su_num = request.getParameter("su_num");
		ClassVO vo = SugangDAO.get_classDetail(su_num);
		String cPage = request.getParameter("cPage");
		String manage = "classDetail.jsp";
		HttpSession session = request.getSession();
		int member = -1;
		if(session.getAttribute("member_num") != null) {
			member = (int) session.getAttribute("member_num");	
		}
		
		if(request.getParameter("manage") != null) {
			manage = request.getParameter("manage");
		}
		System.out.println(member);
		Map<String, String> map = new HashMap<String, String>();
		map.put("su_num", su_num);
		map.put("member_num", Integer.toString(member));
		int isInCart = SugangDAO.isInCart(map);
		int isOrdered = SugangDAO.isOrdered(map);
		System.out.println("isOrdered : " + isOrdered );
		
		//페이징 처리
		doPaging.reviewPaging(request, response, su_num, cPage);
		
		//2. 응답페이지에 데이터 전달
		request.setAttribute("detail", vo);
		request.setAttribute("member", member);
		request.setAttribute("isInCart", isInCart);
		request.setAttribute("isOrdered", isOrdered);
		request.setAttribute("su_num", su_num);
		
		return manage;
	}

}
