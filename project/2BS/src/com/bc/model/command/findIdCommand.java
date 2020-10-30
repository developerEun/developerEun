
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


public class findIdCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		String result = "idcheck.jsp";
		String value = "-1"; 
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		map.put("phone", phone);
		System.out.println("name:" + name);
		System.out.println("phone:" + phone);
		MemberVO member = MemberDAO.getList3(map);
		request.setAttribute("find_id", member);
		System.out.println("member : " + member);
		
		if(member != null) {
			
		} else {
			value = "1";
			result = "findId.jsp?result=" + value;
		}
		
		return result;
	}

}
