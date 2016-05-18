package com.just.AudioRecorder.S.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.just.AudioRecorder.S.Dao.Bean.User;
import com.just.AudioRecorder.S.Dao.Bean.UserInfoPrivate;
import com.just.AudioRecorder.S.Dao.Bean.UserInfoPublic;
import com.just.AudioRecorder.S.Service.StaticDataPackage;
import com.just.AudioRecorder.S.Service.UserLogin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charest=UTF-8");
		PrintWriter out=response.getWriter();
		String Loginname = request.getParameter("LoginName");
		String Loginpassword = request.getParameter("LoginPassword");
		System.out.println(Loginname);
		System.out.println(Loginpassword);
		if (Loginname == null || Loginname.isEmpty()
                || Loginpassword == null || Loginpassword.isEmpty()) {
            //response.sendRedirect("login.jsp");
        } else {
            UserLogin ul = new UserLogin();
            UserInfoPrivate user = ul.login(Loginname, Loginpassword);
            if (user == null) {
                return;
            }
            StaticDataPackage.UserSOnline.put(Loginname, new User(Loginname, Loginpassword, user.getMail()));
        	out.print("success");
     
		}
	}
}
