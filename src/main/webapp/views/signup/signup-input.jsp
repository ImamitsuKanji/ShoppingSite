<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/tool/header.jsp">
	<jsp:param value="新規登録" name="title" />
</jsp:include>

<form action="
${pageContext.request.contextPath}/Signup.action" method="get">
	
	<p>ID:<input type="text" name="id" required></p>
	<p>パスワード:<input type="text" name="password" required></p>
	<p>メールアドレス:<input type="text" name="mail" required></p>
	<p>名前:<input type="text" name="lastname" required></p>
	
	<input type="submit" value="登録">
	<input type="button" value="戻る" onclick="location.href=
					'${pageContext.request.contextPath}/views/login/login-in.jsp'">
	
</form>

<%@ include file="/tool/footer.html"%>