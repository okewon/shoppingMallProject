package service;

import java.util.Date;
import java.util.Scanner;

import dao.ReviewDao;
import data.Session;
import vo.ReviewVO;

public class ReviewService {

	private static ReviewService instance;
	private static int Review_num = 1;
	
	private ReviewService() {}
	
	public static ReviewService getInstance() {
		if(instance == null) {
			instance = new ReviewService();
		}
		return instance;
	}
	
	ReviewDao reviewDao = ReviewDao.getInstance();
	
	public void enrollReviewComment() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("리뷰에 대한 댓글을 작성 합니다.\n");
		System.out.print("조회하고자 하는 리뷰의 상품명을 작성하시오. >> ");
		String product_name = s.nextLine();
		reviewDao.showReview(product_name);
		System.out.print("댓글을 작성할 게시글의 제목을 입력하시오. >> ");
		String Review_name = s.nextLine();
		System.out.print("내용을 입력하세요. >> ");
		String Review_content = s.nextLine();
		String User_id = Session.LoginUser.getUser_id();
		Date Review_date = new Date();
		
		ReviewVO reviewVO = new ReviewVO();
		reviewVO.setReview_name(Review_name);
		reviewVO.setReview_content(Review_content);
		reviewVO.setProduct_name(product_name);
		reviewVO.setUser_id(User_id);
		reviewVO.setReview_date(Review_date);
		reviewVO.setReview_num(Review_num);
	
		reviewDao.enrollReviewComment(reviewVO);
		Review_num++;
	}
	
	public void modifyReviewComment() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("작성된 리뷰에 대한 댓글을 수정합니다.\n");
		System.out.print("수정하고자 하는 리뷰의 상품명을 작성하시오. >> ");
		String product_name = s.nextLine();
		reviewDao.showReview(product_name);
		System.out.print("수정하고자 하는 게시글의 제목을 입력하시오. >> ");
		String Review_name = s.nextLine();
		System.out.print("변경될 제목을 입력하세요. >> ");
		String Modified_review_name = s.nextLine();
		System.out.println("변경될 내용을 입력하세요. >> ");
		String Modified_review_content = s.nextLine();
		Date Review_date = new Date();
		
		reviewDao.ModifyReviewComment(product_name, Review_name, Modified_review_name, Modified_review_content, Review_date);
	}
	
	public void deleteReviewComment() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("삭제하고자 하는 댓글이 존재하는 리뷰의 상품명을 입력하시오. >> ");
		String product_name = s.nextLine();
		reviewDao.showReview(product_name);
		System.out.println("삭제하고자 하는 댓글이 존재하는 리뷰의 제목을 입력하시오. >> ");
		String Review_name = s.nextLine();
		
		reviewDao.deleteReviewComment(product_name, Review_name);
	}
	
	public void showReview() {
		Scanner s = new Scanner(System.in);
		
		System.out.print("조회하고자 하는 리뷰의 상품명을 작성하시오. >> ");
		String product_name = s.nextLine();
		reviewDao.showReview(product_name);
	}
}
