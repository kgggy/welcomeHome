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
	UserDAO dao = new UserDAO();
	List<UserVO> list = dao.getUsers();

	String tag = "";
	tag += "<table border='1'>"; // += => 원래값에 누적
	for (UserVO vo : list) {
		tag += "<tr><td>" + vo.getUserName() + "</td><td>" 
				+ vo.getUserHobby() + "</td><td>" 
				+ vo.getUserBirth() + "</td></tr>";
	}
	tag += "</table>";
	out.println(tag);
	%>
</body>
</html>