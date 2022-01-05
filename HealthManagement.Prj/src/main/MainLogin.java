package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Exception.MyException;
import Exception.MyException2;
import dao.ManagerDAO;
import dto.ManagerDTO;

public class MainLogin {
	Scanner scan = new Scanner(System.in); // 라인단위 입력 스캐너

	// 그냥 로그인만 (디폴트 시만)
	public void LoginAction() {
		try {
			HashMap<String, String> map = new HashMap<String, String>(); // 아이디 비번 일치용
			HashMap<String, String> map2 = new HashMap<String, String>(); // 이름 출력용

			ManagerDAO dao = new ManagerDAO();
			ArrayList<ManagerDTO> members = new ArrayList<ManagerDTO>();
			members = dao.getManagers();

			for (int i = 0; i < members.size(); i++) {
				map.put(members.get(i).getM_Id(), members.get(i).getM_Pwd());
				map2.put(members.get(i).getM_Id(), members.get(i).getM_Name());
			}

			int count = 0; // 카운트 변수
			while (true) {

				System.out.println("[ 로그인 화면 ] ");
				System.out.println("아이디와 비밀번호를 입력하세요.");
				System.out.print("ID: ");
				String id = scan.nextLine().trim();

				System.out.print("PASSWORD: ");
				String password = scan.nextLine().trim();
				System.out.println();

				if (!map.containsKey(id)) { // 입력한 아이디가 해쉬맵 키에 들어가 있지 않다면
					System.out.println("[경고] 입력하신 ID는 존재하지 않습니다!  다시 입력 해주세요. ");
					count++;
					System.out.println(" [입력 가능 횟수] = " + (5 - count) + "[회]");
					if (count == 5) {
						System.out.println("[ 입력 횟수 초과로 강제종료합니다.]");
						System.exit(0); // 강제 종료
					}
					// continue; // 이건 사용 안해도 될 것 같음
				} else {
					if (!(map.get(id).equals(password))) {
						System.out.println("[경고] 입력하신 비밀번호가 일치하지 않습니다. 다시 입력해주세요.. ");

					} else {
						System.out.println(" 아이디와 비밀번호가 일치합니다.");
						System.out.printf(" ★환영합니다 [%s] 관리자님★ \n", map2.get(id));
						break;
					}
				}

			} // while
		} catch (Exception e) {
			System.out.println("예외처리 :" + e.getMessage());
			e.printStackTrace();
		}

	}

	public void LoginAction2() throws SQLException {
		try {
			HashMap<String, String> map = new HashMap<String, String>(); // 아이디 비번 일치용
			HashMap<String, String> map2 = new HashMap<String, String>(); // 이름 출력용

			ManagerDAO dao = new ManagerDAO();
			List<ManagerDTO> members = new ArrayList<ManagerDTO>();
			members = dao.getManagers();

			for (int i = 0; i < members.size(); i++) {
				map.put(members.get(i).getM_Id(), members.get(i).getM_Pwd());
				map2.put(members.get(i).getM_Id(), members.get(i).getM_Name());
			}
			Scanner scan = new Scanner(System.in); // 라인단위 입력 스캐너

			int count = 0; // 카운트 변수
			while (true) {
				System.out.println("[ 로그인 화면 ] ");
				System.out.println("아이디와 비밀번호를 입력하세요.");
				System.out.print("ID: ");
				String id = scan.nextLine().trim();

				System.out.print("PASSWORD: ");
				String password = scan.nextLine().trim();
				System.out.println();

				if (!map.containsKey(id)) { // 입력한 아이디가 해쉬맵 키에 들어가 있지 않다면
					System.out.println("[경고] 입력하신 ID는 존재하지 않습니다!  다시 입력 해주세요. ");
					count++;
					System.out.println("[경고] [입력 가능 횟수] = " + (5 - count) + "[회]");
					if (count == 5) {
						System.out.println("[ 입력 횟수 초과로 강제종료합니다.]");
						System.exit(0);
					}
					// continue; // 이건 사용 안해도 될 것 같음
				} else {
					if (!(map.get(id).equals(password))) {
						System.out.println("[경고] 비밀번호 일치하지 않습니다. 다시 입력해주세요.");

					} else {
						System.out.println(" 아이디와 비밀번호가 일치합니다.");
						System.out.printf(" ★환영합니다 [%s] 관리자님★ \n", map2.get(id));
						executeProgram(); // 바로 프로그램 실행 메소드 호출
					}
				}

			} // while
		} catch (Exception e) {
			System.out.println("예외처리 :" + e.getMessage());
			e.printStackTrace();
		}

	}
//객체 간의 관계를 통해 메세지를 주고받아 프로그램을 작성하는 방법
	// (관리자 프로그램 실행)로그인 성공 시 -> 1번 : 관리자 회원가입 / 2번 : 사원 관리 프로그램 / 3번 : 로그아웃
	public void executeProgram() {
		ClientEx ce = new ClientEx();
		int select = 0;
		while (true) {
			System.out.println("[ 프로그램 실행.. ]");
			System.out.print("[1. 관리자 관리 프로그램]\n[2. 사원 관리 프로그램]\n[3. 로그아웃]\n번호 입력: ");

			// int select = scan.nextInt(); nextline이랑 번가르면 엔터처리 못해서 겹쳐짐
			try {
				select = Integer.parseInt(scan.nextLine().trim());
			} catch (NumberFormatException e) {
			}
			switch (select) {
			case 1:
				System.out.println("[관리자 프로그램을 실행합니다..]");
				new ManagerEx().managerManage();// 관리자 관리 프로그램 실행 진입 메소드
			case 2:
				System.out.println("[헬스 회원 관리 프로그램을 실행합니다..]");
				ce.start();
			case 3:
				System.out.println("[로그아웃이 완료되었습니다..]");
				MainProgram.main(null);// 다시 로그인 창으로 메인메소드 부름

			default:
				System.out.println("[경고] : 1 ~ 3 만 입력하세요.. ");
				System.out.println("===============================================");

			}
		}
	}

