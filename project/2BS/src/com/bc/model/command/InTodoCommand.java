package com.bc.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.DAO;
import com.bc.model.vo.CalendarVO;

public class InTodoCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String text = request.getParameter("text");
		String date = request.getParameter("date");
		String color =  request.getParameter("color");
		
		CalendarVO todo = new CalendarVO();
		todo.setMember_num(2);
		todo.setCal_date(date);
		todo.setCal_name(title);
		todo.setCal_content(text);
		todo.setCal_color(color);
		
		DAO.insertTodo(todo);
		
		return "0myCalendar.jsp";
	}
}
