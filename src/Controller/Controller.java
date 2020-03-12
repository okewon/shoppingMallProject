package Controller;

import java.util.Scanner;

import data.Session;
import service.UserService;

public class Controller {
	
	public static void main(String[] args) {
		new Controller().start();
	}

	private void start() {
		//1.회원가입 2.로그인 3.종료
		//로그인 할경우 권한에 따라 새로운 컨트롤러 사용
		
		Scanner s = new Scanner(System.in);
		String choice;
		UserService u_service = UserService.getInstanec();
		
		do {
			u_service.logo2();
			System.out.println("==================================");
			System.out.println("||\t1.회원 가입	\t||"           );
			System.out.println("||\t2.로그인		\t||"             );
			System.out.println("||\t3.아이디 혹은 비밀번호 찾기\t|| ");
			System.out.println("||\t4.종료		\t|| "               );
			System.out.println("==================================");
			System.out.print(">> ");
			choice = s.nextLine();
			switch(choice){
				case "1": 
					System.out.println("회원 가입 창으로 이동");
					//회원가입 메서드
					u_service.join();
					break;
				case "2":
					System.out.println("로그인 창으로 이동 ");
					u_service.login();
						if(Session.LoginUser != null) {
							if(Session.LoginUser.getUser_access()==0) {
								UserController u_controller = new UserController();
							}else if(Session.LoginUser.getUser_access()==1) {
								AdminController a_controller = AdminController.getInstance();
								a_controller.AdiminMenu();
							}
						}else System.err.println("로그인 실패");
					//로그인 메서드
					break;
				case "3":
					u_service.find_id();
					break;
				case "4":
			 		System.err.println("종료합니다.");
					//종료
					break;
			}
		}
		while(!choice.equals("4"));
	}
}