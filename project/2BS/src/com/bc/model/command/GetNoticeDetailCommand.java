package com.bc.model.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bc.model.DAO;
import com.bc.model.vo.MemberVO;
import com.bc.model.vo.NoticeReplyVO;
import com.bc.model.vo.NoticeVO;

public class GetNoticeDetailCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 임의 유저 */

		
		int r_num = Integer.parseInt(request.getParameter("rNum"));
		int not_num = Integer.parseInt(request.getParameter("notNum"));
		
		NoticeVO notice = DAO.getNoticeOne(not_num);
		NoticeVO prevNotice = DAO.getNoticeRNOne(r_num-1);
		NoticeVO nextNotice = DAO.getNoticeRNOne(r_num+1);
		
		request.setAttribute("notice", notice);
		request.setAttribute("prevNotice", prevNotice);
		request.setAttribute("nextNotice", nextNotice);
		
		List<NoticeReplyVO> replyList = DAO.getNoticeReply(not_num);
		request.setAttribute("replyList", replyList);
		
		if(request.getParameter("screenType") == null) {
			return "1noticeDetail.jsp";
		} else {
			return "1managerNoticeDetail.jsp";
		}
		
	}

}
