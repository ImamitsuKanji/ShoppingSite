package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteDAO extends DAO {

	public int userDelete(String id) 
			throws Exception{
		String sql="DELETE FROM users	WHERE MEMBER_ID = ?";
		System.out.println(sql);
		
		Connection con=getConnection();
		PreparedStatement st;
		st=con.prepareStatement(sql);
		
		st.setString(1, id);
		
		int line=st.executeUpdate();
		System.out.println(line);
		st.close();
		con.close();
		return line;
	}
}