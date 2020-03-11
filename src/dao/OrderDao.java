package dao;

import data.Database;

public class OrderDao {

	private static OrderDao instance;
	
	private OrderDao() {}
	
	public static OrderDao getInstance() {
		if(instance == null) {
			instance = new OrderDao();
		}
		return instance;
	}
	
	Database database = Database.getInstance();
	
	public void showOrder() {
		if(database.tb_order.size() == 0) {
			System.out.println("주문이 존재하지 않습니다.");
		}else {
			System.out.println("주문 내역을 조회합니다.\n");
			for(int i = database.tb_order.size() - 1; i >= 0; i--) {
				System.out.println("------------------------------------------------------------------------------------------------------");
				System.out.println("주문번호\t구매 일자\t사용자 아이디\t상품 코드\t상품명\t구매 수량");
				System.out.println("------------------------------------------------------------------------------------------------------");
				System.out.println(database.tb_order.get(i).getOrder_code() + "\t" + database.tb_order.get(i).getOrder_date() + "\t" + database.tb_order.get(i).getUser_id() + "\t" + database.tb_order.get(i).getProduct_code() + database.tb_order.get(i).getProduct_name() + "\t" + database.tb_order.get(i).getBuy_count());
				System.out.println("------------------------------------------------------------------------------------------------------");
			}			
		}
	}
	
	public void showChangeOrder() {
		if(database.tb_order.size() == 0) {
			System.out.println("주문이 존재하지 않습니다.");
		} else {
			System.out.println("주문 정보가 변경된 주문 내역을 조회합니다.\n");
			for(int i = database.tb_order.size() - 1; i >= 0; i--) {
				if(database.tb_order.get(i).getChange_order() != null) {				
					System.out.println("------------------------------------------------------------------------------------------------------");
					System.out.println("주문번호\t구매 일자\t사용자 아이디\t상품 코드\t상품명\t구매 수량");
					System.out.println("------------------------------------------------------------------------------------------------------");
					System.out.println(database.tb_order.get(i).getOrder_code() + "\t" + database.tb_order.get(i).getOrder_date() + "\t" + database.tb_order.get(i).getUser_id() + "\t" + database.tb_order.get(i).getProduct_code() + database.tb_order.get(i).getProduct_name() + "\t" + database.tb_order.get(i).getBuy_count());
					System.out.println("------------------------------------------------------------------------------------------------------");
				}
			}			
		}
	}
	
	public void insertDeliver_waybill(String Order_code) {
		if(database.tb_order.size() == 0) {
			System.out.println("주문이 존재하지 않습니다.");
		}else {
			for(int i = 0; i < database.tb_order.size(); i++) {
				if(database.tb_order.get(i).getOrder_code().equals(Order_code)) {
					database.tb_order.get(i).setDelivery_waybill(Order_code.hashCode() + "");
					System.out.println("운송장 정보가 등록되었습니다.");
				} else {
					if(i == database.tb_order.size() - 1) {
						System.out.println(Order_code + "에 해당하는 주문 정보가 없습니다.");					
					}
				}
			}
		}
	}
	
	public void changeDelivery_status(String Order_code, int status) {
		if(database.tb_order.size() == 0) {
			System.out.println("주문이 존재하지 않습니다.");
		}else {
			for(int i = 0; i < database.tb_order.size(); i++) {
				if(database.tb_order.get(i).getOrder_code().equals(Order_code )) {
					switch(status) {
					case 0:
						database.tb_order.get(i).setDelivery_status("운송장 미등록");
						break;
					case 1:
						database.tb_order.get(i).setDelivery_status("방문예정");
						break;
					case 2:
						database.tb_order.get(i).setDelivery_status("상품인수");
						break;
					case 3:
						database.tb_order.get(i).setDelivery_status("이동중");
						break;
					case 4:
						database.tb_order.get(i).setDelivery_status("배송터미널 도착");
						break;
					case 5:
						database.tb_order.get(i).setDelivery_status("배송출발");
						break;
					case 6:
						database.tb_order.get(i).setDelivery_status("배송완료");
						break;
					}
					System.out.println("배송 상태가 변경되었습니다.");
				} else {
					if(i == database.tb_order.size() - 1) {
						System.out.println(Order_code + "에 해당하는 운송장 번호가 존재하지 않습니다.");
					}
				}
			}
		}
		
	}
}
