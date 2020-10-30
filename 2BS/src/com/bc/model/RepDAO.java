package com.bc.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bc.model.vo.MemberVO;
import com.bc.model.vo.QAVO;
import com.bc.model.vo.RepVO;
import com.bc.mybatis.DBService;

public class RepDAO {

/*	//직원 전체 목록 조회
	public static List<RepVO> getList(Map<String, String> map){
		SqlSession ss = DBService.getFactory().openSession();
		List<RepVO> repList = ss.selectList("REPLY.RepAllList", map);
		ss.close();
		return repList;
	}*/
	//부서코드로 직원 조회
	public static int getRepInsert(RepVO repvo){
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.insert("REPLY.RepInsert", repvo);
		ss.close();
		return result;
	}
	

	public static int getRepUpdate(RepVO repvo){
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.update("REPLY.RepUpdate", repvo);
		ss.close();
		return result;
	}
	
	public static int getRepDelete(int qa_num){
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.update("REPLY.RepDelete", qa_num);
		ss.close();
		return result;
	}

	
	public static RepVO getOneList(int num){
		SqlSession ss = DBService.getFactory().openSession();
		RepVO repList = ss.selectOne("REPLY.RepList", num);
		ss.close();
		return repList;
	}
}
