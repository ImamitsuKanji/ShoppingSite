<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/tool/header.jsp">
	<jsp:param value="ログアウト" name="title"/>
</jsp:include>

<p>ログアウトしました</p>
<input type="button" value="ログイン画面へ戻る"
		onclick="location.href=
				'${pageContext.request.contextPath}/views/login/login-in.jsp'">

<%@ include file="/tool/footer.html"%>