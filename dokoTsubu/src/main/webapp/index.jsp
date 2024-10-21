<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--<link rel="stylesheet" href="1.css" type="text/css">-->
<title>どこつぶ</title>
</head>
<body>
	<h1>どこつぶへようこそ</h1>
	<form action="Login" method="post">
		<p>
			<label>ユーザー名：<input type="text" name="name"></label>
		</p>
		<p>
			<label>パスワード：<input type="password" name="pass"></label>
		</p>
		<p><input type="submit" value="ログイン"></p>
	</form>
	<p><a href="Submit">ユーザー登録</a></p>
</body>
</html>