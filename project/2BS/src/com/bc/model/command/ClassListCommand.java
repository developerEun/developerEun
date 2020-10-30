package com.bc.model.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bc.model.SugangDAO;
import com.bc.model.paging.doPaging;
import com.bc.model.vo.ClassVO;
import com.bc.model.vo.QAVO;
import com.bc.mybatis.Paging;

public class ClassListCommand implements Command {

	//강의 목록 페이지
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. DB연결하고 데이터 가져오기
		String cPage = request.getParameter("cPage");
		List<ClassVO> list = doPaging.classPaging(request, response, cPage);

		//2. 응답페이지(classList.jsp)에 전달
		
		Paging p= new Paging();
		p = (Paging) request.getAttribute("pvo");
		String str = "classList";
		request.setAttribute("list", list);
		
		request.setAttribute("str", str);
		request.setAttribute("pvo", p);
/*		System.out.println("list : " + list.toString());
		System.out.println("str : " + str);
		System.out.println("p : " + p);
*/
		return "classList.jsp";
	}

}
