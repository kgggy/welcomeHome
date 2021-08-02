package co.yedam.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	protected Connection conn;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;

	public void connect() {
		try {
			// 1.드라이버로딩
			Class.forName("org.sqlite.JDBC");
			// 2.DB연결
			String url = "D:\\sqlite\\db\\chinook.db";
			conn = DriverManager.getConnection("jdbc:sqlite:" + url);
			System.out.println("connected!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		if (conn != null)
			try {
				// 연결 종료.
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
