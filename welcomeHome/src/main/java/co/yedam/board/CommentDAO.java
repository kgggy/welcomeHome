package co.yedam.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommentDAO extends DAO { 
	private static CommentDAO instance; // commentDAO class를 담아놓기 위한 static 타입의 instance 필드 선언.

	private CommentDAO() {

	}

	public static CommentDAO getInstance() { // 싱글톤방식
		instance = new CommentDAO();
		return instance;
	}

	// 글 내용 수정.
	public HashMap<String, Object> update(Comment comment) {
		connect();
		String sql = "update comments set name=?, content=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment.getName());
			pstmt.setString(2, comment.getContent());
			pstmt.setString(3, comment.getId());
			int r = pstmt.executeUpdate();
			System.out.println("수정: " + r);

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", comment.getId());
			map.put("name", comment.getName());
			map.put("content", comment.getContent());
			return map;

		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			disconnect();
		}
		return null;
	}

	// 글 등록하기.
	public HashMap<String, Object> insert(Comment comment) {
		// 1. id_repository 테이블에서 현재 시퀀스번호.
		// 2. comments 테이블에 추가.
		// 3. id_repository 에 새로운 시퀀스번호로 변경.
		int nextId = 0; // 시퀀스값 받아오는 변수.
		connect();
		try {
			// 1.현재 시퀀스번호 가져옴.
			conn.setAutoCommit(false); // 도중에 에러나면 기존값으로.
			stmt = conn.createStatement(); // stmt는 쿼리선언하면서 변수를 직접 값을넣어줘야함(ex. comment.getId()), pstmt => ?를 써서 쿼리만들때 바로
											// 안넣어도됨.
			rs = stmt.executeQuery("select value from id_repository where name='comment'"); // 현재 value 가져오는 쿼리.
			if (rs.next()) { // 한건만 가져옴.
				nextId = rs.getInt("value");
			}
			// 2. 시퀀스에 1 증가시켜서 comment 테이블에 입력.
			nextId++; // 다음순번에 추가.
			pstmt = conn.prepareStatement("insert into comments values(?,?,?)");
			pstmt.setInt(1, nextId);
			pstmt.setString(2, comment.getName());
			pstmt.setString(3, comment.getContent());
			int r = pstmt.executeUpdate(); // 조회:executeQuery, 입력/수정/삭제:executeUpdate => 수정된게 하나면 1을 리턴.
			System.out.println("입력건수: " + r);
			// 3.새로운 시퀀스번호로 변경.
			pstmt = conn.prepareStatement("update id_repository set value=? where name='comment'");
			pstmt.setInt(1, nextId);
			pstmt.executeUpdate();

			conn.commit();
			// 정상적으로 실행시.
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", nextId);
			map.put("name", comment.getName());
			map.put("content", comment.getContent());

			return map;

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback(); // 정상실행 실패시.
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("msg", e.getMessage());
				return map;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			disconnect();
		}

		return null;
	}

	// 글목록 가져오기.
	public List<HashMap<String, Object>> selectAll() { // HashMap => key, value 형식으로 가져옴.
		connect();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		try {
			pstmt = conn.prepareStatement("select * from comments");
			rs = pstmt.executeQuery();
			while (rs.next()) {
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
