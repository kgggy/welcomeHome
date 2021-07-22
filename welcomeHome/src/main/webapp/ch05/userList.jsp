<%@page import="co.yedam.UserVO"%>
<%@page import="java.util.List"%>
<%@page import="co.yedam.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	UserDAO dao = new UserDAO(); //import => ctrl+space
	List<UserVO> list = dao.getUsers();
	//out.println 안에 태그 써야함.
	//id, name, birth
	out.println("<table border='1'>");
	for(UserVO vo : list) {
		out.println("<tr><td>" + vo.getUserId() + 
				"</td><td>" +  vo.getUserName() + 
				"</td><td><input type='date' value='" + vo.getUserBirth() + "'>" + 
				"</td></tr>");  //출력시 out 객체 이용.
	}
	out.println("</table>");
	%>
</body>
</html>