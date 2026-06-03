package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.User;
import jp.co.aforce.dao.SearchDAO;
import jp.co.aforce.dao.SignupDAO;
import jp.co.aforce.tool.Action;
import jp.co.aforce.tool.Check;

public class SignupAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		SignupDAO signupDao = new SignupDAO();
		SearchDAO searchDao = new SearchDAO();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String mail = request.getParameter("mail");
		String lastname = request.getParameter("lastname");
		String role = "user";
		
		int line = signupDao.userSignup(id, password, mail, role, lastname);
		User user = searchDao.loginSearch(lastname, password);
		String result = Check.isSqlDirty(line);
		
		if (result != null) {
			session.setAttribute("message", result);
			return "/error/login-error.jsp";
		}
		
		session.removeAttribute("message");
		session.setAttribute("user", user);
		return "signup/signup-out.jsp";
	}

}
