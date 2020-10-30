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
import com.bc.mybatis.Paging;

public class QASubClassListCommand implements Command {

	//강의 목록 페이지(과목별)
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. DB연결하고 데이터 가져오기
		HttpSession session = request.getSession();
		String code = request.getParameter("sub");
		String cPage = request.getParameter("cPage");
		List<ClassVO> list = doPaging.SubClassPaging(request, response, cPage, code);
		System.out.println("cPage : "+ cPage);
		//2. 응답페이지(classList.jsp)에 전달
		session.setAttribute("code", code);
		request.setAttribute("list", list);
		
		Paging p= new Paging();
		p = (Paging) request.getAttribute("pvo");
		String str = "SubclassList";
		request.setAttribute("str", str);
		request.setAttribute("sub", code);
		request.setAttribute("pvo", p);
		System.out.println("list : " + list.toString());
		System.out.println("str : " + str);
		System.out.println("p : " + p);
		System.out.println(list.toString());
		
		return "QAclassList.jsp";
	}

}
