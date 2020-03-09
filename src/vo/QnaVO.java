package vo;

import java.util.Date;

public class QnaVO{
	private int Qna_num;
	private String Qna_name;
	private String Qna_content;
	private String Qna_password;
	private Date Qna_date;
	private String Member_id;
	private String Product_code;
	
	public int getQna_num() {
		return Qna_num;
	}
	public void setQna_num(int qna_num) {
		Qna_num = qna_num;
	}
	public String getQna_name() {
		return Qna_name;
	}
	public void setQna_name(String qna_name) {
		Qna_name = qna_name;
	}
	public String getQna_content() {
		return Qna_content;
	}
	public void setQna_content(String qna_content) {
		Qna_content = qna_content;
	}
	public String getQna_password() {
		return Qna_password;
	}
	public void setQna_password(String qna_password) {
		Qna_password = qna_password;
	}
	public Date getQna_date() {
		return Qna_date;
	}
	public void setQna_date(Date qna_date) {
		Qna_date = qna_date;
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