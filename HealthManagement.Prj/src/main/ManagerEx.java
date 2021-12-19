package main;

import java.util.Scanner;

import dao.ManagerDAO;

public class ManagerEx {
	public void managerManage() {

		Scanner scan = new Scanner(System.in);

		ManagerDAO Md = new ManagerDAO();

		int select;

		while (true) {
			do {
				System.out.println(" [ ◀관리자 프로그램▶ ] ");
				System.out.print("========================\n");
				System.out.println(
						"[1. 관리자 전체 조회]\n[2. 선택 관리자 조회]\n[3. 관리자 회원 가입]\n[4. 관리자 정보 수정]\n[5. 관리자 탈퇴]\n[6. 종료] ");
				System.out.print("========================\n입력:  ");
				select = scan.nextInt();

			} while (select < 1 || select > 6);

			System.out.println();

			switch (select) {

			case 1:
				Md.searchAll(); //
				System.out.println();
				break;
			case 2:
				Md.searchOne();
				System.out.println();
				break;
			case 3:
				Md.insert();
				System.out.println();
				break;
			case 4:
				Md.update();
				System.out.println();
				break;
			case 5:
				Md.delete();
				System.out.println();
				break;
			case 6:
				System.out.println(" [ 프로그램이 종료되었습니다. ] ");
				new MainLogin().executeProgram();// 다시 첫 로그인 화면으로
			}
		}
	}
}
