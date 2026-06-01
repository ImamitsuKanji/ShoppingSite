package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.User;

public class LoginDAO extends DAO {
	public User userSearch(String id, String password) 
			throws Exception{
		String sql="select * from users where MEMBER_ID=? and PASSWORD =?";
		
		User user=null;
		
		Connection con=getConnection();
		PreparedStatement st;
		st=con.prepareStatement(sql);
		
		st.setString(1, id);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();
		
		
		while (rs.next()) {
			user=new User();
			user.setId(rs.getString("MEMBER_ID"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setFirstName(rs.getString("FIRST_NAME"));
			user.setLastName(rs.getString("LAST_NAME"));
			user.setAddress(rs.getString("ADDRESS"));
			user.setMailAddress(rs.getString("MAIL_ADDRESS"));
			user.setRole(rs.getString("ROLE"));
		}
		
		st.close();
		rs.close();
		return user;
	}
}
