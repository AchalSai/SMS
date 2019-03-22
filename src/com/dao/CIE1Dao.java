package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.StudentMarks;

public class CIE1Dao {
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

	public List<StudentMarks> viewMarks() {
		List<StudentMarks> list = new ArrayList<StudentMarks>();
		StudentMarks s = null;

		conn = connection();
		String view = " select e.*,s.total_marks from cie1 e inner join subject s on e.subname=s.subname";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				s = new StudentMarks();
				s.setSid(rs.getString(1));
				s.setSubname(rs.getString(2));
				s.setMarks_obtained(rs.getInt(3));
				s.setTotal_marks(rs.getInt(4));
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

	public List<StudentMarks> viewMarksById(String sid) {
		List<StudentMarks> list = new ArrayList<StudentMarks>();
		StudentMarks s = null;

		conn = connection();
		String view = " select e.*,s.total_marks from cie1 e inner join subject s on e.subname=s.subname and e.sid=?";

		try {
			pstmt = conn.prepareStatement(view);
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				s = new StudentMarks();
				s.setSid(rs.getString(1));
				s.setSubname(rs.getString(2));
				s.setMarks_obtained(rs.getInt(3));
				s.setTotal_marks(rs.getInt(4));
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

	public String addMarks(String sid, String subname, int marks_obtained) {
		conn = connection();
		String insert = "insert into cie1 values(?,?,?)";

		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, sid);
			pstmt.setString(2, subname);
			pstmt.setInt(3, marks_obtained);
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

	public String deleteMarksById(String sid) {
		conn = connection();
		String delete = "delete from cie1 where sid=?";
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
		} finally {
			closeresource();
		}
		return null;

	}

	public String deleteMarksByIdSub(String sid, String subname) {
		conn = connection();
		String delete = "delete from cie1 where sid=? and subname=?";
		try {
			pstmt = conn.prepareStatement(delete);

			pstmt.setString(1, sid);
			pstmt.setString(2, subname);

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

	public String updateMarks(String subname, String sid, int marks_obtained) {
		conn = connection();
		String update = " update cie1 set marks_obtained=? where sid=? and subname=?";
		try {
			pstmt = conn.prepareStatement(update);

			pstmt.setInt(1, marks_obtained);
			pstmt.setString(2, sid);
			pstmt.setString(3, subname);
			int status = pstmt.executeUpdate();
			if (status != 0) {
				return "Updated succesfully";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeresource();
		}
		return null;

	}

}
