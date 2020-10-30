package com.bc.frontcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.QADAO;
import com.bc.model.command.Command;
import com.bc.model.command.QAClassListCommand;
import com.bc.model.command.QADeleteCommand;
import com.bc.model.command.QAInsertCommand;
import com.bc.model.command.QAPagingCommand;
import com.bc.model.command.QASearchCommand;
import com.bc.model.command.QAUpdateCommand;
import com.bc.model.command.RepDeleteCommand;
import com.bc.model.command.RepInsertCommand;
import com.bc.model.command.RepUpdateCommand;
import com.bc.model.command.SearchCommand;
import com.bc.model.command.QASearchPagingCommand;
import com.bc.model.command.QASubClassListCommand;
import com.bc.model.vo.QAVO;



import javafx.scene.control.ListCell;

@WebServlet("/QAcontroller")
public class QAController2 extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		System.out.println(">> FrontController.doGet() 실행~~!!!  ");
		//요청에 대한 처리
		String type = request.getParameter("type");
		Command command = null;
		
		if("sugangDetail".equals(type)) {  //수강페이지 가기
			command = new QAPagingCommand();
		}else if("QA_insert".equals(type)) {  //QA등록
			command = new QAInsertCommand();	
		}else if("QA_update".equals(type)) { //QA수정
			command = new QAUpdateCommand();	
		}else if("QA_delete".equals(type)) { //QA삭제
			command = new QADeleteCommand();	
		}else if("search".equals(type)) {  //검색페이지 리스트출력 + paging 처리
			command = new QASearchPagingCommand();
		}else if("Rep_insert".equals(type)) { //QA의 댓글등록
			command = new RepInsertCommand();
		}else if("Rep_update".equals(type)) { //QA의 댓글업데이트
			command = new RepUpdateCommand();
		}else if("Rep_delete".equals(type)) { //QA의 댓글삭제
			command = new RepDeleteCommand();
		}else if("QAclassList".equals(type)) { //수강>QA목록
			command = new QAClassListCommand();
		}else if("SubclassList".equals(type)) { //수강>QA목록
			command = new QASubClassListCommand();
		}else if ("Search".equals(type)) {
			command = new QASearchCommand();
		//강의 정보 페이지
		}else {
			System.out.println("type : " + type);
		}
		
		String path = command.exec(request, response);
		request.getRequestDispatcher(path).forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
	
	
}
