package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.ClientDAO;
import dto.ClientDTO;

public class ClientEx {

	static boolean run = true;

	// 콘솔로 문자열 입력받기 메소드
	public String getStringInfo() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		return s;
	}

	// 콘솔로 숫자 입력받기 메소드
	public int getIntInfo() {
		Scanner sc = new Scanner(System.in);
		int i = Integer.parseInt(sc.nextLine());
		return i;
	}

	// 콘솔로 문자열 입력받기 메소드

	public String getStringInfo(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.print(msg + " = ");
		String inData = scan.nextLine();
		return inData;
	}

	// 콘솔로 숫 입력받기 메소드
	public int getIntInfo(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.print(msg + "=");
		int i = Integer.parseInt(scan.nextLine());
		return i;
	}

	public void InsertInfo() {
		ClientDAO clientdao = new ClientDAO();
		int ptcnt = 0;

		String name = getStringInfo("이름");
		String phonenum = getStringInfo("전화번호");
		int age = getIntInfo("나이");
		String sex = getStringInfo("성별");
		String address = getStringInfo("주소");
		int height = getIntInfo("키");
		int weight = getIntInfo("몸무게");
		int reg_months = getIntInfo("개월수");
		int ifpt = getIntInfo("피티여부");
		if (ifpt == 1) {
			ptcnt = getIntInfo("피티횟수");
		}

		clientdao.setInsert(name, phonenum, age, sex, address, height, weight, reg_months, ifpt, ptcnt);
	}

	// 상세정보 출력
	public void showAllClientInfo() {
		ClientDAO cd = new ClientDAO();
		List<ClientDTO> list = cd.getAllInfo();
		System.out.println("  번호\t 이름\t    연락처\t 나이\t성별\t 주소\t   키\t몸무게\t  등록일     등록기간\t  만료일       PT여부\tPT횟수");

		for (ClientDTO e : list) {
			System.out.printf("%4d\t%3s\t%13s\t%4d\t%2s\t%3s\t%6d\t%4d\t%tY/%tm/%td\t%2d\t%tY/%tm/%td\t%2d\t%4d\t\n\n",
					e.getC_ClientNum(), e.getC_Name(), e.getC_PhoneNum(), e.getC_age(), e.getC_Sex(), e.getC_Address(),
					e.getC_Height(), e.getC_Weight(), e.getC_RegistrationDate(), e.getC_RegistrationDate(),
					e.getC_RegistrationDate(), e.getC_Reg_Months(), e.getC_ExpirationDate(), e.getC_ExpirationDate(),
					e.getC_ExpirationDate(), e.getC_ifPT(), e.getC_LeftPTCnt());
		}
	}

	// 간단정보 출력
	public void showSimpleClientInfo() {
		ClientDAO cd = new ClientDAO();
		List<ClientDTO> list = cd.getSimpleInfo();
		for (ClientDTO e : list) {
			System.out.printf("%d\t%s\t%s\n", e.getC_ClientNum(), e.getC_Name(), e.getC_PhoneNum());
		}
	}

	// 검색정보 출력
	public void showSearchInfo() {
		ClientDAO cd = new ClientDAO();
		List<ClientDTO> list = cd.getSearch(getStringInfo());
		for (ClientDTO e : list) {
			System.out.printf("%d\t%s\t%s\n", e.getC_ClientNum(), e.getC_Name(), e.getC_PhoneNum());
		}
	}

	// 회원상태 출력 (이용중 ,만료) > 인자를 회원번호로 받아왔음
	public void showClientState(int a) {

		ClientDAO c = new ClientDAO();
		List<ClientDTO> list = new ArrayList<ClientDTO>();
		list = c.getAllInfo();

		Date c_expriationDate = list.get(a - 1).getC_ExpirationDate();

		Calendar cal = Calendar.getInstance();
		Date today = new Date(cal.getTimeInMillis());

		if (today.compareTo(c_expriationDate) > 0) {
			System.out.println("만료");
		} else if (today.compareTo(c_expriationDate) < 0) {
			System.out.println("이용중");
		} else {
			System.out.println("오늘이 마지막 이용일입니다.");
		}
	}

	// 회원정보 수정 선택 메뉴 출력 메소드
	public void menu_Update() {
		System.out.println(
				"\n[메뉴] 1: 이름, 2: 연락처, 3: 나이, 4 : 성별, 5 : 주소, 6 : 키, 7 : 몸무게, 8 : 만료일, 9 : PT횟수, 10 : 이전단계로 = ");
		getIntInfo();
	}

	// 시작 메소드
	public void start() {
		System.out.println("[회원관리 프로그램을 시작합니다]\n");

		while (run) {
			ClientDAO cd = new ClientDAO();
//		System.out.println("  번호\t 이름\t    연락처\t 나이\t성별\t 주소\t   키\t몸무게\t  등록일     등록기간\t  만료일       PT여부\tPT횟수");
//		System.out.println("================================================================================================================================");
//		
			System.out.println(
					"\n[메뉴] 1: 회원정보조회(상세), 2: 회원정보조회(기본), 3: 회원상태조회, 4 : 회원검색, 5 : 회원추가, 6 : 회원수정, 7 : 회원 삭제, 8 : 종료 = ");
			System.out.print("[원하시는 기능의 번호를 입력하세요] : ");
			int a = getIntInfo();
			switch (a) {
			case 1: // 회원정보조회(상세)
				System.out.println(
						"\n[메뉴] 1: 회원정보조회(상세), 2: 회원정보조회(기본), 3: 회원상태조회, 4 : 회원검색, 5 : 회원추가, 6 : 회원수정, 7 : 회원 삭제, 8 : 종료 = ");
				showAllClientInfo();
				break;
			case 2: // 회원정보조회(기본)
				showSimpleClientInfo();
				break;
			case 3: // 회원상태조회
				System.out.print("회원번호를 입력해주세요 = ");
				showClientState(getIntInfo());
				break;
			case 4: // 회원검색
				System.out.print("이름 또는 연락처를 입력해주세요 = ");
				showSearchInfo();
				break;
			case 5: // 회원추가
				System.out.print("회원정보를 입력해주세요 = ");
				InsertInfo();
				break;

			case 6: // 회원수정
				System.out
						.println("\n[메뉴] 1: 이름, 2: 연락처, 3: 나이, 4 : 성별, 5 : 주소, 6 : 키, 7 : 몸무게, 8 : PT횟수, 9 : 이전단계로 = ");
				switch (getIntInfo()) {
				case 1:
					System.out.print("회원번호와 이름을 순서대로 입력해주세요 = ");
					cd.setUpdateName(getIntInfo(), getStringInfo());
					System.out.println(
							"\n[메뉴] 1: 회원정보조회(상세), 2: 회원정보조회(기본), 3: 회원상태조회, 4 : 회원검색, 5 : 회원추가, 6 : 회원수정, 7 : 회원 삭제, 8 : 종료 = ");
					showAllClientInfo();
					break;
				case 2:
					System.out.print("회원번호와 연락처를 순서대로 입력해주세요 = ");
					cd.setUpdatePhoneNum(getIntInfo(), getStringInfo());
					System.out.println(
							"\n[메뉴] 1: 회원정보조회(상세), 2: 회원정보조회(기본), 3: 회원상태조회, 4 : 회원검색, 5 : 회원추가, 6 : 회원수정, 7 : 회원 삭제, 8 : 종료 = ");
					showAllClientInfo();
					break;
				case 3:
					System.out.print("회원번호와 나이를 순서대로 입력해주세요 = ");
					cd.setUpdateAge(getIntInfo(), getIntInfo());
					System.out.println(
							"\n[메뉴] 1: 회원정보조회(상세), 2: 회원정보조회(기본), 3: 회원상태조회, 4 : 회원검색, 5 : 회원추가, 6 : 회원수정, 7 : 회원 삭제, 8 : 종료 = ");
					showAllClientInfo();
					break;
				case 4:
					System.out.print("회원번호와 성별을 순서대로 입력해주세요 = ");
					cd.setUpdateSex(getIntInfo(), getStringInfo());
					System.out.println(
							"\n[메뉴] 1: 회원정보조회(상세), 2: 회원정보조회(기본), 3: 회원상태조회, 4 : 회원검색, 5 : 회원추가, 6 : 회원수정, 7 : 회원 삭제, 8 : 종료 = ");
					showAllClientInfo();
					menu_Update();
					break;
				case 5:
					System.out.print("회원번호와 주소를 순서대로 입력해주세요 = ");
					cd.setUpdateAddress(getIntInfo(), getStringInfo());
					System.out.println(
							"\n[메뉴] 1: 회원정보조회(상세), 2: 회원정보조회(기본), 3: 회원상태조회, 4 : 회원검색, 5 : 회원추가, 6 : 회원수정, 7 : 회원 삭제, 8 : 종료 = ");
					showAllClientInfo();
					break;
				case 6:
					System.out.print("회원번호와 키를 순서대로 입력해주세요 = ");
					cd.setUpdateHeight(getIntInfo(), getIntInfo());
					System.out.println(
							"\n[메뉴] 1: 회원정보조회(상세), 2: 회원정보조회(기본), 3: 회원상태조회, 4 : 회원검색, 5 : 회원추가, 6 : 회원수정, 7 : 회원 삭제, 8 : 종료 = ");
					showAllClientInfo();
					break;
				case 7:
					System.out.print("회원번호와 몸무게를 순서대로 입력해주세요 = ");
					cd.setUpdateWeight(getIntInfo(), getIntInfo());
					System.out.println(
							"\n[메뉴] 1: 회원정보조회(상세), 2: 회원정보조회(기본), 3: 회원상태조회, 4 : 회원검색, 5 : 회원추가, 6 : 회원수정, 7 : 회원 삭제, 8 : 종료 = ");
					showAllClientInfo();
					break;
				case 8:
					System.out.print("회원번호와 PT횟수를 순서대로 입력해주세요 = ");
					cd.setUpdateLeftPTCnt(getIntInfo(), getIntInfo());
					System.out.println(
							"\n[메뉴] 1: 회원정보조회(상세), 2: 회원정보조회(기본), 3: 회원상태조회, 4 : 회원검색, 5 : 회원추가, 6 : 회원수정, 7 : 회원 삭제, 8 : 종료 = ");
					showAllClientInfo();
					break;

				}
				break;
			case 7: // 회원삭제
				System.out.print("회원번호를 입력해주세요 = ");
				cd.setDelete(getIntInfo());
				break;
			case 8: // 종료 또는 관리자 메인 메뉴로 복귀
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;

			}
		}
	}
}
