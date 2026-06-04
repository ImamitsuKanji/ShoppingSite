package jp.co.aforce.servlet;

import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.UserDAO;
import jp.co.aforce.tool.Action;

public class UserAddConfirmAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		try {

			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String address = request.getParameter("address");
			String mailaddress = request.getParameter("mailaddress");

			UserBean userBean = new UserBean();

			userBean.setId(userId);
			userBean.setPassword(password);
			userBean.setFirstName(firstName);
			userBean.setLastName(lastName);
			userBean.setAddress(address);
			userBean.setMailAddress(mailaddress);

			boolean bean1 = UserDAO.UserCheck(userBean);

			// 既に登録済み
			if (!bean1) {

				request.setAttribute(
						"errMessage",
						"入力したユーザーは、既に登録済みです。");

				request.setAttribute("userBean", userBean);

				return "signup/user-add.jsp";
			}

			session.setAttribute("userBean", userBean);

			return "signup/user-add-confirm.jsp";

		} catch (SQLException e) {

			request.setAttribute(
					"errMessage",
					"データベースエラーが発生しました：" + e.getMessage());

			return "signup/user-add.jsp";
		}
	}
}