package co.yedam.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CommentSevlet")
public class CommentSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommentSevlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/xml;charset=utf-8"); // xml data로 만듦.(key, value 형식)
		response.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		String cmd = request.getParameter("cmd");

		if (cmd == null) {
			out.println(errorXML("cmd null")); //cmd값이 없으면 에러.

		} else if (cmd.equals("selectAll")) { //1)전체조회
			try {
				List<HashMap<String, Object>> list = CommentDAO.getInstance().selectAll();
				StringBuffer sb = new StringBuffer();
				sb.append("<result>");
				sb.append("<code>success</code>");
				sb.append("<data>");
				for (HashMap<String, Object> map : list) {
					sb.append("<row>"); // 한건씩 구분해서 가져오기위해.
					sb.append("   <id>" + map.get("id") + "</id>");
					sb.append("   <name>" + map.get("name") + "</name>");
					sb.append("   <content>" + map.get("content") + "</content>");
					sb.append("</row>");
				}
				sb.append("</data>");
				sb.append("</result>");
				out.print(sb.toString());
			} catch (Exception e) {
				out.println(errorXML(e.getMessage()));
			}
		} else if (cmd.equals("insert")) { // 2)한건입력.(사용자가 입력한 parameter값 읽어와서 comment에 담아줌.
			try {
				String name = request.getParameter("name");
				String content = request.getParameter("content");
				Comment comment = new Comment();
				comment.setName(name);
				comment.setContent(content);
				HashMap<String, Object> map = CommentDAO.getInstance().insert(comment); // insert리턴타입 => HashMap.
				
				out.println(dataXML(map));
				
			} catch (Exception e) {
				out.println(errorXML(e.getMessage()));
			}
		} else if(cmd.equals("update")) { //3)수정.
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String content = request.getParameter("content");
			
			Comment comment = new Comment();
			comment.setId(id);
			comment.setName(name);
			comment.setContent(content);
			
			HashMap<String, Object> map = CommentDAO.getInstance().update(comment);
			out.println(dataXML(map));
		}
	} // end of doGet();
	
	private String dataXML(HashMap<String, Object> map) { //결과값을 다시 받아옴.
		StringBuffer sb = new StringBuffer();
		sb.append("<result>");
		sb.append("<code>success</code>");
		sb.append("<data>");
		sb.append("   <id>" + map.get("id") + "</id>");
		sb.append("   <name>" + map.get("name") + "</name>");
		sb.append("   <content>" + map.get("content") + "</content>");
		sb.append("</data>");
		sb.append("</result>");
		return sb.toString();
	}
	
	private String errorXML(String msg) { //에러발생시.
		StringBuffer sb = new StringBuffer();
		sb.append("<result>");
		sb.append("<code>error</code>");
		sb.append("<data>" + msg + "</data>");
		sb.append("</result>");
		
		return sb.toString();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
