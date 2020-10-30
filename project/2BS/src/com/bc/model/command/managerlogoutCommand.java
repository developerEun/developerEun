
package com.bc.model.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bc.model.MemberDAO;
import com.bc.model.vo.MemberVO;
import com.bc.model.vo.QAVO;


public class managerlogoutCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession httpSession = request.getSession(true);
		httpSession.setAttribute("login", null);
		
		return "1MemberLogin.jsp";
	}

}
