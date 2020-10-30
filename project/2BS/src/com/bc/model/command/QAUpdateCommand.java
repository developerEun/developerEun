package com.bc.model.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bc.model.MemberDAO;
import com.bc.model.QADAO;
import com.bc.model.vo.MemberVO;
import com.bc.model.vo.QAVO;

public class QAUpdateCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. DB연결하고 데이터 가져오기
		String content = request.getParameter("content");
		String qa_name = request.getParameter("name");
		int t_code = Integer.parseInt(request.getParameter("t_code"));
		int qa_num = Integer.parseInt(request.getParameter("qa_num"));
		int su_num = Integer.parseInt(request.getParameter("su_num"));
		String su_name = request.getParameter("su_name");
		/*System.out.println("content : " + content + "qa_name : " + qa_name + "t_code: " + t_code + "qa_num" + qa_num);*/
		HttpSession httpSession = request.getSession(true);
		QAVO qavo = (QAVO) httpSession.getAttribute("qavo");
		qavo.setQa_content(content);
		qavo.setQa_name(qa_name);
		qavo.setT_code(t_code);
		qavo.setQa_num(qa_num);
		int result = QADAO.getQAUpdate(qavo);
		System.out.println("qavo : " + qavo);
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
