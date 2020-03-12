package dao;

import data.Database;
import vo.ProductVO;

public class ProductDao {
	
	private static ProductDao instance;
	private static int number = 0;
	
	private ProductDao() {}
	
	public static ProductDao getInstance() {
		if(instance == null) {
			instance = new ProductDao();
		}
		
		return instance;
	}
	
	Database database = Database.getInstance();

	public void EnrollProduct(ProductVO product) { //상품을 등록하는 함수
		database.tb_product.add(product);
		number = database.tb_product.size();	
	}
	
	public void showEnrollProduct() { //새로 등록된 상품을 보여주는 함수
		if(database.tb_product.size() == 0) {
			System.out.println("등록된 상품이 없습니다.\n");
		} else {
			System.out.println("종료 이전에 새로 등록된 상품을 조회합니다.\n");
			System.out.println("------------------------------------------------------------------------------------------------------");
			System.out.println("상품 코드\t\t\t상품 이름\t\t상품 가격\t\t상품 사이즈\t\t상품 색상\t\t상품 품목\t\t상품 재고\t\t상품 상세정보\t\t\t상품 등록일자");
			System.out.println("------------------------------------------------------------------------------------------------------");
			for(int i = database.tb_product.size() - 1; i >= number - 1; i--) {
				System.out.print(database.tb_product.get(i).getProduct_code() + "\t"+ database.tb_product.get(i).getProduct_name() + "\t\t" + database.tb_product.get(i).getProduct_price() + "원\t\t" + database.tb_product.get(i).getProduct_size() + "\t\t" + database.tb_product.get(i).getProduct_color());
				System.out.println("\t\t" + database.tb_product.get(i).getProduct_type() + "\t\t" + database.tb_product.get(i).getProduct_count() + "\t\t" + database.tb_product.get(i).getProduct_content() + "\t" + database.tb_product.get(i).getProduct_date());
			}
			System.out.println("------------------------------------------------------------------------------------------------------\n");
		}
	}
	
	public void showTotalProduct() { //기존에 등록되어 있는 상품을 보여주는 함수
		if(database.tb_product.size() == 0) {
			System.out.println("등록된 상품이 없습니다.\n");
		} else {
			System.out.println("기존에 등록되어있는 상품을 조회합니다.\n");
			System.out.println("------------------------------------------------------------------------------------------------------");
			System.out.println("상품 코드\t\t\t상품 이름\t\t상품 가격\t\t상품 사이즈\t\t상품 색상\t\t상품 품목\t\t상품 재고\t\t상품 상세정보\t\t\t상품 등록일자");
			System.out.println("------------------------------------------------------------------------------------------------------");
			for(int i = database.tb_product.size() - 1; i > -1; i--) {
				System.out.print(database.tb_product.get(i).getProduct_code() + "\t"+ database.tb_product.get(i).getProduct_name() + "\t\t" + database.tb_product.get(i).getProduct_price() + "원\t\t" + database.tb_product.get(i).getProduct_size() + "\t\t" + database.tb_product.get(i).getProduct_color());
				System.out.println("\t\t" + database.tb_product.get(i).getProduct_type() + "\t\t" + database.tb_product.get(i).getProduct_count() + "\t\t" + database.tb_product.get(i).getProduct_content() + "\t" + database.tb_product.get(i).getProduct_date());
			}				
			System.out.println("------------------------------------------------------------------------------------------------------\n");
		}
	}
	 
	public void modifyProduct(ProductVO product, String product_size, String product_color) { //기존에 등록되어 있는 상품을 수정하는 함수
		if(database.tb_product.size() == 0) {
			System.out.println("등록된 상품이 없습니다.\n");
		} else {
			for(int i = 0; i < database.tb_product.size(); i++) {
				if(database.tb_product.get(i).getProduct_name().equals(product.getProduct_name())) {
					database.tb_product.remove(i);
					database.tb_product.add(i, product);
					System.out.println(product.getProduct_name() + "의 상품 정보가 수정되었습니다.\n");
				} else {
					if(i == database.tb_product.size() - 1) {
						System.out.println(product.getProduct_name() + "와(과) 일치하는 상품이 존재하지 않습니다.\n");					
					}
				}	
			}
		}
	}
	
	public void deleteProduct(String product_name, String product_size, String product_color) { //기존에 등록되어 있는 상품을 삭제하는 함수
		if(database.tb_product.size() == 0) {
			System.out.println("등록된 상품이 없습니다.\n");
		} else {
			for(int i = 0; i < database.tb_product.size(); i++) {
				if(database.tb_product.get(i).getProduct_name().equals(product_name) && database.tb_product.get(i).getProduct_size().equals(product_size) && database.tb_product.get(i).getProduct_color().equals(product_color)) {
					database.tb_product.remove(i);
					System.out.println(product_name + "이(가) 삭제되었습니다.\n");
				} else {
					if(i == database.tb_product.size() - 1) {
						System.out.println(product_name + "와(과) 일치하는 상품이 존재하지 않습니다.\n");					
					}
				}	
			}
		}
	}
	
}
