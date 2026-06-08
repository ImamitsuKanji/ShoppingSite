package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.UserDAO;
import jp.co.aforce.tool.Action;

public class UserAddConfirmAction extends Action {

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

			// Bean生成
			UserBean UserBean = new UserBean();
			

			UserBean.setId(userId);
			UserBean.setPassword(password);
			UserBean.setFirstName(firstName);
			UserBean.setLastName(lastName);
			UserBean.setAddress(address);
			UserBean.setMailAddress(mailAddress);

			UserDAO dao = new UserDAO();

			boolean existsUser = dao.existsUser(userId);
			boolean halfWidth = dao.isHalfWidth(userId, password);

			// 既に登録済み
			if (existsUser) {

				request.setAttribute(
						"errMessage",
						"入力したユーザーは、既に登録済みです。");

				request.setAttribute(
						"userBean",
						UserBean);

				return "signup/user-add.jsp";
			}
			
			if (!halfWidth) {

				request.setAttribute(
						"halfWidthErrMessage",
						"半角英数字で入力してください");

				request.setAttribute(
						"userBean",
						UserBean);

				return "signup/user-add.jsp";
			}

			// session保存
			session.setAttribute(
					"updateBean",
					UserBean);

			// 確認画面へ
			return "signup/user-add-confirm.jsp";

	}
}