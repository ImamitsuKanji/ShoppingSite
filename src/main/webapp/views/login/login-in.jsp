<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--<c:if test="${not empty user}">-->
<!--    <c:redirect url="login-menu.jsp" />-->
<!--</c:if>-->


<jsp:include page="/tool/header.jsp">
	<jsp:param name="title" value="ログイン"/>
</jsp:include>

	<div class="contents">
		<form action="
		${pageContext.request.contextPath}/Login.action" method="post">
			<p>
					  ID：<input type="text" name="id" class="login-contents" required>
			</p>
			<p>
				パスワード：<input type="password" name="password" required>
			</p>
			<input type="submit" value="ログイン" class="btn">
		</form>

		<form action="
		${pageContext.request.contextPath}/views/signup/user-add.jsp" method="post">
			<input type="submit" value="新規会員登録" class="btn">
		</form>
	</div>

<style><%@include file="/views/css/login.css" %></style>

<%@ include file="/tool/footer.html"%>