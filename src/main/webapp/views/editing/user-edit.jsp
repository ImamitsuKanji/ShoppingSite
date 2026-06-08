<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/tool/header.jsp">
	<jsp:param value="会員情報編集" name="title" />
</jsp:include>

</head>
<body>

<p>会員情報編集</p>

<p>${errMessage}</p>

<form
	action="${pageContext.request.contextPath}/UserEditConfirm.action"
	method="post">

	<p>
		ユーザーID:
		<input type="text"
			name="userId"
			value="${user.id}"
			readonly>
	</p>

	<p>
		パスワード:
		<input type="password"
			name="password"
			value="${user.password}"
			required>
	</p>

	<p>
		名前(姓):
		<input type="text"
			name="lastName"
			value="${user.lastName}"
			required>
	</p>

	<p>
		名前(名):
		<input type="text"
			name="firstName"
			value="${user.firstName}"
			required>
	</p>

	<p>
		住所:
		<input type="text"
			name="address"
			value="${user.address}"
			required>
	</p>

	<p>
		メールアドレス:
		<input type="text"
			name="mailaddress"
			value="${user.mailAddress}"
			required>
	</p>

	<input type="submit" value="確認">

</form>

<a href="${pageContext.request.contextPath}/views/login/user-menu.jsp">
	メニュー画面へ戻る
</a>

<%@ include file="/tool/footer.html"%>
