package com.bc.model.paging;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.SugangDAO;
import com.bc.model.vo.ClassVO;
import com.bc.model.vo.ReviewVO;
import com.bc.mybatis.Paging;

public class doPaging {
	
	//리뷰게시판 페이징 처리
	public static List<ReviewVO> reviewPaging
			(HttpServletRequest request, HttpServletResponse response, String su_num, String rPage) 
					throws ServletException, IOException {
		
		//페이징 객체 생성
		Paging p= new Paging();
		
		//1. 전체 리뷰 수 구하기
		p.setTotalRecord(SugangDAO.getReviewCount(su_num));
		p.setTotalPage();
		System.out.println("> 전체 게시글 수 : " + p.getTotalRecord());
		System.out.println("> 전체 페이지 수 : " + p.getTotalPage());
		
		System.out.println("rPage : " + rPage);
		//2. 현재 페이지 구하기
		if(rPage != null) {
			p.setNowPage(Integer.parseInt(rPage));
		}
		
		//3. 현재 페이지에 표시할 리뷰 시작번호(begin), 끝번호(end) 구하기
		p.setEnd(p.getNowPage() * p.getNumPerPage()); // 현재페이지번호 * 페이지당 글 수 
		p.setBegin(p.getEnd() - p.getNumPerPage() + 1);
		
		System.out.println(">> End : " + p.getEnd());
		System.out.println(">> Begin : " + p.getBegin());
		
		//(선택적)3-1. 끝 글번호가 데이터 건수보다 많아지면 데이터 건수와 동일한 번호로 설정
		if(p.getEnd() > p.getTotalRecord()){
			p.setEnd(p.getTotalRecord());
		}
		
		System.out.println("------------------");
		System.out.println(">> 현재페이지  : " + p.getNowPage());
		System.out.println(">> 시작번호(begin) : " + p.getBegin());
		System.out.println(">> 끝번호(end) : " + p.getEnd());
		
		//----- 블록(block) 계산하기 -----
		//4. 블록의 시작페이지, 끝페이지 구하기(현재 페이지 번호 사용)
		//시작페이지 번호 구하기
		int nowPage = p.getNowPage();
		int beginPage = (nowPage - 1) / p.getPagePerBlock() * p.getPagePerBlock() + 1;
		p.setBeginPage(beginPage);
		p.setEndPage(p.getBeginPage() + p.getPagePerBlock() - 1);
		System.out.println(">> 시작페이지(beginPage) : " + p.getBeginPage());
		System.out.println(">> 끝페이지(endPage) : " + p.getEndPage());
		
		//4-1. 끝페이지(endPage)가 전체 페이지 수(totalPage)보다 크면
		//끝페이지를 전체 페이지수로 변경처리
		if(p.getEndPage() > p.getTotalPage()) {
			p.setEndPage(p.getTotalPage());
		}
		
		//=================================================
		//현재 페이지 기준으로 DB데이터(게시글) 가져오기
		//시작글번호, 끝 글번호로 Map 데이터 만들기(전달할 파라미터 값)
		Map<String, Integer> map = new HashMap<>();
		map.put("begin", p.getBegin());
		map.put("end", p.getEnd());
		map.put("su_num", Integer.parseInt(su_num));
		
		List<ReviewVO> list = SugangDAO.get_reviewList(map);
		System.out.println(">> doReviewPaging list : " + list);
		
		request.setAttribute("reList", list);
		request.setAttribute("rpvo", p);
		
		return list;
	}
	
