package dao;

import java.util.Date;

import data.Database;
import data.Session;
import vo.QnaVO;

public class QnaDao {
	
	private static QnaDao instance;
	
	private QnaDao() {}
	
	public static QnaDao getInstance() {
		if(instance == null) {
			instance = new QnaDao();
		}
		return instance;
	}
	
	Database database = Database.getInstance();
	
	public void showQna(String product_name) {
		if(database.tb_qna.size() == 0) {
			System.out.println("등록된 QnA가 존재하지 않습니다.\n");
		} else {
			System.out.println(product_name + "에 대해 작성된 QnA를 조회합니다.");
			System.out.println("------------------------------------------------------------------------------------------------------");
			System.out.println("게시글 번호\t\t작성자\t\t상품코드\t\t상품명\t\t게시글 제목\t\t게시글 내용\t\t게시일");
			System.out.println("------------------------------------------------------------------------------------------------------");
			for(int i = database.tb_qna.size() - 1; i >= 0; i--) {
				if(database.tb_qna.get(i).getProduct_name().equals(product_name)) {
					System.out.println(database.tb_qna.get(i).getQna_num() + "\t" + database.tb_qna.get(i).getUser_id() + "\t" + database.tb_qna.get(i).getProduct_code() + "\t" + database.tb_qna.get(i).getProduct_name() + "\t" + database.tb_qna.get(i).getQna_name() + "\t" + database.tb_qna.get(i).getQna_content() + "\t" + database.tb_qna.get(i).getQna_date());
				}
			}
			System.out.println("------------------------------------------------------------------------------------------------------\n");
		}
	}
	
	public void enrollComment(QnaVO qnaVO, String Qna_name){
		if(database.tb_qna.size() == 0) {
			System.out.println("등록된 QnA가 존재하지 않습니다.\n");
		} else {
			System.out.println(qnaVO.getQna_name() + "에 대한 댓글을 등록을 시작합니다.");
			for(int i = 0; i < database.tb_qna.size(); i++) {
				if(database.tb_qna.get(i).getProduct_name().equals(qnaVO.getProduct_name()) && database.tb_qna.get(i).getQna_name().equals(Qna_name)) {
					qnaVO.setProduct_code(database.tb_qna.get(i).getProduct_code());
					qnaVO.setQna_num(database.tb_qna.get(i).getQna_num());
					int date = database.tb_qna.get(i).getQna_date().compareTo(qnaVO.getQna_date());
					if(date < 0) {
						database.tb_qna.add(i + 1, qnaVO);
						System.out.println(qnaVO.getQna_name() + "에 대한 댓글 등록이 완료되었습니다.\n");
					} else {
						if(i == database.tb_review.size() - 1) {
							System.out.println(qnaVO.getQna_name() + "에 해당하는 QnA가 존재하지 않습니다.\n");
						}
					}
				}
			}
		}
	}
	
	public void modifyComment(String product_name, String qna_name, String Modified_qna_name, String Modified_qna_content, Date qna_date) {
		if(database.tb_qna.size() == 0) {
			System.out.println("등록된 QnA가 존재하지 않습니다.\n");
		} else {
			System.out.println(qna_name + "에 대한 댓글 수정을 시작합니다.");
			for(int i = 0; i < database.tb_qna.size(); i++) {
				if(qna_name.equals(database.tb_qna.get(i).getQna_name()) && database.tb_review.get(i).getProduct_name().equals(product_name) && Session.LoginUser.getUser_access() == 1) {
					database.tb_qna.get(i).setQna_name(Modified_qna_name);
					database.tb_qna.get(i).setQna_content(Modified_qna_content);
					database.tb_qna.get(i).setQna_date(qna_date);
					System.out.println("댓글의 수정이 완료되었습니다.\n");
				}else {
					if(i == database.tb_qna.size() - 1) {
						System.out.println(qna_name + "에 해당하는 리뷰가 존재하지 않습니다.\n");
					}
				}
			}
		}
	}
	
	public void deleteComment(String product_name, String qna_name) {
		if(database.tb_qna.size() == 0) {
			System.out.println("등록된 QnA가 존재하지 않습니다.\n");
		} else {
			System.out.println(qna_name + "에 대한 댓글 삭제를 시작합니다.");
			for(int i = 0; i < database.tb_qna.size(); i++) {
				if(database.tb_qna.get(i).getProduct_name().equals(product_name) && database.tb_qna.get(i).getQna_name().equals(qna_name) && database.tb_qna.get(i).getUser_id().equals("admin")) {
					database.tb_qna.remove(i);
					System.out.println("댓글 삭제가 완료되었습니다.\n");
				} else {
					if(i == database.tb_qna.size() - 1) {
						System.out.println(qna_name + "에 해당하는 리뷰가 존재하지 않습니다.\n");
					}
				}
			}
		}
	}
}
