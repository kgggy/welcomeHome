package co.yedam;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAO extends DAO{
	
	public List<UserVO> getUsers() {
		connect();
		List<UserVO> userList = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement("select * from users");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserVO vo = new UserVO();
				vo.setUserBirth(rs.getString("user_birth")); //"DB의 칼럼이름"
				vo.setUserId(rs.getString("user_id"));
				vo.setUserGen(rs.getString("user_gen"));
				vo.setUserHobby(rs.getString("user_hobby"));
				vo.setUserName(rs.getString("user_name"));
				vo.setUserPw(rs.getString("user_pw"));
				userList.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public void insertUser(UserVO vo) {
		//사용자입력값을 => 오라클 디비에 입력처리.
		connect();
		String sql = "insert into users(user_id, user_pw, user_name, user_gen, user_hobby, user_birth) values(?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getUserPw());
			pstmt.setString(3, vo.getUserName());
			pstmt.setString(4, vo.getUserGen());
			pstmt.setString(5, vo.getUserHobby());
			pstmt.setString(6, vo.getUserBirth());
			int r = pstmt.executeUpdate(); //쿼리를 실행.
			System.out.println(r + "건 입력.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