	public void selectMenu() {
		int select = 0;
		while (true) {
			System.out.println("[1. 로그인] | [2.아이디 찾기] | [3.비밀번호 찾기(변경)] | [4.종료]\n입력:");
			try {
				select = Integer.parseInt(scan.nextLine().trim());
			} catch (NumberFormatException e) {
			}
			switch (select) {
			case 1:
				try {
					LoginAction2();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			case 2:
				idFindAction();
				break;
			case 3:
				pwdChange();
				break;
			case 4:
				System.out.println("[종료] 프로그램을 종료합니다..");
				System.exit(0); // 완전 종료
			default:
				System.out.println("[경고] : 0 ~ 3 만 입력하세요.. ");
			}
		}
	}

	// 아이디 찾기 메소드 아이디 보여줌
	public void idFindAction() {
		HashMap<String, String> map = new HashMap<String, String>(); // 아이디 비번 일치용
		HashMap<String, String> map2 = new HashMap<String, String>(); // 이름 출력용

		ManagerDAO dao = new ManagerDAO();
		List<ManagerDTO> members = new ArrayList<ManagerDTO>(); // member 변수에 관리자 정보 다 넣기
		members = dao.getManagers();

		for (int i = 0; i < members.size(); i++) {
			map.put(members.get(i).getM_Name(), members.get(i).getM_PhoneNum()); // 이름 폰
			map2.put(members.get(i).getM_Name(), members.get(i).getM_Id()); // 이름 아이디
		}
		while (true) {
			System.out.println("이름과 전화번호를 입력하세요.");
			System.out.print("이름: ");
			String name = scan.nextLine().trim();

			System.out.print("전화번호: ");
			String phone = scan.nextLine().trim();

			System.out.println();

			if (!map.containsKey(name)) { // 입력한 이름이 키에 있지 않을떄
				System.out.println("[경고] 입력하신 이름은 존재하지 않습니다. 다시 입력해주세요");

			} else {
				if (!(map.get(name).equals(phone))) {
					System.out.println("[경고] 전화번호가 일치하지 않습니다. 다시 입력해주세요.");
				} else {
					System.out.println(" 이름과 전화번호가 일치합니다.");
					System.out.println(" 당신의 ID: " + map2.get(name));
					selectMenu(); // 다시 돌아가기
				}
			}
		}
	}

	// 비밀번호 변경 메소드
	public void pwdChange() {
		HashMap<String, String> map = new HashMap<String, String>(); // 아이디 비번 일치용
		HashMap<String, String> map2 = new HashMap<String, String>(); // 이름 출력용

		ManagerDAO dao = new ManagerDAO();
		List<ManagerDTO> members = new ArrayList<ManagerDTO>(); // member 변수에 관리자 정보 다 넣기
		members = dao.getManagers();

		for (int i = 0; i < members.size(); i++) {
			map.put(members.get(i).getM_Id(), members.get(i).getM_PhoneNum()); // 아이디 폰
			map2.put(members.get(i).getM_Id(), members.get(i).getM_Name()); // 아이디 이름
		}

		System.out.println("아이디 이름과 전화번호를 입력하세요.");
		System.out.print("아이디: ");
		String id = scan.nextLine().trim();

		System.out.print("이름: ");
		String name2 = scan.nextLine().trim();

		System.out.print("전화번호: ");
		String phone2 = scan.nextLine().trim();
		System.out.println();

		if (!map.containsKey(id)) { // 입력한 이름이 키에 있지 않을떄
			System.out.println("[경고] 입력하신 아이디는 존재하지 않습니다. 다시 입력해주세요");

			// !(map2.get(name2).equals(map2.get(name2)))
		} else {
			if (!(map2.get(id).equals(name2))) {
				System.out.println("[경고] 이름이 일치하지 않습니다. 다시 입력해주세요.");
			} else {
				if (!(map.get(id).equals(phone2))) {
					System.out.println("[경고] 전화번호가 일치하지 않습니다. 다시 입력해주세요.");
				} else {
					System.out.println(" 모든 정보가 일치합니다. ");
					System.out.println(" 비밀번호를 변경 해주세요.");
					dao.updatePwd(id); // 입력 받은 아이디 넘기고 비밀번호만 변경하는 메소드
					selectMenu(); // 다시 돌아가기
				}
			}
		}
	}
}
