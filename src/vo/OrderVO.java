package vo;

import java.util.Date;

public class OrderVO {
	private String Order_code; //
	private String Product_code; //
	private String Product_name; //
	private String User_id;
	private int Buy_count; //
	private Date Order_date; //
	private String Delivery_status; //
	private String User_phone_num;
	private String Member_add1;
	private String Delivery_waybill;//운송장번호는 order_code를 해쉬값으로 만들어서 저장
	private String change_order; //
	
	public String getOrder_code() {
		return Order_code;
	}
	public void setOrder_code(String order_code) {
		Order_code = order_code;
	}
	public String getProduct_code() {
		return Product_code;
	}
	public void setProduct_code(String product_code) {
		Product_code = product_code;
	}
	public String getProduct_name() {
		return Product_name;
	}
	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}
	public String getUser_id() {
		return User_id;
	}
	public void setUser_id(String user_id) {
		User_id = user_id;
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
	public String getUser_phone_num() {
		return User_phone_num;
	}
	public void setUser_phone_num(String user_phone_num) {
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
	public String getChange_order() {
		return change_order;
	}
	public void setChange_order(String change_order) {
		this.change_order = change_order;
	}
	
	
}