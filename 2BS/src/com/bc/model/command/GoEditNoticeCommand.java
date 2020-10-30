package com.bc.model.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.DAO;
import com.bc.model.vo.NoticeVO;

public class GoEditNoticeCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int not_num = Integer.parseInt(request.getParameter("notNum"));
		
		NoticeVO notice = DAO.getNoticeOne(not_num);
		request.setAttribute("notice", notice);
		
		int importCnt = DAO.getImportCount();
		request.setAttribute("importCnt", importCnt);
		List<NoticeVO> importList = DAO.getImportNotice();
		request.setAttribute("importList", importList);
		
		return "1managerNoticeEdit.jsp";
	}
	
}
