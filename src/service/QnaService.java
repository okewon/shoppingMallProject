package service;

import java.util.Date;
import java.util.Scanner;

import dao.QnaDao;
import data.Session;
import vo.QnaVO;
import vo.ReviewVO;

public class QnaService {
	
	private static QnaService instance;
	private static int Qna_num = 1;
	
	private QnaService() {}
	
	public static QnaService getInstance() {
		if(instance == null) {
			instance = new QnaService();
		}
		return instance;
	}
	
	QnaDao qnaDao = QnaDao.getInstance();
	
	public void showQna() {
		Scanner s = new Scanner(System.in);
		
		System.out.print("조회하고자 하는 QnA의 상품명을 작성하시오. >> ");
		String product_name = s.nextLine();
		qnaDao.showQna(product_name);
	}
	
	public void enrollComment() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Qna에 대한 댓글을 작성 합니다.\n");
		System.out.print("조회하고자 하는 Qna의 상품명을 작성하시오. >> ");
		String product_name = s.nextLine();
		qnaDao.showQna(product_name);		
		System.out.print("댓글을 작성할 게시글의 제목을 입력하시오. >> ");
		String qna_name = s.nextLine();
		System.out.print("내용을 입력하세요. >> ");
		String qna_content = s.nextLine();
		String User_id = Session.LoginUser.getUser_id();
		Date qna_date = new Date();
		
		QnaVO qnaVO = new QnaVO();
		qnaVO.setQna_name(qna_name);
		qnaVO.setQna_content(qna_content);
		qnaVO.setProduct_name(product_name);
		qnaVO.setUser_id(User_id);
		qnaVO.setQna_date(qna_date);
		qnaVO.setQna_num(Qna_num);
	
		qnaDao.enrollComment(qnaVO, qna_name);
		Qna_num++;
	}
	
	public void modifyComment() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("작성된 QnA에 대한 댓글을 수정합니다.\n");
		System.out.print("수정하고자 하는 리뷰의 상품명을 작성하시오. >> ");
		String product_name = s.nextLine();
		qnaDao.showQna(product_name);
		System.out.print("수정하고자 하는 게시글의 제목을 입력하시오. >> ");
		String qna_name = s.nextLine();
		System.out.print("변경될 제목을 입력하세요. >> ");
		String Modified_qna_name = s.nextLine();
		System.out.print("변경될 내용을 입력하세요. >> ");
		String Modified_qna_content = s.nextLine();
		Date qna_date = new Date();
		
		qnaDao.modifyComment(product_name, qna_name, Modified_qna_name, Modified_qna_content, qna_date);
	}
	
	public void deleteComment() {
		Scanner s = new Scanner(System.in);
		
		System.out.print("삭제하고자 하는 댓글이 존재하는 QnA의 상품명을 입력하시오. >> ");
		String product_name = s.nextLine();
		qnaDao.showQna(product_name);
		System.out.print("삭제하고자 하는 댓글이 존재하는 Qna의 제목을 입력하시오. >> ");
		String qna_name = s.nextLine();
		
		qnaDao.deleteComment(product_name, qna_name);
	}
}
