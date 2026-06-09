<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<jsp:include page="/tool/header.jsp">
	<jsp:param value="ログイン" name="title" />
</jsp:include>

<style>
	<%@include	file="/views/modal/style.css"%>
</style>

</head>
<body>

<jsp:include page="/views/modal/logoutModal.jsp" />

	<c:choose>

		<c:when test="${not empty sessionScope.user}">

			<p>ようこそ、 ${user.lastName}さん！</p>

			<!-- 修正 -->
			<form
				action="${pageContext.request.contextPath}/views/editing/user-edit.jsp"
				method="post">

				<input type="submit" value="修正">
			</form>

			<!-- 削除 -->
			<form
				action="${pageContext.request.contextPath}/views/delete/user-delete-confirm.jsp"
				method="post">

				<input type="hidden" name="id" value="${user.id}"> <input
					type="submit" value="削除">
			</form>

			<!-- ログアウト -->

			<button type="button" id="openBtn">
			<script src="${pageContext.request.contextPath}/views/modal/script.js">
			</script>
			ログアウト
			</button>

		</c:when>

		<c:otherwise>
			<h1>ログインしてください。</h1>
			<form action="${pageContext.request.contextPath}/views/login/login-in.jsp">
				<button type="submit">ログイン画面へ</button>
			</form>
		</c:otherwise>

	</c:choose>

	<%@ include file="/tool/footer.html"%>