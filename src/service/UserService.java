package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.UserDao;
import data.Session;
import data.Database;
import vo.UserVO;

public class UserService {
	private static UserService instance;
		
		private UserService(){}
		
		public static UserService getInstanec(){
			if(instance == null){
				instance = new UserService();
			}
			return instance;
		}
		
		UserDao userDao = UserDao.getInstance();
		
		public void join() {
			//join에서 사용되야할 메서드내용
			Scanner s= new Scanner(System.in);
			UserVO user = new UserVO();
			boolean flag = true;
			while(true) {
				System.out.print("아이디 >> " );
				String id = s.nextLine();				// 아이디 입력
				String regex_id = "(\\w|\\W){5,20}";    // 규칙 : (모든 영어/숫자|모든 특수문자){5자리에서 20자리까지}    
				Pattern p = Pattern.compile(regex_id);  // Pattern p에 위에서 만든 규칙을 대입
				Matcher m = p.matcher(id);				// Matcher m 값에 만든 규칙에 입력한 아이디 값을 태입
				int count =0;
					if(m.matches()) {                   // m 함수를 통해 규칙에 맞는 아이디일 경우 
			               Database database = Database.getInstance();  //usesrdatabase 에서 이미 존재하는 아이디를 확인 부분
			               for(int i=0; i< database.tb_user.size() ; i++) {      
			                  UserVO user1 = database.tb_user.get(i);
			                  if(!user1.getUser_id().equals(id)) {   //기존의 id와 회원가입하는 id가 다를경우 count값이 올라감
			                	  count++;
			                  } 
			               
			               }
			               if(database.tb_user.size()==count) {  // 카운트를 통해 중복여부를 확인후 아이디로 set
			            	   user.setUser_id(id);
			            	   break;
			               }else System.out.println("이미 존재하는 아이디 입니다.\n");
					}else
						System.out.println("아이디를 다시 입력해주세요 (5~20 영문자,숫자) >> ");
						
			}
			
			while(true) {
				System.out.print("비밀번호 >> " );
				String password = s.nextLine();
				String regex_password = "(\\w|\\W){8,16}";   //아이디와 동일하게  규칙 : (모든 영어/숫자|모든 특수문자){5자리에서 20자리까지} 
				Pattern p = Pattern.compile(regex_password); //규칙을 p에 대입
				Matcher m = p.matcher(password);			 //규칙에 비밀번호를 대입에서 m에 저장
				boolean flag1 = true;                        //flag1 변수를 이용할거야 
				if(m.matches()) {                            //위의 규칙이 맞을 경우 
					String regex_password1 = "\\w+";		 //새로운 규칙을 만들고
					p = Pattern.compile(regex_password1);    //새로운 규칙을 p에 대입
					m = p.matcher(password);                 //새로운 규칙에 비밀번호를 대입에서 m에 저장
					if(m.matches()) flag1 = false;           //m.matches결과가 true 일경우 위에서 만든 flag1변수가 false로 바뀜
					
					String regex_passowrd2 = "\\W+";         //또 다른 규칙을 만들고 위와 동일하게 진행
					p = Pattern.compile(regex_passowrd2);    
					m = p.matcher(password);             	 
					if(m.matches()) flag1 = false;
					
					if(flag1) {
						user.setUser_password(password);     //모든 규칙을 통과해 flag변수가 true일 경우에만 비밀번호를 set
						break;
					}
					if(!flag1)  {
						System.out.print("비밀번호를 다시 입력해주세요 (비밀 번호 8~16자 영문자, 숫자,특수문자사용) >> ");
					}
				}
				else System.out.print("비밀번호를 다시 입력해주세요 (비밀 번호 8~16자 영문자, 숫자,특수문자사용) >> "); 
						
			}
			
			while(true) {
				System.out.println("-------비밀번호를 찾기 위한 질문-------");
				System.out.print("당신이 가장 좋아하는 단어는? >> " );
				String question = s.nextLine();
				System.out.println("--------------------------------\n");
				String regex_name = "(\\w|\\W)+";
				Pattern p = Pattern.compile(regex_name);
				Matcher m = p.matcher(question);
				if(m.matches()) {
					user.setUser_password_question(question);
					break;
				}else
					System.out.print("다시 입력해주세요. >> ");
			}
			
			while(true) {
				System.out.print("이름 >> " );
				String name = s.nextLine();
				String regex_name = "\\W{2,15}";
				Pattern p = Pattern.compile(regex_name);
				Matcher m = p.matcher(name);
				if(m.matches()) {
					user.setUser_name(name);
					break;
				}else
					System.out.print("이름을 다시 입력해주세요 >> ");
			}
			
			while(true) {
				System.out.print("핸드폰 번호(-생략) >> ");
				String phone = s.nextLine();	
				String regex_phone =  "[0-9]{3}[0-9]{3,4}[0-9]{4}";
				Pattern p = Pattern.compile(regex_phone);
				Matcher m = p.matcher(phone);
				if(m.matches()) {
					user.setUser_phone_num(phone);
					break;
				}else
					System.out.print("핸드폰번호를 다시 입력해주세요 >> ");
			}
			
			while(true) {
				System.out.print("생년월일(8자리) >> ");
				String birth = s.nextLine();
				String regex_birth = "[1-2]{1}[0-9]{7}";
				Pattern p = Pattern.compile(regex_birth);
				Matcher m = p.matcher(birth);
				if(m.matches()) {
					user.setUser_birth(birth);
					break;
				}else
					System.out.print("생년월일을 (8자리) 다시 입력해주세요 >> ");
				
				
			}
			
			
			while(true) {
				System.out.print("주소: ");
				String add1 = s.nextLine();
				String regex_add1= "(\\W|[0-9]){1,50}";
				Pattern p = Pattern.compile(regex_add1);
				Matcher m = p.matcher(add1);
				if(m.matches()) {
					user.setUser_add1(add1);
					break;
				}else
					System.out.print("주소를 다시 입력해주세요 >> ");	
				
			}
			
			while(true) {
				System.out.print("상세주소 >> ");
				String add2 = s.nextLine();
				String regex_add2= "(\\W|[0-9]){1,50}";
				Pattern p = Pattern.compile(regex_add2);
				Matcher m = p.matcher(add2);
				if(m.matches()) {
					user.setUser_add2(add2);
					break;
				}else
					System.out.print("주소를 다시 입력해주세요 >> ");	
				
			}
			while(true) {
				System.out.print("(선택사항:엔터를 누르세요) 이메일 >> ");
				String email = s.nextLine();
				String regex_email= "^[a-z0-9A-Z._-]*@([a-z0-9A-Z])+(\\.)+[a-zA-Z.]+$";
				Pattern p = Pattern.compile(regex_email);
				if(email.length()==0) {
					user.setUser_email(null);
					break;
				}
				Matcher m = p.matcher(email);
				if(m.matches()) {
					user.setUser_email(email);
					break;
				}else
					System.out.print("(선택사항:엔터를 누르세요) 이메일을 다시 입력해주세요 >> ");
			}
			user.setUser_access(0);
			
			UserDao userDao = UserDao.getInstance();
			userDao.insertUser(user);
			
			
		}
		
