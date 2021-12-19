package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Exception.MyException2;
import dbconn.DBConn;
//import dbconn.DBconn;
import dto.ManagerDTO;
import main.MainLogin;

public class ManagerDAO {
	private Scanner scan = new Scanner(System.in);
	MainLogin ml = new MainLogin(); // 로그인 메소드들 사용하기 위한 객체 생성
	// ManagerDAO dao = new ManagerDAO(); // 활용하기 위해 메소드 생성 지워도 됨 같은 클래스라
	// ====================================================================================
	// 첫째: 입력된 값을 DB 연동하여 처리하는 메소드들 JDBC

	// 1. 관리자 전체 조회 SELECTALL
	public ArrayList<ManagerDTO> getManagers() {
		ArrayList<ManagerDTO> list = new ArrayList<ManagerDTO>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		
		try {
			conn = DBConn.getConn();
			String sql = "SELECT * FROM MANAGER";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ManagerDTO md = new ManagerDTO();
				// 이거도 고쳐서 알아야함 컬럼명
				md.setM_Id(rs.getString("MNGID"));
				md.setM_Pwd(rs.getString("MNGPWD"));
				md.setM_Name(rs.getString("MNGNAME"));
				md.setM_PhoneNum(rs.getString("MNGPHONE"));
				md.setM_Position(rs.getString("MNGPOSITION"));

				list.add(md);
			}
			

		} catch (SQLException e) {
			System.out.println("예외 발생: " + e.toString());
			e.printStackTrace();
		} finally {
			DBConn.setDBClose(conn, pstmt, rs);
		}
		return list;
	}

	// 2. 관리자 이름으로 선택 조회
	public ArrayList<ManagerDTO> getManager(String name) {

		ArrayList<ManagerDTO> list = new ArrayList<ManagerDTO>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = DBConn.getConn();
			String sql;
			sql = "SELECT * FROM MANAGER WHERE MNGNAME = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				ManagerDTO md = new ManagerDTO();

				// 이거도 고쳐서 알아야함 컬럼명
				md.setM_Id(rs.getString("MNGID"));
				md.setM_Pwd(rs.getString("MNGPWD"));
				md.setM_Name(rs.getString("MNGNAME"));
				md.setM_PhoneNum(rs.getString("MNGPHONE"));
				md.setM_Position(rs.getString("MNGPOSITION"));

				list.add(md);
			}

		} catch (Exception e) {	
			System.out.println("예외 발생 : " + e.toString());
			e.printStackTrace();
		} finally {
			DBConn.setDBClose(conn, pstmt, rs);
		}
		return list;
	}

	// 3. 값 넣기 INSERT
	public int insertData(ManagerDTO md) {

		int result = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = DBConn.getConn();
			String sql;

			sql = "INSERT INTO MANAGER VALUES(?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, md.getM_Id()); // 각 순서대로 값 가져오기
			pstmt.setString(2, md.getM_Pwd());
			pstmt.setString(3, md.getM_Name());
			pstmt.setString(4, md.getM_PhoneNum());
			pstmt.setString(5, md.getM_Position());

			result = pstmt.executeUpdate(); // 가져온 값 넣기 쿼리문 실행 메소드

		} catch (SQLException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			DBConn.setDBClose(conn, pstmt, rs);
		}

		return result;
	}

	// 4. 값 업데이트 update
	public int updateData(ManagerDTO md) {

		int result = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = DBConn.getConn();
			String sql;
			sql = "UPDATE MANAGER SET MNGID = ?, MNGPWD = ?, MNGPHONE = ?, MNGPOSITION = ? WHERE MNGNAME = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, md.getM_Id());
			pstmt.setString(2, md.getM_Pwd());
			pstmt.setString(3, md.getM_PhoneNum());
			pstmt.setString(4, md.getM_Position());
			pstmt.setString(5, md.getM_Name());

			result = pstmt.executeUpdate(); // 가져온 값 넣기 쿼리문 실행 메소드

		} catch (SQLException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			DBConn.setDBClose(conn, pstmt, rs);
		}
		return result;
	}

	// 5. 값 삭제 delete
	public int deleteData(String name) {

		int result = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = DBConn.getConn();
			String sql;

			sql = "DELETE MANAGER WHERE MNGNAME = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name); // 가져온 관리자 이름으로 세팅

			result = pstmt.executeUpdate(); // 가져온 값 넣기 쿼리문 실행 메소드

		} catch (SQLException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			DBConn.setDBClose(conn, pstmt, rs);
			}
		return result;

	}

	// 6. 비밀번호만 업데이트 update
	public int updateOnlyPwd(ManagerDTO md) {

		int result = 0;

		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = DBConn.getConn();
			String sql;
			sql = "UPDATE MANAGER SET MNGPWD = ? WHERE MNGID = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, md.getM_Pwd());
			pstmt.setString(2, md.getM_Id());

			result = pstmt.executeUpdate(); // 가져온 값 넣기 쿼리문 실행 메소드

		} catch (SQLException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			DBConn.setDBClose(conn, pstmt);
		}
		return result;
	}

	// 7. 테이블 레코드 가져오는 함수
	public int selectRecord() {
		ManagerDTO dto = new ManagerDTO();
		int rowCount = 1;
		// List<Integer> list = new ArrayList<Integer>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = DBConn.getConn();
			String sql;
			sql = "SELECT COUNT(*) AS COUNT FROM MANAGER";

			Statement stmt = null;
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				dto.setNum(rs.getInt("COUNT"));
			}
			rowCount = dto.getNum();

		} catch (SQLException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			DBConn.setDBClose(conn, pstmt, rs);
		}
		return rowCount;
	}

	// ====================================================================================
	// 둘째: 사용자로부터 값을 입력 받는 메소드들
	// 예외 객체
	MyException2 ex = new MyException2();

	// [전체 관리자 조회용] 메소드
	public void searchAll() {
		ArrayList<ManagerDTO> list = getManagers();

		Iterator<ManagerDTO> it = list.iterator();

		int i = 1;
		while (it.hasNext()) { // 다음에 가리킬 값 있으면 true
			ManagerDTO vo = it.next(); // 다음에 가져올 값 있으면 가져오기
			System.out.println("[ 관리자 (" + i + ")]");
			System.out.println(vo.toString());
			i++;
		}
	}

	// [선택 관리자 조회용] 메소드
	public void searchOne() {

		System.out.print(" 조회할 관리자 이름 입력: ");
		ArrayList<ManagerDTO> list = getManager(scan.next());

		Iterator<ManagerDTO> it = list.iterator();

		if (!it.hasNext()) {
			System.out.println(" [ 검색하신 관리자가 존재하지 않습니다.. ] ");
		}

		while (it.hasNext()) { // 다음에 가리킬 값 있으면 true
			ManagerDTO vo = it.next(); // 다음에 가져올 값 있으면 가져오기
			System.out.println(vo.toString());

		}
	}

	// 사용자 입력 받는 [관리자 회원가입용]메소드
	public void insert() {
		boolean mngId = true;
		boolean mngPwd = true;
		boolean mngName = true;
		boolean mngPhone = true;
		boolean mngPosition = true;

		System.out.println("=========================================");
		System.out.println(" [ 관리자 회원 가입 ] ");
		System.out.println("=========================================");

		try {
			ManagerDTO dto = new ManagerDTO();

			do {

				System.out.print("관리자 아이디 입력: ");
				dto.setM_Id(scan.next().trim());
				ex.idCheck(dto.getM_Id()); // 예외처리 할거임 나중에

				mngId = false;

			} while (mngId); // true 일때까지 계속 반복 정규식에 틀린 형태일때 계속 반복됨

			do {

				System.out.print("관리자 비밀번호 입력: ");
				dto.setM_Pwd(scan.next().trim());

				mngPwd = false;

			} while (mngPwd);

			do {

				System.out.print("관리자 이름 입력: ");
				dto.setM_Name(scan.next().trim());
				ex.nameCheck(dto.getM_Name()); // 예외처리 할거임

				mngName = false;

			} while (mngName);

			do {
				System.out.print("관리자 전화번호 입력: ");
				dto.setM_PhoneNum(scan.next().trim());
				ex.phoneCheck(dto.getM_PhoneNum());

				mngPhone = false;

			} while (mngPhone);

			do {
				System.out.print("관리자 직급 입력: ");
				dto.setM_Position(scan.next().trim());
				ex.nameCheck(dto.getM_Position());

				mngPosition = false;

			} while (mngPosition);

			int result = insertData(dto); // 방금 받은 값 다 넣어주고

			if (result != 0) { // 데이터가 들어온 경우 회원가입 성공으로 간주
				System.out.println();
				System.out.println(" [ 관리자 회원 가입이 완료 되었습니다. ] ");
				System.out.println("=====================================");
				System.out.println(" [ 사원 정보 ] [아이디, 비밀번호는 보안 상 출력되지 않습니다.] ");
				System.out.println(dto.toString());
			} else
				System.out.println("[ 실패. 다시 시도해주세요. ]");
		} catch (Exception e) {
			System.out.println(" 예외 발생: " + e.toString());
		}
	}

	// 사용자 입력 받는 [관리자 정보 수정용]메소드
	public void update() {

		try {
			ManagerDTO vo = new ManagerDTO();

			System.out.print("수정할 관리자의 이름 입력: ");
			vo.setM_Name(scan.nextLine());
			ex.nameCheck(vo.getM_Name());

			System.out.print("관리자 아이디 변경 : "); // 고민
			vo.setM_Id(scan.nextLine().trim());
			ex.idCheck(vo.getM_Id());

			System.out.print("관리자 비밀번호 변경 : "); // 고민
			vo.setM_Pwd(scan.nextLine().trim());

			System.out.print("관리자 휴대폰번호 변경 : ");
			vo.setM_PhoneNum(scan.nextLine().trim());
			ex.phoneCheck(vo.getM_PhoneNum());

			System.out.print("관리자 직급 변경 : ");
			vo.setM_Position(scan.nextLine().trim());
			ex.nameCheck(vo.getM_Position());

			int result = updateData(vo); // 방금 변경한 데이타 값 넣기

			if (result != 0)
				System.out.println(" [ 관리자 정보 수정 완료 ] ");
			else
				System.out.println(" [ 관리자 정보 수정 실패. 재시도 요망]");
		} catch (Exception e) {
			System.out.println(" 예외 발생: " + e.toString());
		}

	}

	// 사용자 입력 받는 [관리자 정보 삭제용]메소드
	public void delete() {
		try {

			String mngName;

			System.out.print("관리자 이름 입력: ");
			mngName = scan.nextLine();
			ex.nameCheck(mngName);

			int result = deleteData(mngName);

			if (result != 0)
				System.out.println(" [ 관리자 삭제 완료 ] ");
			else
				System.out.println(" [ 관리자 탈퇴 실패. 재시도 요망]");
		} catch (Exception e) {
			System.out.println(" 예외 발생: " + e.toString());
		}
	}

	// 비밀번호 수정 메소드
	public void updatePwd(String id) {

		while (true) {
			try {
				ManagerDTO vo = new ManagerDTO();

				vo.setM_Id(id); // 아이디 입력 받은 거 넣기

				System.out.print("비밀번호 변경 : ");
				vo.setM_Pwd(scan.nextLine().trim());
				if (vo.getM_Pwd().length() != 0) {
					int result = updateOnlyPwd(vo); // 방금 변경한 데이타 값 넣기

					if (result != 0) {
						System.out.println(" [ 비밀번호 수정 완료 ] ");
						break;
					} else
						System.out.println(" [ 비밀번호 수정 실패. 재시도 요망]");
				} else {
					System.out.println("공백 문자를 입력하지 마세요.");
				}

			} catch (Exception e) {
				System.out.println(" 예외 발생: " + e.toString());
			}

		}
	}
}