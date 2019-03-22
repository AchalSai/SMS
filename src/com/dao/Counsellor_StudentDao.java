package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.CounsellorStudent;
import com.model.Student;

public class Counsellor_StudentDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;

	public Connection connection() {

		String sql = "jdbc:mysql://localhost:3306/sms";
		String username = "root";
		String password = "mysql123";
		try {
			conn = DriverManager.getConnection(sql, username, password);
		} catch (SQLException e) {

			e.getMessage();
		}

		return conn;
	}

	public void closeresource() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public List<CounsellorStudent> viewCounsellorStudents() {
		List<CounsellorStudent> list = new ArrayList<CounsellorStudent>();
		CounsellorStudent s = null;

		conn = connection();
		String view = "select * from  counsellor_student";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				s = new CounsellorStudent();
				s.setCid(rs.getString(1));
				s.setSid(rs.getString(2));
				list.add(s);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeresource();
		}

		return list;

	}

	public String addCounsellorStudent(String cid, String sid) {
		conn = connection();
		String insert = "insert into counsellor_student(cid,sid) values(?,?)";

		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, cid);
			pstmt.setString(2, sid);

			int status = pstmt.executeUpdate();
			if (status != 0) {
				return "Added succesfully";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeresource();
		}
		return null;
	}
	
	public String deleteCounsellorStudent(String sid) {
		conn = connection();
		String delete = "delete from counsellor_student where sid=?";
		try {
			pstmt = conn.prepareStatement(delete);

			pstmt.setString(1, sid);

			int status = pstmt.executeUpdate();
			if (status != 0) {
				return "Deleted succesfully";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeresource();
		}
		return null;

	}
	public String updateCounsellorStudent(String cid,String sid) {
		conn = connection();
		String update = "update counsellor_student set cid=? where sid=?";
		try {
			pstmt = conn.prepareStatement(update);

			pstmt.setString(1, cid);
			pstmt.setString(2, sid);
			

			int status = pstmt.executeUpdate();
			if (status != 0) {
				return "Updated succesfully";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeresource();
		}
		return null;

	}

}
