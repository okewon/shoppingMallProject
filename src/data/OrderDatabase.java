package data;

import java.util.ArrayList;

import vo.OrderVO;

public class OrderDatabase {

	private static OrderDatabase instance;
	
	private OrderDatabase() {}
	
	public static OrderDatabase getInstance() {
		if(instance == null) {
			instance = new OrderDatabase();
		}
		return instance;
	}
	
	public ArrayList<OrderVO> tb_buy = new ArrayList<OrderVO>();
	{
		OrderVO order =  new OrderVO();
	}
}
