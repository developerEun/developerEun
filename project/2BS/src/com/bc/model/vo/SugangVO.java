package com.bc.model.vo;

public class SugangVO {
	private String su_num;
	private String code;
	private String su_name;
	private String price;
	private int t_code;
	private int member_num;
	private String su_date;
	private String img;
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
	public int getT_code() {
		return t_code;
	}
	public void setT_code(int t_code) {
		this.t_code = t_code;
	}
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
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
	
	@Override
	public String toString() {
		return "SugangVO [su_num=" + su_num + ", code=" + code + ", su_name=" + su_name + ", price=" + price
				+ ", t_code=" + t_code + ", member_num=" + member_num + ", su_date=" + su_date + ", img=" + img + "]";
	}
	
}
