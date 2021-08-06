package co.yedam.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScheduleDao extends DAO {
	private static ScheduleDao instance;

	private ScheduleDao() {

	}

	public static ScheduleDao getInstance() {
		instance = new ScheduleDao();
		return instance;
	}

	// 1.조회기능, 2.입력기능, 3.삭제기능.
	// 1.조회기능
	public List<HashMap<String, Object>> selectAll() {
		connect();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		try {
			pstmt = conn.prepareStatement("select * from schedule");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("title", rs.getString("title"));
				map.put("start", rs.getString("start"));
				map.put("end", rs.getString("end"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 2.입력기능
	public HashMap<String, Object> insert(Schedule schedule) {
		connect();
		String sql = "insert into schedule values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schedule.getTitle());
			pstmt.setString(2, schedule.getStart());
			pstmt.setString(3, schedule.getEnd());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다.");

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", schedule.getTitle());
			map.put("start", schedule.getStart());
			map.put("end", schedule.getEnd());

			return map;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 3.삭제기능
	public HashMap<String, Object> delete(String title) {
		connect();
		String sql = "delete from schedule where title = ?";
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 삭제되었습니다.");

			map.put("title", title); // 정상실행되면 id값 넘겨줌.
			return map;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
}
