package com.bc.model.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bc.model.SugangDAO;
import com.bc.model.vo.CartVO;

public class MyCartCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String member_num = Integer.toString((int)session.getAttribute("member_num"));
		System.out.println("member_num : " + member_num);
		
		//DB에서 로그인한 member_num으로 장바구니 리스트 가져오기
		List<CartVO> list = SugangDAO.myCartList(member_num);
		
		//request에 올리기
		session.setAttribute("list", list);
		System.out.println(list);
		
		//페이지 이동
		//response.sendRedirect("myCart.jsp");
		
		return "myCart.jsp";
	}

}
