package vo;

import java.util.Date;

public class OrderVO {
	private Date Buy_date;
	private String Product_code;
	private int Buy_count;
	private Date Order_date;
	private String Delivery_status;
	private int User_phone_num;
	private String Member_add1;
	private String Delivery_waybill;
	
	public Date getBuy_date() {
		return Buy_date;
	}
	public void setBuy_date(Date buy_date) {
		Buy_date = buy_date;
	}
	public String getProduct_code() {
		return Product_code;
	}
	public void setProduct_code(String product_code) {
		Product_code = product_code;
	}
	public int getBuy_count() {
		return Buy_count;
	}
	public void setBuy_count(int buy_count) {
		Buy_count = buy_count;
	}
	public Date getOrder_date() {
		return Order_date;
	}
	public void setOrder_date(Date order_date) {
		Order_date = order_date;
	}
	public String getDelivery_status() {
		return Delivery_status;
	}
	public void setDelivery_status(String delivery_status) {
		Delivery_status = delivery_status;
	}
	public int getUser_phone_num() {
		return User_phone_num;
	}
	public void setUser_phone_num(int user_phone_num) {
		User_phone_num = user_phone_num;
	}
	public String getMember_add1() {
		return Member_add1;
	}
	public void setMember_add1(String member_add1) {
		Member_add1 = member_add1;
	}
	public String getDelivery_waybill() {
		return Delivery_waybill;
	}
	public void setDelivery_waybill(String delivery_waybill) {
		Delivery_waybill = delivery_waybill;
	}

}