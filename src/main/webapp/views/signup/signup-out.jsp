<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/tool/header.jsp">
	<jsp:param value="登録完了" name="title"/>
</jsp:include>

<%-- <p>登録完了しました</p>
<form action="${pageContext.request.contextPath}/Login.action" method="post">
	<input type="submit" value="メニュー">
</form> --%>

<form action="${pageContext.request.contextPath}/views/login/login-in.jsp" method="post">
	<input type="submit" value="ログイン">
</form>

<%@ include file="/tool/footer.html"%>