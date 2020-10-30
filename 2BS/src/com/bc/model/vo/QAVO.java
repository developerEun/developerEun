package com.bc.model.vo;

import java.util.Date;

public class QAVO {
	private int qa_num;
	private int member_num;
	private int s_t;
	private int t_code;
	private String qa_name;
	private String qa_content;
	private String qa_date;
	private int su_num;
	


	public int getSu_num() {
		return su_num;
	}
	public void setSu_num(int su_num) {
		this.su_num = su_num;
	}
	public int getQa_num() {
		return qa_num;
	}
	public void setQa_num(int qa_num) {
		this.qa_num = qa_num;
	}
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}
	public int getS_t() {
		return s_t;
	}
	public void setS_t(int s_t) {
		this.s_t = s_t;
	}
	public int getT_code() {
		return t_code;
	}
	public void setT_code(int t_code) {
		this.t_code = t_code;
	}
	public String getQa_name() {
		return qa_name;
	}
	public void setQa_name(String qa_name) {
		this.qa_name = qa_name;
	}
	public String getQa_content() {
		return qa_content;
	}
	public void setQa_content(String qa_content) {
		this.qa_content = qa_content;
	}
	public String getQa_date() {
		return qa_date;
	}
	public void setQa_date(String qa_date) {
		this.qa_date = qa_date;
	}
	@Override
	public String toString() {
		return "QAVO [qa_num=" + qa_num + ", member_num=" + member_num + ", s_t=" + s_t + ", t_code=" + t_code
				+ ", qa_name=" + qa_name + ", qa_content=" + qa_content + ", qa_date=" + qa_date + ", su_num=" + su_num
				+ "]";
	}

	
	
}
