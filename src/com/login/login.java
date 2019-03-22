package com.login;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.adminLoginDao;
import com.login.dao.counsellorLoginDao;
import com.login.dao.studentLoginDao;



@WebServlet("/login")
public class login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uid = request.getParameter("uid");
		String password = request.getParameter("pass");

		adminLoginDao dao = new adminLoginDao();
		counsellorLoginDao dao1 = new counsellorLoginDao();
		studentLoginDao dao2 = new studentLoginDao();

		if (uid.startsWith("A1")) {
			if (dao.check(uid, password)) {

				HttpSession session = request.getSession();
				session.setAttribute("username", uid);
				response.sendRedirect("admin.jsp");
			}
		}
		else if(uid.startsWith("C1")) {
			if (dao1.check(uid, password)) {

				HttpSession session = request.getSession();
				session.setAttribute("username", uid);
				response.sendRedirect("counsellor.jsp");
			}
		}
		
		else if(uid.startsWith("S1")) {
			if (dao2.check(uid, password)) {

				HttpSession session = request.getSession();
				session.setAttribute("username", uid);
				response.sendRedirect("student.jsp");
			}
		}

		else {

			response.sendRedirect("login.jsp");
		}

	}

}

