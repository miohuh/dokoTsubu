<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String submit = (String)request.getAttribute("submit");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
	<form action="Submit" method="post">
		<p><label>ユーザー名：<input type="text" name="name"></label></p>
		<p><label>パスワード：<input type="password" name="pass"></label></p>
		<input type="submit" value="登録">
		
	</form>
	<% if(submit != null){ %>
	<p><%= submit %></p>
	<% } %>
	<p>
		<a href="index.jsp">戻る</a>
	</p>
</body>
</html>