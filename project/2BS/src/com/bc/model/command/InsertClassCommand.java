package com.bc.model.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.SugangDAO;
import com.bc.model.vo.MemberVO;

public class InsertClassCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. DB에서 강사 목록 받아오기
		List<MemberVO> list = SugangDAO.teacherList();
		
		//2. 응답페이지에 데이터 전달
		request.setAttribute("list", list);

		return "insertClass.jsp";
	}

}
