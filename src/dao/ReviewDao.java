package dao;

import java.util.Date;

import data.Database;
import data.Session;
import vo.ReviewVO;

public class ReviewDao {
	
	private static ReviewDao instance;
	
	private ReviewDao() {}
	
	public static ReviewDao getInstance() {
		if(instance == null) {
			instance = new ReviewDao();
		}
		
		return instance; 
	}
	
	Database database = Database.getInstance();

	public void showReview(String product_name) {
		if(database.tb_review.size() == 0) {
			System.out.println("등록된 리뷰가 존재하지 않습니다.\n");
		}else {
			System.out.println(product_name + "에 대해 작성된 리뷰를 조회합니다.\n");
			System.out.println("------------------------------------------------------------------------------------------------------");
			System.out.println("게시글 번호\t\t작성자\t\t상품코드\t\t상품명\t\t게시글 제목\t\t게시글 내용\t\t게시일");
			System.out.println("------------------------------------------------------------------------------------------------------");
			for(int i = database.tb_review.size() - 1; i >= 0; i--) {
				if(database.tb_review.get(i).getProduct_name().equals(product_name)) {
					System.out.println(database.tb_review.get(i).getReview_num() + "\t" + database.tb_review.get(i).getReview_name() + "\t" + database.tb_review.get(i).getProduct_code()+ "\t" + database.tb_review.get(i).getProduct_name() + "\t" + database.tb_review.get(i).getReview_name() + "\t" + database.tb_review.get(i).getReview_content() + "\t" + database.tb_review.get(i).getReview_date()  );
				}
			}
			System.out.println("------------------------------------------------------------------------------------------------------\n");
		}
	}
	
	public void enrollReviewComment(ReviewVO reviewVO) {
		if(database.tb_qna.size() == 0) {
			System.out.println("등록된 QnA가 존재하지 않습니다.\n");
		} else {
			System.out.println(reviewVO.getReview_name() + "에 대한 댓글 등록을 시작합니다.");
			for(int i = 0; i < database.tb_order.size(); i++) {
				if(database.tb_review.get(i).getProduct_name().equals(reviewVO.getProduct_name()) && database.tb_review.get(i).getReview_name().equals(reviewVO.getReview_name())) {
					reviewVO.setProduct_code(database.tb_review.get(i).getProduct_code());
					reviewVO.setReview_num(database.tb_review.get(i).getReview_num());
					int date = database.tb_review.get(i).getReview_date().compareTo(reviewVO.getReview_date());
					if(date < 0) {
						database.tb_review.add(i + 1, reviewVO);
						System.out.println(reviewVO.getReview_name() + "에 대한 댓글 등록이 완료되었습니다.\n");
					} else {
						if(i == database.tb_review.size() - 1) {
							System.out.println(reviewVO.getReview_name() + "에 해당하는 리뷰가 존재하지 않습니다.\n");
						}
					}
				}
			} 
		}
	}
	
	public void ModifyReviewComment(String product_name, String review_name, String Modified_review_name, String Modified_review_content, Date review_date) {
		if(database.tb_qna.size() == 0) {
			System.out.println("등록된 QnA가 존재하지 않습니다.\n");
		} else {
			System.out.println(review_name + "에 대한 댓글 수정을 시작합니다.");
			for(int i = 0; i < database.tb_review.size(); i++) {
				if(review_name.equals(database.tb_review.get(i).getReview_name()) && database.tb_review.get(i).getProduct_name().equals(product_name) && database.tb_review.get(i).getUser_id().equals("Admin")) {
					database.tb_review.get(i).setProduct_name(Modified_review_name);
					database.tb_review.get(i).setReview_content(Modified_review_content);
					database.tb_review.get(i).setReview_date(review_date);
					System.out.println("댓글의 수정이 완료되었습니다.\n");
				}else {
					if(i == database.tb_review.size() - 1) {
						System.out.println(review_name + "에 해당하는 리뷰가 존재하지 않습니다.\n");
					}
				}
			}
		}
	}
	
	public void deleteReviewComment(String product_name, String review_name) {
		if(database.tb_qna.size() == 0) {
			System.out.println("등록된 QnA가 존재하지 않습니다.\n");
		} else {
			System.out.println(review_name + "에 대한 댓글 삭제를 시작합니다.");
			for(int i = 0; i < database.tb_review.size(); i++) {
				if(database.tb_review.get(i).getProduct_name().equals(product_name) && database.tb_review.get(i).getReview_name().equals(review_name) && database.tb_review.get(i).getUser_id().equals("Admin")) {
					database.tb_review.remove(i);
					System.out.println("댓글 삭제가 완료되었습니다.\n");
				}else {
					if(i == database.tb_review.size() - 1) {
						System.out.println(review_name + "에 해당하는 리뷰가 존재하지 않습니다.\n");
					}
				}
			}
		}
	}
}
