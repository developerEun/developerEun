package com.bc.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bc.model.vo.CartVO;
import com.bc.model.vo.ClassVO;
import com.bc.model.vo.MemberVO;
import com.bc.model.vo.OrderVO;
import com.bc.model.vo.ReviewVO;
import com.bc.model.vo.SugangVO;
import com.bc.mybatis.DBService;

import oracle.jdbc.internal.OracleStatement.SqlKind;

public class SugangDAO {
	
	//전체 강의 개수 불러오기
	public static int classCount() {
		SqlSession ss = DBService.getFactory().openSession();
		int result = ss.selectOne("sugang.classCount");
		ss.close();
		
		return result;
	}
	
	//강의 목록 불러오기
	public static List<ClassVO> get_classList(Map<String, Integer> map) {
		SqlSession ss = DBService.getFactory().openSession();
		List<ClassVO> list = ss.selectList("sugang.classList", map);
		ss.close();
		
		return list;
	}
	
	//과목별 강의 개수 불러오기
	public static int SubClassCount(String code) {
		SqlSession ss = DBService.getFactory().openSession();
		int result = ss.selectOne("sugang.SubClassCount", code);
		ss.close();
		
		return result;
	}
	
	//과목별 강의 목록 불러오기
	public static List<ClassVO> get_SubClassList(Map<String,String> map) {
		SqlSession ss = DBService.getFactory().openSession();
		List<ClassVO> list = ss.selectList("sugang.SubClassList", map);
		ss.close();
		
		return list;
	}
	
	//강의명/강사명 강의 개수 불러오기
	public static int SearchClassCount(Map<String,String> map) {
		SqlSession ss = DBService.getFactory().openSession();
		int result = ss.selectOne("sugang.SearchClassCount", map);
		ss.close();
		
		return result;
	}
	
	//강의명/강사명으로 검색해서 목록 불러오기
	public static List<ClassVO> get_SearchClassList(Map<String,String> map) {
		SqlSession ss = DBService.getFactory().openSession();
		List<ClassVO> list = ss.selectList("sugang.SearchClassList", map);
		ss.close();
		
		return list;
	}
	
	//강의 상세정보 불러오기
	public static ClassVO get_classDetail(String su_num) {
		SqlSession ss = DBService.getFactory().openSession();
		ClassVO vo = ss.selectOne("sugang.selectOne", su_num);
		ss.close();
		
		return vo;
	}
	
	//리뷰 게시판에 리뷰 작성하기
	public static int insertReview(ReviewVO vo) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.insert("sugang.insertReview", vo);
		ss.close();
		
		return result;
	}
	
	//리뷰 게시판 불러오기
	public static List<ReviewVO> get_reviewList(Map<String, Integer> map) {
		System.out.println("map : " + map);
		SqlSession ss = DBService.getFactory().openSession();
		List<ReviewVO> list = ss.selectList("sugang.reviewList", map);
		ss.close();
		
		//id 불러오기
		for(ReviewVO vo : list) {
			vo.setId(SugangDAO.get_id(vo.getMember_num()));
		}
		System.out.println(">> DAO list : " + list);
		
		return list;
	}
	
	//아이디 찾아오기
	public static String get_id(String member_num) {
		SqlSession ss = DBService.getFactory().openSession();
		String id = ss.selectOne("sugang.getId", member_num);
		ss.close();
		
		return id;
	}

	//전체 리뷰 수 조회
	public static int getReviewCount(String su_num) {
		SqlSession ss = DBService.getFactory().openSession();
		int totalCount = ss.selectOne("sugang.reviewCount", su_num);
		ss.close();
		
		return totalCount;
	}
	
	//리뷰 삭제하기
	public static int deleteReview(String re_num) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.delete("sugang.deleteReview", re_num);
		ss.close();
		
		return result;
	}
	
	//리뷰 정보 불러오기
	public static ReviewVO getReview(String re_num) {
		SqlSession ss = DBService.getFactory().openSession();
		ReviewVO vo = ss.selectOne("sugang.get_review", re_num);
		ss.close();
		
		vo.setId(SugangDAO.get_id(vo.getMember_num()));
		
		return vo;
	}
	
	//리뷰 수정
	public static int updateReview(ReviewVO vo) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.update("sugang.update_review", vo);
		ss.close();
		
		return result;
	}
	
	//선생님 목록 받아오기
	public static List<MemberVO> teacherList(){
		SqlSession ss = DBService.getFactory().openSession();
		List<MemberVO> list = ss.selectList("sugang.teacherList");
		ss.close();
		
		return list;
	}
	
	//강의 정보 수정(파일 비포함)
	public static int updateClass1(SugangVO vo) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.update("sugang.update_class1", vo);
		ss.close();
		
		return result;
	}
	
	//강의 정보 수정(파일 포함)
	public static int updateClass2(SugangVO vo) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.update("sugang.update_class2", vo);
		ss.close();
		
		return result;
	}
	
	//강의 삭제
	public static int deleteClass(String su_num) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.update("sugang.deleteClass", su_num);
		ss.close();
		
		return result;
	}
	
	//강의 추가
	public static int insertClass(SugangVO vo) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.insert("sugang.insertClass", vo);
		ss.close();
		
		return result;
	}
	
	//강의 가격 받아오기
	public static String getPrice(String su_num) {
		SqlSession ss = DBService.getFactory().openSession();
		String price = ss.selectOne("sugang.getPrice",su_num);
		ss.close();
		
		return price;
	}
	
	//장바구니에 추가하기
	public static int insertCart(CartVO vo) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.insert("sugang.insertCart", vo);
		ss.close();
		
		return result;
	}
	
	//장바구니에 이미 담긴 상품인지 확인
	public static int isInCart (Map map) {
		SqlSession ss = DBService.getFactory().openSession();
		int result = ss.selectOne("sugang.isInCart", map);
		ss.close();
		
		return result;
	}
	
	//이미 구매한 상품인지 확인
	public static int isOrdered(Map map) {
		SqlSession ss = DBService.getFactory().openSession();
		int result = ss.selectOne("sugang.isOrdered", map);
		ss.close();
		
		return result;
	}
	
	//내 장바구니 목록 불러오기
	public static List<CartVO> myCartList(String member_num){
		SqlSession ss = DBService.getFactory().openSession();
		List<CartVO> list = ss.selectList("sugang.MyCartList", member_num);
		ss.close();
		
		return list;
	}
	
	//장바구니에서 항목 삭제하기
	public static int deleteCart(String cart_num) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.delete("sugang.deleteCart", cart_num);
		ss.close();
		
		return result;
	}
	
	//카트에서 결제할 항목 받아오기(1개씩)
	public static CartVO getOneCart(String cart_num) {
		SqlSession ss = DBService.getFactory().openSession();
		CartVO vo = ss.selectOne("sugang.getOneCart", cart_num);
		ss.close();
		
		return vo;
	}
	
	//Order 테이블에 추가
	public static int insertOrder(OrderVO vo) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.insert("sugang.insertOrder", vo);
		ss.close();
		
		return result;
	}

}












