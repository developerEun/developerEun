package com.bc.model.vo;

public class ClassVO {
	private String su_num;
	private String code;
	private String su_name;
	private String price;
	private String t_code;
	private String member_num;
	private String su_date;
	private String img;
	private String name;
	
	public String getSu_num() {
		return su_num;
	}
	public void setSu_num(String su_num) {
		this.su_num = su_num;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSu_name() {
		return su_name;
	}
	public void setSu_name(String su_name) {
		this.su_name = su_name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getT_code() {
		return t_code;
	}
	public void setT_code(String t_code) {
		this.t_code = t_code;
	}
	public String getMember_num() {
		return member_num;
	}
	public void setMember_num(String member_num) {
		this.member_num = member_num;
	}
	public String getSu_date() {
		return su_date;
	}
	public void setSu_date(String su_date) {
		this.su_date = su_date;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "ClassVO [su_num=" + su_num + ", code=" + code + ", su_name=" + su_name + ", price=" + price
				+ ", t_code=" + t_code + ", member_num=" + member_num + ", su_date=" + su_date + ", img=" + img
				+ ", name=" + name + "]";
	}
	
	
	
	
}
