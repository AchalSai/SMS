package com.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CIE1Dao;
import com.dao.Counsellor_StudentDao;
import com.model.StudentMarks;

@WebServlet("/viewcie1byid")
public class ViewCie1ById extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	String sid = request.getParameter("sid");
	CIE1Dao f=new CIE1Dao();
	List<StudentMarks> list =f.viewMarksById(sid);
	RequestDispatcher rd3 = request.getRequestDispatcher("viewCie1.jsp");
	request.setAttribute("list3", list);
	rd3.forward(request, response);
	
	}

}
