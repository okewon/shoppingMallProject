package dao;

import data.Database;

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
}
