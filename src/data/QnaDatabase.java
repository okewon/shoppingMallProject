package data;

import java.util.ArrayList;

import vo.QnaVO;

public class QnaDatabase {
	
	private static QnaDatabase instance;
	
	private QnaDatabase() {}
	
	public static QnaDatabase getInstance() {
		if(instance == null) {
			instance = new QnaDatabase();
		}
		return instance;
	}
	
	public ArrayList<QnaVO> tb_qna = new ArrayList<QnaVO>();
	{
		QnaVO qna = new QnaVO();
	}
}
