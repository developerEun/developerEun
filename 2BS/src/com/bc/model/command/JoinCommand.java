package com.bc.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.MemberDAO;
import com.bc.model.vo.MemberVO;


public class JoinCommand implements Command {

	
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String re_pwd = request.getParameter("re_pwd");
		String check = request.getParameter("s_t");
		
		String result = "joinsuccess.jsp";
		String value = "-1";
		int s_t = 0;
		if(check.equals("t")) {
			s_t = 2;
		} else {
			s_t = 1;
		}

		
		MemberVO user = new MemberVO();
		MemberVO userid = new MemberVO();
		userid = MemberDAO.getList4(id);
		MemberVO phonec = new MemberVO();
		phonec = MemberDAO.getList5(phone);
		if(userid!=null) {
			value = "1";
			result = "join.jsp?result="+value;	
			System.out.println(result);
		}else if(phonec!=null){
			value = "2";
			result = "join.jsp?result="+value;
			}else {
			user.setId(id);
			user.setPwd(pwd);
			user.setName(name);
			user.setPhone(phone);
			user.setS_t(s_t);
			MemberDAO.getList(user);
		}
		
		
		return result;
	}

}
