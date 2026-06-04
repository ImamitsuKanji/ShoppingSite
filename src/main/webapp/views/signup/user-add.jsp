<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/tool/header.jsp">
	<jsp:param value="新規登録" name="title" />
</jsp:include>
<P>新規会員登録</P>

${errormessage}

<form action="
${pageContext.request.contextPath}/UserAdd.action" method="get">
	
	<p>ユーザーID:<input type="text" name="userId" required></p>
	<p>パスワード:<input type="text" name="password" required></p>
	<p>名前(姓):<input type="text" name="firstName" required></p>
	<p>名前(名):<input type="text" name="lastName" required></p>
	<p>住所:<input type="text" name="address" required></p>
	<p>メールアドレス:<input type="text" name="mailaddress" required></p>
	
	<input type="submit" value="確認">
</form>

<a href="${pageContext.request.contextPath}/views/login/login-in.jsp">ログイン画面へ戻る</a>

<%@ include file="/tool/footer.html"%>