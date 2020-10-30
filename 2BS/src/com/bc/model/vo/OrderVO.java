package com.bc.model.vo;

public class OrderVO {
	public String order_num;
	public String member_num;
	public String su_num;
	public String card;
	public String price;
	public String order_date;
	
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
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
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	
	@Override
	public String toString() {
		return "OrderVO [order_num=" + order_num + ", member_num=" + member_num + ", su_num=" + su_num + ", card="
				+ card + ", price=" + price + ", order_date=" + order_date + "]";
	}
	
}
