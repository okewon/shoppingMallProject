 package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import dao.ProductDao;
import vo.ProductVO;

public class ProductService {
	
	private static ProductService instance;
	
	private ProductService() {}
	
	public static ProductService getInstance() {
		if(instance == null) {
			instance = new ProductService();
		}
		return instance;
	}
	
	ProductDao productDao = ProductDao.getInstance();

	public void enrollProduct() {
		Scanner s = new Scanner(System.in);
		
		productDao.showTotalProduct();		
		
		System.out.println("상품 등록을 시작합니다.\n");
		
		do {
			String product_code = null;
			System.out.print("상품의 이름을 입력하시오.(종료 : Q) >> ");
			String product_name = s.nextLine();
			if(product_name.equals("Q")) {
				productDao.showEnrollProduct();
				System.out.println("상품 등록이 종료되었습니다.\n");
				break;
			}
			System.out.print("상품의 가격을 입력하시오. >> ");
			int product_price = Integer.parseInt(s.nextLine());
			if(product_price < 0) {
				System.out.print("상품의 가격은 0원 이상입니다.\n");
				continue;
			}
			System.out.print("상품의 사이즈를 입력하세요. >> ");
			String product_size = s.nextLine();
			System.out.print("상품의 색상을 입력하세요. >> ");
			String product_color = s.nextLine();
			System.out.print("상품의 품목을 입력하세요. ");
			System.out.print("구분(T: 티셔츠, P: 바지, O: 외투, B: 가방, S: 신발, A: 악세사리, H: 모자) >> ");
			String product_type = s.nextLine();
			switch (product_type) {
			case "T":
			case "P":
			case "O":
			case "B":
			case "S":
			case "A":
			case "H":
				break;
			default:
				System.out.println("옳지 않은 상품 품목입니다.\n");
				break;
			}
			System.out.print("상품의 재고 수량을 입력하세요. >> ");
			int product_count = Integer.parseInt(s.nextLine());
			if(product_count < 0) {
				System.out.println("재고 수량이 0개 이하인 경우 등록할 수 없습니다.\n");
				continue;
			}
			System.out.print(product_name + "에 대한 상세 정보를 입력해주세요. >> ");
			String product_content = s.nextLine();
			Date product_date = new Date();
			switch (product_type) {
			case "T":
				product_code = "T" + product_color + product_size + product_name.hashCode();
				break;
			case "P":
				product_code = "P" + product_color + product_size +product_name.hashCode();
				break;
			case "O":
				product_code = "O" + product_color + product_size +product_name.hashCode();
				break;
			case "B":
				product_code = "B" + product_color + product_size +product_name.hashCode();
				break;
			case "S":
				product_code = "S" + product_color + product_size +product_name.hashCode();
				break;
			case "A":
				product_code = "A" + product_color + product_size +product_name.hashCode();
				break;
			case "H":
				product_code = "H" + product_color + product_size +product_name.hashCode();
				break;
			}
			
			ProductVO product = new ProductVO();
			product.setProduct_code(product_code);
			product.setProduct_name(product_name);
			product.setProduct_price(product_price);
			product.setProduct_size(product_size);
			product.setProduct_color(product_color);
			product.setProduct_type(product_type);
			product.setProduct_count(product_count);
			product.setProduct_content(product_content);
			product.setProduct_date(product_date);
			
			productDao.EnrollProduct(product);
		}while(true);
		
		System.out.println("상품이 등록되었습니다.\n");
	}
	
	public void modifyProduct() {
		Scanner s = new Scanner(System.in);
		do {
			String product_code = null;
			System.out.println("등록된 상품을 수정합니다.\n");
			System.out.print("수정하고자 하는 상품의 이름을 입력해주세요. >> ");
			String product_name = s.nextLine();
			if(product_name.equals("Q")) {
				System.out.println("상품 수정이 종료되었습니다.\n");
				return;
			}
			System.out.print("수정하고자 하는 상품의 사이즈를 입력하세요. >> ");
			String Product_color = s.nextLine();
			System.out.print("수정하고자 하는 상품의 색상을 입력하세요. >> ");
			String Product_size = s.nextLine();
			System.out.print("수정하고자 하는 상품의 가격을 입력해주세요. >> ");
			System.out.print("수정하고자 하는 상품의 가격을 입력하시오. >> ");
			int product_price = Integer.parseInt(s.nextLine());
			if(product_price < 0) {
				System.out.print("상품의 가격은 0원 이상입니다.\n");
				continue;
			}
			System.out.print("수정하고자 하는 상품의 사이즈를 입력하세요. >> ");
			String product_size = s.nextLine();
			System.out.print("수정하고자 하는 상품의 색상을 입력하세요. >> ");
			String product_color = s.nextLine();
			System.out.print("수정하고자 하는 상품의 품목을 입력하세요. ");
			System.out.println("구분(T: 티셔츠, P: 바지, O: 외투, B: 가방, S: 신발, A: 악세사리, H: 모자) >> ");
			String product_type = s.nextLine();
			switch (product_type) {
			case "T":
			case "P":
			case "O":
			case "B":
			case "S":
			case "A":
			case "H":
				break;
			default:
				System.out.println("옳지 않은 상품 품목입니다.\n");
				break;
			}
			System.out.print("수정하고자 하는 상품의 재고 수량을 입력하세요. >> ");
			int product_count = Integer.parseInt(s.nextLine());
			if(product_count < 0) {
				System.out.println("재고 수량이 0개 이하인 경우 등록할 수 없습니다.\n");
				continue;
			}
			System.out.print("수정하고자 하는 " + product_name + "에 대한 상세 정보를 입력해주세요. >> ");
			String product_content = s.nextLine();
			Date product_date = new Date();
			
			switch (product_type) {
			case "T":
				product_code = "T" + product_color + product_size + product_name.hashCode();
				break;
			case "P":
				product_code = "P" + product_color + product_size + product_name.hashCode();
				break;
			case "O":
				product_code = "O" + product_color + product_size + product_name.hashCode();
				break;
			case "B":
				product_code = "B" + product_color + product_size + product_name.hashCode();
				break;
			case "S":
				product_code = "S" + product_color + product_size + product_name.hashCode();
				break;
			case "A":
				product_code = "A" + product_color + product_size + product_name.hashCode();
				break;
			case "H":
				product_code = "H" + product_color + product_size + product_name.hashCode();
				break;
			default:
				break;
			}
			
			ProductVO product = new ProductVO();
			product.setProduct_code(product_code);
			product.setProduct_name(product_name);
			product.setProduct_price(product_price);
			product.setProduct_size(product_size);
			product.setProduct_color(product_color);
			product.setProduct_type(product_type);
			product.setProduct_count(product_count);
			product.setProduct_content(product_content);
			product.setProduct_date(product_date);
			
			productDao.modifyProduct(product, Product_size, Product_color);
			
		}while(true);
		
	}
	
	public void deleteProduct() {
		Scanner s = new Scanner(System.in);
		System.out.println("등록된 상품을 삭제합니다.\n");
		do {
			System.out.print("삭제하고자 하는 상품의 이름을 입력해주세요. >> ");
			String product_name = s.nextLine();
			if(product_name.equals("Q")) {
				System.out.println("상품 삭제가 종료되었습니다.\n");
				break;
			}
			System.out.print("삭제하고자 하는 상품의 색상과 사이즈를 입력하세요. >> ");
			String Product_color = s.nextLine();
			String Product_size = s.nextLine();
			productDao.deleteProduct(product_name, Product_size, Product_color);
		}while(true);
	}
	
	public void showProduct() {
		productDao.showEnrollProduct();
	}
	
}
