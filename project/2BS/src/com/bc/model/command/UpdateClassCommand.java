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

public class UpdateClassCommand implements Command {

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
		
		File img = mr.getFile("img");
		
		
		SugangVO vo = new SugangVO();
		String su_num = mr.getParameter("su_num");
		System.out.println("su_num : " + su_num );
		vo.setSu_num(su_num);
		vo.setSu_name(mr.getParameter("su_name"));
		vo.setPrice(mr.getParameter("price"));
		
		List<MemberVO> list = (List<MemberVO>)session.getAttribute("teacherList");
		System.out.println(list);
		//선희 수정 int 타입
		int member_num = Integer.parseInt(mr.getParameter("teacher"));
		vo.setMember_num(member_num);
		int t_code = -1;
		for(MemberVO mem : list) {
			if(mem.getMember_num() == member_num) {
				t_code = mem.getT_code();
			}
		}
		vo.setT_code(t_code);
		int result = 0;
		
		if(img == null) { //파일을 수정하지 않을 때
			System.out.println(vo);
			result = SugangDAO.updateClass1(vo);
			
		}else { //파일을 수정할 때
			String str = img.getName();
			vo.setImg(str); //파일 이름 저장
			result = SugangDAO.updateClass2(vo);
		}
		
		System.out.println("updateClass : " + result);
		
		return "controller?type=classManage&su_num=" + su_num;
	}

}
