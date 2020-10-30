package com.bc.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bc.model.DAO;
import com.bc.model.vo.NoticeReplyVO;

public class InNoticeReplyCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rep_content = request.getParameter("rep_content");
		int not_num = Integer.parseInt(request.getParameter("notNum"));
		int r_num = Integer.parseInt(request.getParameter("rNum"));
		HttpSession session = request.getSession(true);
		int member_num = (int)session.getAttribute("member_num");
		
		NoticeReplyVO noticeReply = new NoticeReplyVO();
		noticeReply.setMember_num(member_num);
		noticeReply.setRep_content(rep_content);
		noticeReply.setNot_num(not_num);
		
		DAO.insertNoticeReply(noticeReply);
		
		return "0CustomerController?type=detailNotice&rNum=" + r_num + "&notNum=" + not_num;
	}

}
