package com.bc.model.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.SugangDAO;
import com.bc.model.paging.doPaging;
import com.bc.model.vo.ClassVO;
import com.bc.mybatis.Paging;

public class QASearchCommand implements Command {

	//동적검색 : 강의명, 강사명
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idx = request.getParameter("idx");
		String keyword = "%" + request.getParameter("keyword") + "%";
		String keyword2 = request.getParameter("keyword");
		String cPage = request.getParameter("cPage");
		
		
		
		System.out.println("idx : " + idx + "keyword : " + keyword);
		List<ClassVO> list = doPaging.SearchClassPaging(request, response, cPage, idx, keyword);
		System.out.println("list : " + list);
		
		request.setAttribute("list", list);
		Paging p= new Paging();
		p = (Paging) request.getAttribute("pvo");
		String str = "search";
		request.setAttribute("str", str);
		request.setAttribute("pvo", p);
		request.setAttribute("idx", idx);
		request.setAttribute("keyword", keyword2);
		
		return "QAclassList.jsp";
	}

}
