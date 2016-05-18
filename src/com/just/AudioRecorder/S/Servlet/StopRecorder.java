package com.just.AudioRecorder.S.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.just.AudioRecorder.S.Dao.Bean.RequestBean;
import com.just.AudioRecorder.S.Service.StaticDataPackage;
import com.just.AudioRecorder.S.Service.StopRec;

/**
 * Servlet implementation class StopRecorder
 */
@WebServlet("/StopRecorder")
public class StopRecorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StopRecorder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charest=UTF-8");
        PrintWriter out = response.getWriter();
        String LoginName = request.getParameter("LoginName");
        String RoomName = request.getParameter("RoomName");
        if (StopRec.Stop(LoginName, RoomName)) {
			out.write("success");
		}
	}

}
