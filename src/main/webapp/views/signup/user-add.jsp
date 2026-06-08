<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/tool/header.jsp">
	<jsp:param value="新規登録" name="title" />
</jsp:include>

</head>
<body>

<p>新規会員登録</p>

<p style="color: red;">${errMessage}</p>

<form action="${pageContext.request.contextPath}/UserAddConfirm.action"
	method="post">

	<p>
		ユーザーID: <input type="text" name="userId" required>
		<p style="color: red;">${halfWidthErrMessage}</p>
	</p>

	<p>
		パスワード: <input type="password" name="password" required>
		<p style="color: red;">${halfWidthErrMessage}</p>
	</p>

	<p>
		名前(姓): <input type="text" name="firstName" required>
	</p>

	<p>
		名前(名): <input type="text" name="lastName" required>
	</p>

	<p>
		住所: <input type="text" name="address" required>
	</p>

	<p>
		メールアドレス: <input type="email" name="mailaddress" required>
	</p>

	<input type="submit" value="確認">
	
	<input type="button"  value="リセット"
		onclick="location.href=
				'${pageContext.request.contextPath}/views/signup/user-add.jsp'">

</form>
<a href="${pageContext.request.contextPath}/views/login/login-in.jsp">

	ログイン画面へ戻る </a>
	


<%@ include file="/tool/footer.html"%>
