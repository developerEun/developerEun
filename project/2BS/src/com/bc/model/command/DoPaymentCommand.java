package com.bc.model.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bc.model.SugangDAO;
import com.bc.model.vo.CartVO;
import com.bc.model.vo.OrderVO;

public class DoPaymentCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<CartVO> clist = (List<CartVO>)session.getAttribute("list");
		String member_num = Integer.toString((int)session.getAttribute("member_num"));
		String card1 = request.getParameter("card1");
		String card2 = request.getParameter("card2");
		String card3 = request.getParameter("card3");
		String card4 = request.getParameter("card4");
		String card = card1 + card2 + card3 + card4;
		System.out.println("member : " + member_num);
		System.out.println("card : " + card);
		int result = 1;
		
		for(CartVO cvo : clist){
			if(result == 1) {
				OrderVO ovo = new OrderVO();
				ovo.setMember_num(member_num);
				ovo.setSu_num(cvo.getSu_num());
				ovo.setCard(card);
				ovo.setPrice(cvo.getPrice());
				
				result = SugangDAO.insertOrder(ovo);
			}
			
			if(result == 1) {
				String c_num = cvo.getCart_num();
				result = SugangDAO.deleteCart(c_num);
			}
		}
		
		request.setAttribute("result", result);
		
		if(result == 1) {
			System.out.println("결제 성공");
		} else {
			System.out.println("결제 실패");
		}
		
		return "payment_ok.jsp";
	}

}
