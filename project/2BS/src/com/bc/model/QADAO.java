package com.bc.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bc.model.vo.QAVO;
import com.bc.model.vo.SearchVO;
import com.bc.mybatis.DBService;

public class QADAO {

	//QA 전체 목록 조회
	public static List<QAVO> getList(String t_code){
		SqlSession ss = DBService.getFactory().openSession();
		List<QAVO> qaList = ss.selectList("QA.QAAllList", t_code);
		ss.close();
		return qaList;
	}
	//부서코드로 직원 조회
	public static int getQAInsert(QAVO qavo){
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.insert("QA.QAInsert", qavo);
		ss.close();
		return result;
	}
	
	//이름으로 직원 조회
	public static int getQAUpdate(QAVO qavo){
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.update("QA.QAUpdate", qavo);
		ss.close();
		return result;
	}
	
	public static int getQADelete(int qa_num){
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.update("QA.QADelete", qa_num);
		ss.close();
		return result;
	}
	//전체 건수 조회
	public static int getTotalCount(int su_num) {
		SqlSession ss = DBService.getFactory().openSession();
		int totalCount = ss.selectOne("QA.totalCount", su_num);
		ss.close();
		return totalCount;
	}
	
	//전체 건수 조회
	public static int getSearchTotalCount(SearchVO searchvo) {
		SqlSession ss = DBService.getFactory().openSession();
		int searchtotalCount = ss.selectOne("QA.searchtotalCount", searchvo);
		ss.close();
		return searchtotalCount;
	}

	//페이지에 해당하는 글목록(게시글) 가져오기
	public static List<QAVO> getList(SearchVO map) {
		SqlSession ss = DBService.getFactory().openSession();
		List<QAVO> list = ss.selectList("QA.list", map);
		ss.close();
		return list;
	}
	
	//페이지에 해당하는 글목록(게시글) 가져오기
	public static List<QAVO> getSearchList(SearchVO searchvo) {
		SqlSession ss = DBService.getFactory().openSession();
		List<QAVO> searchlist = ss.selectList("QA.searchlist", searchvo);
		ss.close();
		return searchlist;
	}
	
	public static List<QAVO> getSearch(String idx, String keyword) {
		SqlSession ss = DBService.getFactory().openSession();
		Map<String, String> map = new HashMap<>();
		
		map.put("idx", idx);
		map.put("keyword", keyword);
		List<QAVO> list = ss.selectList("QA.search", map);
		ss.close();
		return list;
	}


}
