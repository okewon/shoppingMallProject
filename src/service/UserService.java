package service;

import dao.UserDao;

public class UserService {

	private static UserService instance;
	
	private UserService() {}
	
	public static UserService getInstance() {
		if(instance == null) {
			instance = new UserService();
		}
		return instance;
	}
	
	UserDao userDao = UserDao.getInstance();
}
