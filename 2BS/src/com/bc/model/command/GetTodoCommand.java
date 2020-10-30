package com.bc.model.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.DAO;
import com.bc.model.vo.CalendarVO;

public class GetTodoCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		List<CalendarVO> list = DAO.getTodo();
		
		String result = "{\"todo\" : [";
		for (CalendarVO vo : list) {
			result += "{";
			result += "\"title\" : \"" + vo.getCal_name() + "\",";
			result += "\"date\" : \"" + vo.getCal_date() + "\"";
			result += "},";
		}
		result = result.substring(0, result.length()-1);
		result += "]}";
		
		out.print(result);
		System.out.println(result);
		
		return "0myCalendar.jsp";
	}

	
}
