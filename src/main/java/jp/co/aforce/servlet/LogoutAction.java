package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.User;
import jp.co.aforce.tool.Action;
import jp.co.aforce.tool.Check;
import jp.co.aforce.tool.LoginManager;

public class LogoutAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);

		if (session != null) {
			User user = (User) session.getAttribute("user");

			if (user != null) {
				LoginManager.logout(user.getId());
			}

			session.invalidate();

			String checkResult = Check.logoutCheckResult(user);
			System.out.println("チェック");

			if (checkResult != null) {
				session.setAttribute("message", checkResult);
				return "error/login-error.jsp";
			}
		}

		return "logout/logout-out.jsp";
	}
}