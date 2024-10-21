<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
User user = (User) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
	<%
	if (user == null) {
	%>
	<p>ログイン失敗しました。</p>
	<a href="index.jsp">TOPへ</a>
	<%
	} else {
	%>
	<p>ログイン成功しました。</p>
	<p>ようこそ<%=user.getName()%>さん </p>
	<a href="Main">つぶやき投稿・閲覧へ</a>
	<%
	}
	%>
</body>
</html>