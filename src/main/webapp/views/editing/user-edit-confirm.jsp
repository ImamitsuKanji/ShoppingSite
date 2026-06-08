<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/tool/header.jsp">
	<jsp:param value="新規登録" name="title" />
</jsp:include>

</head>
<body>

<P>登録する内容はよろしかったですか？</P>

<form action="
${pageContext.request.contextPath}/UserEdit.action"
	method="get">

	<p>
		名前(姓): <input type="text" name="lastName"
			value="${updateUserBean.lastName}" required>
	</p>

	<p>
		名前(名): <input type="text" name="firstName"
			value="${updateUserBean.firstName}" required>
	</p>
	<p>
		住所:<input type="text" name="address" value="${updateUserBean.address}"
			required>
	</p>
	<p>
		メールアドレス:<input type="text" name="mailaddress"
			value="${updateUserBean.mailAddress}" required>
	</p>

	<input type="submit" value="登録">
</form>

<a href="${pageContext.request.contextPath}/views/editing/user-edit.jsp">戻る</a>

<%@ include file="/tool/footer.html"%>>
