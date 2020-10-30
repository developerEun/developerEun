package com.bc.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.DAO;
import com.bc.model.vo.CalendarVO;
import com.bc.model.vo.NoticeVO;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@WebServlet("/GetMainNoticeController")
public class GetMainNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		List<NoticeVO> list = DAO.getAllNoticeList();
		
		String result = "{\"mainNotice\" : [";
		
		for (NoticeVO vo : list) {
			result += "{";
			result += "\"R_NUM\" : \"" + vo.getR_num() + "\",";
			result += "\"MEMBER_NAME\" : \"" + vo.getMember_name() + "\",";
			result += "\"NOT_NAME\" : \"" + vo.getNot_name() + "\",";
			result += "\"NOT_MONTH\" : \"" + vo.getNot_date().substring(5,7) + "\",";
			result += "\"NOT_DAY\" : \"" + vo.getNot_date().substring(8,10) + "\",";
			result += "\"NOT_TYPE\" : \"" + vo.getNot_type() + "\"";
			result += "},";
		}
		result = result.substring(0, result.length()-1);
		result += "]}";
		
		out.print(result);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}
