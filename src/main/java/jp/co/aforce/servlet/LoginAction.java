package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.User;
import jp.co.aforce.dao.SearchDAO;
import jp.co.aforce.tool.Action;
import jp.co.aforce.tool.Check;
import jp.co.aforce.tool.LoginManager;

public class LoginAction extends Action {
	String check;

	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		SearchDAO dao = new SearchDAO();

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println(id+ password);

		User user= dao.loginSearch(id, password);
		System.out.println(user +id);
		
		String checkResult = Check.loginCheckResult(id, user);

		if (checkResult != null) {
			session.invalidate();
			session.setAttribute("message", checkResult);
			return "/error/login-error.jsp";
		}else {
			LoginManager.login(id, session.getId());
			System.out.println(checkResult);
			String role= user.getRole();
			session.removeAttribute("message");
			session.setAttribute("user", user);
			
			if("admin".equals(role)){
				return "/login/admin-login-menu.jsp";
			}else {
				return "/login/login-menu.jsp";
			}
		}
	}
}
