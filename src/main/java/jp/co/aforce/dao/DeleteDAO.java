package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteDAO extends DAO {

	public int userDelete(String id) 
			throws Exception{
		String sql="DELETE FROM users	WHERE MEMBER_ID = " + id +";";
		
		Connection con=getConnection();
		PreparedStatement st;
		st=con.prepareStatement(sql);
		
		int line=st.executeUpdate();
		st.close();
		return line;
	}
}