package service;

import java.util.Scanner;

import dao.UserManagementDao;


public class UserManageMentService {
	
	private static UserManageMentService instance;
	
	private UserManageMentService() {}
	
	public static UserManageMentService getInstance() {
		if(instance == null) {
			instance = new UserManageMentService();
		}
		return instance;
	}
	
	UserManagementDao userDao = UserManagementDao.getInstance();
	
	public void showUser() {
		userDao.showUser();
	}
	
	public void deleteUser() {
		Scanner s = new Scanner(System.in);
		
		System.out.print("삭제하고자 하는 일반 회원의 ID를 하시오.");
		String user_id = s.nextLine();
		
		userDao.deleteUser(user_id);
	}
	
	public void modifyUser() {
		Scanner s = new Scanner(System.in);
		String user_id = null;
		
		System.out.println("회원의 마일리지와 쿠폰을 변경하고자 합니다.");
		System.out.print("1.마일리지\n2.쿠폰");
		String choice = s.nextLine();
		
		switch(choice) {
		case "1":
			System.out.print("마일리지 내역을 변경하고자 하는 사용자의 아이디를 입력하시오.");
			user_id = s.nextLine();
			System.out.print("변경될 마일리지를 입력하시오.");
			int user_mileage = Integer.parseInt(s.nextLine());
			if(user_mileage < 0) {
				System.out.println("마일리지는 0이 최소값입니다.");
			} else {
				userDao.modifyMileage(user_id, user_mileage);				
			}
			break;
		case "2":
			System.out.print("쿠폰 내역을 변경하고자 하는 사용자의 아이디를 입력하시오.");
			user_id = s.nextLine();
			System.out.print("변경될 쿠폰 내역을 입력하시오.");
			String user_coupon = s.nextLine();
			if(user_coupon.equals("유") || user_coupon.equals("무")) {
				userDao.modifyCoupon(user_id, user_coupon);				
			} else {
				System.out.println("쿠폰 내역은 유/무로만 입력해주세요.");
			}
			break;
		default:
			System.out.println("잘못된 입력입니다.");
		}
	}
}
