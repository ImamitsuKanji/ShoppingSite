package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

public class SignupDAO extends DAO {

	public int userSignup(String id, String password, String mail, String role, String lastname, String address, LocalDateTime intdata, LocalDateTime editData)
			throws Exception {
		String sql = "insert into users(MEMBER_ID, PASSWORD,MAIL_ADDRESS, ROLE, LAST_NAME) values(?, ?, ?, ?, ?)";

		Connection con = getConnection();
		PreparedStatement st;
		st = con.prepareStatement(sql);

		st.setString(1, id);
		st.setString(2, password);
		st.setString(3, mail);
		st.setString(4, role);
		st.setString(5, lastname);
		int line = st.executeUpdate();
		con.close();
		st.close();
		return line;
	}
}
