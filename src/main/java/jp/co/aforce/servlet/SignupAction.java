package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.dao.SignupDAO;
import jp.co.aforce.tool.Action;
import jp.co.aforce.tool.Check;

public class SignupAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		SignupDAO dao = new SignupDAO();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String mail = request.getParameter("mail");
		String lastname = request.getParameter("lastname");
		String role = "user";
		
		int line = dao.userSignup(id, password, mail, role, lastname);
		String result = Check.isSqlDirty(line);
		
		if (result != null) {
			session.setAttribute("message", result);
			return "/error/login-error.jsp";
		}else {
			session.removeAttribute("message");
		}
		
		return "signup/signup-out.jsp";
	}

}
