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
import com.dao.StudentDao;


@WebServlet("/DeleteMarksById")
public class DeleteMarksById extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CIE1Dao a = new CIE1Dao();
		PrintWriter out = response.getWriter();
		
		String sid = request.getParameter("sid");
		
		
		String delete = a.deleteMarksById(sid);
		RequestDispatcher rd = request.getRequestDispatcher("deleteMarksByIdResult.jsp");
		request.setAttribute("delete", delete);
		rd.forward(request, response);
	}
}
