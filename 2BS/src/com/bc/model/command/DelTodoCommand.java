package com.bc.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.DAO;

public class DelTodoCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cal_num = Integer.parseInt(request.getParameter("calNum"));
		DAO.deleteTodo(cal_num);
		
		return "0myCalendar.jsp";
	}

}
