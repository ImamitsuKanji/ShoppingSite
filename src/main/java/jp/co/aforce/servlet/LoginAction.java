package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.User;
import jp.co.aforce.dao.LoginDAO;
import jp.co.aforce.tool.Action;
import jp.co.aforce.tool.Check;
import jp.co.aforce.tool.LoginManager;

public class LoginAction extends Action {
	String check;

	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		LoginDAO dao = new LoginDAO();

		String id = request.getParameter("id");
		String password = request.getParameter("password");

		User user = dao.userSearch(id, password);
		String usrId= user.getId();
		String role= user.getRole();
		LoginManager.login(usrId, session.getId());
		
		String checkResult = Check.showCheckResult(id, user);
		System.out.println("チェック");
		

		if (checkResult != null) {
			session.setAttribute("message", checkResult);
			return "/login/login-error.jsp";
		}else {
			session.removeAttribute("message");
			session.setAttribute("user", user);
		}
		
		if(role.equals("admin")){
			return "/login/admin-login-menu.jsp";
		}else {
			return "/login/login-menu.jsp";
		}
	}
}
