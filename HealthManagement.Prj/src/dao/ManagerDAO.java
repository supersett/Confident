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
	MainLogin ml = new MainLogin(); // �α��� �޼ҵ�� ����ϱ� ���� ��ü ����
	// ManagerDAO dao = new ManagerDAO(); // Ȱ���ϱ� ���� �޼ҵ� ���� ������ �� ���� Ŭ������
	// ====================================================================================
	// ù°: �Էµ� ���� DB �����Ͽ� ó���ϴ� �޼ҵ�� JDBC

	// 1. ������ ��ü ��ȸ SELECTALL
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
				// �̰ŵ� ���ļ� �˾ƾ��� �÷���
				md.setM_Id(rs.getString("MNGID"));
				md.setM_Pwd(rs.getString("MNGPWD"));
				md.setM_Name(rs.getString("MNGNAME"));
				md.setM_PhoneNum(rs.getString("MNGPHONE"));
				md.setM_Position(rs.getString("MNGPOSITION"));

				list.add(md);
			}
			

		} catch (SQLException e) {
			System.out.println("���� �߻�: " + e.toString());
			e.printStackTrace();
		} finally {
			DBConn.setDBClose(conn, pstmt, rs);
		}
		return list;
	}

	// 2. ������ �̸����� ���� ��ȸ
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

				// �̰ŵ� ���ļ� �˾ƾ��� �÷���
				md.setM_Id(rs.getString("MNGID"));
				md.setM_Pwd(rs.getString("MNGPWD"));
				md.setM_Name(rs.getString("MNGNAME"));
				md.setM_PhoneNum(rs.getString("MNGPHONE"));
				md.setM_Position(rs.getString("MNGPOSITION"));

				list.add(md);
			}

		} catch (Exception e) {	
			System.out.println("���� �߻� : " + e.toString());
			e.printStackTrace();
		} finally {
			DBConn.setDBClose(conn, pstmt, rs);
		}
		return list;
	}

	// 3. �� �ֱ� INSERT
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

			pstmt.setString(1, md.getM_Id()); // �� ������� �� ��������
			pstmt.setString(2, md.getM_Pwd());
			pstmt.setString(3, md.getM_Name());
			pstmt.setString(4, md.getM_PhoneNum());
			pstmt.setString(5, md.getM_Position());

			result = pstmt.executeUpdate(); // ������ �� �ֱ� ������ ���� �޼ҵ�

		} catch (SQLException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			DBConn.setDBClose(conn, pstmt, rs);
		}

		return result;
	}

	// 4. �� ������Ʈ update
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

			result = pstmt.executeUpdate(); // ������ �� �ֱ� ������ ���� �޼ҵ�

		} catch (SQLException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			DBConn.setDBClose(conn, pstmt, rs);
		}
		return result;
	}

	// 5. �� ���� delete
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

			pstmt.setString(1, name); // ������ ������ �̸����� ����

			result = pstmt.executeUpdate(); // ������ �� �ֱ� ������ ���� �޼ҵ�

		} catch (SQLException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			DBConn.setDBClose(conn, pstmt, rs);
			}
		return result;

	}

	// 6. ��й�ȣ�� ������Ʈ update
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

			result = pstmt.executeUpdate(); // ������ �� �ֱ� ������ ���� �޼ҵ�

		} catch (SQLException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			DBConn.setDBClose(conn, pstmt);
		}
		return result;
	}

	// 7. ���̺� ���ڵ� �������� �Լ�
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
	// ��°: ����ڷκ��� ���� �Է� �޴� �޼ҵ��
	// ���� ��ü
	MyException2 ex = new MyException2();

	// [��ü ������ ��ȸ��] �޼ҵ�
	public void searchAll() {
		ArrayList<ManagerDTO> list = getManagers();

		Iterator<ManagerDTO> it = list.iterator();

		int i = 1;
		while (it.hasNext()) { // ������ ����ų �� ������ true
			ManagerDTO vo = it.next(); // ������ ������ �� ������ ��������
			System.out.println("[ ������ (" + i + ")]");
			System.out.println(vo.toString());
			i++;
		}
	}

	// [���� ������ ��ȸ��] �޼ҵ�
	public void searchOne() {

		System.out.print(" ��ȸ�� ������ �̸� �Է�: ");
		ArrayList<ManagerDTO> list = getManager(scan.next());

		Iterator<ManagerDTO> it = list.iterator();

		if (!it.hasNext()) {
			System.out.println(" [ �˻��Ͻ� �����ڰ� �������� �ʽ��ϴ�.. ] ");
		}

		while (it.hasNext()) { // ������ ����ų �� ������ true
			ManagerDTO vo = it.next(); // ������ ������ �� ������ ��������
			System.out.println(vo.toString());

		}
	}

	// ����� �Է� �޴� [������ ȸ�����Կ�]�޼ҵ�
	public void insert() {
		boolean mngId = true;
		boolean mngPwd = true;
		boolean mngName = true;
		boolean mngPhone = true;
		boolean mngPosition = true;

		System.out.println("=========================================");
		System.out.println(" [ ������ ȸ�� ���� ] ");
		System.out.println("=========================================");

		try {
			ManagerDTO dto = new ManagerDTO();

			do {

				System.out.print("������ ���̵� �Է�: ");
				dto.setM_Id(scan.next().trim());
				ex.idCheck(dto.getM_Id()); // ����ó�� �Ұ��� ���߿�

				mngId = false;

			} while (mngId); // true �϶����� ��� �ݺ� ���ԽĿ� Ʋ�� �����϶� ��� �ݺ���

			do {

				System.out.print("������ ��й�ȣ �Է�: ");
				dto.setM_Pwd(scan.next().trim());

				mngPwd = false;

			} while (mngPwd);

			do {

				System.out.print("������ �̸� �Է�: ");
				dto.setM_Name(scan.next().trim());
				ex.nameCheck(dto.getM_Name()); // ����ó�� �Ұ���

				mngName = false;

			} while (mngName);

			do {
				System.out.print("������ ��ȭ��ȣ �Է�: ");
				dto.setM_PhoneNum(scan.next().trim());
				ex.phoneCheck(dto.getM_PhoneNum());

				mngPhone = false;

			} while (mngPhone);

			do {
				System.out.print("������ ���� �Է�: ");
				dto.setM_Position(scan.next().trim());
				ex.nameCheck(dto.getM_Position());

				mngPosition = false;

			} while (mngPosition);

			int result = insertData(dto); // ��� ���� �� �� �־��ְ�

			if (result != 0) { // �����Ͱ� ���� ��� ȸ������ �������� ����
				System.out.println();
				System.out.println(" [ ������ ȸ�� ������ �Ϸ� �Ǿ����ϴ�. ] ");
				System.out.println("=====================================");
				System.out.println(" [ ��� ���� ] [���̵�, ��й�ȣ�� ���� �� ��µ��� �ʽ��ϴ�.] ");
				System.out.println(dto.toString());
			} else
				System.out.println("[ ����. �ٽ� �õ����ּ���. ]");
		} catch (Exception e) {
			System.out.println(" ���� �߻�: " + e.toString());
		}
	}

	// ����� �Է� �޴� [������ ���� ������]�޼ҵ�
	public void update() {

		try {
			ManagerDTO vo = new ManagerDTO();

			System.out.print("������ �������� �̸� �Է�: ");
			vo.setM_Name(scan.nextLine());
			ex.nameCheck(vo.getM_Name());

			System.out.print("������ ���̵� ���� : "); // ���
			vo.setM_Id(scan.nextLine().trim());
			ex.idCheck(vo.getM_Id());

			System.out.print("������ ��й�ȣ ���� : "); // ���
			vo.setM_Pwd(scan.nextLine().trim());

			System.out.print("������ �޴�����ȣ ���� : ");
			vo.setM_PhoneNum(scan.nextLine().trim());
			ex.phoneCheck(vo.getM_PhoneNum());

			System.out.print("������ ���� ���� : ");
			vo.setM_Position(scan.nextLine().trim());
			ex.nameCheck(vo.getM_Position());

			int result = updateData(vo); // ��� ������ ����Ÿ �� �ֱ�

			if (result != 0)
				System.out.println(" [ ������ ���� ���� �Ϸ� ] ");
			else
				System.out.println(" [ ������ ���� ���� ����. ��õ� ���]");
		} catch (Exception e) {
			System.out.println(" ���� �߻�: " + e.toString());
		}

	}

	// ����� �Է� �޴� [������ ���� ������]�޼ҵ�
	public void delete() {
		try {

			String mngName;

			System.out.print("������ �̸� �Է�: ");
			mngName = scan.nextLine();
			ex.nameCheck(mngName);

			int result = deleteData(mngName);

			if (result != 0)
				System.out.println(" [ ������ ���� �Ϸ� ] ");
			else
				System.out.println(" [ ������ Ż�� ����. ��õ� ���]");
		} catch (Exception e) {
			System.out.println(" ���� �߻�: " + e.toString());
		}
	}

	// ��й�ȣ ���� �޼ҵ�
	public void updatePwd(String id) {

		while (true) {
			try {
				ManagerDTO vo = new ManagerDTO();

				vo.setM_Id(id); // ���̵� �Է� ���� �� �ֱ�

				System.out.print("��й�ȣ ���� : ");
				vo.setM_Pwd(scan.nextLine().trim());
				if (vo.getM_Pwd().length() != 0) {
					int result = updateOnlyPwd(vo); // ��� ������ ����Ÿ �� �ֱ�

					if (result != 0) {
						System.out.println(" [ ��й�ȣ ���� �Ϸ� ] ");
						break;
					} else
						System.out.println(" [ ��й�ȣ ���� ����. ��õ� ���]");
				} else {
					System.out.println("���� ���ڸ� �Է����� ������.");
				}

			} catch (Exception e) {
				System.out.println(" ���� �߻�: " + e.toString());
			}

		}
	}
}