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

public class StudentDao {

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

	public List<Student> viewStudents() {
		List<Student> list = new ArrayList<Student>();
		Student s = null;

		conn = connection();
		String view = "select * from student";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				s = new Student();
				s.setSname(rs.getString(1));
				s.setSid(rs.getString(2));
				s.setSpassword(rs.getString(3));
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

	public String addStudent(String sname, String sid, String spassword) {
		conn = connection();
		String insert = "insert into student(sname,sid,spassword) values(?,?,?)";

		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, sname);
			pstmt.setString(2, sid);
			pstmt.setString(3, spassword);
			int status = pstmt.executeUpdate();
			if (status != 0) {
				return "Added succesfully";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeresource();
		}
		return null;
	}

	public String deleteStudent(String sid) {
		conn = connection();
		String delete = "delete from student where sid=?";
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

	public String updateStudent(String sname, String Nsid, String spassword,String sid) {
		conn = connection();
		String update = "update student set sname=?,sid=?,spassword=? where sid=?";
		try {
			pstmt = conn.prepareStatement(update);

			pstmt.setString(1, sname);
			pstmt.setString(2, Nsid);
			pstmt.setString(3, spassword);
			pstmt.setString(4, sid);
			

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
