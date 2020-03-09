package data;

import java.util.ArrayList;

import vo.CartVO;

public class CartDatabase {

	private static CartDatabase instance;
	
	private CartDatabase() {}
	
	public static CartDatabase getInstance() {
		if(instance == null) {
			instance = new CartDatabase();
		}
		return instance;
	}
	
	public ArrayList<CartVO> tb_cart = new ArrayList<CartVO>();
	{
		CartVO cart = new CartVO();
	}
}
