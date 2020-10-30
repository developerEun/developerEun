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


public class MemberCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condition = request.getParameter("condition");
		String keyword = request.getParameter("keyword");
		
		Map<String, String> map = new HashMap<>();
		map.put("condition", condition);
		map.put("keyword", keyword);
		List<MemberVO> member = MemberDAO.getMemberList(map);
		
		request.setAttribute("member", member);
		
		return "memberResult.jsp";
		
	}
}
