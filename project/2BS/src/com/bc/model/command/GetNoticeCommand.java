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

public class GetNoticeCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Paging p = new Paging();
		
		int recordCnt = p.getNumPerPage();
		int importCnt = DAO.getImportCount();
		p.setNumPerPage(recordCnt-importCnt);
		
		p.setTotalRecord(DAO.getTotalCount());
		p.setTotalPage();
		System.out.println("> 전체 게시글 수 : " + p.getTotalRecord());
		System.out.println("> 전체 페이지 수 : " + p.getTotalPage());
		
		String cPage = request.getParameter("cPage");
		System.out.println(cPage);
		if(cPage != null) {
			p.setNowPage(Integer.parseInt(cPage));
		}
		
		p.setEnd(p.getNowPage() * p.getNumPerPage());
		p.setBegin(p.getEnd() - p.getNumPerPage() + 1);
		
		if(p.getEnd() > p.getTotalRecord()) {
			p.setEnd(p.getTotalRecord());
		}
		System.out.println("-----------");
		System.out.println(">>현재페이지 : " + p.getNowPage());
		System.out.println(">>시작번호(begin) : " + p.getBegin());
		System.out.println(">>끝번호(end) : " + p.getEnd());
		int nowPage = p.getNowPage();
		int beginPage = (nowPage - 1) / p.getPagePerBlock() * p.getPagePerBlock() + 1;
		p.setBeginPage(beginPage);
		p.setEndPage(p.getBeginPage() + p.getPagePerBlock() - 1);
		
		if(p.getEndPage() > p.getTotalPage()) {
			p.setEndPage(p.getTotalPage());
		}
		//-------------------------------------------------------------------------------
		Map<String, Integer> map = new HashMap<>();
		map.put("begin", p.getBegin());
		map.put("end", p.getEnd());
		
		List<NoticeVO> list = DAO.getNoticeList(map);
		List<NoticeVO> importList = DAO.getImportNotice();
		System.out.println("> 현재페이지 글목록(list): " + list);
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
