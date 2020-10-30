package com.bc.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bc.model.vo.CalendarVO;
import com.bc.model.vo.NoticeReplyVO;
import com.bc.model.vo.NoticeVO;
import com.bc.model.vo.SearchVO;
import com.bc.mybatis.DBService;

public class DAO {

	public static void insertTodo(CalendarVO todo) {
		SqlSession ss = DBService.getFactory().openSession(true);
		ss.insert("2BS2.insertTodo", todo);
		ss.close();
	}
	
	public static void insertNotice(NoticeVO notice) {
		SqlSession ss = DBService.getFactory().openSession(true);
		ss.insert("2BS2.insertNotice", notice);
		ss.close();
	}
	
	public static void insertNoticeReply(NoticeReplyVO noticeReply) {
		SqlSession ss = DBService.getFactory().openSession(true);
		ss.insert("2BS2.insertNoticeReply", noticeReply);
		ss.close();
	}
	
	//寃뚯떆湲��쓽 �쟾泥� 嫄댁닔 議고쉶
	public static int getTotalCount() {
		SqlSession ss = DBService.getFactory().openSession();
		int totalCount = ss.selectOne("2BS2.totalCount");
		ss.close();
		
		return totalCount;
	}
	
	public static int getSearchCount(String idx, String keyword) {
		SqlSession ss = DBService.getFactory().openSession();
		Map<String, String> map = new HashMap<>();
		map.put("idx", idx);
		map.put("keyword", keyword);
		int totalCount = ss.selectOne("2BS2.searchCount", map);
		ss.close();
		
		return totalCount;
	}
	
	//寃뚯떆湲��쓽 湲닿툒 嫄댁닔 議고쉶
	public static int getImportCount() {
		SqlSession ss = DBService.getFactory().openSession();
		int importCount = ss.selectOne("2BS2.importCount");
		ss.close();
		
		return importCount;
	}
	
	//�럹�씠吏��뿉 �빐�떦�븯�뒗 湲�紐⑸줉(寃뚯떆湲�) 媛��졇�삤湲�
	public static List<NoticeVO> getNoticeList(Map<String, Integer> map) {
		SqlSession ss = DBService.getFactory().openSession();
		List<NoticeVO> list = ss.selectList("2BS2.noticeList", map);
		ss.close();
		return list;
	}
	
	public static List<NoticeVO> getAllNoticeList() {
		SqlSession ss = DBService.getFactory().openSession();
		List<NoticeVO> list = ss.selectList("2BS2.noticeAllList");
		ss.close();
		return list;
	}
	
	public static List<NoticeVO> getNoticeSearchList(SearchVO search) {
		SqlSession ss = DBService.getFactory().openSession();
		List<NoticeVO> list = ss.selectList("2BS2.noticeSearchList", search);
		ss.close();
		return list;
	}
	
	public static List<NoticeVO> getImportNotice() {
		SqlSession ss = DBService.getFactory().openSession();
		List<NoticeVO> list = ss.selectList("2BS2.importNotice");
		ss.close();
		return list;
	}
	
	public static List<NoticeReplyVO> getNoticeReply(int not_num) {
		SqlSession ss = DBService.getFactory().openSession();
		List<NoticeReplyVO> list = ss.selectList("2BS2.noticeReplyList", not_num);
		ss.close();
		return list;
	}
	
	//�럹�씠吏��뿉 �빐�떦�븯�뒗 �긽�꽭�럹�씠吏� 媛��졇�삤湲�
	public static NoticeVO getNoticeOne(int not_num) {
		SqlSession ss = DBService.getFactory().openSession();
		NoticeVO notice = ss.selectOne("2BS2.noticeOne", not_num);
		ss.close();
		return notice;
	}
	
	public static NoticeVO getNoticeRNOne(int not_num) {
		SqlSession ss = DBService.getFactory().openSession();
		NoticeVO notice = ss.selectOne("2BS2.noticeRNOne", not_num);
		ss.close();
		return notice;
	}
	
	public static void updateTodo(CalendarVO todo) {
		SqlSession ss = DBService.getFactory().openSession(true);
		ss.update("2BS2.updateTodo", todo);
		ss.close();
	}
	
	public static void updateNoticeReply(NoticeReplyVO noticeReply) {
		SqlSession ss = DBService.getFactory().openSession(true);
		ss.update("2BS2.updateNoticeReply", noticeReply);
		ss.close();
	}
	
	public static void updateNotice(NoticeVO notice) {
		SqlSession ss = DBService.getFactory().openSession(true);
		ss.update("2BS2.updateNotice", notice);
		ss.close();
	}
	
	public static void deleteTodo(int todo) {
		SqlSession ss = DBService.getFactory().openSession(true);
		ss.delete("2BS2.deleteTodo", todo);
		ss.close();
	}
	
	public static void deleteNotice(int not_num) {
		SqlSession ss = DBService.getFactory().openSession(true);
		ss.delete("2BS2.deleteNotice", not_num);
		ss.close();
	}
	
	public static void deleteNoticeReply(int rep_num) {
		SqlSession ss = DBService.getFactory().openSession(true);
		ss.delete("2BS2.deleteNoticeReply", rep_num);
		ss.close();
	}
	
	public static List<CalendarVO> getTodo() {
		SqlSession ss = DBService.getFactory().openSession();
		List<CalendarVO> todo = ss.selectList("2BS2.getTodo");
		ss.close();
		
		return todo;
	}
}
