<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/tool/header.jsp">
	<jsp:param value="エラー" name="title" />
</jsp:include>

<div class="error">
	<p style="color: red;" class="errortext">${sessionScope.message}</p>
	<input type="button" value="メニューへ戻る"
		onclick="location.href=
				'${pageContext.request.contextPath}/views/login/login-menu.jsp'">
</div>

<style><%@include	file="/views/css/error.css"%></style>

<%@ include file="/tool/footer.html"%>