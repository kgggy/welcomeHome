//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

import co.yedam.board.DAO;
//import co.yedam.shop.Item;

public class Exam01DAO extends DAO {
	
//	public List<member> getMemList() {
//		List<member> list = new ArrayList<member>();
//
//		connect();
//		try {
//			pstmt = conn.prepareStatement("select * from member");
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				Item item = new Item();
//				item.setItemNo(rs.getString("item_no")); // "칼럼명"
//				item.setItemName(rs.getString("item_name"));
//				item.setItemDesc(rs.getString("item_desc"));
//				item.setLikeIt(rs.getDouble("like_it"));
//				item.setPrice(rs.getDouble("price"));
//				item.setPriceOff(rs.getDouble("price_off"));
//				item.setImage(rs.getString("image"));
//
//				list.add(item);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			disconnect();
//		}
//		return list;
//	}
}
