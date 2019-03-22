package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class adminLoginDao {
	String sql = "select * from admin where id=? and password=?";
	String url = "jdbc:mysql://localhost:3306/sms";
	String user = "root";
	String password = "mysql123";

	public boolean check(String uid, String pass) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, uid);
			st.setString(2, pass);
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
