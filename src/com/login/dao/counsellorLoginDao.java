package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class counsellorLoginDao {
	String sql = "select * from counsellor where cid=? and cpassword=?";
	String url = "jdbc:mysql://localhost:3306/sms";
	String user = "root";
	String password = "mysql123";

	public boolean check(String cid, String cpass) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, cid);
			st.setString(2, cpass);
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
