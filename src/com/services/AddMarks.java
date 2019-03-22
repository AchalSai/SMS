package com.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CIE1Dao;
import com.dao.StudentDao;

@WebServlet("/addmarks")
public class AddMarks extends HttpServlet {
	private SessionData sd = SessionData.getSd();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CIE1Dao a = new CIE1Dao();
		PrintWriter out = response.getWriter();
		String sid = request.getParameter("sid");
		String subname = request.getParameter("subname");
		int marks_obtained = Integer.parseInt(request.getParameter("marks_obtained"));
		 
//		System.out.println(sd.getChoiceCie());
//		List<Integer> choice = sd.getChoice();
//		for(int i:choice) {
//			if(i==1) {
//				
//			}
//		}
//		String add = null;
//		if (sd.getChoiceCie() == 1) {
//			add = a.addMarks(sid, subname, marks_obtained);
//
//		}
		
		System.out.println("Serv getdata "+sd.getChoiceCie());
		/*
		 * int c=0;
		 * 
		 * Cookie cookies[]=request.getCookies(); for(Cookie ck:cookies) {
		 * if(ck.getName().equals("c")) { c=Integer.parseInt(ck.getValue()); }
		 * 
		 * }
		 * 
		 * System.out.println("c"+c);
		 */
		
		
		
		
		
		
		
		
		
		String add =a.addMarks(sid, subname, marks_obtained);
		RequestDispatcher rd = request.getRequestDispatcher("addMarksResult.jsp");
		request.setAttribute("add", add);
		rd.forward(request, response);
	}

}
