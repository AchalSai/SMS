package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class studentLoginDao {
	String sql = "select * from student where sid=? and spassword=?";
	String url = "jdbc:mysql://localhost:3306/sms";
	String user = "root";
	String password = "mysql123";

	public boolean check(String sid, String spass) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, sid);
			st.setString(2, spass);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {

				return true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}
}

