package com.bc.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.DAO;
import com.bc.model.vo.CalendarVO;

@WebServlet("/getTodoController")
public class GetTodoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		List<CalendarVO> list = DAO.getTodo();
		
		String result = "{\"todo\" : [";
		for (CalendarVO vo : list) {
			result += "{";
			result += "\"calNum\" : \"" + vo.getCal_num() + "\",";
			result += "\"title\" : \"" + vo.getCal_name() + "\",";
			result += "\"text\" : \"" + vo.getCal_content() + "\",";
			result += "\"date\" : \"" + vo.getCal_date() + "\",";
			result += "\"color\" : \"" + vo.getCal_color() + "\"";
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
