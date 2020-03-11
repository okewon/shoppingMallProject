package dao;

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
		System.out.println(product_name + "에 대해 작성된 리뷰를 조회합니다.");
		for(int i = database.tb_review.size(); i >= 0; i--) {
			if(database.tb_review.get(i).getProduct_name().equals(product_name)) {
				System.out.println("------------------------------------------------------------------------------------------------------");
				System.out.print("게시글 번호\t작성자\t상품코드\t상품명\t게시글 제목\t게시글 내용\t게시일\t");
				System.out.println("------------------------------------------------------------------------------------------------------");
				System.out.println(database.tb_review.get(i).getReview_num() + "\t" + database.tb_review.get(i).getReview_name() + "\t" + database.tb_review.get(i).getProduct_code()+ "\t" + database.tb_review.get(i).getProduct_name() + "\t" + database.tb_review.get(i).getReview_name() + "\t" + database.tb_review.get(i).getReview_content() + "\t" + database.tb_review.get(i).getReview_date()  );
				System.out.println("------------------------------------------------------------------------------------------------------");
			}
		}
	}
	
	public void enrollReviewComment(ReviewVO reviewVO) {
		System.out.println(reviewVO.getReview_name() + "에 대한 댓글 등록을 시작합니다.");
		for(int i = 0; i < database.tb_order.size(); i++) {
			if(database.tb_review.get(i).getProduct_name().equals(reviewVO.getProduct_name()) && database.tb_review.get(i).getReview_name().equals(reviewVO.getReview_name())) {
				reviewVO.setProduct_code(database.tb_review.get(i).getProduct_code());
				reviewVO.setReview_num(database.tb_review.get(i).getReview_num());
				int date = database.tb_review.get(i).getReview_date().compareTo(reviewVO.getReview_date());
				if(date < 0) {
					database.tb_review.add(i + 1, reviewVO);
					System.out.println(reviewVO.getReview_name() + "댓글 등록이 완료되었습니다.");
				} else {
					if(i == database.tb_review.size() - 1) {
						System.out.println(reviewVO.getReview_name() + "에 해당하는 리뷰가 존재하지 않습니다.");
					}
				}
			}
		} 
	}
	
	public void ModifyReviewComment(ReviewVO reviewVO, String review_name) {
		System.out.println(review_name + "에 대한 댓글 수정을 시작합니다.");
		for(int i = 0; i < database.tb_review.size(); i++) {
			if(review_name.equals(database.tb_review.get(i).getReview_name()) && database.tb_review.get(i).getProduct_name().equals(reviewVO.getProduct_name()) && Session.LoginUser.getUser_access() == 1) {
				database.tb_review.set(i, reviewVO);
				System.out.println("댓글의 수정이 완료되었습니다.");
			}else {
				if(i == database.tb_review.size() - 1) {
					System.out.println(review_name + "에 해당하는 리뷰가 존재하지 않습니다.");
				}
			}
		}
	}
	
	public void deleteReviewComment(String product_name, String review_name) {
		System.out.println(review_name + "에 대한 삭제를 시작합니다.");
		for(int i = 0; i < database.tb_review.size(); i++) {
			if(database.tb_review.get(i).getProduct_name().equals(product_name) && database.tb_review.get(i).getReview_name().equals(review_name) && Session.LoginUser.getUser_access() == 1) {
				database.tb_review.remove(i);
				System.out.println("댓글 삭제가 완료되었습니다.");
			}else {
				if(i == database.tb_review.size() - 1) {
					System.out.println(review_name + "에 해당하는 리뷰가 존재하지 않습니다.");
				}
			}
		}
	}
}
