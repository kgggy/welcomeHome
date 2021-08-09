package co.yedam.shop;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/GetItemListServ") //서블릿 호출시 db데이터를 가져와 json모양으로 바꿔줌.
public class GetItemListServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetItemListServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		ShopDAO dao = new ShopDAO();
		List<Item> list = dao.getItemList();
		Gson gson = new GsonBuilder().create();
		
		response.getWriter().println(gson.toJson(list));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
