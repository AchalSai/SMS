package com.services;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CIE1Dao;
import com.dao.Counsellor_StudentDao;
import com.dao.StudentDao;
import com.dao.SubjectDao;
import com.model.CounsellorStudent;
import com.model.Student;
import com.model.StudentMarks;
import com.model.Subject;

@WebServlet("/adminservices")
public class AdminServices extends HttpServlet {

	 private SessionData sd = SessionData.getSd();
	 private List<SessionData> listsd = new ArrayList<>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookie=null;
		String url = request.getRequestURI();
		StudentDao a = new StudentDao();
		CIE1Dao f = new CIE1Dao();
		Counsellor_StudentDao b = new Counsellor_StudentDao();
		SubjectDao d = new SubjectDao();
		PrintWriter out = response.getWriter();
		int c = Integer.parseInt(request.getParameter("services"));
		int k=0;

		RequestDispatcher rd = null;
		switch (c) {
		case 1:
			List<Student> list = a.viewStudents();

//				ListIterator<Student> i1=list.listIterator();
//				while(i1.hasNext()) {
//					Student s = i1.next();
//					out.println(s);
//				}
//			for (Student ss : list) {
//				out.println(ss);
//
//			}

			rd = request.getRequestDispatcher("viewStudent.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);
			break;

		case 2:

			response.sendRedirect("addStudent.jsp");

			break;

		case 3:

			response.sendRedirect("deleteStudent.jsp");

			break;

		case 4:
			response.sendRedirect("updateStudent.jsp");
			break;

		case 5:
			List<CounsellorStudent> list1 = b.viewCounsellorStudents();
			rd = request.getRequestDispatcher("viewCounsellorStudent.jsp");
			request.setAttribute("list1", list1);
			rd.forward(request, response);
			break;

		case 6:

			response.sendRedirect("addCounsellorStudent.jsp");
			break;

		case 7:

			response.sendRedirect("deleteCounsellorStudent.jsp");

			break;

		case 8:
			response.sendRedirect("updateCounsellorStudent.jsp");
			break;

		case 9:
			List<Subject> list2 = d.viewSubjects();
			rd = request.getRequestDispatcher("viewSubject.jsp");
			request.setAttribute("list2", list2);
			rd.forward(request, response);
			break;

		case 10:

			response.sendRedirect("addSubject.jsp");

			break;

		case 11:

			response.sendRedirect("deleteSubject.jsp");

			break;

		case 12:
			response.sendRedirect("updateSubject.jsp");
			break;

		case 13:
			List<StudentMarks> list3 = f.viewMarks();
			RequestDispatcher rd3 = request.getRequestDispatcher("viewCie1.jsp");
			request.setAttribute("list3", list3);
			rd3.forward(request, response);
			break;
		case 14:
			response.sendRedirect("Sidinput.jsp");
			break;
		case 15:
			//sd.setChoiceCie(1);
			SessionData ss=new SessionData(1);
//			rd = request.getRequestDispatcher("addmarks.jsp");
//			request.setAttribute("c", c);
//			rd.forward(request, response);
//			break;
//			k=15;
//             cookie = new Cookie("k", k+"");			
             response.sendRedirect("addmarks.jsp");
             break;
		case 16:
			
			rd = request.getRequestDispatcher("deletemarksbyid.jsp");
			request.setAttribute("c", c);
			rd.forward(request, response);
			break;
		case 17:

			rd = request.getRequestDispatcher("deletemarksbyidsub.jsp");
			request.setAttribute("c", c);
			rd.forward(request, response);
			break;
		case 18:

			rd = request.getRequestDispatcher("updatemarks.jsp");
			request.setAttribute("c", c);
			rd.forward(request, response);
			break;
		}

	}

}
