package com.bc.model.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.DAO;
import com.bc.model.vo.NoticeVO;

public class GetNoticeWriterCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int importCnt = DAO.getImportCount();
		List<NoticeVO> importList = DAO.getImportNotice();
		request.setAttribute("importCnt", importCnt);
		request.setAttribute("importList", importList);
		
		return "1managerNoticeInsert.jsp";
	}

}
