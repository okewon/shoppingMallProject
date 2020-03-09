package data;

import java.util.ArrayList;

import vo.GongjiVO;

public class GonjiDatabase {

	private static GonjiDatabase instance;
	
	private GonjiDatabase() {}
	
	public static GonjiDatabase getInstance() {
		if(instance == null) {
			instance = new GonjiDatabase();
		}
		return instance;
	}
	
	public ArrayList<GongjiVO> tb_gongji = new ArrayList<GongjiVO>();
	{
		GongjiVO gongji = new GongjiVO();
	}
}
