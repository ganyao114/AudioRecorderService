package com.just.AudioRecorder.S.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.formula.functions.Now;

import sun.print.resources.serviceui;

import net.sf.json.JSONObject;

import com.just.AudioRecorder.S.Dao.Bean.Message;
import com.just.AudioRecorder.S.Service.SendMessage;
import com.just.AudioRecorder.S.Service.StaticDataPackage;

/**
 * Servlet implementation class SendMsg
 */
@WebServlet("/SendMsg")
public class SendMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
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
		String LoginName = request.getParameter("LoginName");
		JSONObject Message = JSONObject.fromObject(request.getParameter("Message"));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date now = new Date();
		String data = dateFormat.format(now);
	    Message msg=new Message(Message.getString("Sender"),Message.getString("Content"),
	    		data,null);
	    SendMessage.Send(LoginName, msg);
	    out.write("success");
		System.out.println(Message.toString());
	}

}
