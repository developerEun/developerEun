package com.bc.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bc.model.SugangDAO;
import com.bc.model.vo.CartVO;

public class InsertCartCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String member_num = Integer.toString((int)session.getAttribute("member_num"));
		String su_num = request.getParameter("su_num");
		String price = SugangDAO.getPrice(su_num);
		CartVO vo = new CartVO();
		vo.setMember_num(member_num);
		vo.setSu_num(su_num);
		vo.setPrice(price);
		
		int result = SugangDAO.insertCart(vo);
		System.out.println("insertCart : " + result);
		request.setAttribute("insertCartResult", result);
		request.setAttribute("su_num", su_num);
		
		return "insertCart.jsp";
	}

}
