<%@page import="model.Mutter"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
User user = (User) session.getAttribute("user");
List<Mutter> mutterList = (List<Mutter>) request.getAttribute("mutterList");
String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
	<h1>どこつぶメイン</h1>
	<p><%=user.getName()%>さん、ログイン中</p>
	<a href="Logout">ログアウト</a>
	<p><a href="Main">更新</a></p>

	<form action="Main" method="post">
		<input type="text" name="text">
		<input type="submit" value="つぶやく">
	</form>
	<% if (error != null) { %>
		<p><%=error.toString() %></p>
	<% } %>
	<% if (mutterList != null) { %>
		<% for (Mutter m : mutterList) { %>
			<p><%=m.getUserName() %> ： <%=m.getText() %></p>
		<% } %>
	<% } %>
</body>
</html>

