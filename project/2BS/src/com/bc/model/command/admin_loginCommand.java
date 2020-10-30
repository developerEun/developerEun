
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


public class admin_loginCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String result = "adminLoginCheck.jsp";
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String s_t = request.getParameter("s_t");
		System.out.println("?????????");
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pwd", pwd);
		map.put("s_t", s_t);
		MemberVO admin = MemberDAO.getAdminList(map);
		
		if(admin != null) {
			result = "managerCustomer.jsp"; // main page 이동 
		}else {
			
		}
		HttpSession httpSession = request.getSession(true);
		httpSession.setAttribute("login", admin);
		System.out.println("result : "  + result);
		return result;
	}

}
