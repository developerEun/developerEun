package com.bc.model.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bc.model.DAO;
import com.bc.model.vo.NoticeVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UpdateNoticeCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String path = session.getServletContext().getRealPath("/file");
		
		/*String path = "c:/lovelyeun/fruitStore/00_2BS/WebContent/file";*/
		MultipartRequest mr = new MultipartRequest(
				request, path, (10*1024*1024),"UTF-8",new DefaultFileRenamePolicy());
		
		NoticeVO notice = new NoticeVO();
		
		int not_num = Integer.parseInt(mr.getParameter("notNum"));
		int r_num = Integer.parseInt(mr.getParameter("rNum"));
		String type = mr.getParameter("kind");
		String title = mr.getParameter("title");
		String text = mr.getParameter("text");
		
		notice.setNot_num(not_num);
		notice.setNot_type(type);
		notice.setNot_name(title);
		notice.setNot_content(text);
		
		if(mr.getFile("file") != null) {
			notice.setNot_file(mr.getFilesystemName("file"));
			notice.setNot_file_ori(mr.getOriginalFileName("file"));
		} else {
			notice.setNot_file("");
			notice.setNot_file_ori("");
		}
		
		DAO.updateNotice(notice);
		
		int importCnt = DAO.getImportCount();
		request.setAttribute("importCnt", importCnt);
		List<NoticeVO> importList = DAO.getImportNotice();
		request.setAttribute("importList", importList);
		
		return "1ManagerController?type=detailNotice&screenType=1&rNum="+ r_num +"&notNum=" + not_num;
	}

}
