package service;

import java.util.Scanner;

import dao.OrderDao;

public class OrderService {
	
	private static OrderService instance;
	
	private OrderService() {}
	
	public static OrderService getInstance() {
		if(instance == null) {
			instance = new OrderService();
		}
		return instance;
	}
	
	OrderDao orderDao = OrderDao.getInstance();
	
	public void showOrder() {
		orderDao.showOrder();
	}
	
	public void showChangeOrder() {
		orderDao.showChangeOrder();
	}
	
	public void insertDeliver_waybii() {
		Scanner s = new Scanner(System.in);
		System.out.print("운송장 번호를 등록하고자 하는 주문 번호를 입력하세요.");
		String Order_code = s.nextLine();
		
		orderDao.insertDeliver_waybill(Order_code);
	}
	
	public void changeDelivery_status() {
		Scanner s = new Scanner(System.in);
		System.out.print("배송 상태를 변경하고자 하는 주문 번호를 입력하세요.");
		String Order_code = s.nextLine();
		System.out.print("변경된 배송 상태를 입력하세요.");
		int status = Integer.parseInt(s.nextLine());
		if(status > 0 && status < 7) {
			orderDao.changeDelivery_status(Order_code, status);			
		} else {
			System.out.println("배송 상태는 1~6 사이의 값으로 입력해주세요.");
		}
		
	}
}
