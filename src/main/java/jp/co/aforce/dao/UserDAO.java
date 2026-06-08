package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.beans.updateUserBean;
import jp.co.aforce.tool.LoginManager;

public class UserDAO extends DAO {

	public boolean isHalfWidth(String id, String password) {
		if (id.matches("^[0-9a-zA-Z]+$"))
			return true;
		return false;
	}

	public boolean existsUser(String id)
			throws Exception {

		boolean result = false;

		String sql = "SELECT * FROM users WHERE MEMBER_ID = ?";

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, id);

		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			result = true;
		}

		rs.close();
		st.close();
		con.close();

		return result;
	}

	public boolean loginCheckResult(
			String id,
			UserBean user) {

		//ID不正
		if (!isHalfWidth(id, id))
			return false;

		// ユーザーなし
		if (user == null)
			return false;

		// 既にログイン中
		if (LoginManager.isLoggedIn(id))
			return false;

		return true;
	}

	//実行確認
	public boolean isSqlDirty(int line) {
		if (line == 0) {
			return true;
		}
		System.out.println("ok");

		return false;
	}

	//ID確認
	public boolean UserCheck(UserBean user) throws SQLException {
		if (user == null) {
			return true;
		}
		return false;
	}

	public boolean deleteUser(UserBean userBean)
			throws Exception {
		boolean result = false;
		String sql = "DELETE FROM users	WHERE MEMBER_ID = ?";
		System.out.println(sql);

		Connection con = getConnection();
		PreparedStatement st;
		st = con.prepareStatement(sql);

		st.setString(1, userBean.getId());

		int line = st.executeUpdate();
		if (line != 0) {
			result = true;
		}
		st.close();
		con.close();
		return result;
	}

	public boolean updateUser(UserBean userBean)
			throws Exception {
		boolean result = false;
		String sql = "UPDATE users "
				+ "SET MAIL_ADDRESS= ?, ADDRESS= ?, FIRST_NAME= ?, LAST_NAME= ? "
				+ "WHERE MEMBER_ID=?";

		Connection con = getConnection();
		PreparedStatement st;
		st = con.prepareStatement(sql);

		st.setString(1, userBean.getMailAddress());
		st.setString(2, userBean.getAddress());
		st.setString(3, userBean.getFirstName());
		st.setString(4, userBean.getLastName());
		st.setString(5, userBean.getId());
		int line = st.executeUpdate();
		if (line != 0) {
			result = true;
		}
		st.close();
		con.close();
		return result;
	}

	// IDのみ検索
	public UserBean userCheck(String id) throws Exception {

		UserBean user = null;

		String sql = "SELECT * FROM users WHERE MEMBER_ID = ?";

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, id);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {

			user = new UserBean();

			user.setId(rs.getString("MEMBER_ID"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setFirstName(rs.getString("FIRST_NAME"));
			user.setLastName(rs.getString("LAST_NAME"));
			user.setAddress(rs.getString("ADDRESS"));
			user.setMailAddress(rs.getString("MAIL_ADDRESS"));
			user.setRole(rs.getString("ROLE"));
		}

		rs.close();
		st.close();
		con.close();

		return user;
	}

	// ID + PASSWORD検索（ログイン用）
	public UserBean loginCheck(String id, String password) throws Exception {

		UserBean user = null;

		String sql = "SELECT * FROM users WHERE MEMBER_ID = ? AND PASSWORD = ?";

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, id);
		st.setString(2, password);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {

			user = new UserBean();

			user.setId(rs.getString("MEMBER_ID"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setFirstName(rs.getString("FIRST_NAME"));
			user.setLastName(rs.getString("LAST_NAME"));
			user.setAddress(rs.getString("ADDRESS"));
			user.setMailAddress(rs.getString("MAIL_ADDRESS"));
			user.setRole(rs.getString("ROLE"));
		}

		rs.close();
		st.close();
		con.close();

		return user;
	}

	public UserBean BeanCast(updateUserBean updateUserBean) {
		UserBean user = new UserBean();

		user.setId(updateUserBean.getId());
		user.setPassword(updateUserBean.getPassword());
		user.setFirstName(updateUserBean.getFirstName());
		user.setLastName(updateUserBean.getLastName());
		user.setAddress(updateUserBean.getAddress());
		user.setMailAddress(updateUserBean.getMailAddress());
		user.setRole(updateUserBean.getRole());

		return user;

	}
}
