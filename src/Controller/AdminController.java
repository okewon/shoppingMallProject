package Controller;

import java.util.Scanner;

import service.GongjiService;
import service.OrderService;
import service.ProductService;
import service.QnaService;
import service.ReviewService;
import service.ShopService;
import service.UserManageMentService;

public class AdminController {
	
	private static AdminController instance;
	
	private AdminController() {}
	
	public static AdminController getInstance() {
		if(instance == null) {
			instance = new AdminController();
		}
		return instance;
	}
	
	public void AdiminMenu() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("==================================");
        System.out.println("||\t1.상품 조회   \t||"           );
        System.out.println("||\t2.게시글 관리      \t||"             );
        System.out.println("||\t3.회원 관리\t|| ");
        System.out.println("||\t4.쇼핑몰 정보 조회      \t|| "               );
        System.out.println("||\t5.주문 현황 조회      \t|| "               );
        System.out.println("||\t6.종료      \t|| "               );
        System.out.println("==================================");
        System.out.print(">>");
        
        String choice = s.nextLine();
        
        switch(choice) {
        case "1":
        	System.out.println("상품 조회 메뉴");
        	Product();
        	break;
        case "2":
        	System.out.println("게시글 관리");
        	board();
        	break;
        case "3":
        	System.out.println("회원 관리");
        	userManagement();
        	break;
        case "4":
        	System.out.println("쇼핑몰 정보 조회");
        	shopInfo();
        	break;
        case "5":
        	System.out.println("주문 현황 조회");
        	orderStatus();
        	break;
        case "6":
        	System.out.println("종료되었습니다.");
        	return;
        default:
        	System.out.println("잘못된 입력입니다.");
        	break;
        }
	}
	
	public void Product() {
		ProductService product = ProductService.getInstance();
		Scanner s = new Scanner(System.in);
		
		System.out.println("==================================");
        System.out.println("||\t1.상품 등록   \t||"           );
        System.out.println("||\t2.상품 수정      \t||"             );
        System.out.println("||\t3.상품 삭제\t|| ");
        System.out.println("||\t4.상품 조회\t|| ");        
        System.out.println("||\t5.종료      \t|| "               );
        System.out.println("==================================");
        System.out.print(">>");
        
        String choice = s.nextLine();
        
        switch(choice) {
        case "1":
        	product.enrollProduct();
        	break;
        case "2":
        	product.modifyProduct();
        	break;
        case "3":
        	product.deleteProduct();
        	break;
        case "4":
        	product.showProduct();
        	break;
        case "5":
        	System.out.println("상품 조회 메뉴가 종료됩니다.");
        	return;
        default:
        	System.out.println("잘못된 입력입니다.");
        	break;
        }
	}
	
	public void board() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("==================================");
        System.out.println("||\t1.Notice   \t||"           );
        System.out.println("||\t2.Reivew      \t||"             );
        System.out.println("||\t3.QnA\t|| ");       
        System.out.println("||\t4.종료      \t|| "               );
        System.out.println("==================================");
        System.out.print(">>");
        
        String choice = s.nextLine();
        
        switch(choice) {
        case "1":
        	notice();
        	break;
        case "2":
        	review();
        	break;
        case "3":
        	QnA();
        	break;
        case "4":
        	System.out.println("게시글 관리가 종료됩니다.");
        	return;
        default:
        	System.out.println("잘못된 입력입니다.");
        	break;
        }
	}
	
	public void notice() {
		Scanner s = new Scanner(System.in);
		GongjiService gongji = GongjiService.getInstance();
		
		System.out.println("==================================");
		System.out.println("||\t1.공지사항 조회\t|| ");       
        System.out.println("||\t2.공지사항 등록   \t||"           );
        System.out.println("||\t3.공지사항 수정      \t||"             );
        System.out.println("||\t4.공지사항 삭제\t|| ");       
        System.out.println("||\t5.종료      \t|| "               );
        System.out.println("==================================");
        System.out.print(">>");
        
        String choice = s.nextLine();
        
        switch(choice) {
        case "1":
        	gongji.showGongji();
        	break;
        case "2":
        	gongji.enrollGongji();
        	break;
        case "3":
        	gongji.modifyGongji();
        	break;
        case "4":
        	gongji.deleteGongji();
        	break;
        case "5":
        	System.out.println("공지사항 관리가 종료됩니다.");
        	return;
        default:
        	System.out.println("잘못된 입력입니다.");
        	break;
        }
	}
	
	public void review() {
		Scanner s = new Scanner(System.in);
		ReviewService review = ReviewService.getInstance();
		
		System.out.println("==================================");
        System.out.println("||\t1.리뷰 조회   \t||"           );
        System.out.println("||\t2.리뷰 댓글 작성     \t||"             );
        System.out.println("||\t3.리뷰 댓글 삭제\t|| ");       
        System.out.println("||\t4.종료      \t|| "               );
        System.out.println("==================================");
        System.out.print(">>");
        
        String choice = s.nextLine();
        
        switch(choice) {
        case "1":
        	review.showReview();
        	break;
        case "2":
        	review.enrollReviewComment();
        	break;
        case "3":
        	review.deleteReviewComment();
        	break;
        case "4":
        	System.out.println("리뷰 관리가 종료됩니다.");
        	return;
        default:
        	System.out.println("잘못된 입력입니다.");
        	break;
        }
	}
	
	public void QnA() {
		Scanner s = new Scanner(System.in);
		QnaService qna = QnaService.getInstance();
		
		System.out.println("==================================");
        System.out.println("||\t1.QnA 조회   \t||"           );
        System.out.println("||\t2.QnA 댓글 작성      \t||"             );
        System.out.println("||\t3.QnA 댓글 수정\t|| ");       
        System.out.println("||\t4.QnA 댓글 삭제\t|| ");       
        System.out.println("||\t5.종료      \t|| "               );
        System.out.println("==================================");
        System.out.print(">>");
        
        String choice = s.nextLine();
        
        switch(choice) {
        case "1":
        	break;
        case "2":
        	break;
        case "3":
        	break;
        case "4":
        	break;
        case "5":
        	System.out.println("QnA 게시글 관리가 종료됩니다.");
        	return;
        default:
        	System.out.println("잘못된 입력입니다.");
        	break;
        }
	}
	
	public void userManagement() {
		Scanner s = new Scanner(System.in);
		UserManageMentService userManage = UserManageMentService.getInstance();
		
		System.out.println("==================================");
		System.out.println("||\t1.회원 조회   \t||"           );
        System.out.println("||\t2.회원 쿠폰/마일리지 관리   \t||"           );
        System.out.println("||\t3.회원 삭제      \t||"             );
        System.out.println("||\t4.종료\t|| ");
        System.out.println("==================================");
        System.out.print(">>");
        
        String choice = s.nextLine();
        
        switch(choice) {
        case "1":
        	userManage.showUser();
        	break;
        case "2":
        	userManage.deleteUser();
        	break;
        case "3":
        	userManage.modifyUser();
        	break;
        case "4":
        	System.out.println("회원 관리가 종료됩니다.");
        	return;
        default:
        	System.out.println("잘못된 입력입니다.");
        	break;
        }
	}
	
	public void shopInfo() {
		Scanner s = new Scanner(System.in);
		ShopService shop = ShopService.getInstance();
		
		System.out.println("==================================");
        System.out.println("||\t1.쇼핑몰 정보 조회   \t||"          );
        System.out.println("||\t2.쇼핑몰 정보 수정   \t||"          );        
        System.out.println("||\t3.종료   \t||"          );
        System.out.println("==================================");
        System.out.print(">>");
        
        String choice = s.nextLine();
        
        switch(choice) {
        case "1":
        	shop.showShopInfo();
        	break;
        case "2":
        	shop.modifyShopInfo();        	
        	break;
        case "3":
        	System.out.println("쇼핑몰 정보 조회가 종료됩니다.");
        	return;
        default:
        	System.out.println("잘못된 입력입니다.");
        	break;
        }
	}
	
	public void orderStatus() {
		Scanner s = new Scanner(System.in);
		OrderService order = OrderService.getInstance();
		
		System.out.println("==================================");
        System.out.println("||\t1.주문현황 조회   \t||"           );
        System.out.println("||\t2.변경된 주문 조회     \t||"             );
        System.out.println("||\t3.운송장 번호 등록\t|| ");
        System.out.println("||\t4.배송 현황 변경      \t|| "               );
        System.out.println("||\t5.종료      \t|| "               );
        System.out.println("==================================");
        System.out.print(">>");
        
        String choice = s.nextLine();
        
        switch(choice) {
        case "1":
        	order.showOrder();
        	break;
        case "2":
        	order.showChangeOrder();
        	break;
        case "3":
        	order.insertDeliver_waybii();
        	break;
        case "4":
        	order.changeDelivery_status();
        	break;
        case "5":
        	System.out.println("주문현황 조회가 종료됩니다.");
        	return;
        default:
        	System.out.println("잘못된 입력입니다.");
        	break;
        }
	}

}
