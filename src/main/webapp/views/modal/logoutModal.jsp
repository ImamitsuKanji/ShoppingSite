<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="modal" class="modal" role="dialog">

	<div class="modal-content">

		<button type="button" id="closeBtn" class="close-btn">
			&times;
		</button>
		<p>ログアウトしますか？</p>

		<form action="${pageContext.request.contextPath}
						/views/logout/logout-in.jsp"method="post">

			<input type="submit" value="ログアウト" class="logout-btn">

		</form>

	</div>

</div>