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


@WebServlet("/deletesubject")
public class DeleteSubject extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SubjectDao a = new SubjectDao();
		PrintWriter out = response.getWriter();
		
		String subname = request.getParameter("subname");
		
		
		String delete = a.deleteSubject(subname);
		RequestDispatcher rd = request.getRequestDispatcher("deleteSubjectResult.jsp");
		request.setAttribute("delete", delete);
		rd.forward(request, response);
	}

}
