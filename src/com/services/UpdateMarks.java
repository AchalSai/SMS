package com.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CIE1Dao;


@WebServlet("/updatemarks")
public class UpdateMarks extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CIE1Dao a = new CIE1Dao();
		//PrintWriter out = response.getWriter();
		String sid = request.getParameter("sid");
		String subname = request.getParameter("subname");
		int marks_obtained = Integer.parseInt(request.getParameter("marks_obtained"));
//		int c=(int) request.getAttribute("c");
		
		String update =a.updateMarks(subname, sid, marks_obtained);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("updateMarksResult.jsp");
		request.setAttribute("update", update);
		rd.forward(request, response);
	}
}
