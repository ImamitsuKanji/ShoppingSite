package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.tool.Action;

public class UserEditConfirmAction extends Action {

	@Override
	public String execute(
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession();

		String userId = request.getParameter("userId");

		String password = request.getParameter("password");

		String firstName = request.getParameter("firstName");

		String lastName = request.getParameter("lastName");

		String address = request.getParameter("address");

		String mailAddress = request.getParameter("mailaddress");

		UserBean updateUserBean = new UserBean();

		updateUserBean.setId(userId);
		updateUserBean.setPassword(password);
		updateUserBean.setFirstName(firstName);
		updateUserBean.setLastName(lastName);
		updateUserBean.setAddress(address);
		updateUserBean.setMailAddress(mailAddress);

		// session保存
		session.setAttribute(
				"updateUserBean",
				updateUserBean);

		return "editing/user-edit-confirm.jsp";
	}
}