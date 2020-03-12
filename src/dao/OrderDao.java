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
			System.out.println("------------------------------------------------------------------------------------------------------");
			System.out.println("주문번호\t\t구매 일자\t\t\t\t사용자 아이디\t\t상품 코드\t\t\t상품명\t\t구매 수량");
			System.out.println("------------------------------------------------------------------------------------------------------");
			for(int i = database.tb_order.size() - 1; i >= 0; i--) {
				System.out.println(database.tb_order.get(i).getOrder_code() + "\t" + database.tb_order.get(i).getOrder_date() + "\t" + database.tb_order.get(i).getUser_id() + "\t\t\t" + database.tb_order.get(i).getProduct_code() + "\t" + database.tb_order.get(i).getProduct_name() + "\t\t" + database.tb_order.get(i).getBuy_count());
			}			
			System.out.println("------------------------------------------------------------------------------------------------------\n");
		}
	}
	
	public void showChangeOrder() {
		if(database.tb_order.size() == 0) {
			System.out.println("\n주문이 존재하지 않습니다.\n");
		} else {
			System.out.println("\n주문 정보가 변경된 주문 내역을 조회합니다.");
			System.out.println("------------------------------------------------------------------------------------------------------");
			System.out.println("주문번호\t\t구매 일자\t\t\t\t사용자 아이디\t\t상품 코드\t\t\t상품명\t\t구매 수량");
			System.out.println("------------------------------------------------------------------------------------------------------");
			for(int i = database.tb_order.size() - 1; i >= 0; i--) {
				if(database.tb_order.get(i).getChange_order() != null) {
					System.out.println(database.tb_order.get(i).getOrder_code() + "\t" + database.tb_order.get(i).getOrder_date() + "\t" + database.tb_order.get(i).getUser_id() + "\t\t\t" + database.tb_order.get(i).getProduct_code() + "\t" + database.tb_order.get(i).getProduct_name() + "\t\t" + database.tb_order.get(i).getBuy_count());
				} else {
					System.out.println("주문 정보가 변경된 주문 내역이 존재하지 않습니다.\n");
				}
			}			
			System.out.println("------------------------------------------------------------------------------------------------------\n");
		}
	}
	
	public void insertDeliver_waybill(String Order_code) {
		if(database.tb_order.size() == 0) {
			System.out.println("주문이 존재하지 않습니다.\n");
		}else {
			for(int i = 0; i < database.tb_order.size(); i++) {
				if(database.tb_order.get(i).getOrder_code().equals(Order_code)) {
					database.tb_order.get(i).setDelivery_waybill(Order_code.hashCode() + "");
					System.out.println(Order_code + "에 해당하는 주문의 운송장 정보가" + Order_code.hashCode() + "으로 등록되었습니다.\n");
				} else {
					if(i == database.tb_order.size() - 1) {
						System.out.println(Order_code + "에 해당하는 주문 정보가 없습니다.\n");					
					}
				}
			}
		}
	}
	
	public void changeDelivery_status(String Order_code, int status) {
		if(database.tb_order.size() == 0) {
			System.out.println("주문이 존재하지 않습니다.\n");
		}else {
			for(int i = 0; i < database.tb_order.size(); i++) {
				if(database.tb_order.get(i).getOrder_code().equals(Order_code)) {
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
					System.out.println(Order_code + "에 해당하는 배송 현황이 " + database.tb_order.get(i).getDelivery_status() + "으로 변경되었습니다.\n");
				} else {
					if(i == database.tb_order.size() - 1) {
						System.out.println(Order_code + "에 해당하는 운송장 번호가 존재하지 않습니다.\n");
					}
				}
			}
		}
		
	}
}
