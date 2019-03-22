package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;
import com.model.Subject;

public class SubjectDao {
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

	public List<Subject> viewSubjects() {
		List<Subject> list = new ArrayList<Subject>();
		Subject s = null;

		conn = connection();
		String view = "select * from subject";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				s = new Subject();
				s.setSubid(rs.getString(1));
				s.setSubname(rs.getString(2));
				s.setTotal_marks(rs.getInt(3));

				list.add(s);
			}
			System.out.println("aaaaa");
			System.out.println(list);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeresource();
		}

		return list;

	}

	public String addSubject(String subid, String subname, int total_marks) {
		conn = connection();
		String insert = "insert into subject(subid,subname,total_marks) values(?,?,?)";

		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, subid);
			pstmt.setString(2, subname);
			pstmt.setInt(3, total_marks);
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

	public String deleteSubject(String subname) {
		conn = connection();
		String delete = "delete from subject where subname=?";
		try {
			pstmt = conn.prepareStatement(delete);

			pstmt.setString(1, subname);

			int status = pstmt.executeUpdate();
			if (status != 0) {
				return "Deleted succesfully";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeresource();
		}
		return null;

	}
	
	public String updateStudent(String subid, String Nsubname, int total_marks,String subname) {
		conn = connection();
		String update = "update subject set subid=?,subname=?,total_marks=? where subname=?";
		try {
			pstmt = conn.prepareStatement(update);

			pstmt.setString(1, subid);
			pstmt.setString(2, Nsubname);
			pstmt.setInt(3, total_marks);
			pstmt.setString(4, subname);

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
