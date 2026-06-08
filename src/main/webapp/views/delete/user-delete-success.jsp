<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/tool/header.jsp">
	<jsp:param value="削除完了" name="title"/>
</jsp:include>

</head>
<body>

<p>削除しました</p>
<meta http-equiv="refresh" content="3;URL=
	<%= request.getContextPath() %>/views/login/login-in.jsp">

<%@ include file="/tool/footer.html"%>