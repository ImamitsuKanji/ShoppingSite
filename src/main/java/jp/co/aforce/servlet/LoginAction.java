package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.User;
import jp.co.aforce.dao.LoginDAO;
import jp.co.aforce.tool.Action;

public class LoginAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		LoginDAO dao = new LoginDAO();
		User user = dao.userSearch(id, password);

		if (user != null) {
			session.setAttribute("user", user);
			return "login-menu.jsp";
		}

		return "login-error.jsp";
	}
}
