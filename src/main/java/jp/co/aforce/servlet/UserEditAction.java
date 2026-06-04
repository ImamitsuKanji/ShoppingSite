package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.UserDAO;
import jp.co.aforce.tool.Action;

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

		// 更新用userBean取得
		UserBean updateUserBean = (UserBean) session.getAttribute("updateUserBean");

		// 更新処理
		boolean result = UserDAO.updateUser(updateUserBean);

		// 更新失敗
		if (!result) {

			request.setAttribute(
					"errMessage",
					"更新エラー");

			return "error/login-error.jsp";
		}

		// userBeanセッション更新
		session.setAttribute(
				"userBean",
				updateUserBean);

		// 更新用セッション削除
		session.removeAttribute(
				"updateUserBean");

		// 完了画面
		return "signup/user-edit-success.jsp";
	}
}
