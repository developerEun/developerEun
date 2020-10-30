package com.bc.model.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.DAO;
import com.bc.model.vo.Paging;
import com.bc.model.vo.NoticeVO;
import com.bc.model.vo.SearchVO;

public class GetNoticeSearchCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idx = request.getParameter("idx");
		String keyword = request.getParameter("keyword");
		
		Paging p = new Paging();
		
		int recordCnt = p.getNumPerPage();
		int importCnt = DAO.getImportCount();
		p.setNumPerPage(recordCnt-importCnt);
		
		p.setTotalRecord(DAO.getSearchCount(idx, keyword));
		p.setTotalPage();
		
		
		String cPage = request.getParameter("cPage");
		if(cPage != null) {
			p.setNowPage(Integer.parseInt(cPage));
		}
		
		p.setEnd(p.getNowPage() * p.getNumPerPage());
		p.setBegin(p.getEnd() - p.getNumPerPage() + 1);
		
		if(p.getEnd() > p.getTotalRecord()) {
			p.setEnd(p.getTotalRecord());
		}
		
		int nowPage = p.getNowPage();
		int beginPage = (nowPage - 1) / p.getPagePerBlock() * p.getPagePerBlock() + 1;
		p.setBeginPage(beginPage);
		p.setEndPage(p.getBeginPage() + p.getPagePerBlock() - 1);
		
		if(p.getEndPage() > p.getTotalPage()) {
			p.setEndPage(p.getTotalPage());
		}
		//-------------------------------------------------------------------------------
		SearchVO search = new SearchVO();
		search.setBegin(p.getBegin());
		search.setEnd(p.getEnd());
		search.setIdx(Integer.parseInt(idx));
		search.setKeyword(keyword);
		
		List<NoticeVO> list = DAO.getNoticeSearchList(search);
		List<NoticeVO> importList = DAO.getImportNotice();

		//=================================================================
		request.setAttribute("list", list);
		request.setAttribute("importList", importList);
		request.setAttribute("pvo", p);
		
		if(request.getParameter("screenType") == null) {
			return "1noticeView.jsp";
		} else {
			return "1managerNotice.jsp";
		}
	}

}
