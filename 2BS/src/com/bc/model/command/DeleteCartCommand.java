package com.bc.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.SugangDAO;

public class DeleteCartCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cart_num = request.getParameter("cart_num");
		
		int result = SugangDAO.deleteCart(cart_num);
		System.out.println("deleteCart : " + result);
		
		return "controller?type=myCart";
	}

}
