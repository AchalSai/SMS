package com.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.dao.Counsellor_StudentDao;


@WebServlet("/addcounsellorstudent")
public class AddCounsellorStudent extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Counsellor_StudentDao b = new Counsellor_StudentDao();
		PrintWriter out = response.getWriter();
		String cid = request.getParameter("cid");
		String sid = request.getParameter("sid");
		
		String add = b.addCounsellorStudent(cid, sid);
		RequestDispatcher rd = request.getRequestDispatcher("addCounsellorStudentResult.jsp");
		request.setAttribute("add", add);
		rd.forward(request, response);
	}
}
