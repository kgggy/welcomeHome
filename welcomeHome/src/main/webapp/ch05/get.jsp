<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- parameter을 읽어옴. -->
<!-- 자바소스는 <% %> 안에 쓰기! -->
<!-- parameter을 읽어옴. -->
	<%
	String uid = request.getParameter("user_id");
	String upw = request.getParameter("user_pw");
	String unm = request.getParameter("user_name");
	%>
	<h3>ID: <%=uid %></h3>
	<h3>PW: <%=upw %></h3>
	<h3>NAME: <%=unm %></h3>
</body>
</html>