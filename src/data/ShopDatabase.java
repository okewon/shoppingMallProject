package data;

import java.util.ArrayList;

import vo.ShopVO;

public class ShopDatabase {
	
	private static ShopDatabase instance;
	
	private ShopDatabase() {}
	
	public static ShopDatabase getInstance() {
		if(instance == null) {
			instance = new ShopDatabase();
		}
		return instance;
	}
	
	public ArrayList<ShopVO> tb_shop = new ArrayList<ShopVO>();
	{
		ShopVO shop = new ShopVO();
	}
}
