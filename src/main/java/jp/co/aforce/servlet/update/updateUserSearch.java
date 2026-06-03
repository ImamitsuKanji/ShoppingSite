package jp.co.aforce.servlet.update;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.User;
import jp.co.aforce.dao.SearchDAO;
import jp.co.aforce.tool.Action;
import jp.co.aforce.tool.Check;
import jp.co.aforce.tool.LoginManager;

public class updateUserSearch  extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		SearchDAO dao = new SearchDAO();
		
		String id = request.getParameter("id");
		User user = dao.searchById(id);
		System.out.println(user +id);
		
		System.out.println(user);
		String checkResult = Check.UserCheck(user);
		LoginManager.login(id, session.getId());
		System.out.println(checkResult);
		
		if (checkResult != null) {
			session.setAttribute("message", checkResult);
			return "/error/menu-error.jsp";
		}else {
			session.removeAttribute("message");
			session.setAttribute("user", user);
			
		return "/update/update-check.jsp";
		}
	}
}
