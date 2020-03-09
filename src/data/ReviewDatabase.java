package data;

import java.util.ArrayList;

import vo.ReviewVO;

public class ReviewDatabase {
	
	private static ReviewDatabase instance;
	
	private ReviewDatabase() {}
	
	public static ReviewDatabase getInstance() {
		if(instance == null) {
			instance = new ReviewDatabase();
		}
		return instance;
	}
	
	public ArrayList<ReviewVO> tb_review = new ArrayList<ReviewVO>();
	{
		ReviewVO review = new ReviewVO();
	}
}
