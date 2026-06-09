package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.UserDAO;
import jp.co.aforce.tool.Action;
import jp.co.aforce.tool.LoginManager;

public class UserDeleteAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		if (session == null) {
			return "error/session-error.jsp";
		}

		// セッションから取得
		UserBean user = (UserBean) session.getAttribute("user");

		UserDAO dao = new UserDAO();
		// 削除処理
		boolean result = dao.deleteUser(user);

		// 削除失敗
		if (!result) {

			request.setAttribute("errMessage","削除エラー");

			if (session != null) {
				session.invalidate();
			}
			
			LoginManager.logout(user.getId());

			return "error/login-error.jsp";
		}

		// セッション破棄
		session.invalidate();

		// 完了画面
		return "delete/user-delete-success.jsp";

	}

}
