package co.yedam.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@WebServlet("/ScheduleServlet")
public class ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ScheduleServlet() {
		super();
	}
	
	//[{k:y}, {k,y}, {k,y}, {k,y}]
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8"); // xml data로 만듦.(key, value 형식)
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String cmd = request.getParameter("cmd");
		
		if (cmd == null) {
			out.println("오류");

		}
		else if (cmd.equals("select")) {
			response.setContentType("text/json;charset=utf-8");
			List<HashMap<String, Object>> list = ScheduleDao.getInstance().selectAll();
			Gson gson = new GsonBuilder().create(); //생성자.
			JsonArray aryOut = new JsonArray();
			
			for(int i=0; i<list.size(); i++) { //collection 타입일 경우 size()로 총 몇갠지 불러옴.
				HashMap<String, Object> map = list.get(i);
				JsonObject obj = new JsonObject();
				obj.addProperty("title", (String)map.get("title"));
				obj.addProperty("start", (String)map.get("start"));
				obj.addProperty("end", (String)map.get("end"));
				
				aryOut.add(obj);
				
			}
			response.getWriter().print(gson.toJson(aryOut));
			
		} else if (cmd.equals("insert")) {
			String title = request.getParameter("title");
			String start = request.getParameter("start");
			String end = request.getParameter("end");
			Schedule schedule = new Schedule();
			schedule.setTitle(title);
			schedule.setStart(start);
			schedule.setEnd(end);
			HashMap<String, Object> map = ScheduleDao.getInstance().insert(schedule);
			Gson gson = new GsonBuilder().create();
			out.println(gson.toJson(map));
			
		} else if (cmd.equals("delete")) {
			String id = request.getParameter("title");
			HashMap<String, Object> map = ScheduleDao.getInstance().delete(id);
			Gson gson = new GsonBuilder().create();
			out.println(gson.toJson(map));
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
