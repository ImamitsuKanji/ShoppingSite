package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.tool.LoginManager;

public class UserDAO extends DAO {
	public static boolean IDcheck(String id) {
		return id.matches("\\d+");
	}

	public static boolean loginCheckResult(String id, UserBean user) {
		if (!IDcheck(id)) {
			return true;
		}

		if (user == null) {
			return true;
		}

		if (LoginManager.isLoggedIn(id)) {
			return true;
		}
		System.out.println("ok");
		return false;
	}

	//実行確認
	public static boolean isSqlDirty(int line) {
		if (line == 0) {
			return true;
		}
		System.out.println("ok");

		return false;
	}

	//ID確認
	public static boolean UserCheck(UserBean user) throws SQLException {
		if (user == null) {
			return true;
		}
		return false;
	}

	public static boolean addUser(UserBean user) {
		if (user == null) {
			return true;
		}
		return false;
	}

	public static boolean deleteUser(UserBean userBean)
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

	public static boolean updateUser(UserBean user)
			throws Exception {
		boolean result = false;
		String sql = "UPDATE users "
				+ "SET MAIL_ADDRESS= ?, ADDRESS= ?, FIRST_NAME= ?, LAST_NAME= ? "
				+ "WHERE MEMBER_ID=?";

		Connection con = getConnection();
		PreparedStatement st;
		st = con.prepareStatement(sql);

		st.setString(1, user.getMailAddress());
		st.setString(2, user.getAddress());
		st.setString(3, user.getFirstName());
		st.setString(4, user.getLastName());
		st.setString(5, user.getId());
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
}
