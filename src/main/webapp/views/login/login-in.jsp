<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:if test="${not empty sessionScope.user}">
	<c:redirect url="user-menu.jsp" />
</c:if>

<jsp:include page="/tool/header.jsp">
	<jsp:param name="title" value="ログイン" />
</jsp:include>

<style><%@include	file="/views/css/login.css"%></style>

</head>
<body>

	<div class="container">

		<div class="left">

			<h1>SHOP STYLE</h1>

			<p>ショッピングを もっと楽しく</p>

		</div>

		<div class="right">

			<div class="login-box">

				<h2>ログイン</h2>

				<form action="${pageContext.request.contextPath}/Login.action"
					method="post">
					<p>
						ID：<input type="text" name="id" placeholder="ユーザーID入力" required>
					</p>
					<p>
						パスワード：<input type="password" name="password" placeholder="パスワード入力"
							required>
					</p>
					<button type="submit">ログイン</button>
				</form>

				<button type="button"
					onclick="location.href=
						'${pageContext.request.contextPath}/views/signup/user-add.jsp'">
					新規会員登録</button>
			</div>
		</div>
	</div>

	<%@ include file="/tool/footer.html"%>