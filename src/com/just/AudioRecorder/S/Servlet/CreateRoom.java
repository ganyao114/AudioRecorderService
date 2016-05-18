package com.just.AudioRecorder.S.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.just.AudioRecorder.S.Dao.Bean.RoomBean;
import com.just.AudioRecorder.S.Dao.Bean.UserInfoPublic;
import com.just.AudioRecorder.S.Service.CreateRoomService;
import com.just.AudioRecorder.S.Service.StaticDataPackage;

/**
 * Servlet implementation class CreateRoom
 */
@WebServlet("/CreateRoom")
public class CreateRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateRoom() {
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
		response.setContentType("text/html;charest=UTF-8");
		PrintWriter out=response.getWriter();
		String LoginName = request.getParameter("LoginName");
        String RoomName = request.getParameter("RoomName");
        JSONArray GuestList = JSONArray.fromObject(request.getParameter("UserList")); 

        if (LoginName == null || LoginName.isEmpty()
                || RoomName == null || RoomName.isEmpty() || GuestList == null || GuestList.isEmpty()) {
            //response.sendRedirect("login.jsp");
        } else {
        	CreateRoomService createRoom = new CreateRoomService(LoginName, RoomName, GuestList);
        	if (createRoom.doCrateRoom()) {
        		out.write("success");
			}else {
				out.write("failed");
			}
            
        }
		/*JSONArray jsonArray = JSONArray.fromObject( GuestList);
		System.out.println(jsonArray.toString());
		System.out.println(request.getParameter("RoomName"));
		out.print("success");*/
		
	}

}
