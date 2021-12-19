package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {
	

	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1522:orcl";
			String user = "BITUSER";
			String pwd = "1004";
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			System.out.println("Connection 인스턴스를 생성할수 없습니다");
		}
		return conn;
	}

	public static void setDBClose(Connection conn) {
		try {
			if (conn != null)
				conn.close();

		} catch (SQLException e) {

		}
	}

	public static void setDBClose(Connection conn, PreparedStatement pstmt) {
		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();

		} catch (SQLException e) {

		}
	}

	public static void setDBClose(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();

		} catch (SQLException e) {

		}
	}

	

}