		//로그인
		public void login(){
			Scanner s = new Scanner(System.in);
			int count = 0;
			boolean flag = true;
			do {
				System.out.print("아이디 >> ");
				String id = s.nextLine();
				System.out.print("비밀번호 >> ");
				String password = s.nextLine();
				
				HashMap<String,String>param = new HashMap<>();
				param.put("User_id", id);
				param.put("User_password", password);
				
				
				UserVO user = userDao.selectUser(param);
				
				if(user == null){
					count++;
					System.err.println(count+" 번째 로그인 시도");
					System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.\n");
					Session.LoginUser = null;
					flag=false;
				}else{
					System.out.println("로그인 성공!");
					UserService.logo();
					System.out.println(user.getUser_name() + "님 환영합니다.\n");
					Session.LoginUser = user;
					flag=true;
				}
			} while(!flag&&count<3);
			
		}
		
		//회원목록
		public void userList() {
			ArrayList<UserVO> userList = userDao.selectUserLsit();

			System.out.println("-------------------------------------");
			System.out.println("번호\t아이디\t이름");
			System.out.println("-------------------------------------");
			for(int i=userList.size() - 1 ;i >=0 ; i--){
				UserVO user = userList.get(i);
				System.out.println(i +1 + "\t" + user.getUser_id() + "\t" +user.getUser_name());
			}
			System.out.println("-------------------------------------");
			
		}
		
	  
		static void logo() {
			  System.out.println("      ■■■■■■■■■■■ ");
		      System.out.println("     ■           ■");
		      System.out.println("     ■           ■");
		      System.out.println("     ■           ■");
		      System.out.println("     ■   ■    ■  ■");
		      System.out.println("     ■   ■    ■  ■");
		      System.out.println("     ■           ■");
		      System.out.println("      ■         ■");
		      System.out.println("       ■■■■■■■■■ ");
		      System.out.println("     ■     ■     ■");
		      System.out.println("    ■      ■      ■");
		      System.out.println("   ■       ■       ■");
		      System.out.println("  ■        ■        ■");  
		      System.out.println("  ■  ■           ■  ■");
		      System.out.println("  ■■■■           ■■■■");
		      System.out.println("     ■           ■ ");
		      System.out.println("     ■    ■■■    ■ ");
		      System.out.println("     ■■■■■   ■■■■■   ");
		}
		
