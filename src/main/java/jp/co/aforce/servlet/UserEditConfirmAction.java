package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.updateUserBean;
import jp.co.aforce.tool.Action;

public class UserEditConfirmAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String mailaddress = request.getParameter("mailaddress");
		
		updateUserBean updateUserBean= new updateUserBean();
		
		updateUserBean.setId(userId);
		updateUserBean.setPassword(password);
		updateUserBean.setFirstName(firstName);
		updateUserBean.setLastName(lastName);
		updateUserBean.setAddress(address);
		updateUserBean.setMailAddress(mailaddress);
		
		request.setAttribute("updateUserBean", updateUserBean);
		
		return "editing/user-edit-confirm.jsp";
	}

}
