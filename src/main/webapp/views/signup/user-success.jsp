<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/tool/header.jsp">
	<jsp:param value="登録完了" name="title"/>
</jsp:include>

<p>新規登録完了</p>
a href="${pageContext.request.contextPath}/views/login/login-in.jsp">ログイン画面へ戻る</a>

<%@ include file="/tool/footer.html"%>