	//상품 목록 페이징 처리
	public static List<ClassVO> classPaging
		(HttpServletRequest request, HttpServletResponse response, String cPage) 
				throws ServletException, IOException {
			
		//페이징 객체 생성
		Paging p= new Paging();
		
		//1. 전체 강의 수 구하기
		p.setTotalRecord(SugangDAO.classCount());
		p.setTotalPage();
		System.out.println("> 전체 게시글 수 : " + p.getTotalRecord());
		System.out.println("> 전체 페이지 수 : " + p.getTotalPage());
		
		//2. 현재 페이지 구하기
		if(cPage != null) {
			p.setNowPage(Integer.parseInt(cPage));
		}
		
		//3. 현재 페이지에 표시할 리뷰 시작번호(begin), 끝번호(end) 구하기
		p.setEnd(p.getNowPage() * p.getNumPerPage()); // 현재페이지번호 * 페이지당 글 수 
		p.setBegin(p.getEnd() - p.getNumPerPage() + 1);
		
		System.out.println(">> End : " + p.getEnd());
		System.out.println(">> Begin : " + p.getBegin());
		
		//(선택적)3-1. 끝 글번호가 데이터 건수보다 많아지면 데이터 건수와 동일한 번호로 설정
		if(p.getEnd() > p.getTotalRecord()){
			p.setEnd(p.getTotalRecord());
		}
		
		System.out.println("------------------");
		System.out.println(">> 현재페이지  : " + p.getNowPage());
		System.out.println(">> 시작번호(begin) : " + p.getBegin());
		System.out.println(">> 끝번호(end) : " + p.getEnd());
		
		//----- 블록(block) 계산하기 -----
		//4. 블록의 시작페이지, 끝페이지 구하기(현재 페이지 번호 사용)
		//시작페이지 번호 구하기
		int nowPage = p.getNowPage();
		int beginPage = (nowPage - 1) / p.getPagePerBlock() * p.getPagePerBlock() + 1;
		p.setBeginPage(beginPage);
		p.setEndPage(p.getBeginPage() + p.getPagePerBlock() - 1);
		System.out.println(">> 시작페이지(beginPage) : " + p.getBeginPage());
		System.out.println(">> 끝페이지(endPage) : " + p.getEndPage());
		
		//4-1. 끝페이지(endPage)가 전체 페이지 수(totalPage)보다 크면
		//끝페이지를 전체 페이지수로 변경처리
		if(p.getEndPage() > p.getTotalPage()) {
			p.setEndPage(p.getTotalPage());
		}
		
		//=================================================
		//현재 페이지 기준으로 DB데이터(게시글) 가져오기
		//시작글번호, 끝 글번호로 Map 데이터 만들기(전달할 파라미터 값)
		Map<String, Integer> map = new HashMap<>();
		map.put("begin", p.getBegin());
		map.put("end", p.getEnd());
		
		List<ClassVO> list = SugangDAO.get_classList(map);
		System.out.println(">> doPaging list : " + list);
		
		request.setAttribute("pList", list);
		request.setAttribute("pvo", p);
		
		return list;
	}
	
	//과목별 상품 목록 페이징 처리
	public static List<ClassVO> SubClassPaging
		(HttpServletRequest request, HttpServletResponse response, String cPage, String code) 
				throws ServletException, IOException {
			
		//페이징 객체 생성
		Paging p= new Paging();
		
		//1. 전체 강의 수 구하기
		p.setTotalRecord(SugangDAO.SubClassCount(code));
		p.setTotalPage();
		System.out.println("> 전체 게시글 수 : " + p.getTotalRecord());
		System.out.println("> 전체 페이지 수 : " + p.getTotalPage());
		
		//2. 현재 페이지 구하기
		if(cPage != null) {
			p.setNowPage(Integer.parseInt(cPage));
		}
		
		//3. 현재 페이지에 표시할 리뷰 시작번호(begin), 끝번호(end) 구하기
		p.setEnd(p.getNowPage() * p.getNumPerPage()); // 현재페이지번호 * 페이지당 글 수 
		p.setBegin(p.getEnd() - p.getNumPerPage() + 1);
		
		System.out.println(">> End : " + p.getEnd());
		System.out.println(">> Begin : " + p.getBegin());
		
		//(선택적)3-1. 끝 글번호가 데이터 건수보다 많아지면 데이터 건수와 동일한 번호로 설정
		if(p.getEnd() > p.getTotalRecord()){
			p.setEnd(p.getTotalRecord());
		}
		
		System.out.println("------------------");
		System.out.println(">> 현재페이지  : " + p.getNowPage());
		System.out.println(">> 시작번호(begin) : " + p.getBegin());
		System.out.println(">> 끝번호(end) : " + p.getEnd());
		
		//----- 블록(block) 계산하기 -----
		//4. 블록의 시작페이지, 끝페이지 구하기(현재 페이지 번호 사용)
		//시작페이지 번호 구하기
		int nowPage = p.getNowPage();
		int beginPage = (nowPage - 1) / p.getPagePerBlock() * p.getPagePerBlock() + 1;
		p.setBeginPage(beginPage);
		p.setEndPage(p.getBeginPage() + p.getPagePerBlock() - 1);
		System.out.println(">> 시작페이지(beginPage) : " + p.getBeginPage());
		System.out.println(">> 끝페이지(endPage) : " + p.getEndPage());
		
		//4-1. 끝페이지(endPage)가 전체 페이지 수(totalPage)보다 크면
		//끝페이지를 전체 페이지수로 변경처리
		if(p.getEndPage() > p.getTotalPage()) {
			p.setEndPage(p.getTotalPage());
		}
		
		//=================================================
		//현재 페이지 기준으로 DB데이터(게시글) 가져오기
		//시작글번호, 끝 글번호로 Map 데이터 만들기(전달할 파라미터 값)
		Map<String, String> map = new HashMap<>();
		map.put("begin", Integer.toString(p.getBegin()));
		map.put("end", Integer.toString(p.getEnd()));
		map.put("code", code);
		
		List<ClassVO> list = SugangDAO.get_SubClassList(map);
		System.out.println(">> doPaging list : " + list);
		
		request.setAttribute("pList", list);
		request.setAttribute("pvo", p);
		
		return list;
	}
		
