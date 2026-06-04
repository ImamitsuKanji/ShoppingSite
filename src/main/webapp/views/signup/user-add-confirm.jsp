<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/tool/header.jsp">
	<jsp:param value="新規登録" name="title" />
</jsp:include>
<P>登録する内容はよろしかったですか？</P>

<form action="
${pageContext.request.contextPath}/UserAddConfirm.action" method="get">
	
	<p>ユーザーID:<input type="text" name="userID" required></p>
	<p>パスワード：<input type="text" name="password" required></p>
	<p>名前(姓):<input type="text" name="firstName" required></p>
	<p>名前(名):<input type="text" name="lastName" required></p>
	<p>住所:<input type="text" name="address" required></p>
	<p>メールアドレス:<input type="text" name="mailaddress" required></p>
	
	<input type="submit" value="登録">
</form>

<a href="${pageContext.request.contextPath}/views/sigmup/user-add.jsp">戻る</a>

<%@ include file="/tool/footer.html"%>