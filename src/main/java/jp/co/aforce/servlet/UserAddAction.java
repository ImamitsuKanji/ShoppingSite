package jp.co.aforce.servlet;

import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.UserDAO;
import jp.co.aforce.tool.Action;

public class UserAddAction extends Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		try {

			UserBean userBean =
					(UserBean) session.getAttribute("userBean");

			// 既存ユーザチェック
			boolean check = UserDAO.UserCheck(userBean);

			// 既に登録済み
			if (!check) {

				request.setAttribute(
						"errMessage",
						"入力したユーザーIDは、すでに登録済みです。");

				return "error/login-error.jsp";
			}

			// 登録処理
			boolean result = UserDAO.addUser(userBean);

			// DBエラー
			if (!result) {

				request.setAttribute(
						"errMessage",
						"データベースエラーが発生しました。");

				return "error/login-error.jsp";
			}

			// セッション破棄
			session.invalidate();

			return "signup/user-success.jsp";

		} catch (SQLException e) {

			request.setAttribute(
					"errMessage",
					"データベースエラーが発生しました："
							+ e.getMessage());

			return "error/login-error.jsp";
		}
	}
}