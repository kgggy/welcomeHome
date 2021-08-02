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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/xml;charset=utf-8"); //xml data로 만듦.(key, value 형식)
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		String cmd = request.getParameter("cmd");
		
		if(cmd == null) { 
			StringBuffer sb = new StringBuffer();
			sb.append("<result>");
			sb.append("<code>error</code>"); //cmd값이 없는 경우 error 노출.
			sb.append("<data>");
			sb.append("cmd null");
			sb.append("</data>");
			sb.append("</result>");
			out.print(sb.toString());
					
		}else if(cmd.equals("selectAll")) {
			List<HashMap<String, Object>> list = CommentDAO.getInstance().selectAll();
			StringBuffer sb = new StringBuffer();
			sb.append("<result>");
			sb.append("<code>success</code>");
			for(HashMap<String, Object> map : list) {
				sb.append("<data>");
				sb.append("   <id>" + map.get("id") + "</id>");
				sb.append("   <name>" + map.get("name") + "</name>");
				sb.append("   <content>" + map.get("content") + "</content>");
				sb.append("</data>");
			}
			sb.append("</result>");
			out.print(sb.toString());
		}else if(cmd.equals("insert")) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
