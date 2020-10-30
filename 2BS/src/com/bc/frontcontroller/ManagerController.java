package com.bc.frontcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.SugangDAO;
import com.bc.model.command.AddClassCommand;
import com.bc.model.command.Command;
import com.bc.model.command.DelTodoCommand;
import com.bc.model.command.DeleteClassCommand;
import com.bc.model.command.DeleteImportCommand;
import com.bc.model.command.GetNoticeCommand;
import com.bc.model.command.GetNoticeDetailCommand;
import com.bc.model.command.GetNoticeSearchCommand;
import com.bc.model.command.GetNoticeWriterCommand;
import com.bc.model.command.GetTodoCommand;
import com.bc.model.command.InNoticeCommand;
import com.bc.model.command.InNoticeReplyCommand;
import com.bc.model.command.InTodoCommand;
import com.bc.model.command.InsertClassCommand;
import com.bc.model.command.InsertListCommand;
import com.bc.model.command.DeleteNoticeCommand;
import com.bc.model.command.DownloadCommand;
import com.bc.model.command.UpTodoCommand;
import com.bc.model.command.UpdateClassCommand;
import com.bc.model.command.UpdateNoticeCommand;
import com.bc.model.command.managerlogoutCommand;
import com.bc.model.command.GoEditNoticeCommand;
import com.bc.model.vo.NoticeVO;
import com.bc.model.command.NoticeReplyCommand;

@WebServlet("/ManagerController")
public class ManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String type = request.getParameter("type");
		Command command = null;
		
		String pathAll = null;
		String pathType = null;
		String path = null;
		
		/**************** 공지사항 ****************/
		
		if(("getNoticeWriter").equals(type)) { // 공지 작성 페이지로 이동
			command = new GetNoticeWriterCommand();
		} else if(("insertNotice").equals(type)) { // 공지 작성 후 데이터 처리
			command = new InNoticeCommand();
		} else if(("getNotice").equals(type)) { // 모든 공지 조회
			command = new GetNoticeCommand();
		} else if(("detailNotice").equals(type)) { // 공지 상세페이지 조회
			command = new GetNoticeDetailCommand();
		} else if(("deleteImport").equals(type)) { // 타입="긴급" 게시글 5개 초과시 공지 선택 삭제
			command = new DeleteImportCommand();
		} else if(("deleteNotice").equals(type)) { // 공지 삭제
			command = new DeleteNoticeCommand();			
		} else if(("goEditNotice").equals(type)) { // 공지 수정 페이지로 이동
			command = new GoEditNoticeCommand();			
		} else if(("updateNotice").equals(type)) { // 공지 수정 작업 처리
			command = new UpdateNoticeCommand();
		} else if(("getNoticeSearch").equals(type)) { // 공지 게시글 검색
			command = new GetNoticeSearchCommand();
		} else if("logout".equals(type)) {  //로그아웃 처리
			command = new managerlogoutCommand();
		}  else {
			System.out.println("type : " + type);  
		}
		pathAll = command.exec(request, response);
		pathType = pathAll.substring(0, 1);
		path = pathAll.substring(1);
		String path1 = pathAll.substring(0);
		System.out.println("path : " + path);
		System.out.println("pathAll : " + pathAll);
		System.out.println("path1 : " + path1);
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
