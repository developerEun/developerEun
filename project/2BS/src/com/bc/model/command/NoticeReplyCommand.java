package com.bc.model.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.DAO;
import com.bc.model.vo.NoticeReplyVO;

public class NoticeReplyCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String changeType = request.getParameter("change");
		String rep_content = request.getParameter("repContent");
		int r_num = Integer.parseInt(request.getParameter("rNum"));
		int not_num = Integer.parseInt(request.getParameter("notNum"));
		int rep_num = Integer.parseInt(request.getParameter("repNum"));
		
		NoticeReplyVO noticeReply = new NoticeReplyVO();
		
		if("update".equals(changeType)) {
			noticeReply.setRep_num(rep_num);
			noticeReply.setRep_content(rep_content);
			
			DAO.updateNoticeReply(noticeReply);
		}else if("delete".equals(changeType)){
			DAO.deleteNoticeReply(rep_num);
		}
		
		
		return "0CustomerController?type=detailNotice&rNum=" + r_num + "&notNum=" + not_num;
	}

}
