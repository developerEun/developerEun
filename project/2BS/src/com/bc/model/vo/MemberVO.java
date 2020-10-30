package com.bc.model.vo;

import java.util.Date;

public class MemberVO {
	private int member_num;
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private int s_t;
	private int t_code;
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	@Override
	public String toString() {
		return "MemberVO [member_num=" + member_num + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", phone="
				+ phone + ", s_t=" + s_t + ", t_code=" + t_code + "]";
	}
	
	
	
}
