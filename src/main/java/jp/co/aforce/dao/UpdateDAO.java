package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.aforce.beans.User;

public class UpdateDAO extends DAO {
	public int updateInformation (User user)
			throws Exception {
		String sql = "UPDATE users PASSWORD= ?, MAIL_ADDRESS= ?, ROLE= ?, LAST_NAME= ? WHERE= ?";

		Connection con = getConnection();
		PreparedStatement st;
		st = con.prepareStatement(sql);

		st.setString(1, user.getPassword());
		st.setString(2, user.getMailAddress());
		st.setString(3, user.getAddress());
		st.setString(4, user.getRole());
		st.setString(5, user.getFirstName());
		st.setString(6, user.getLastName());
		st.setString(7, user.getId());
		int line = st.executeUpdate();
		con.close();
		st.close();
		return line;
	}
}
