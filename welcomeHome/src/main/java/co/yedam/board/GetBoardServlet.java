package co.yedam.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@WebServlet("/GetBoardServlet")
public class GetBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetBoardServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");//한국어 타입.
		
		//{ "data" : [[1번째], [2번째], [3번째]...... [마지막]] }모양으로 만들어줘야함. => {object[outary[inary
		List<HashMap<String, Object>> list = CommentDAO.getInstance().selectAll();
		Gson gson = new GsonBuilder().create(); //gson의 toJson을 쓰기 위해 생성.
		//response.getWriter().print(gson.toJson(list));
		
		JsonArray outAry = new JsonArray();
		for(int i=0; i<list.size(); i++) { //collection 타입일 경우 size()로 총 몇갠지 불러옴.
			HashMap<String, Object> map = list.get(i);
			JsonArray inAry = new JsonArray();
			inAry.add((String)map.get("id")); //가져온 value 타입이 Object타입이므로 String으로 바꿔줌.
			inAry.add((String)map.get("name")); //id에 들어있는 값 가져옴.
			inAry.add((String)map.get("content"));
			
			outAry.add(inAry); // => 현재 outAry 형태[[1번째], [2번째], [3번째]...... [마지막]]
		}
		JsonObject obj = new JsonObject();
		obj.add("data", outAry); // => obj 형태 { "data" : [[1번째], [2번째], [3번째]...... [마지막]] }
		response.getWriter().print(gson.toJson(obj));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
