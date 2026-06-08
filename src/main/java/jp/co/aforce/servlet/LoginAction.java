package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.UserDAO;
import jp.co.aforce.tool.Action;
import jp.co.aforce.tool.LoginManager;

public class LoginAction extends Action {

	@Override
	public String execute
		(HttpServletRequest request,HttpServletResponse response)
	throws Exception {

		HttpSession session = request.getSession();

		UserDAO dao = new UserDAO();

		String id = request.getParameter("id");

		String password = request.getParameter("password");

		// ログイン検索
		UserBean user = dao.loginCheck(id, password);

		// ログイン判定
		boolean checkResult = false;
		try {
			checkResult = dao.loginCheckResult(id, user);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		// ログイン失敗
		if (!checkResult) {

			request.setAttribute("errMessage","ログインに失敗しました。");

			session.invalidate();

			return "error/login-error.jsp";
		}

		// ログイン管理
		LoginManager.login(
				id,
				session.getId());

		// session保存
		session.setAttribute(
				"user",
				user);

		return "login/user-menu.jsp";
	}
}
