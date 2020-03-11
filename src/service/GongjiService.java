package service;

import java.util.Date;
import java.util.Scanner;

import dao.GongjiDao;
import data.Session;
import vo.GongjiVO;

public class GongjiService {
	
	private static GongjiService instance;
	private static int Gongji_num = 1;
	
	private GongjiService() {}
	
	public static GongjiService getInstance() {
		if(instance == null) {
			instance = new GongjiService();
		}
		return instance;
	}
	
	GongjiDao gongjiDao = GongjiDao.getInstance();

	public void enrollGongji() {
		Scanner s = new Scanner(System.in);
		System.out.println("공지사항 등록을 시작합니다.");
		
		System.out.print("제목 : ");
		String Gongji_name = s.nextLine();
		System.out.print("내용 : ");
		String Gongji_content = s.nextLine();
		Date Gongji_date = new Date();
		String Gongji_id = Session.LoginUser.getUser_id();
		Gongji_num++;
		
		GongjiVO gongji = new GongjiVO();
		gongji.setGongji_num(Gongji_num);
		gongji.setGongji_name(Gongji_name);
		gongji.setGongji_content(Gongji_content);
		gongji.setGongji_date(Gongji_date);
		gongji.setGongji_id(Gongji_id);
		gongji.setGongji_num(Gongji_num);
		
		gongjiDao.enrollGongji(gongji);
		System.out.println("공지가 등록되었습니다.");
		Gongji_num++;
	}
	
	public void modifyGongji() {
		Scanner s = new Scanner(System.in);
		System.out.println("공지사항 수정을 시작합니다.");
		
		System.out.print("제목 : ");
		String Gongji_name = s.nextLine();
		System.out.print("내용 : ");
		String Gongji_content = s.nextLine();
		
		gongjiDao.modifyGongji(Gongji_name, Gongji_content);
	}
	
	public void deleteGongji() {
		Scanner s = new Scanner(System.in);
		System.out.println("등록된 공지사항을 삭제합니다.");
		
		System.out.print("삭제하고자 하는 공지사항의 게시글 제목을 입력하시오.");
		String Gongji_name = s.nextLine();
		gongjiDao.deleteGongji(Gongji_name);
	}
	
	public void showGongji() {
		gongjiDao.showGongji();
	}
}
