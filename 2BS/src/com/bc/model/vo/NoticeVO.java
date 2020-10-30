package com.bc.model.vo;

public class NoticeVO {
	private int r_num;
	private int not_num;
	private int member_num;
	private String member_name;
	private int s_t;
	private String not_name;
	private String not_content;
	private String not_date;
	private String not_type;
	private String not_file;
	private String not_file_ori;
	
	public NoticeVO() {
	}
	
	public String getNot_file() {
		return not_file;
	}

	public void setNot_file(String not_file) {
		this.not_file = not_file;
	}

	public String getNot_file_ori() {
		return not_file_ori;
	}

	public void setNot_file_ori(String not_file_ori) {
		this.not_file_ori = not_file_ori;
	}

	public int getR_num() {
		return r_num;
	}

	public void setR_num(int r_num) {
		this.r_num = r_num;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public int getNot_num() {
		return not_num;
	}

	public void setNot_num(int not_num) {
		this.not_num = not_num;
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

	public String getNot_name() {
		return not_name;
	}

	public void setNot_name(String not_name) {
		this.not_name = not_name;
	}

	public String getNot_content() {
		return not_content;
	}

	public void setNot_content(String not_content) {
		this.not_content = not_content;
	}

	public String getNot_date() {
		return not_date;
	}

	public void setNot_date(String not_date) {
		this.not_date = not_date;
	}

	public String getNot_type() {
		return not_type;
	}

	public void setNot_type(String not_type) {
		this.not_type = not_type;
	}

	@Override
	public String toString() {
		return "NoticeVO [not_num=" + not_num + ", member_num=" + member_num + ", s_t=" + s_t + ", not_name=" + not_name
				+ ", not_content=" + not_content + ", not_date=" + not_date + ", not_type=" + not_type + "]";
	}
	
	
	
}
