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


@WebServlet("/deletestudent")
public class DeleteStudent extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentDao a = new StudentDao();
		PrintWriter out = response.getWriter();
		
		String sid = request.getParameter("sid");
		
		
		String delete = a.deleteStudent(sid);
		RequestDispatcher rd = request.getRequestDispatcher("deleteStudentResult.jsp");
		request.setAttribute("delete", delete);
		rd.forward(request, response);
	}

}
