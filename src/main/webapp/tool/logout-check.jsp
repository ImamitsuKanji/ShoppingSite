<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="jp.co.aforce.beans.User"%>

<%
UserBean userBean = (UserBean) session.getAttribute("userBean");

if (userBean != null) {
%>
<p>ようこそ、${userBean.lastName}さん！</p>
<%
} else {
%>
<p>ログインされていません。</p>
<%
}
%>