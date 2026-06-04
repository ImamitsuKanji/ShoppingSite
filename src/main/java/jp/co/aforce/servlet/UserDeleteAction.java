package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.UserDAO;
import jp.co.aforce.tool.Action;

public class UserDeleteAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		if (session != null) {
			return "error/session-error.jsp";
		}

		// セッションから取得
		UserBean userBean = (UserBean) session.getAttribute("userBean");

		// 削除処理
		boolean result = UserDAO.deleteUser(userBean);

		// 削除失敗
		if (!result) {

			request.setAttribute(
					"errMessage",
					"削除エラー");

			return "error/login-error.jsp";
		}

		// セッション破棄
		session.invalidate();

		// 完了画面
		return "signup/user-delete-success.jsp";

	}

}
