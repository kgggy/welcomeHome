package co.yedam.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

@WebServlet("/GetAmtByCountryServ")
public class GetAmtByCountryServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetAmtByCountryServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, Integer> map = CommentDAO.getInstance().getAmtByCountry();
		Gson gson = new GsonBuilder().create();
		
		JsonArray aryOut = new JsonArray(); //바깥의 배열.
		Set<String> set = map.keySet(); //set변수에 key부분(나라이름)만 담아옴.
		Iterator<String> iter = set.iterator(); //iterator => 반복자.
		while(iter.hasNext()) {
			JsonArray aryIn = new JsonArray(); //내부의 배열.
			
			String key = iter.next(); //key를 하나씩 가져옴.
			Integer val = map.get(key); 
			
			aryIn.add(key);
			aryIn.add(val);
			
			aryOut.add(aryIn); //배열안에 배열넣기.
		}
		//[[k,y], [k,y]], [k,y]], [k,y]]
		response.getWriter().print(gson.toJson(aryOut)); //json형식으로 화면에 그려줌.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
