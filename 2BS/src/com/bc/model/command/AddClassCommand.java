package com.bc.model.command;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bc.model.SugangDAO;
import com.bc.model.vo.MemberVO;
import com.bc.model.vo.SugangVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AddClassCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. insert 해줄 SugangVO 만들기
		HttpSession session = request.getSession();
		String path = session.getServletContext().getRealPath("/img");
		
		//파일처리용 MultipartRequest 객체
		MultipartRequest mr = new MultipartRequest(
				request, path, 10 * 1024 * 1024, 
				"UTF-8", new DefaultFileRenamePolicy()
				);
		
		SugangVO vo = new SugangVO();
		vo.setCode(mr.getParameter("code"));
		vo.setSu_name(mr.getParameter("su_name"));
		vo.setPrice(mr.getParameter("price"));
		
		//세션에서 선생님 목록 받아와서 t_code 채워주기
		//선희 수정 int 타입
		int member_num = Integer.parseInt(mr.getParameter("teacher"));
		vo.setMember_num(member_num);
		int t_code = -1;
		
		List<MemberVO> list = (List<MemberVO>)session.getAttribute("teacherList");
		for(MemberVO mem : list) {
			if(mem.getMember_num() == member_num) {
				t_code = mem.getT_code();
			}
		}
		vo.setT_code(t_code);
		
		//파일 업로드 및 저장
		File img = mr.getFile("img");
		String str = "";
		if(img != null) {
			str = img.getName();
			vo.setImg(mr.getOriginalFileName("img")); //파일 이름 저장
		}
		
		//2. 데이터베이스에 insert해주기.
		int result = SugangDAO.insertClass(vo);
		System.out.println("insetClass : " + result);
		
		//3. 이미지를 다운로드
		if(str.equals("")) {
			System.out.println("70");
			return "1ManagerController?type=insertList";
		}else {
			session.setAttribute("str", str);
			System.out.println("requestDispatcher");
			//response.sendRedirect("download.jsp");
			return "download.jsp";
		}
	}

}