	//과목별 상품 목록 페이징 처리
	public static List<ClassVO> SearchClassPaging
		(HttpServletRequest request, HttpServletResponse response, String cPage, String idx, String keyword) 
				throws ServletException, IOException {
			
		//페이징 객체 생성
		Paging p= new Paging();
		
		//1. 전체 강의 수 구하기
		Map<String, String> map = new HashMap<>();
		map.put("idx", idx);
		map.put("keyword", keyword);
		System.out.println(map);
		p.setTotalRecord(SugangDAO.SearchClassCount(map));
		p.setTotalPage();
		System.out.println("> 전체 게시글 수 : " + p.getTotalRecord());
		System.out.println("> 전체 페이지 수 : " + p.getTotalPage());
		
		//2. 현재 페이지 구하기
		if(cPage != null) {
			p.setNowPage(Integer.parseInt(cPage));
		}
		
		//3. 현재 페이지에 표시할 리뷰 시작번호(begin), 끝번호(end) 구하기
		p.setEnd(p.getNowPage() * p.getNumPerPage()); // 현재페이지번호 * 페이지당 글 수 
		p.setBegin(p.getEnd() - p.getNumPerPage() + 1);
		
		System.out.println(">> End : " + p.getEnd());
		System.out.println(">> Begin : " + p.getBegin());
		
		//(선택적)3-1. 끝 글번호가 데이터 건수보다 많아지면 데이터 건수와 동일한 번호로 설정
		if(p.getEnd() > p.getTotalRecord()){
			p.setEnd(p.getTotalRecord());
		}
		
		System.out.println("------------------");
		System.out.println(">> 현재페이지  : " + p.getNowPage());
		System.out.println(">> 시작번호(begin) : " + p.getBegin());
		System.out.println(">> 끝번호(end) : " + p.getEnd());
		
		//----- 블록(block) 계산하기 -----
		//4. 블록의 시작페이지, 끝페이지 구하기(현재 페이지 번호 사용)
		//시작페이지 번호 구하기
		int nowPage = p.getNowPage();
		int beginPage = (nowPage - 1) / p.getPagePerBlock() * p.getPagePerBlock() + 1;
		p.setBeginPage(beginPage);
		p.setEndPage(p.getBeginPage() + p.getPagePerBlock() - 1);
		System.out.println(">> 시작페이지(beginPage) : " + p.getBeginPage());
		System.out.println(">> 끝페이지(endPage) : " + p.getEndPage());
		
		//4-1. 끝페이지(endPage)가 전체 페이지 수(totalPage)보다 크면
		//끝페이지를 전체 페이지수로 변경처리
		if(p.getEndPage() > p.getTotalPage()) {
			p.setEndPage(p.getTotalPage());
		}
		
		//=================================================
		//현재 페이지 기준으로 DB데이터(게시글) 가져오기
		//시작글번호, 끝 글번호로 Map 데이터 만들기(전달할 파라미터 값)
		map.put("begin", Integer.toString(p.getBegin()));
		map.put("end", Integer.toString(p.getEnd()));
		
		List<ClassVO> list = SugangDAO.get_SearchClassList(map);
		System.out.println(">> doPaging list : " + list);
		
		request.setAttribute("pList", list);
		request.setAttribute("pvo", p);
		
		return list;
	}
	
}
