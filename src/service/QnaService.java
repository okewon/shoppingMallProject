package service;

import dao.QnaDao;

public class QnaService {
	
	private static QnaService instance;
	
	private QnaService() {}
	
	public static QnaService getInstance() {
		if(instance == null) {
			instance = new QnaService();
		}
		return instance;
	}
	
	QnaDao qnaDao = QnaDao.getInstance();
}
