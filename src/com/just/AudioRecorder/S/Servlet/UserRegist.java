package com.just.AudioRecorder.S.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.just.AudioRecorder.S.Dao.DBOperate;


@WebServlet("/UserRegist")
public class UserRegist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");
		
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charest=UTF-8");
		PrintWriter out=response.getWriter();
		String name = request.getParameter("LoginName");
		String passwd = request.getParameter("LoginPassword");
		String mail = request.getParameter("Mail");

	        if(name == null || name.isEmpty()
	                || passwd == null || passwd.isEmpty()
	                ||mail == null || mail.isEmpty())
	        {
	            return;
	        }
	       DBOperate dbo = new DBOperate();
	       dbo.DoReginster(name,passwd,mail);
	        System.out.println(name);
			System.out.println(passwd);
			System.out.println(mail);
	        out.print("success");
	        return;		
	}
	
}