		public static void logo2() {
			System.out.println("                                                                                                                                                                                                                              \r\n" + 
					"  ZZZZZZZj       ZZZZZZZZ     ZZZZZ        BZZZZ       jZZZZZZZZZZZ     ZZZZZ     ZZZZZZZZ       ZZZZZ       yZZZZZZZZZZZ         ZZZZZZZ                                                                                    \r\n" + 
					"  ZZZZZZZZ       ZZZZZZZZ     ZZZZZ        ,ZZZZ      ZZZZZZ9ZZZZZZD    ZZZZZ     ZZZZZZZZy      EZZZ9     jZZZZZZZZZZZZZ         ZZZZZZZ                                                                                    \r\n" + 
					"  ZZZZZZZZW     ZZZZZZZZZ     ZZZZZ        5ZZZZ     ZZZZj              ZZZZZ     ZZZZZZZZZ      EZZZE    WZZZZ                  ZZZZZZZZZ                                                                                   \r\n" + 
					"  ZZZZZZZZZ    wZZZZZZZZZ     ZZZZZ        zZZZZ     ZZZZ               ZZZZZ     ZZZZZZZZZZ     EZZZZ    9ZZZD                 jZZZZ ZZZZW                                                                                  \r\n" + 
					"  ZZZZ ZZZZ5   ZZZZZ ZZZZ     ZZZZZ        9ZZZZ     ZZZZZ              ZZZZZ     ZZZZ9 ZZZZ9    EZZZZ    ZZZZZZ                ZZZZZ zZZZZ                                                                                  \r\n" + 
					"  ZZZZ  ZZZZ  zZZZZ ,ZZZZ     ZZZZZ        9ZZZZ     ZZZZZZZZZZE        ZZZZZ     ZZZZZ  ZZZZ    EZZZZ    9ZZZZZZZZZZD         8ZZZZ   ZZZZZ                                                                                 \r\n" + 
					"  ZZZZ  8ZZZ  ZZZZ  BZZZZ     ZZZZZ        9ZZZZ       ZZZZZZZZZZZZ     ZZZZZ     ZZZZZ   ZZZZ   EZZZZ      ZZZZZZZZZZZZZ      ZZZZ5   8ZZZZ                                                                                 \r\n" + 
					"  ZZZZ   ZZZZZZZZZ  8ZZZZ     ZZZZZ        EZZZZ           DEZZZZZZ9    ZZZZZ     ZZZZZ   9ZZZz  9ZZZZ          BZZZZZZZZz    ZZZZZ     ZZZZZ                                                                                \r\n" + 
					"  ZZZZ   wZZZZZZZ   zZZZZ     ZZZZZ        9ZZZZ               ZZZZZ    ZZZZZ     ZZZZZ    ZZZZ  8ZZZ9              wZZZZZ    ZZZZZZZZZZZZZZZj                                                                               \r\n" + 
					"  ZZZZ    j9z8yB    8ZZZZ     DZZZZ        DZZZZ               ,ZZZZ    ZZZZZ     ZZZZZ     ZZZZ jZZZz               8ZZZZ   ZZZZZ9z8888EZZZZZ                                                                               \r\n" + 
					"  ZZZZ              8ZZZZ      9ZZZE      ,ZZZZZ               ZZZZz    ZZZZZ     ZZZZZ      ZZZZZZZZB               ZZZZB  jZZZZB        ZZZZ9                                                                              \r\n" + 
					"  ZZZZ              8ZZZZ       ZZZZZZZZZZZZZZZ     ZZZZZZZZEZZZZZZ     ZZZZZ     ZZZZZ      ,ZZZZZZZy    ZZZZZZZZEZZZZZZ   ZZZZZ         ZZZZZ                                                                              \r\n" + 
					"  ZZZZ              ZZZZZ         8ZZZZZZZZZW       jZZZZZZZZZZZZ       ZZZZZ     ZZZZZ       DZZZZZZz    ZZZZZZZZZZZZZ    ZZZZZ           ZZZZZ                                                                             \r\n" + 
					"                                                                                                          ");
		}
		
