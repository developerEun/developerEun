package com.bc.frontcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.command.AddClassCommand;
import com.bc.model.command.ClassDetailCommand;
import com.bc.model.command.ClassListCommand;
import com.bc.model.command.Command;
import com.bc.model.command.DeleteCartCommand;
import com.bc.model.command.DeleteClassCommand;
import com.bc.model.command.DeleteReviewCommand;
import com.bc.model.command.DoPaymentCommand;
import com.bc.model.command.DoUpdateReviewCommand;
import com.bc.model.command.DownloadCommand;
import com.bc.model.command.InsertCartCommand;
import com.bc.model.command.InsertClassCommand;
import com.bc.model.command.InsertListCommand;
import com.bc.model.command.MyCartCommand;
import com.bc.model.command.PaymentCommand;
import com.bc.model.command.SearchCommand;
import com.bc.model.command.SubClassListCommand;
import com.bc.model.command.UpdateClassCommand;
import com.bc.model.command.UpdateDeleteClassCommand;
import com.bc.model.command.UpdateReviewCommand;
import com.bc.model.command.WriteReviewCommand;

@WebServlet("/controller")
public class FrontControllerCommand extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		System.out.println(">type : " + type);
		Command command = null;
		//강의 목록 페이지
		if("classList".equals(type)) {
			command = new ClassListCommand();
		//강의 목록 페이지(과목별)
		}else if("SubclassList".equals(type)) {
			command = new SubClassListCommand();
		//동적검색 : 강의명, 강사명
		}else if ("search".equals(type)) {
			command = new SearchCommand();
		//강의 정보 페이지
		} else if ("classDetail".equals(type)) {
			System.out.println("classDetail");
			command = new ClassDetailCommand();
		//리뷰 쓰기
		} else if ("writeReview".equals(type)) {
			command = new WriteReviewCommand();
		//리뷰 수정페이지로 보내주기
		}else if("updReview".equals(type)) {
			command = new UpdateReviewCommand();
		//리뷰 수정하기
		}else if("doUpdateReview".equals(type)) {
			command = new DoUpdateReviewCommand();
		//리뷰 삭제
		}else if("delReview".equals(type)) {
			command = new DeleteReviewCommand();
			//(관리자페이지) 강의 수정/삭제 페이지로 넘어가기
		}else if("classManage".equals(type)) {
			command = new UpdateDeleteClassCommand();
		//카트에 넣기
		}else if ("insertCart".equals(type)) {
			command = new InsertCartCommand();
		//내 장바구니 목록 보기
		}else if("myCart".equals(type)) {
			command = new MyCartCommand();
		//장바구니에서 항목 삭제
		}else if("deleteCart".contentEquals(type)) {	
			command = new DeleteCartCommand();
		//체크된 항목 결제하기
		}else if("payment".equals(type)) {
			command = new PaymentCommand();
		//카드로 결제하기
		}else if ("doPayment".equals(type)){
			command = new DoPaymentCommand();
		//(관리자페이지) 강의 목록으로 넘어가기
		}else if("insertList".equals(type)) {
			command = new InsertListCommand();
		//(관리자페이지) 강의 추가 폼으로 넘어가기
		}else if("insertClass".equals(type)) {
			command = new InsertClassCommand();
		//(관리자페이지) 강의 추가 후 목록으로 돌아가기
		}else if("addClass".equals(type)) {
			command = new AddClassCommand();
		//(관리자페이지) 강의 정보 수정
		} else if ("updateClass".equals(type)) {
			command = new UpdateClassCommand();
		//(관리자페이지) 강의 삭제
		}else if ("classDelete".equals(type)){
			command = new DeleteClassCommand();
		}else if("download".equals(type)) {
			command = new DownloadCommand();
		}else {
			System.out.println("type값 찾기");
		}
		
		String path = command.exec(request, response);
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}










