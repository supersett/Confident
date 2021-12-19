package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dbconn.DBConn;
import dto.ClientDTO;

public class ClientDAO {

	
	
	
	// 회원정보 불러오기 > list에 담기
	public List<ClientDTO> getAllInfo() {
		List<ClientDTO> list = new ArrayList<ClientDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = DBConn.getConn();
			String sql = "SELECT C_CLIENTNUM,C_NAME,C_PHONENUM,C_AGE,C_SEX,C_ADDRESS,C_HEIGHT,C_WEIGHT,C_REGDATE,C_REGMONTHS,C_EXPDATE,C_IFPT,C_PT_CNT FROM HEALTHMS ORDER BY C_CLIENTNUM";//
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ClientDTO vo = new ClientDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getDate(9), rs.getInt(10),
						rs.getDate(11), rs.getInt(12), rs.getInt(13));
				list.add(vo);
			}
		} catch (Exception e) {
		} finally {
			DBConn.setDBClose(conn, pstmt, rs);
		}
		return list;
	}

	// 회원정보 간단불러오기 list에 담기
	public List<ClientDTO> getSimpleInfo() {
		List<ClientDTO> list = new ArrayList<ClientDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = DBConn.getConn();

			String sql = "SELECT C_CLIENTNUM,C_NAME,C_PHONENUM FROM HEALTHMS ORDER BY C_CLIENTNUM";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ClientDTO vo = new ClientDTO(rs.getInt(1), rs.getString(2), rs.getString(3));
				list.add(vo);
			}
		} catch (Exception e) {
		} finally {
			DBConn.setDBClose(conn, pstmt, rs);
		}
		return list;
	}

	// 검색
	public List<ClientDTO> getSearch(String getInput) {
		List<ClientDTO> list = new ArrayList<ClientDTO>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		boolean isNumeric = getInput.matches("[+-]?\\d*(\\.\\d+)?");
		if (isNumeric) {
			System.out.println("숫자임");
			Connection conn = DBConn.getConn();
			String sql = "SELECT C_CLIENTNUM, C_NAME, C_PHONENUM FROM HEALTHMS WHERE C_PHONENUM LIKE '%" + getInput
					+ "%'";
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					ClientDTO clientDTO = new ClientDTO(rs.getInt(1), rs.getString(2), rs.getString(3));
					list.add(clientDTO);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception ee) {
				ee.printStackTrace();
			} finally {
				DBConn.setDBClose(conn, pstmt, rs);
			}
			return list;
		} else {
			System.out.println("숫자아님");

			Connection conn = DBConn.getConn();
			String sql = "SELECT C_CLIENTNUM, C_NAME, C_PHONENUM FROM HEALTHMS WHERE C_NAME LIKE '%" + getInput + "%'";
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					ClientDTO clientDTO = new ClientDTO(rs.getInt(1), rs.getString(2), rs.getString(3));
					list.add(clientDTO);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception ee) {
				ee.printStackTrace();
			} finally {
				DBConn.setDBClose(conn, pstmt, rs);
			}
			return list;
		}
	}

	// insert 추가하기
	public void setInsert(String name, String phonenum, int age, String sex, String address, int height, int weight,
			int reg_months, int ifpt, int ptcnt) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = DBConn.getConn();
			String sql = "INSERT INTO HEALTHMS(" + "C_CLIENTNUM ," + "C_NAME ," + "C_PHONENUM ," + "C_AGE ," + "C_SEX ,"
					+ "C_ADDRESS ," + "C_HEIGHT ," + "C_WEIGHT ," + "C_REGMONTHS ," + "C_IFPT ," + "C_PT_CNT "
					+ ") VALUES (SEQ_HEALTH.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";// Statement에서 지원해
			PreparedStatement st = conn.prepareStatement(sql);// 미리 시퀄문 준비한다음 실행만 할수 있도록한다.!
			// rs = pstmt.executeQuery();
			// st.setInt(1, "SEQ_HEALTH.NEXTVAL");
			st.setString(1, name);
			st.setString(2, phonenum);
			st.setInt(3, age);
			st.setString(4, sex);
			st.setString(5, address);
			st.setInt(6, height);
			st.setInt(7, weight);
			st.setInt(8, reg_months);
			st.setInt(9, ifpt);
			st.setInt(10, ptcnt);

			int result = st.executeUpdate();// excuteUpdate : Insert, Update, Delete 같은 조작을 위한 커
			System.out.println(result);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			DBConn.setDBClose(conn, pstmt, rs);
			System.out.println("입력된 값이 저장되었습니다.");
		}
	}

	// 회원 수정(전체) => primary 키를 받아 비교.
	public void setUpdate(int C_ClientNum) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = DBConn.getConn();
			List<ClientDTO> list = new ArrayList<ClientDTO>();
			list = getAllInfo();

			String sql = "UPDATE HEALTHMS SET C_NAME =?, C_PHONENUM =?, C_AGE =?, C_SEX =?, "
					+ "C_ADDRESS =?, C_HEIGHT =?, C_WEIGHT =?, C_EXPDATE =?, " + "C_PT_CNT =? WHERE C_CLIENTNUM =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, list.get(C_ClientNum - 1).getC_Name());
			pstmt.setString(2, list.get(C_ClientNum - 1).getC_PhoneNum());
			pstmt.setInt(3, list.get(C_ClientNum - 1).getC_age());
			pstmt.setString(4, list.get(C_ClientNum - 1).getC_Sex());
			pstmt.setString(5, list.get(C_ClientNum - 1).getC_Address());
			pstmt.setInt(6, list.get(C_ClientNum - 1).getC_Height());
			pstmt.setInt(7, list.get(C_ClientNum - 1).getC_Weight());
			pstmt.setDate(8, (java.sql.Date) (list.get(C_ClientNum - 1).getC_ExpirationDate()));
			pstmt.setInt(9, list.get(C_ClientNum - 1).getC_LeftPTCnt());
			pstmt.setInt(10, C_ClientNum);
			int result = pstmt.executeUpdate();
		} catch (Exception e) {
		} finally {
			DBConn.setDBClose(conn, pstmt);
		}
	}

	// 회원 수정(이름) => primary 키를 받아 비교.
	public void setUpdateName(int C_ClientNum, String C_Name) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = DBConn.getConn();
			List<ClientDTO> list = new ArrayList<ClientDTO>();
			list = getAllInfo();

			String sql = "UPDATE HEALTHMS SET C_NAME =? WHERE C_CLIENTNUM =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, C_Name);
			pstmt.setInt(2, C_ClientNum);
			int result = pstmt.executeUpdate();
		} catch (Exception e) {
		} finally {
			DBConn.setDBClose(conn, pstmt);
		}
	}

	// 회원 수정(연락처) => primary 키를 받아 비교.
	public void setUpdatePhoneNum(int C_ClientNum, String C_PhoneNum) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = DBConn.getConn();
			List<ClientDTO> list = new ArrayList<ClientDTO>();
			list = getAllInfo();
			String sql = "UPDATE HEALTHMS SET C_PHONENUM =? WHERE C_CLIENTNUM =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, C_PhoneNum);
			pstmt.setInt(2, C_ClientNum);
			int result = pstmt.executeUpdate();
		} catch (Exception e) {
		} finally {
			DBConn.setDBClose(conn, pstmt);
		}
	}

	// 회원 수정(나이) => primary 키를 받아 비교.
	public void setUpdateAge(int C_ClientNum, int C_age) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = DBConn.getConn();
			List<ClientDTO> list = new ArrayList<ClientDTO>();
			list = getAllInfo();
			String sql = "UPDATE HEALTHMS SET C_AGE =? WHERE C_CLIENTNUM =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, C_age);
			pstmt.setInt(2, C_ClientNum);
			int result = pstmt.executeUpdate();
		} catch (Exception e) {
		} finally {
			DBConn.setDBClose(conn, pstmt);
		}
	}

	// 회원 수정(성별) => primary 키를 받아 비교.
	public void setUpdateSex(int C_ClientNum, String C_Sex) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = DBConn.getConn();
			List<ClientDTO> list = new ArrayList<ClientDTO>();
			list = getAllInfo();
			String sql = "UPDATE HEALTHMS SET C_SEX =? WHERE C_CLIENTNUM =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, C_Sex);
			pstmt.setInt(2, C_ClientNum);
			int result = pstmt.executeUpdate();
		} catch (Exception e) {
		} finally {
			DBConn.setDBClose(conn, pstmt);
		}
	}

	// 회원 수정(주소) => primary 키를 받아 비교.
	public void setUpdateAddress(int C_ClientNum, String C_Address) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = DBConn.getConn();
			List<ClientDTO> list = new ArrayList<ClientDTO>();
			list = getAllInfo();
			String sql = "UPDATE HEALTHMS SET C_ADDRESS =? WHERE C_CLIENTNUM =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, C_Address);
			pstmt.setInt(2, C_ClientNum);
			int result = pstmt.executeUpdate();
		} catch (Exception e) {
		} finally {
			DBConn.setDBClose(conn, pstmt);
		}
	}

	// 회원 수정(키) => primary 키를 받아 비교.
	public void setUpdateHeight(int C_ClientNum, int C_Height) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = DBConn.getConn();
			List<ClientDTO> list = new ArrayList<ClientDTO>();
			list = getAllInfo();
			String sql = "UPDATE HEALTHMS SET C_HEIGHT =? WHERE C_CLIENTNUM =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, C_Height);
			pstmt.setInt(2, C_ClientNum);
			int result = pstmt.executeUpdate();
		} catch (Exception e) {
		} finally {
			DBConn.setDBClose(conn, pstmt);
		}
	}

	// 회원 수정(몸무게) => primary 키를 받아 비교.
	public void setUpdateWeight(int C_ClientNum, int C_Weight) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = DBConn.getConn();
			List<ClientDTO> list = new ArrayList<ClientDTO>();
			list = getAllInfo();
			String sql = "UPDATE HEALTHMS SET C_WEIGHT =? WHERE C_CLIENTNUM =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, C_Weight);
			pstmt.setInt(2, C_ClientNum);
			int result = pstmt.executeUpdate();
		} catch (Exception e) {
		} finally {
			DBConn.setDBClose(conn, pstmt);
		}
	}

	// 회원 수정(PT횟수) => primary 키를 받아 비교.
	public void setUpdateLeftPTCnt(int C_ClientNum, int C_LeftPTCnt) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = DBConn.getConn();
			List<ClientDTO> list = new ArrayList<ClientDTO>();
			list = getAllInfo();
			String sql = "UPDATE HEALTHMS SET C_PT_CNT =? WHERE C_CLIENTNUM =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, C_LeftPTCnt);
			pstmt.setInt(2, C_ClientNum);
			int result = pstmt.executeUpdate();
		} catch (Exception e) {
		} finally {
			DBConn.setDBClose(conn, pstmt);
		}
	}

	// 회원 삭제 //일단은 회원번호을 받아서 삭제하는거로 만들었음 > 이름으로하면 동명이인도 삭제되니까!
	public void setDelete(int a) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = DBConn.getConn();
			String sql = "DELETE HEALTHMS WHERE C_CLIENTNUM=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, a);
			int rows = pstmt.executeUpdate();

			if (rows == 1) {
				System.out.println("성공적으로 삭제 되었습니다");
			}

		} catch (Exception e) {
		} finally {
			DBConn.setDBClose(conn, pstmt);
		}
	}
}
