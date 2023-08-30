<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
	<h1>로그아웃</h1>
	<form action="<c:url value='/member/logout'/>" method="post">
		<input type="text" name="me_id" placeholder="아이디" required> <br>
		<input type="password" name="me_pw" placeholder="비번" required> <br>
		<button>로그아웃</button>
	</form>
</body>
</html>