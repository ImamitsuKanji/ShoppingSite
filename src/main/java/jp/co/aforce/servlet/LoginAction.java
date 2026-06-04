package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.UserDAO;
import jp.co.aforce.tool.Action;
import jp.co.aforce.tool.LoginManager;

public class LoginAction extends Action {
	String check;

	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		UserDAO dao = new UserDAO();

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println(id + password);

		UserBean user = dao.loginCheck(id, password);
		System.out.println(user + id);

		boolean checkResult = UserDAO.loginCheckResult(id, user);

		if (checkResult != true) {
			session.invalidate();
			session = request.getSession(true);
			if (session != null) {
				session.invalidate();
			}
			return "error/login-error.jsp";
		} else {
			LoginManager.login(id, session.getId());
			session.setAttribute("user", user);
				return "login/user-menu.jsp";
		}
	}
}
