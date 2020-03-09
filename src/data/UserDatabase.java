package data;

import java.util.ArrayList;

import vo.UserVO;

public class UserDatabase {
	
	private static UserDatabase instance;
	
	private UserDatabase() {}

	public static UserDatabase getInstance() {
		if(instance == null) {
			instance = new UserDatabase();
		}
		return instance;
	}
	
	public ArrayList<UserVO> tb_user = new ArrayList<UserVO>();
	{
		UserVO user = new UserVO();
		
	}
}