package com.bc.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.DAO;

public class DeleteNoticeCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int not_num = Integer.parseInt(request.getParameter("notNum"));
		
		DAO.deleteNotice(not_num);
		
		return "0ManagerController?type=getNotice&screenType=1";
	}

}
