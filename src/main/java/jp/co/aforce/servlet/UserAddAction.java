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
			 session.invalidate();
			return "error/session-error.jsp";
		}

		try {

			UserDAO dao = new UserDAO();

			// 既存ユーザチェック
			boolean existsUser = dao.existsUser(userBean.getId());

			if (existsUser) {
				return error(
						request,
						session,
						"入力したユーザーIDは、すでに登録済みです。");
			}

			// 登録処理
			boolean result = dao.insertUser(userBean);

			if (!result) {
				return error(
						request,
						session,
						"データベースでエラーが発生しました。");
			}

			session.invalidate();

			return "signup/user-success.jsp";

		} catch (SQLException e) {
			e.printStackTrace();
			return error(
					request,
					session,
					"データベースエラーが発生しました。");
		} catch (Exception e) {
			e.printStackTrace();
			return error(
					request,
					session,
					"システムエラーが発生しました。");
		}

	}

	private String error(
			HttpServletRequest request,
			HttpSession session,
			String message) {

		request.setAttribute("errMessage", message);

		UserBean user = (UserBean) session.getAttribute("user");

		if (user != null) {
			LoginManager.logout(user.getId());
		}

		session.invalidate();

		return "error/login-error.jsp";
	}

}