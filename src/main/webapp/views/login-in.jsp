<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jp.co.aforce.beans.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
User user = (User) session.getAttribute("user");
if (user != null) {
	response.sendRedirect("login-menu.jsp");
	return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>

	<div class="contents">
		<form action="${pageContext.request.contextPath}/Login.action"
			method="post">
			<p>
						ID：<input type="text" name="id" class="login" required>
			</p>
			<p>
				パスワード：<input type="password" name="password" class="login" required>
			</p>
			<input type="submit" value="ログイン">
		</form>

		<input type="submit" value="新規会員登録">
	</div>


</body>
</html>