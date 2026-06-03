package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.User;

public class SearchDAO extends DAO {

    // IDのみ検索
    public User searchById(String id) throws Exception {

        User user = null;

        String sql = "SELECT * FROM users WHERE LAST_NAME = ?";

        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement(sql);

        st.setString(1, id);

        ResultSet rs = st.executeQuery();

        while (rs.next()) {

            user = new User();

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
    public User loginSearch(String id, String password) throws Exception {

        User user = null;

        String sql = "SELECT * FROM users WHERE MEMBER_ID = ? AND PASSWORD = ?";

        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement(sql);

        st.setString(1, id);
        st.setString(2, password);

        ResultSet rs = st.executeQuery();

        while (rs.next()) {

            user = new User();

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