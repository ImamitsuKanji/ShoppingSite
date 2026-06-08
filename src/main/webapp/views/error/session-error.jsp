<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/tool/header.jsp">
	<jsp:param value="エラー" name="title" />
</jsp:include>

</head>
<body>

	<div class="error">
		<h1 style="color: red;" class="errortext">${errMessage}</h1>
		<input type="button" value="メニュー画面へ戻る"
			onclick="location.href=
				'${pageContext.request.contextPath}/views/login/user-menu.jsp'">
	</div>

<style>
	<%@include file="/views/css/error.css"%>
</style>

<%@ include file="/tool/footer.html"%>