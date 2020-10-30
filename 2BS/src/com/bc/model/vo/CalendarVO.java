package com.bc.model.vo;

public class CalendarVO {
	private int cal_num;
	private int member_num;
	private String cal_date;
	private String cal_name;
	private String cal_content;
	private String cal_color;

	public CalendarVO() {
	}
	
	public String getCal_color() {
		return cal_color;
	}

	public void setCal_color(String cal_color) {
		this.cal_color = cal_color;
	}

	public int getCal_num() {
		return cal_num;
	}

	public void setCal_num(int cal_num) {
		this.cal_num = cal_num;
	}

	public int getMember_num() {
		return member_num;
	}

	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}

	public String getCal_date() {
		return cal_date;
	}

	public void setCal_date(String cal_date) {
		this.cal_date = cal_date;
	}

	public String getCal_name() {
		return cal_name;
	}

	public void setCal_name(String cal_name) {
		this.cal_name = cal_name;
	}

	public String getCal_content() {
		return cal_content;
	}

	public void setCal_content(String cal_content) {
		this.cal_content = cal_content;
	}
	
	@Override
	public String toString() {
		return "CalendarVO [cal_num=" + cal_num + ", member_num=" + member_num + ", cal_date=" + cal_date
				+ ", cal_name=" + cal_name + ", cal_content=" + cal_content + "]";
	}
	

	

	
	
}
