package com.bc.model.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.MemberDAO;
import com.bc.model.QADAO;
import com.bc.model.RepDAO;
import com.bc.model.vo.MemberVO;
import com.bc.model.vo.Paging;
import com.bc.model.vo.QAVO;
import com.bc.model.vo.RepVO;
import com.bc.model.vo.SearchVO;

public class QAPagingCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이징 처리를 위한 Paging 객체 생성해서 값 읽고 설정
		Paging p = new Paging();
		int t_code = Integer.parseInt(request.getParameter("t_code"));
		int su_num = Integer.parseInt(request.getParameter("su_num"));
		//1. 전체 게시물의 수를 구하기
		p.setTotalRecord(QADAO.getTotalCount(su_num));
		p.setTotalPage();
/*		System.out.println("> 전체 게시글 수 : " + p.getTotalRecord());
		System.out.println("> 전체 페이지 수 : " + p.getTotalPage());*/
		System.out.println("su_num : "+ su_num);
		//2. 현재 페이지 구하기
		String cPage = request.getParameter("cPage");
		if (cPage != null) {
			p.setNowPage(Integer.parseInt(cPage));
		}
		
		//3. 현재 페이지에 표시할 게시글 시작번호(begin), 끝번호(end) 구하기
		p.setEnd(p.getNowPage() * p.getNumPerPage()); //현재페이지번호 * 페이지당글수
		p.setBegin(p.getEnd() - p.getNumPerPage() + 1);
		
		//(선택적) 3-1 끝 글번호가 데이터건수보다 많아지면 데이터 건수와 동일한 번호로 설정
		if (p.getEnd() > p.getTotalRecord()) {
			p.setEnd(p.getTotalRecord());
		}
		/*System.out.println("-----------");
		System.out.println(">>현재페이지 : " + p.getNowPage());
		System.out.println(">>시작번호(begin) : " + p.getBegin());
		System.out.println(">>끝번호(end) : " + p.getEnd());*/
		
		//---- 블록(block) 계산하기 -----------
		//4. 블록의 시작페이지, 끝페이지 구하기(현재 페이지 번호 사용)
		//시작페이지 번호 구하기
		int nowPage = p.getNowPage();
		int beginPage = (nowPage - 1) / p.getPagePerBlock() * p.getPagePerBlock() + 1;
		p.setBeginPage(beginPage);
		p.setEndPage(p.getBeginPage() + p.getPagePerBlock() - 1);
		/*
		(개인실습) 위의 시작페이지, 끝페이지 구하기 방식을
		현재페이지가 위치한 블록값을 구하고
		블록값을 기준으로 끝페이지 구한 후 시작페이지 구하기 
		
		*/
		//4-1 끝페이지(endPage)가 전체 페이지 수(totalPage) 보다 크면
		// 끝페이지를 전체페이지수로 변경처리
		if (p.getEndPage() > p.getTotalPage()) {
			p.setEndPage(p.getTotalPage());
		}
		/*System.out.println(">>시작페이지(beginPage) : " + p.getBeginPage());
		System.out.println(">>끝페이지(endPage) : " + p.getEndPage());
*/
		//=============================================
		//현재 페이지 기준으로 DB데이터(게시글) 가져오기
		//시작글번호, 끝 글번호로 Map 데이터 만들기(전달할 파라미터 값)
		/*System.out.println("t_code : " + t_code);*/
		SearchVO map = new SearchVO();
		map.setBegin(p.getBegin());
		map.setEnd(p.getEnd());
		map.setSu_num(su_num);
		int num = 0;
		int qa_num = 0;
		List<QAVO> list = QADAO.getList(map); 
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		List<RepVO> repList = new ArrayList<RepVO>();
		for(QAVO qavo : list) {
			num = qavo.getMember_num();
			qa_num = qavo.getQa_num();
			memberList.add(MemberDAO.getOneList(num));
			repList.add(RepDAO.getOneList(qa_num));
		}
		request.setAttribute("memberList", memberList);
		request.setAttribute("repList", repList);
		//System.out.println("> 현재페이지 글목록(list): " + list);
	
	//================================
	// EL, JSTL 사용을 위해 scope에 데이터 등록(page 영역)
		request.setAttribute("list", list);
		request.setAttribute("pvo", p);
	
		
		// 응답은 컨트롤러에서 해주는 것이 좋다.
		return "SugangDetail.jsp";
	}

}
