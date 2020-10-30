package com.bc.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.DAO;
import com.bc.model.vo.CalendarVO;

public class UpTodoCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int calNum = Integer.parseInt(request.getParameter("calNum"));
		String title = request.getParameter("title");
		String text = request.getParameter("text");
		
		CalendarVO todo = new CalendarVO();
		todo.setCal_num(calNum);
		todo.setCal_name(title);
		todo.setCal_content(text);
		
		DAO.updateTodo(todo);
		
		return "0myCalendar.jsp";
	}
}
