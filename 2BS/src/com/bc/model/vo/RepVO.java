package com.bc.model.vo;

import java.util.Date;

public class RepVO {
	private int rep_num;
	private int qa_num; 
	private int t_code;
	private String rep_content;
	private String rep_date;
	private int member_num;
	public int getRep_num() {
		return rep_num;
	}
	public void setRep_num(int rep_num) {
		this.rep_num = rep_num;
	}
	public int getQa_num() {
		return qa_num;
	}
	public void setQa_num(int qa_num) {
		this.qa_num = qa_num;
	}
	public int getT_code() {
		return t_code;
	}
	public void setT_code(int t_code) {
		this.t_code = t_code;
	}
	public String getRep_content() {
		return rep_content;
	}
	public void setRep_content(String rep_content) {
		this.rep_content = rep_content;
	}
	public String getRep_date() {
		return rep_date;
	}
	public void setRep_date(String rep_date) {
		this.rep_date = rep_date;
	}
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}
	@Override
	public String toString() {
		return "RepVO [rep_num=" + rep_num + ", qa_num=" + qa_num + ", t_code=" + t_code + ", rep_content="
				+ rep_content + ", rep_date=" + rep_date + ", member_num=" + member_num + "]";
	}
	



}
