package bank_casher;

import java.sql.*;
import java.util.Scanner;

public class sqlTest {
	Scanner a = new Scanner(System.in);

	String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	String jdbcUrl = "jdbc:mysql://localhost/testschema?serverTimezone=UTC&characterEncoding=UTF-8";
	
	Connection conn;

	PreparedStatement pstmt;
	ResultSet rs;

	sqlTest() {
		System.out.println("##이름과 이메일 입력 : ");
		System.out.print("이름 : ");
		String uname = a.next();
		System.out.print("이메일 : ");
		String email = a.next();

		connectDB();
		registUser(uname, email);
		printList();
		closeDB();

	}

	private void closeDB() {
		// TODO Auto-generated method stub
		try {
			pstmt.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void printList() {
		// TODO Auto-generated method stub
		System.out.println("# 등록자 명단");
		String sql = "select * from event";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("uname") + ", " + rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void registUser(String uname, String email) {
		// TODO Auto-generated method stub
		String sql = "insert into event values(?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2, email);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void connectDB() {
		// TODO Auto-generated method stub
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcUrl, "root", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		sqlTest b = new sqlTest();

	}
}