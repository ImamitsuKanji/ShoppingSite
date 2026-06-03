package jp.co.aforce.servlet.delete;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.dao.DeleteDAO;
import jp.co.aforce.tool.Action;
import jp.co.aforce.tool.Check;

public class DeleteAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		DeleteDAO dao = new DeleteDAO();
		
		String id = request.getParameter("id");
		System.out.println(id);
		
		int line = dao.userDelete(id);
		String result = Check.isSqlDirty(line);
		
		if (result != null) {
			session.setAttribute("message", result);
			return "/error/menu-error.jsp";
		}else {
			session.removeAttribute("message");
			session.invalidate();
		}
		
		return "delete/delete-out.jsp";
	}

}