package dao;

import data.Database;
import vo.GongjiVO;

public class GongjiDao {
	
	private static GongjiDao instance;
	private static int number = 0;
	
	private GongjiDao() {}
	
	public static GongjiDao getInstance() {
		if(instance == null) {
			instance = new GongjiDao();
		}
		
		return instance;
	}
	
	Database database = Database.getInstance();

	public void enrollGongji(GongjiVO gongji) {
		database.tb_gongji.add(gongji);	
	}
	
	
	public void modifyGongji(String Gongji_name, String Gongji_content) {
		if(database.tb_gongji.size() == 0) {
			System.out.println("등록된 공지가 존재하지 않습니다.");
		}else {
			for(int i = 0; i < database.tb_gongji.size(); i++) {
				if(database.tb_gongji.get(i).getGongji_name().equals(Gongji_name)) {
					database.tb_gongji.get(i).setGongji_name(Gongji_name);
					database.tb_gongji.get(i).setGongji_content(Gongji_content);
					System.out.println("공지 " + Gongji_name + "가 수정되었습니다.\n");
				} else {
					if(i == database.tb_review.size() - 1) {
						System.out.println(Gongji_name + "와(과) 일치하는 글이 존재하지 않습니다.\n");
					}
				}
			}
		}
	}
	
	public void deleteGongji(String Gongji_name) {
		if(database.tb_gongji.size() == 0) {
			System.out.println("등록된 공지가 존재하지 않습니다.");
		}else {
			for(int i = 0; i < database.tb_gongji.size(); i++) {
				if(database.tb_gongji.get(i).getGongji_name().equals(Gongji_name)) {
					database.tb_gongji.remove(i);
					System.out.println(Gongji_name + "이(가) 삭제되었습니다.\n");
				} else {
					if(i == database.tb_review.size() - 1) {
						System.out.println(Gongji_name + "와(과) 일치하는 게시글이 존재하지 않습니다.\n");
					}
				}
			}
		}
	}
	
	public void showGongji() {
		if(database.tb_gongji.size() == 0) {
			System.out.println("등록된 공지가 존재하지 않습니다.");
		}else {
			System.out.println("------------------------------------------------------------------------------------------------------");
			System.out.println("순서 번호\t\t작성자\t\t게시글 제목\t\t게시글 내용\t\t게시 일자");
			System.out.println("------------------------------------------------------------------------------------------------------");
			for(int i = 0; i < database.tb_gongji.size(); i++) {
			    System.out.println(database.tb_gongji.get(i).getGongji_num() + "\t" + database.tb_gongji.get(i).getGongji_id() + "\t" + database.tb_gongji.get(i).getGongji_name() + "\t" + database.tb_gongji.get(i).getGongji_content() + "\t" + database.tb_gongji.get(i).getGongji_date());
			}
			System.out.println("------------------------------------------------------------------------------------------------------\n");
		}
	}
}
