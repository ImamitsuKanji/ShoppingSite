package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.UserDAO;
import jp.co.aforce.tool.Action;
import jp.co.aforce.tool.LoginManager;

public class UserEditAction extends Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 更新用セッション取得
		HttpSession session = request.getSession(false);

		// セッション切れ
		if (session == null) {
			return "error/session-error.jsp";
		}

		UserBean user = (UserBean) session.getAttribute(
				"updateUserBean");

		if (user == null) {
			return "error/session-error.jsp";
		}

		UserDAO dao = new UserDAO();
		// 更新処理
		boolean result = dao.updateUser(user);

		// 更新失敗
		if (!result) {

			session.setAttribute(
					"user",
					user);
			;

			if (session != null) {
				session.invalidate();
			}

			LoginManager.logout(user.getId());

			return "error/login-error.jsp";
		}

		// ログインユーザー情報更新
		session.setAttribute(
				"user",
				user);

		// 更新用セッション削除
		session.removeAttribute(
				"updateUserBean");

		// 完了画面
		return "editing/user-edit-success.jsp";
	}
}