		public void find_id() {
			Scanner s = new Scanner(System.in);
			String name;
			String birth;
			String phone;
			UserVO user;
			int count =0;
			String answer;
			UserDao userdao = UserDao.getInstance();
			ArrayList<UserVO> abc = userdao.selectUserLsit();
			total :do {
				System.out.println("==========아이디 찾기=========");
				System.out.print("이름을 입력해주세요 >> ");
				name = s.nextLine();
				System.out.print("생년월일을 입력해주세요(8자리) >> ");
				birth = s.nextLine();
				System.out.print("핸드폰 번호를 입력해주세요(-생략) >> ");
				phone = s.nextLine();
				System.out.println("비교중....");
				for(int i=0;i<abc.size();i++) {
					user = abc.get(i);
					if((user.getUser_name().equals(name) && user.getUser_birth().equals(birth) &&user.getUser_phone_num().equals(phone))) {
						System.out.println("사용자님의 아이디는 "+user.getUser_id()+"입니다");
						do { System.out.print("비밀번호를 찾으시겠습니까? y/n"); answer =s.nextLine();
						if(answer.equals("y")||answer.equals("Y")) { find_password(); break total ;
						} }while(!(answer.equals("N")||answer.equals("n")));
						
					}
				}
				System.out.println("찾을 수 없습니다.\n");
				count++;
			}while (count<3);
		}

	
	 
		public void find_password() {
			Scanner s = new Scanner(System.in);
			String id;
			String answer;
			int count=0;
			boolean flag = true;
			UserDao userdao = UserDao.getInstance();
			ArrayList<UserVO> abc = userdao.selectUserLsit();
			id:do {
				System.out.println("==========비밀번호 찾기=========");
				System.out.print("아이디를 입력해주세요 >> ");
				id = s.nextLine();
				System.out.println("비교중....");
				for(int i=0; i<abc.size();i++) {
					//하나씩 가져와서 equls로 비교 
					if(abc.get(i).getUser_id().equals(id)) {
						System.out.print("당신이 가장 좋아하는 단어는? >> ");
						answer = s.nextLine();
						if(abc.get(i).getUser_id().equals(id)) {
							System.out.println(abc.get(i).getUser_id()+"님의 비밀번호는 ["+abc.get(i).getUser_password()+"]입니다.\n");				
							break id;
						}
						
					}
				}
				System.out.println("찾을 수 없습니다.\n");
				count++;
			}while(count<3);
		}
}
