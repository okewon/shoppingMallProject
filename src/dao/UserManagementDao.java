package dao;

import data.Database;
import vo.UserVO;

public class UserManagementDao {
	
	private static UserManagementDao instance;
	
	private UserManagementDao() {}
	
	public static UserManagementDao getInstance() {
		if(instance == null) {
			instance = new UserManagementDao();
		}
		
		return instance;
	}
	
	Database database = Database.getInstance();
	
	public void showUser() {
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("사용자 아이디\t사용자 비밀번호\t사용자 가입일자\t사용자 생년월일\t사용자 이름\t\t사용자 주소\t\t사용자 핸드폰번호\t사용자 이메일\t사용자 접근권한\t사용자 마일리지\t사용자 쿠폰 내역");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
		for(int i = database.tb_user.size() - 1; i >= 0; i--) {
			System.out.print(database.tb_user.get(i).getUser_id() + "\t\t" + database.tb_user.get(i).getUser_password().hashCode() + "\t" + database.tb_user.get(i).getUser_date() + "\t\t");
			System.out.print(database.tb_user.get(i).getUser_birth() + "\t\t" + database.tb_user.get(i).getUser_name() + "\t\t" + database.tb_user.get(i).getUser_add1() + " " + database.tb_user.get(i).getUser_add2() + "\t");
			System.out.println(database.tb_user.get(i).getUser_phone_num() + "\t\t" + database.tb_user.get(i).getUser_email() +"\t\t" + database.tb_user.get(i).getUser_access() + "\t\t" + database.tb_user.get(i).getUser_mileage() + "\t\t" + database.tb_user.get(i).getUser_coupon());
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void deleteUser(String User_id) {
		for(int i = 0; i < database.tb_user.size(); i++) {
			if(database.tb_user.get(i).getUser_id().equals(User_id)) {
				database.tb_user.remove(i);
				System.out.println(User_id + "회원이 삭제되었습니다.");
			} else if(User_id.equals("Admin")){
				System.out.println("관리자의 정보는 삭제할 수 없습니다.");
			}else {
				if(i == database.tb_user.size() - 1) {
					System.out.println(User_id + "에 해당하는 회원이 존재하지 않습니다.");					
				}
			}
		}
	}
	
	public void modifyCoupon(String user_id, String user_coupon) {
		for(int i = 0; i < database.tb_user.size(); i++) {
			if(database.tb_user.get(i).getUser_id().equals(user_id) && database.tb_user.get(i).getUser_access() == 0) {
				database.tb_user.get(i).setUser_coupon(user_coupon);
				System.out.println("쿠폰 정보가 변경되었습니다.");
			} else {
				if(i == database.tb_user.size() - 1) {
					System.out.println(user_id + "에 해당하는 사용자 정보가 존재하지 않습니다.");
				}
			}
		}
	}
	
	public void modifyMileage(String user_id, int user_mileage) {
		for(int i = 0; i < database.tb_user.size(); i++) {
			if(database.tb_user.get(i).getUser_id().equals(user_id) && database.tb_user.get(i).getUser_access() == 0) {
				database.tb_user.get(i).setUser_mileage(user_mileage);
				System.out.println("마일리지 정보가 변경되었습니다.");
			} else {
				if(i == database.tb_user.size() - 1) {
					System.out.println(user_id + "에 해당하는 사용자 정보가 존재하지 않습니다.");
				}
			}
		}
	}
}
