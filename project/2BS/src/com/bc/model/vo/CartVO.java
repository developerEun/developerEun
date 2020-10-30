package com.bc.model.vo;

public class CartVO {
	private String cart_num;
	private String member_num;
	private String su_num;
	private String price;
	private String su_name;
	
	public String getCart_num() {
		return cart_num;
	}
	public void setCart_num(String cart_num) {
		this.cart_num = cart_num;
	}
	public String getMember_num() {
		return member_num;
	}
	public void setMember_num(String member_num) {
		this.member_num = member_num;
	}
	public String getSu_num() {
		return su_num;
	}
	public void setSu_num(String su_num) {
		this.su_num = su_num;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSu_name() {
		return su_name;
	}
	public void setSu_name(String su_name) {
		this.su_name = su_name;
	}
	
	@Override
	public String toString() {
		return "CartVO [cart_num=" + cart_num + ", member_num=" + member_num + ", su_num=" + su_num + ", price=" + price
				+ ", su_name=" + su_name + "]";
	}
	
	
	
}
