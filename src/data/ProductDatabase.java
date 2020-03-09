package data;

import java.util.ArrayList;

import vo.ProductVO;

public class ProductDatabase {

	private static ProductDatabase instance;
	
	private ProductDatabase() {}
	
	public static ProductDatabase getInstance() {
		if(instance == null) {
			instance = new ProductDatabase();
		}
		return instance;
	}
	
	public ArrayList<ProductVO> tb_product = new ArrayList<ProductVO>();
	{
		ProductVO product = new ProductVO();
	}
	
}
