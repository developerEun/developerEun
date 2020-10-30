package com.bc.model.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bc.model.SugangDAO;
import com.bc.model.vo.CartVO;

public class PaymentCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] cart_num = request.getParameterValues("cart_num");
		System.out.println("cart_num[] : " + Arrays.toString(cart_num));
		
		List<CartVO> list = new ArrayList<CartVO>();
		int totalPrice = 0;
		for(int i =0; i <cart_num.length; i++) {
			CartVO vo = SugangDAO.getOneCart(cart_num[i]);
			list.add(vo);
			totalPrice += Integer.parseInt(vo.getPrice()); 
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		request.setAttribute("totalPrice", totalPrice);
		
		return "payment.jsp";
	}

}
