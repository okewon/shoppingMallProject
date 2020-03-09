package vo;

public class CartVO {
	private String Order_Num;
	private String Product_code;
	private String User_id;
	private int Poduct_count;
	
	public String getOrder_Num() {
		return Order_Num;
	}
	public void setOrder_Num(String order_Num) {
		Order_Num = order_Num;
	}
	public String getProduct_code() {
		return Product_code;
	}
	public void setProduct_code(String product_code) {
		Product_code = product_code;
	}
	public String getUser_id() {
		return User_id;
	}
	public void setUser_id(String user_id) {
		User_id = user_id;
	}
	public int getPoduct_count() {
		return Poduct_count;
	}
	public void setPoduct_count(int poduct_count) {
		Poduct_count = poduct_count;
	}
	
}
