
package com.bc.model.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.MemberDAO;
import com.bc.model.vo.MemberVO;
import com.bc.model.vo.QAVO;


public class findPasswordCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		String result = "passwordcheck.jsp";
		String value = "-1";
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("name", name);
		MemberVO member = MemberDAO.getList2(map);
		request.setAttribute("find_p", member);
		
		if(member != null) {
			 
		} else {
			value = "1";
			result = "findPassword.jsp?result="+value;
		}
	 	 
		return result;
	}

}
