package com.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.SubjectDao;

@WebServlet("/updatesubject")
public class UpdateSubject extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SubjectDao a = new SubjectDao();
		PrintWriter out = response.getWriter();
		String subid = request.getParameter("subid");
		String Nsubname = request.getParameter("Nsubname");
		int total_marks = Integer.parseInt(request.getParameter("total_marks"));
		String subname = request.getParameter("subname");
		String update = a.updateStudent(subid, Nsubname, total_marks, subname);
		RequestDispatcher rd = request.getRequestDispatcher("updateSubjectResult.jsp");
		request.setAttribute("update", update);
		rd.forward(request, response);
	}

}
