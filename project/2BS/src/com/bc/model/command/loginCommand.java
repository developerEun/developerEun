
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


public class loginCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String result = "logincheck.jsp";
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pwd", pwd);
		MemberVO member = MemberDAO.getList(map);
		if(member != null) {
			result = "main.jsp"; // main page 이동 
		}else {
			
		}
		HttpSession httpSession = request.getSession(true);
		httpSession.setAttribute("login", member);
		
		return result;
	}

}
