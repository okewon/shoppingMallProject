package dao;

import data.Database;
import vo.ShopVO;

public class ShopDao {
	private static ShopDao instance;
	
	private ShopDao() {}
	
	public static ShopDao getInstance() {
		if(instance == null) {
			instance = new ShopDao();
		}
		return instance;
	}
	
	Database database = Database.getInstance();
	
	public void modifyShop(ShopVO shopVO) {
		database.tb_shop.set(0, shopVO);
		System.out.println("쇼핑몰 정보를 수정하였습니다.\n");
	}
	
	public void showShopInfo() {
		System.out.println("쇼핑몰 정보를 조회합니다.\n");
		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.println("쇼핑몰 코드\t\t쇼핑몰 상호명\t\t쇼핑몰 주소지\t\t\t쇼핑몰 번호");
		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.println(database.tb_shop.get(0).getShop_code() + "\t\t" + database.tb_shop.get(0).getShop_name() + "\t" + database.tb_shop.get(0).getShop_add1() + " " + database.tb_shop.get(0).getShop_add2() + "\t" + database.tb_shop.get(0).getShop_Phone_num());
		System.out.println("------------------------------------------------------------------------------------------------------\n");
	}
}
