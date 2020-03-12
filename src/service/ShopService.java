package service;

import java.util.Scanner;

import dao.ShopDao;
import vo.ShopVO;

public class ShopService {

	private static ShopService instance;
	
	private ShopService() {}
	
	public static ShopService getInstance() {
		if(instance == null) {
			instance = new ShopService();
		}
		return instance;
	}
	
	ShopDao shopDao = ShopDao.getInstance();
	
	public void modifyShopInfo() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("쇼핑몰의 정보를 수정합니다.\n");
		System.out.print("변경하고자 하는 쇼핑몰 고유 코드를 입력하시오. >> ");
		String Shop_code = s.nextLine();
		System.out.print("변경하고자 하는 쇼핑몰 상호명을 입력하시오. >> ");
		String Shop_name = s.nextLine();
		System.out.print("변경하고자 하는 쇼핑물 주소지를 입력하시오. >> ");
		String Shop_add1 = s.nextLine();
		System.out.print("변경하고자 하는 쇼핑몰 주소지의 상세 주소를 입력하시오. >> ");
		String Shop_add2 = s.nextLine();
		System.out.print("변경하고자 하는 쇼핑몰 전화번호를 입력하시오. >> ");
		String Shop_Phone_num = s.nextLine();
		
		ShopVO shopVO = new ShopVO();
		shopVO.setShop_code(Shop_code);
		shopVO.setShop_name(Shop_name);
		shopVO.setShop_add1(Shop_add1);
		shopVO.setShop_add2(Shop_add2);
		shopVO.setShop_Phone_num(Shop_Phone_num);
		
		shopDao.modifyShop(shopVO);
	}
	
	public void showShopInfo() {
		shopDao.showShopInfo();
	}
}
