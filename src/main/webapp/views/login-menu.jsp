<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報登録ホーム</title>
</head>
<body>

<jsp:include page="/views/logout-check.jsp"/>


	<input type="submit" value="修正">

	<input type="submit" value="削除">

	<form action="logout-in.jsp" method="post">
		<input type="submit" value="ログアウト">
	</form>

</body>
</html>