package com.bc.frontcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.command.Command;
import com.bc.model.command.DelTodoCommand;
import com.bc.model.command.GetNoticeCommand;
import com.bc.model.command.GetNoticeDetailCommand;
import com.bc.model.command.GetNoticeSearchCommand;
import com.bc.model.command.GetTodoCommand;
import com.bc.model.command.InNoticeReplyCommand;
import com.bc.model.command.InTodoCommand;
import com.bc.model.command.UpTodoCommand;
import com.bc.model.command.NoticeReplyCommand;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String type = request.getParameter("type");
		String cPage = request.getParameter("cPage");
		Command command = null;
		System.out.println("Custmer 실행");
		System.out.println("cPage :" + cPage);
		String pathAll = null;
		String pathType = null;
		String path = null;
		
		/**************** 캘린더 ****************/
		
		if ("insertTodo".equals(type)) { // 일정 추가
			command = new InTodoCommand();
		} else if("getTodo".equals(type)) { // 모든일정 AJAX 형식으로 표기된 파일
			command = new GetTodoCommand();
		} else if (("updateTodo").equals(type)){ // 일정 수정
			command = new UpTodoCommand();
		} else if(("delTodo").equals(type)) { // 일정 삭제
			command = new DelTodoCommand();
			
		/**************** 공지사항 ****************/
			
		} else if(("getNotice").equals(type)) { // 모든 공지 조회
			command = new GetNoticeCommand();
			System.out.println("getNotice");
		} else if(("detailNotice").equals(type)) { // 공지 상세페이지 조회
			command = new GetNoticeDetailCommand();
		} else if(("InNoticeReply").equals(type)) { // 공지 상세페이지에서 댓글 달기
			command = new InNoticeReplyCommand();
		} else if(("NoticeReply").equals(type)) { // 공지 상세페이지 댓글 수정&삭제
			command = new NoticeReplyCommand();
		} else if(("getNoticeSearch").equals(type)) { // 공지 게시글 검색
			command = new GetNoticeSearchCommand();
		}
		
		pathAll = command.exec(request, response);
		pathType = pathAll.substring(0, 1);
		path = pathAll.substring(1);
		
		if(pathType.equals("0")) {
			response.sendRedirect(path);
		}else {
			request.getRequestDispatcher(path).forward(request, response);			
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}
