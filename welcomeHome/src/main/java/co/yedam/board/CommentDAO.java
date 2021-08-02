package co.yedam.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommentDAO extends DAO {
	private static CommentDAO instance; //commentDAO class를 담아놓기 위한 static 타입의 instance 필드 선언.
	private CommentDAO() {
		
	}
	public static CommentDAO getInstance() { //싱글톤방식
		instance = new CommentDAO();
		return instance;
	}
	
	//글목록 가져오기
	public List<HashMap<String, Object>> selectAll() { //HashMap => key, value 형식으로 가져옴.
		connect();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		try {
			pstmt = conn.prepareStatement("select * from comments");
			rs = pstmt.executeQuery();
			while(rs.next()) {
//				System.out.println(rs.getString("id") + ", " + rs.getString("name"));
//				System.out.println("=================================");
				HashMap<String, Object> map = new HashMap<>();
				map.put("id", rs.getString("id"));
				map.put("name", rs.getString("name"));
				map.put("content", rs.getString("content"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}
