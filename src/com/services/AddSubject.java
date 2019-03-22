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


@WebServlet("/addsubject")
public class AddSubject extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SubjectDao a = new SubjectDao();
		PrintWriter out = response.getWriter();
		String subid = request.getParameter("subid");
		String subname = request.getParameter("subname");
		int total_marks =Integer.parseInt(request.getParameter("total_marks"));
		
		String add = a.addSubject(subid, subname, total_marks);
		RequestDispatcher rd = request.getRequestDispatcher("addSubjectResult.jsp");
		request.setAttribute("add", add);
		rd.forward(request, response);
	}
}
