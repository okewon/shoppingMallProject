package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import data.Database;
import vo.UserVO;

public class UserDao {
	
private static UserDao instance;

	private UserDao() {}
	
	public static UserDao getInstance() {
		if(instance == null) {
			instance = new UserDao();
		}
		return instance;
		
	}
	
	Database database = Database.getInstance();
	
	public void insertUser(UserVO user) {
		boolean flag = true;
		
		String id = user.getUser_id();

		database.tb_user.add(user);
		System.out.println("<회원가입 성공> "+user.getUser_name()+"님 반갑습니다!");
		
	}
	
	public UserVO selectUser(HashMap<String, String> param) {
		UserVO rtnUser = null;
		for(int i=0; i < database.tb_user.size(); i++) {
			UserVO user = database.tb_user.get(i);
			boolean flag = true;
			for(String key: param.keySet()) {
				String value = param.get(key);
				if(key.equals("User_id")) {
					if(!user.getUser_id().equals(value)) flag = false;
					}else if (key.equals("User_password")) {
						if(!user.getUser_password().equals(value)) flag = false;
						}
					}
					if(flag) rtnUser = user;
				
			
			
		}
		return rtnUser;
	}
	public ArrayList<UserVO> selectUserLsit() {

		return database.tb_user;
	}
	
	
}
