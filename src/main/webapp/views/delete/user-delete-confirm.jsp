<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:include page="/tool/header.jsp">
	<jsp:param value="削除確認" name="title"/>
</jsp:include>

</head>
<body>

<!--削除ボタン-->
<p>削除してもよろしいすか？</p>

<p>${user.firstName}${user.lastName}さん</p>

<form action="${pageContext.request.contextPath}/UserDelete.action" method="post">

	<input type="hidden" name="id" value="${user.id}">
	<input type="submit" value="削除" class="delete">
</form>

<!--戻るボタン-->

<a href=${pageContext.request.contextPath}/views/login/login-menu.jsp"></a>

<!--<input type="button" value="入力画面"-->
<!--		onclick="location.href=-->
<!--				'${pageContext.request.contextPath}/views/delete/delete-input.jsp'">-->

<%@ include file="/tool/footer.html"%>