package vo;

import java.util.Date;

public class ReviewVO{
	private int Review_num;
	private String Review_name;
	private String Review_content;
	private Date Review_date;
	private String Member_id;
	private String Product_code;
	
	public int getReview_num() {
		return Review_num;
	}
	public void setReview_num(int review_num) {
		Review_num = review_num;
	}
	public String getReview_name() {
		return Review_name;
	}
	public void setReview_name(String review_name) {
		Review_name = review_name;
	}
	public String getReview_content() {
		return Review_content;
	}
	public void setReview_content(String review_content) {
		Review_content = review_content;
	}
	public Date getReview_date() {
		return Review_date;
	}
	public void setReview_date(Date review_date) {
		Review_date = review_date;
	}
	public String getMember_id() {
		return Member_id;
	}
	public void setMember_id(String member_id) {
		Member_id = member_id;
	}
	public String getProduct_code() {
		return Product_code;
	}
	public void setProduct_code(String product_code) {
		Product_code = product_code;
	}	
	
}