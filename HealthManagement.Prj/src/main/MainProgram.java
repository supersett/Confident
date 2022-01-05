package main;

import dao.ManagerDAO;
import dto.ManagerDTO;

public class MainProgram {
	public static void main(String[] args) {
		MainLogin ml = new MainLogin(); // 로그인 메소드들 사용하기 위한 객체 생성
		ManagerDAO dao = new ManagerDAO();

		// DB 관리자 로우 1개일 때?
		if (dao.selectRecord() == 1) { // 사이즈로 레코드 수 확인 1개일때?
			try {
				ml.LoginAction();
			} catch (Exception e) {
				e.printStackTrace();
			} // 첫 디폴트 로그인 ( 단순 로그인만 실행함.)
			dao.insert(); // 관리자가 1명이므로 강제로 회원가입 시켜야 함
			main(args);
		}

		// 회원가입 완료 되었으니, 본격 실행 프로그램 1. 로그인, 2. 아이디찾기, 3. 비밀번호찾기
		if (dao.selectRecord() >= 2) { // DB 레코드 수 2개이상?
			ml.selectMenu();
		}

	}
}
