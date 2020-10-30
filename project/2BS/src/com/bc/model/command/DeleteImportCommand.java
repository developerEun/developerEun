package com.bc.model.command;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.DAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class DeleteImportCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "c:/MyStudy/60_Web/00_2BS/WebContent/file";
		/*String path = "c:/lovelyeun/fruitStore/00_2BS/WebContent/file";*/
		MultipartRequest mr = new MultipartRequest(
				request, path, (10*1024*1024),"UTF-8",new DefaultFileRenamePolicy());
		
		String deleteSelect[] = mr.getParameterValues("deleteSelect");
		
		for(String not_num : deleteSelect ) {
			DAO.deleteNotice(Integer.parseInt(not_num));
		}
		
		return "1ManagerController?type=getNoticeWriter";
	}

}
