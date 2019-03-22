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


@WebServlet("/addstudent")
public class AddStudent extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentDao a = new StudentDao();
		PrintWriter out = response.getWriter();
		String sname = request.getParameter("sname");
		String sid = request.getParameter("sid");
		String spassword = request.getParameter("spassword");
//		out.println(sname);
		String add = a.addStudent(sname, sid, spassword);
		RequestDispatcher rd = request.getRequestDispatcher("addStudentResult.jsp");
		request.setAttribute("add", add);
		rd.forward(request, response);
	}

}
