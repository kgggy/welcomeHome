<%@page import="co.yedam.shop.Item"%>
<%@page import="co.yedam.shop.ShopDAO"%>
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
	String itemNo = request.getParameter("item_no");
	ShopDAO dao = new ShopDAO();
	Item searchItem = dao.getItemNo(itemNo);
	out.print("<h1>" + searchItem.getItemNo() + "</h1>");
	out.print("<h1>" + searchItem.getItemName() + "</h1>");
	out.print("<img width='200px' src='../image/" + searchItem.getImage() + "'>");
	%>

</body>
</html>