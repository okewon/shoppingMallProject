package dao;

import data.Database;

public class QnaDao {
	
	private static QnaDao instance;
	
	private QnaDao() {}
	
	public static QnaDao getInstance() {
		if(instance == null) {
			instance = new QnaDao();
		}
		return instance;
	}
	
	Database database = Database.getInstance();
}
