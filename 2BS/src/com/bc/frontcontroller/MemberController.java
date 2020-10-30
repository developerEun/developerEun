package com.bc.frontcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bc.model.command.Command;
import com.bc.model.command.JoinCommand;
import com.bc.model.command.MemberCommand;
import com.bc.model.command.MemberPagingCommand;
import com.bc.model.command.admin_loginCommand;
import com.bc.model.command.findIdCommand;
import com.bc.model.command.findPasswordCommand;
import com.bc.model.command.loginCommand;
import com.bc.model.command.logoutCommand;

import javafx.scene.control.ListCell;

@WebServlet("/membercontroller")
public class MemberController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">> FrontController.doGet() 시작");
		
		String type = request.getParameter("type");
		Command command = null;
	if("join".equals(type)) {
			command = new JoinCommand();		
		}else if("login".equals(type)) {
			command = new loginCommand();		
		}else if("find_p".equals(type)) {
			command = new findPasswordCommand();
		}else if("find_id".equals(type)) {
			command = new findIdCommand();
		}else if("member".equals(type)) {
			command = new MemberPagingCommand();
		}else if("admin_login".equals(type)) {
			command = new admin_loginCommand();
		}else if("logout".equals(type)) {
			command = new logoutCommand();
		}else { 
			System.out.println("type : " + type);
		}
		String path = command.exec(request, response);
		System.out.println(path);
		request.getRequestDispatcher(path).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
	
	
}
