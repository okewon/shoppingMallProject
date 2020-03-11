package data;

import java.util.ArrayList;

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
	
	public ArrayList<OrderVO> tb_order = new ArrayList<OrderVO>();
	
	public ArrayList<ProductVO> tb_product = new ArrayList<ProductVO>();
	
	public ArrayList<QnaVO> tb_qna = new ArrayList<QnaVO>();
	
	public ArrayList<ReviewVO> tb_review = new ArrayList<ReviewVO>();
	
	public ArrayList<ShopVO> tb_shop = new ArrayList<ShopVO>();
	{
		ShopVO shop = new ShopVO();
		shop.setShop_code("YLCO107");
		shop.setShop_name("재단법인 대덕인재개발원");
		shop.setShop_add1("대전광역시 중구 중앙로 76");
		shop.setShop_add2("영민빌딩 2층");
		shop.setShop_Phone_num("042-222-8202");
	}
	
	public ArrayList<UserVO> tb_user = new ArrayList<UserVO>();
}
