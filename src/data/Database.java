package data;

import java.util.ArrayList;
import java.util.Date;

import vo.CartVO;
import vo.GongjiVO;
import vo.OrderVO;
import vo.ProductVO;
import vo.QnaVO;
import vo.ReviewVO;
import vo.ShopVO;
import vo.UserVO;

public class Database {
	
	private static Database instance;
	
	private Database() {}
	
	public static Database getInstance() {
		if(instance == null) {
			instance = new Database();
		}
		
		return instance;
	}
	
	public ArrayList<CartVO> tb_cart = new ArrayList<CartVO>();
	
	public ArrayList<GongjiVO> tb_gongji = new ArrayList<GongjiVO>();
	{
		GongjiVO gongji = new GongjiVO();
		gongji.setGongji_id("Admin");
		gongji.setGongji_name("공지");
		gongji.setGongji_content("공지합니다.");
		gongji.setGongji_date(new Date());
		gongji.setGongji_id("Admin");
		
		tb_gongji.add(gongji);
	}
	
	public ArrayList<OrderVO> tb_order = new ArrayList<OrderVO>();
	{
		OrderVO order = new OrderVO();
		order.setOrder_code("브이넥 니트".hashCode() + "");
		order.setProduct_code("T" + "white" + "M" + "브이넥 니트".hashCode());
		order.setProduct_name("브이넥 니트");
		order.setUser_id("okewon");
		order.setBuy_count(1);
		order.setOrder_date(new Date());
		order.setDelivery_status("운송장 미등록");
		order.setUser_phone_num("0422228202");
		order.setMember_add1("대전광역시 중구 중앙로 76 영민빌딩 2층");
		order.setDelivery_waybill("운송장 미등록".hashCode() + "");
		
		tb_order.add(order);
	}
	
	public ArrayList<ProductVO> tb_product = new ArrayList<ProductVO>();
	{
		ProductVO product = new ProductVO();
		product.setProduct_name("브이넥 니트");
		product.setProduct_price(2000);
		product.setProduct_color("white");
		product.setProduct_size("M");
		product.setProduct_code("T" + "white" + "M" + "브이넥 니트".hashCode());
		product.setProduct_type("T");
		product.setProduct_count(10);
		product.setProduct_content("환절기 입기 좋은 크림색 브이넥 니트");
		product.setProduct_date(new Date());
		
		tb_product.add(product);
	}
	
	public ArrayList<QnaVO> tb_qna = new ArrayList<QnaVO>();
	{
		QnaVO qnaVO = new QnaVO();
		qnaVO.setQna_name("문의");
		qnaVO.setQna_content("아직 발송 이전인데 색상 변경 가능할까요.");
		qnaVO.setQna_password("1234");
		qnaVO.setQna_date(new Date());
		qnaVO.setUser_id("okewon");
		qnaVO.setProduct_code("T" + "white" + "M" + "브이넥 니트".hashCode());
		qnaVO.setProduct_name("브이넥 니트");
		
		tb_qna.add(qnaVO);
	}
	
	{
		QnaVO qnaVO = new QnaVO();
		qnaVO.setQna_name("문의");
		qnaVO.setQna_content("아직 발송 이전인데 색상 변경 가능할까요.");
		qnaVO.setQna_password("1234");
		qnaVO.setQna_date(tb_qna.get(0).getQna_date());
		qnaVO.setUser_id("Admin");
		qnaVO.setProduct_code("T" + "white" + "M" + "브이넥 니트".hashCode());
		qnaVO.setProduct_name("브이넥 니트");
		
		tb_qna.add(qnaVO);
	}
	
	public ArrayList<ReviewVO> tb_review = new ArrayList<ReviewVO>();
	{
		ReviewVO review = new ReviewVO();
		review.setReview_name("리뷰");
		review.setReview_content("촉감이 부드럽고 길이도 낭낭해서 환절기에 입기 좋을 것 같아요!!");
		review.setReview_date(new Date());
		review.setUser_id("okewon");
		review.setProduct_code("T" + "white" + "M" + "브이넥 니트".hashCode());
		review.setProduct_name("브이넥 니트");
		
		tb_review.add(review);
	}
	
	{
		ReviewVO review = new ReviewVO();
		review.setReview_name("리뷰");
		review.setReview_content("촉감이 부드럽고 길이도 낭낭해서 환절기에 입기 좋을 것 같아요!!");
		review.setReview_date(new Date());
		review.setUser_id("Admin");
		review.setProduct_code("T" + "white" + "M" + "브이넥 니트".hashCode());
		review.setProduct_name("브이넥 니트");
		
		tb_review.add(review);
	}
	
	public ArrayList<ShopVO> tb_shop = new ArrayList<ShopVO>();
	{
		ShopVO shop = new ShopVO();
		shop.setShop_code("YLCO107");
		shop.setShop_name("재단법인 대덕인재개발원");
		shop.setShop_add1("대전광역시 중구 중앙로 76");
		shop.setShop_add2("영민빌딩 2층");
		shop.setShop_Phone_num("0422228202");
		
		tb_shop.add(shop);
	}
	
	public ArrayList<UserVO> tb_user = new ArrayList<UserVO>();
	{
		UserVO user = new UserVO();
		user.setUser_id("Admin");
		user.setUser_password("Admin");
		user.setUser_name("Admin");
		user.setUser_access(1);
		
		tb_user.add(user);
	}
	
	{
		UserVO user = new UserVO();
		user.setUser_id("okewon");
		user.setUser_password("dhrgP0827");
		user.setUser_date(new Date());
		user.setUser_birth("19980424");
		user.setUser_name("옥혜원");
		user.setUser_add1("대전광역시 중구 중앙로 76");
		user.setUser_add2("영민빌딩 2층");
		user.setUser_phone_num("0422228202");
		user.setUser_email("okewon@naver.com");
		user.setUser_access(0);
		user.setUser_mileage(2000);
		user.setUser_coupon("유");
		
		tb_user.add(user);
	}
}
