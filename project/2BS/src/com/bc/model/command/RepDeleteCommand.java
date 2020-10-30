package com.bc.model.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bc.model.MemberDAO;
import com.bc.model.QADAO;
import com.bc.model.RepDAO;
import com.bc.model.vo.MemberVO;
import com.bc.model.vo.QAVO;
import com.bc.model.vo.RepVO;

public class RepDeleteCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. DB연결하고 데이터 가져오기
		int qa_num = Integer.parseInt(request.getParameter("qa_num"));
		int su_num = Integer.parseInt(request.getParameter("su_num"));
		int t_code = Integer.parseInt(request.getParameter("t_code"));
		String su_name = request.getParameter("su_name");
		System.out.println(qa_num);
		int result = RepDAO.getRepDelete(qa_num);

		//2. 응답페이지(list.jsp)에 전달(request 객체에 속성값으로 전달)
		if (result<0) {		
			System.out.println("입력정보를 확인하세요.");
		// 응답은 컨트롤러에서 해주는 것이 좋다.
		}
		
		request.setAttribute("su_num", su_num);
		request.setAttribute("su_name", su_name);
		request.setAttribute("t_code", t_code);
		

		return "QAcontroller?type=sugangDetail";
	}

}
