package co.yedam.board;

public class AppMain {
	public static void main(String[] args) {
//		DAO dao = new DAO();
//		dao.connect();
		CommentDAO dao = CommentDAO.getInstance();
		dao.selectAll();
	}
}
