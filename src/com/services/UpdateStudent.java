package com.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;


@WebServlet("/updatestudent")
public class UpdateStudent extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentDao a = new StudentDao();
//		PrintWriter out = response.getWriter();
		String sname = request.getParameter("sname");
		String Nsid = request.getParameter("Nsid");
		String spassword = request.getParameter("spassword");
		String sid = request.getParameter("sid");
		String update = a.updateStudent(sname, Nsid, spassword, sid);
		RequestDispatcher rd = request.getRequestDispatcher("updateStudentResult.jsp");
		request.setAttribute("update", update);
		rd.forward(request, response);
	}


}
