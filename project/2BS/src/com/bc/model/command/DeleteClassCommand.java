package com.bc.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.SugangDAO;

public class DeleteClassCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String su_num = request.getParameter("su_num");
		
		int result = SugangDAO.deleteClass(su_num);
		System.out.println("deleteClass : " + result);

		return "controller?type=insertList";
	}

}
