package jp.co.aforce.servlet.update;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.User;
import jp.co.aforce.dao.UpdateDAO;
import jp.co.aforce.tool.Action;
import jp.co.aforce.tool.Check;

public class EditingAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		UpdateDAO uptatedao = new UpdateDAO();
		User user=new User();
		
		System.out.println(user);
		
		int line = uptatedao.updateInformation(user);
		String result = Check.isSqlDirty(line);
		
		
		if (result != null) {
			session.setAttribute("message", result);
			return "/error/menu-error.jsp";
		}else {
			session.removeAttribute("message");
			session.invalidate();
		}
		
		return "delete/editing-out.jsp";
	}

}