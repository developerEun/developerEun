package com.bc.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bc.model.vo.MemberVO;
import com.bc.model.vo.QAVO;
import com.bc.model.vo.SearchVO;
import com.bc.mybatis.DBService;

public class MemberDAO {

/*	//직원 전체 목록 조회
	public static List<MemberVO> getList(int num){
		SqlSession ss = DBService.getFactory().openSession();
		List<MemberVO> memberList = ss.selectList("member.memberAllList", num);
		ss.close();
		return memberList;
	}*/
	
	public static MemberVO getOneList(int num){
		SqlSession ss = DBService.getFactory().openSession();
		MemberVO memberList = ss.selectOne("member.QAmemberList", num);
		ss.close();
		return memberList;
	}
	
	public static void getList(MemberVO user){
		SqlSession ss = DBService.getFactory().openSession(true);
		ss.insert("member.MemberInsert", user);
		ss.close();
	}
	
	public static MemberVO getList(Map<String,String> map){
		SqlSession ss = DBService.getFactory().openSession();
		MemberVO member = ss.selectOne("member.MemberLogIn", map);
		ss.close();
		return member;
	}
	
	public static MemberVO getList2(Map<String, String> map){
	SqlSession ss = DBService.getFactory().openSession();
	MemberVO member = ss.selectOne("member.findPassword", map);
	ss.close();
	return member;
	}
		
	public static MemberVO getList3(Map<String, String> map){
	SqlSession ss = DBService.getFactory().openSession();
	MemberVO member = ss.selectOne("member.findId", map);
	ss.close();
	return member;
	}
	
	public static MemberVO getList4(String id){
	SqlSession ss = DBService.getFactory().openSession();
	MemberVO member = ss.selectOne("member.checkId", id);
	ss.close();
	return member;
	}
	
	public static MemberVO getList5(String phone){
	SqlSession ss = DBService.getFactory().openSession();
	MemberVO member = ss.selectOne("member.checkPhone", phone);
	ss.close();
	return member;
	}
	
	public static List<MemberVO> getMemberList(Map<String, String> map){
	SqlSession ss = DBService.getFactory().openSession();
	List<MemberVO> member = ss.selectList("member.memberList", map);
	ss.close();
	return member;
	}

/*	public static  int getTotalCount() {
		SqlSession ss = DBService.getFactory().openSession();
		int count = ss.selectOne("member.memberTotalCount");
		ss.close();
		return count;
	}*/

	public static List<MemberVO> getSearchList(SearchVO searchvo) {
		SqlSession ss = DBService.getFactory().openSession();
		List<MemberVO> searchResult = ss.selectList("member.searchList", searchvo);
		ss.close();		
		return searchResult;
	}
	
	public static int getSearchCount(SearchVO searchvo) {
		SqlSession ss = DBService.getFactory().openSession();
		int count = ss.selectOne("member.searchCount", searchvo);
		ss.close();		
		return count;
	}
	public static MemberVO getAdminList(Map<String,String> map){
		SqlSession ss = DBService.getFactory().openSession();
		MemberVO member = ss.selectOne("member.adminLogin", map);
		ss.close();
		return member;
	}
	
}
