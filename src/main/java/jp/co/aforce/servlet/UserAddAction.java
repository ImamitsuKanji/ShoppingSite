package jp.co.aforce.servlet;

import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.UserDAO;
import jp.co.aforce.tool.Action;
import jp.co.aforce.tool.LoginManager;

public class UserAddAction extends Action {

	@Override
	public String execute(
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession(false);

		// セッション切れ
		if (session == null) {
			return "error/session-error.jsp";
		}

		UserBean userBean = (UserBean) session.getAttribute(
				"updateBean");

		// Beanなし
		if (userBean == null) {
			return "error/session-error.jsp";
		}

		try {

			UserDAO dao = new UserDAO();

			// 既存ユーザチェック
			boolean existsUser = dao.existsUser(userBean.getId());
			UserBean user = (UserBean) session.getAttribute("user");

			if (existsUser) {

				request.setAttribute(
						"errMessage",
						"入力したユーザーIDは、すでに登録済みです。");

				System.out.println("チェック");

				LoginManager.logout(user.getId());
				session.invalidate();

				return "error/login-error.jsp";
			}

			// 登録処理
			boolean result = dao.updateUser(userBean);

			if (!result) {

				request.setAttribute(
						"errMessage",
						"データベースエラーが発生しました。");

				LoginManager.logout(user.getId());
				session.invalidate();

				return "error/login-error.jsp";
			}

			session.invalidate();

			return "signup/user-success.jsp";

		} catch (SQLException e) {
			UserBean user = (UserBean) session.getAttribute("user");
			e.printStackTrace();

			request.setAttribute(
					"errMessage",
					"データベースエラーが発生しました。");

			if (session != null) {
				session.invalidate();
			}

			LoginManager.logout(user.getId());

			return "error/login-error.jsp";

		} catch (Exception e) {
			UserBean user = (UserBean) session.getAttribute("user");
			e.printStackTrace();

			request.setAttribute(
					"errMessage",
					"システムエラーが発生しました。");

			if (session != null) {
				session.invalidate();
			}

			LoginManager.logout(user.getId());

			return "error/login-error.jsp";
		}
	}

}